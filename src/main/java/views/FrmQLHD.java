package views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import models.HoaDon;
import models.HoaDonChiTiet;
import models.KhachHang;
import models.KhuyenMai;
import services.IHoaDonCTService;
import services.IHoaDonService;
import services.IKhuyenMaiService;
import services.impl.HoaDonCTService;
import services.impl.HoaDonService;
import services.impl.KhuyenMaiService;
import swing.Table;
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

        loadComboboxTrangThai();
        loadDataToHD(iHoaDonService.getAll());
//        loadDataKH();
        locTrangThai();
    }

    public void loadComboboxTrangThai() {
        comboHD = (DefaultComboBoxModel<HoaDon>) cbo_Trangthai.getModel();
        comboHD.removeAllElements();
        comboHD.addElement("Tất cả");
        comboHD.addElement("Chưa thanh toán");
        comboHD.addElement("Đã thanh toán");
        comboHD.addElement("Đã hủy");
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
                hd.getTrangThai() == 1 ? "Đã thanh toán" : "Chưa thanh toán"
            };
            dtm.addRow(rowData);
        }
    }

    public void locTrangThai() {
        int index = cbo_Trangthai.getSelectedIndex();
        Date from = new Date();
        Date to = new Date();
        String fromString;
        String toString;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fromString = format.format(jdate_from.getDate());
            toString = format.format(jdate_to.getDate());
            from = format.parse(fromString);
            to = format.parse(toString);
            System.out.println(from);
            System.out.println(to);
        } catch (Exception e) {
        }
        iHoaDonService.filter(txt_Timkiem.getText(), from, to, -1);
        if (index == 0) {
            iHoaDonService.filter(txt_Timkiem.getText(), from, to, -1);
        } else if (index == 1) {
            iHoaDonService.filter(txt_Timkiem.getText(), from, to, 0);
        } else if (index == 2) {
            iHoaDonService.filter(txt_Timkiem.getText(), from, to, 1);
        } else {
            iHoaDonService.filter(txt_Timkiem.getText(), from, to, 2);
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

        lblKhuyenmai.setText(String.valueOf(khuyenmai));

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
        button1 = new swing.Button();
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

        button1.setBackground(new java.awt.Color(102, 102, 102));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Hủy hóa đơn");

        jLabel3.setText("Từ ngày");

        jdate_from.setDateFormatString("yyyy-MM-dd");

        jdate_to.setDateFormatString("yyyy-MM-dd");

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
                        .addComponent(cbo_Trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdate_from, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdate_to, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdate_to, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(jdate_from, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(9, 9, 9))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_Trangthai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Timkiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Hóa đơn chi tiết"));

        tb_HDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HD", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
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
        lbl_voucher.setText("Khuyến mãi :");

        lbl_Change.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Change.setForeground(new java.awt.Color(255, 0, 0));
        lbl_Change.setText("Thanh toán :");

        lblKhuyenmai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKhuyenmai.setText("0");

        lblThanhtoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThanhtoan.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTongtien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTongtien)
                    .addComponent(lbl_voucher)
                    .addComponent(lblKhuyenmai)
                    .addComponent(lbl_Change)
                    .addComponent(lblThanhtoan))
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
    private swing.Button button1;
    private javax.swing.ButtonGroup buttonGroup1;
    private swing.Combobox cbo_Trangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdate_from;
    private com.toedter.calendar.JDateChooser jdate_to;
    private javax.swing.JLabel lblKhuyenmai;
    private javax.swing.JLabel lblThanhtoan;
    private javax.swing.JLabel lblTongtien;
    private javax.swing.JLabel lbl_Change;
    private javax.swing.JLabel lbl_voucher;
    private swing.TableScrollButton tableScrollButton1;
    private swing.TableScrollButton tableScrollButton2;
    private javax.swing.JTable tb_HDCT;
    private javax.swing.JTable tb_hoadon;
    private swing.TextField txt_Timkiem;
    // End of variables declaration//GEN-END:variables
}
