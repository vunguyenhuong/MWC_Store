package views;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;

import javax.swing.table.DefaultTableModel;
import models.ChiTietDep;

import models.HoaDon;
import models.HoaDonChiTiet;

import services.IChiTietDepService;

import services.IHoaDonCTService;
import services.IHoaDonService;
import services.IKhuyenMaiService;
import services.impl.ChiTietDepService;

import services.impl.HoaDonCTService;
import services.impl.HoaDonService;
import services.impl.KhuyenMaiService;
import swing.Table;
import ui.EventPagination;
import ui.NotificationMess;
import ui.Page;
import ui.PaginationItemRenderStyle1;
import utilities.Helper;

/**
 *
 * @author dell
 */
public class FrmQLHD extends javax.swing.JPanel {

    private IHoaDonService iHoaDonService;
    private IHoaDonCTService iHoaDonCTService;
    private DefaultComboBoxModel comboHD = new DefaultComboBoxModel();
    private DefaultTableModel dtm = new DefaultTableModel();
    private String typeKH;
    private Helper helper = new Helper();
    private IKhuyenMaiService iKhuyenMaiService;
    private IChiTietDepService iChiTietDepService = new ChiTietDepService();

    private Page pg = new Page();

    Integer limit = 5;
    Integer totalData = 0;

    /**
     * Creates new form FrmQLHD
     */
    public FrmQLHD() {
        initComponents();

        Table.apply(jScrollPane1, Table.TableType.DEFAULT);
        Table.apply(jScrollPane2, Table.TableType.DEFAULT);

        this.iHoaDonCTService = new HoaDonCTService();
        this.iHoaDonService = new HoaDonService();
        this.iKhuyenMaiService = new KhuyenMaiService();

        if (jdate_from.getDate() == null || jdate_to.getDate() == null) {
            jdate_from.setDate(new Date());
            jdate_to.setDate(new Date());
        }

        loadComboboxTrangThai();

        pagination(txt_Timkiem.getText(), null, null, 0);
        pagination1.setPagegination(1, pg.getTotalPage());
        pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());

    }

    public void loadComboboxTrangThai() {
        comboHD = (DefaultComboBoxModel<HoaDon>) cbo_Trangthai.getModel();
        comboHD.removeAllElements();
        comboHD.addElement("Tất cả");
        comboHD.addElement("Chưa thanh toán");
        comboHD.addElement("Đã thanh toán");
        comboHD.addElement("Đã hủy");
    }

    public void pagination(String ten, Date from, Date to, int trangthai) {
        totalData = iHoaDonService.filter(ten, from, to, trangthai).size();
        int totalPage = (int) Math.ceil(totalData.doubleValue() / limit);
        pg.setTotalPage(totalPage);
        if (pg.getTotalPage() < pg.getCurrent()) {
            pagination1.setPagegination(pg.getTotalPage(), pg.getTotalPage());
            loadDataToHD(iHoaDonService.pagination(pg.getTotalPage(), limit, ten, from, to, trangthai));
        } else {
            pagination1.setPagegination(pg.getCurrent(), pg.getTotalPage());
            loadDataToHD(iHoaDonService.pagination(pg.getCurrent(), limit, ten, from, to, trangthai));
        }

        pagination1.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                loadDataToHD(iHoaDonService.pagination(page, limit, ten, from, to, trangthai));
                pg.setCurrent(page);
            }
        });
    }

    private String checkTrangThai(int trangThai) {
        if (trangThai == 0) {
            return "Chưa thanh toán";
        }

        if (trangThai == 1) {
            return "Đã thanh toán";
        }

        return "Đã hủy";

    }

    public void loadDataToHD(List<HoaDon> list) {
        dtm = (DefaultTableModel) tb_hoadon.getModel();

        int i = 1;

        dtm.setRowCount(0);

        for (HoaDon hd : list) {

            Object[] rowData = new Object[]{
                i++,
                hd.getMa(),
                hd.getKhachHang() == null ? "Khách hàng lẻ" : hd.getKhachHang(),
                hd.getNguoiDung().getTen(),
                hd.getNguoiDungTT() == null ? "Chưa thanh toán" : hd.getNguoiDungTT().getTen(),
                hd.getKhuyenMai() == null ? "Không" : hd.getKhuyenMai(),
                helper.formatDate(hd.getNgayTao()),
                hd.getNgayThanhToan() == null ? "Chưa thanh toán" : helper.formatDate(hd.getNgayThanhToan()),
                checkTrangThai(hd.getTrangThai())
            };
            dtm.addRow(rowData);
        }
    }

    public void locTrangThai() {
        int index = cbo_Trangthai.getSelectedIndex();
        String fromString;
        String toString;
        Date dateFrom = new Date();
        Date dateTo = new Date();

        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        try {
            fromString = format.format(jdate_from.getDate());
            toString = format.format(jdate_to.getDate());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
            LocalDate date1 = LocalDate.parse(fromString, formatter);
            LocalDate date2 = LocalDate.parse(toString, formatter);

            dateFrom = java.sql.Date.valueOf(date1);
            dateTo = java.sql.Date.valueOf(date2);
        } catch (Exception e) {
        }

//        if (jdate_from.getDate() == null || jdate_to.getDate() == null) {
//            if (index == -1 || index == 0) {
//                loadDataToHD(iHoaDonService.getAll());
//            } else if (index == 1) {
//                loadDataToHD(iHoaDonService.getByTT(0));
//            } else if (index == 2) {
//                loadDataToHD(iHoaDonService.getByTT(1));
//            } else {
//                loadDataToHD(iHoaDonService.getByTT(2));
//            }
//        } else 
        if (index == 0) {
            pagination(txt_Timkiem.getText(), dateFrom, dateTo, -1);
        } else if (index == 1) {
            pagination(txt_Timkiem.getText(), dateFrom, dateTo, 0);
        } else if (index == 2) {
            pagination(txt_Timkiem.getText(), dateFrom, dateTo, 1);
        } else {
            pagination(txt_Timkiem.getText(), dateFrom, dateTo, 2);
        }

    }

    public void tongTien() {
        int index = tb_hoadon.getSelectedRow();
        HoaDon hd = iHoaDonService.getObj(tb_hoadon.getValueAt(index, 1).toString());
        double khuyenmai = 0;
        double tongTien = 0;
        double giamGia = 0;
        for (int i = 0; i < tb_HDCT.getRowCount(); i++) {
            tongTien = tongTien + Double.parseDouble(tb_HDCT.getValueAt(i, 5).toString());
        }

        lblTongtien.setText(String.valueOf(tongTien));

        if (hd.getKhuyenMai() != null) {
            khuyenmai = tongTien / 100 * hd.getKhuyenMai().getPhantramgiam();
        }

        if (hd.getTrangThai() == 1) {
            giamGia = hd.getDiemTichLuy() * 1000;
        }

        tongTien = tongTien - khuyenmai - giamGia;

        lblDiemtichluy.setText(String.valueOf(hd.getDiemTichLuy()));
        
        lblKhuyenmai.setText(String.valueOf(khuyenmai + giamGia));

        if (hd.getTrangThai() == 1) {
            lblThanhtoan.setText(String.valueOf(tongTien));
        } else {
            lblThanhtoan.setText("0.0");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txt_Timkiem = new swing.TextField();
        cbo_Trangthai = new swing.Combobox();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_hoadon = new javax.swing.JTable();
        btn_HuyHD = new swing.Button();
        jLabel3 = new javax.swing.JLabel();
        jdate_from = new com.toedter.calendar.JDateChooser();
        jdate_to = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tableScrollButton2 = new swing.TableScrollButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_HDCT = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTongtien = new javax.swing.JLabel();
        lbl_voucher = new javax.swing.JLabel();
        lbl_Change = new javax.swing.JLabel();
        lblKhuyenmai = new javax.swing.JLabel();
        lblThanhtoan = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pagination1 = new swing.Pagination();
        lbl_voucher1 = new javax.swing.JLabel();
        lblDiemtichluy = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Hóa đơn"));

        txt_Timkiem.setLabelText("Tìm kiếm hóa đơn");
        txt_Timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_TimkiemCaretUpdate(evt);
            }
        });

        cbo_Trangthai.setLabeText("Trạng thái");
        cbo_Trangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_TrangthaiActionPerformed(evt);
            }
        });

        tb_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HD", "Khách hàng", "Người tạo", "Người thanh toán", "Khuyến mãi", "Ngày tạo", "Ngày thanh toán", "Trạng thái"
            }
        ));
        tb_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_hoadonMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_hoadon);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btn_HuyHD.setBackground(new java.awt.Color(255, 0, 0));
        btn_HuyHD.setForeground(new java.awt.Color(255, 255, 255));
        btn_HuyHD.setText("Hủy hóa đơn");
        btn_HuyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HuyHDActionPerformed(evt);
            }
        });

        jLabel3.setText("Từ ngày");

        jdate_from.setDateFormatString("yyyy-MM-dd");
        jdate_from.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdate_fromPropertyChange(evt);
            }
        });

        jdate_to.setDateFormatString("yyyy-MM-dd");
        jdate_to.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdate_toPropertyChange(evt);
            }
        });

        jLabel5.setText("đến");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_Timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_Trangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jdate_from, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdate_to, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_HuyHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_Trangthai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_HuyHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Timkiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdate_to, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(jdate_from, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Hóa đơn chi tiết"));

        tb_HDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(tb_HDCT);

        tableScrollButton2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScrollButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScrollButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Tổng tiền :");

        lblTongtien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTongtien.setText("0");

        lbl_voucher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_voucher.setForeground(new java.awt.Color(255, 0, 0));
        lbl_voucher.setText("Giảm giá:");

        lbl_Change.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Change.setForeground(new java.awt.Color(255, 0, 0));
        lbl_Change.setText("Thanh toán :");

        lblKhuyenmai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKhuyenmai.setText("0");

        lblThanhtoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThanhtoan.setText("0");

        jPanel3.setBackground(new java.awt.Color(153, 51, 255));

        pagination1.setBackground(new java.awt.Color(153, 51, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_voucher1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_voucher1.setForeground(new java.awt.Color(255, 0, 0));
        lbl_voucher1.setText("Ðiểm tích lũy sử dụng :");

        lblDiemtichluy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDiemtichluy.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTongtien)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_voucher1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDiemtichluy)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_voucher)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblKhuyenmai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Change)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblThanhtoan)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_voucher)
                        .addComponent(lblKhuyenmai)
                        .addComponent(lbl_Change)
                        .addComponent(lblThanhtoan))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_voucher1)
                        .addComponent(lblDiemtichluy))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lblTongtien)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_TimkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_TimkiemCaretUpdate
        locTrangThai();
    }//GEN-LAST:event_txt_TimkiemCaretUpdate

    private void cbo_TrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_TrangthaiActionPerformed
        locTrangThai();
    }//GEN-LAST:event_cbo_TrangthaiActionPerformed

    private void tb_hoadonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_hoadonMousePressed
        // TODO add your handling code here:
        int row = tb_hoadon.getSelectedRow();
        HoaDon hd = iHoaDonService.getObj((String) tb_hoadon.getValueAt(row, 1));
        loadHoaDonCT(hd.getMa());
        tongTien();

    }//GEN-LAST:event_tb_hoadonMousePressed

    private void btn_HuyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HuyHDActionPerformed
        NotificationMess panel;
        int index = tb_hoadon.getSelectedRow();
        if (index == -1) {
            helper.alert(this, "Hãy chọn 1 Hóa đơn");
        } else {
            if (tb_hoadon.getValueAt(index, 8).equals("Đã thanh toán")) {
                panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Hóa đơn đã thanh toán. Không thể hủy !");
                panel.showNotification();
            } else if (tb_hoadon.getValueAt(index, 8).equals("Đã hủy")) {
                panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Hóa đơn đã hủy. Không thể hủy !");
                panel.showNotification();
            } else if (tb_HDCT.getRowCount() == 0) {
                panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Hóa đơn đã trống. Không thể hủy !");
            } else {
                if (helper.confirm(this, "Bạn có muốn hủy hóa đơn không ?")) {
                    HoaDon hd = iHoaDonService.getObj(tb_hoadon.getValueAt(index, 1).toString());
                    hd.setTrangThai(2);
                    this.iHoaDonService.save(hd);
                    List<HoaDonChiTiet> list = iHoaDonCTService.findByMa(hd.getMa());
                    ChiTietDep ctd;
                    for (int i = 0; i < tb_HDCT.getRowCount(); i++) {
                        list.get(i).getSoLuong();
                        ctd = iChiTietDepService.getObj(list.get(i).getCtdep().getId());
                        ctd.setSoLuong(ctd.getSoLuong() + list.get(i).getSoLuong());
                        iChiTietDepService.save(ctd);
                    }
                    panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Cập nhật thành công!");
                    panel.showNotification();
                    locTrangThai();
                }
            }
        }


    }//GEN-LAST:event_btn_HuyHDActionPerformed

    private void jdate_fromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdate_fromPropertyChange
        // TODO add your handling code here:
        locTrangThai();
    }//GEN-LAST:event_jdate_fromPropertyChange

    private void jdate_toPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdate_toPropertyChange
        // TODO add your handling code here:
        locTrangThai();
    }//GEN-LAST:event_jdate_toPropertyChange

    private void loadHoaDonCT(String maHD) {
        int stt = 1;
        dtm = (DefaultTableModel) tb_HDCT.getModel();
        dtm.setRowCount(0);
        for (HoaDonChiTiet x : iHoaDonCTService.findByMa(maHD)) {
            dtm.addRow(new Object[]{
                stt++, x.getCtdep().getDep().getMa(), x.getCtdep().getDep().getTen(), x.getSoLuong(), x.getDonGia(), x.getSoLuong() * x.getDonGia().doubleValue()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_HuyHD;
    private javax.swing.ButtonGroup buttonGroup1;
    private swing.Combobox cbo_Trangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdate_from;
    private com.toedter.calendar.JDateChooser jdate_to;
    private javax.swing.JLabel lblDiemtichluy;
    private javax.swing.JLabel lblKhuyenmai;
    private javax.swing.JLabel lblThanhtoan;
    private javax.swing.JLabel lblTongtien;
    private javax.swing.JLabel lbl_Change;
    private javax.swing.JLabel lbl_voucher;
    private javax.swing.JLabel lbl_voucher1;
    private swing.Pagination pagination1;
    private swing.TableScrollButton tableScrollButton1;
    private swing.TableScrollButton tableScrollButton2;
    private javax.swing.JTable tb_HDCT;
    private javax.swing.JTable tb_hoadon;
    private swing.TextField txt_Timkiem;
    // End of variables declaration//GEN-END:variables
}
