package views;

import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.ChucVu;
import models.NguoiDung;
import services.IChucVuService;
import services.INguoiDungService;
import services.impl.ChucVuService;
import services.impl.NguoiDungService;
import swing.Table;
import ui.EventPagination;
import ui.NotificationMess;
import ui.Page;
import ui.PaginationItemRenderStyle1;
import utilities.Helper;

/**
 *
 * @author VU NGUYEN HUONG
 *
 *
 */
public class FrmNhanVien extends javax.swing.JPanel {

    private DefaultTableModel defaultTableModel;
    private INguoiDungService nguoidungSV;
    private IChucVuService iChucVuService;
    private Helper helper;
    private String filename;
    
    private Page pg = new Page();
    private int checkSearchCT = 0;
    
    Integer limit = 5;
    Integer totalData = 0;

    public FrmNhanVien() {
        initComponents();
        nguoidungSV = new NguoiDungService();
        iChucVuService = new ChucVuService();
        Table.apply(jScrollPane1, Table.TableType.DEFAULT);
        helper = new Helper();
//        LoadData(nguoidungSV.getListNhanVien("CV2"));
        pagination();
        pagination1.setPagegination(1, pg.getTotalPage());
        pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());

    }
    
    public void pagination() {
        LoadData(nguoidungSV.pagination("CV2",pg.getCurrent(), limit));
        totalData = nguoidungSV.getAll().size();
        int totalPage = (int) Math.ceil(totalData.doubleValue() / limit);
        pg.setTotalPage(totalPage);
        pagination1.setPagegination(pg.getCurrent(), pg.getTotalPage());
        pagination1.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                LoadData(nguoidungSV.pagination("CV2",page, limit));
                pg.setCurrent(page);
                pagination1.setPagegination(pg.getCurrent(), pg.getTotalPage());
            }
        });
    }

    public void LoadData(List<NguoiDung> list) {
        defaultTableModel = (DefaultTableModel) tb_nhanvien.getModel();
        defaultTableModel.setRowCount(0);
        int stt = 1;
        for (NguoiDung x : list) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getMa(), x.getTen(), x.getEmail(), x.getSdt(), x.getDiaChi(),
                x.getGioiTinh() == 0 ? "Nam" : "Nữ",
                x.getTrangThai() == 0 ? "Đang làm" : "Nghỉ làm",
                x.getHinhAnh()
            });
            lbl_Total.setText("Total :" + list.size());
        }
    }

    public NguoiDung getForm() {
        NguoiDung nguoidung = new NguoiDung();
        nguoidung.setMa(txt_ma.getText());
        nguoidung.setTen(txt_ten.getText());
        nguoidung.setEmail(txt_email.getText());
        nguoidung.setSdt(txt_sdt.getText());
        nguoidung.setDiaChi(txt_diachi.getText());
        nguoidung.setHinhAnh("defaultavt.jpg");
        nguoidung.setMatKhau(txt_matkhau.getText());
        ChucVu cv = iChucVuService.getAll().get(1);
        nguoidung.setChucVu(cv);
        int gioitinh;
        if (rd_nam.isSelected()) {
            gioitinh = 0;
        } else {
            gioitinh = 1;
        }
        nguoidung.setGioiTinh(gioitinh);
        if (cb_trangthai.getSelectedItem().equals("Đang làm")) {
            nguoidung.setTrangThai(0);
        } else {
            nguoidung.setTrangThai(1);
        }
        nguoidung.setHinhAnh("defaultavt.jpg");
        return nguoidung;
    }

    private boolean checkNull() {
        if (helper.checkNull(txt_ma, "Mã") || helper.checkNull(txt_ten, "Tên") || helper.checkNull(txt_email, "Email") || helper.checkNull(txt_sdt, "Số điện thoại") || helper.checkNull(txt_matkhau, "Mật khẩu")
                || helper.checkRegex(txt_ten, "(\\S+ )*\\S+", "Tên không hợp lệ!")) {
            return true;
        }
        if (helper.checkRegex(txt_sdt, "^0([0-9]{9})$", "Số điện thoại không hợp lệ!")) {
            return true;
        }
        if (helper.checkRegex(txt_diachi, "(\\S+ )*\\S+", "Địa chỉ không hợp lệ!")) {
            return true;
        }
        if (helper.checkRegex(txt_email, "^(.+)@(\\S+)$", "Email không hợp lệ!")) {
            return true;
        }
        if (txt_matkhau.getText().length() < 6) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Mật khẩu tối thiểu 6 kí tự");
            panel.showNotification();
            return true;
        }
        return false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btn_scanqr = new swing.Button();
        txt_email = new swing.TextField();
        txt_ten = new swing.TextField();
        txt_diachi = new swing.TextField();
        rd_nam = new swing.RadioButtonCustom();
        rd_nu = new swing.RadioButtonCustom();
        txt_ma = new swing.TextField();
        txt_sdt = new swing.TextField();
        txt_matkhau = new swing.PasswordField();
        cb_trangthai = new swing.Combobox();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_nhanvien = new javax.swing.JTable();
        btn_them = new swing.Button();
        btn_sua = new swing.Button();
        btn_xoa = new swing.Button();
        txt_timkiem = new swing.TextField();
        lblHinhAnh = new javax.swing.JLabel();
        lbl_Total = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pagination1 = new swing.Pagination();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        btn_scanqr.setBackground(new java.awt.Color(0, 0, 102));
        btn_scanqr.setForeground(new java.awt.Color(255, 255, 255));
        btn_scanqr.setText("Quét QR");
        btn_scanqr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_scanqrActionPerformed(evt);
            }
        });

        txt_email.setLabelText("Email");

        txt_ten.setLabelText("Tên");

        txt_diachi.setLabelText("Địa chỉ");

        buttonGroup1.add(rd_nam);
        rd_nam.setSelected(true);
        rd_nam.setText("Nam");

        buttonGroup1.add(rd_nu);
        rd_nu.setText("Nữ");

        txt_ma.setLabelText("Mã");

        txt_sdt.setLabelText("SDT");

        txt_matkhau.setLabelText("Mật Khẩu");
        txt_matkhau.setShowAndHide(true);

        cb_trangthai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Đang làm", "Nghỉ làm" }));
        cb_trangthai.setLabeText("Trạng Thái");

        tb_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên", "Email", "Số Điện Thoại", "Địa Chỉ", "Giới tính", "Trạng Thái"
            }
        ));
        tb_nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_nhanvienMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_nhanvien);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btn_them.setBackground(new java.awt.Color(102, 102, 102));
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(102, 102, 102));
        btn_sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua.setText("Cập nhật");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(102, 102, 102));
        btn_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        txt_timkiem.setLabelText("Tìm Kiếm");
        txt_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkiemCaretUpdate(evt);
            }
        });

        lblHinhAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_Total.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_Total.setForeground(new java.awt.Color(255, 0, 0));
        lbl_Total.setText("Total : 0");

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        pagination1.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(544, Short.MAX_VALUE)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(537, 537, 537))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                                .addComponent(lbl_Total)
                                .addGap(184, 184, 184)
                                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_scanqr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_ma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                    .addComponent(txt_ten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_diachi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_matkhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_sua, btn_them, btn_xoa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_scanqr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_Total))))
                    .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_sua, btn_them, btn_xoa});

    }// </editor-fold>//GEN-END:initComponents

    private void btn_scanqrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_scanqrActionPerformed
        FrmQRCCCD fqrcccd = new FrmQRCCCD(null, true);
        fqrcccd.setVisible(true);
//        NguoiDung nd = qRCCD.getNguoiDung();
//        txt_ma.setText(nd.getMa());
//        txt_ten.setText("");
//        txt_diachi.setText("");
//        if ("" == "Nam") {
//            rd_nam.setSelected(true);
//        } else {
//            rd_nu.setSelected(true);
//        }

//         txt_ma.setText("");
//        txt_ten.setText("");
//        txt_diachi.setText("");
//        if ("" == "Nam") {
//            rd_nam.setSelected(true);
//        } else {
//            rd_nu.setSelected(true);
//        }
        System.out.println("Đã quét xong");
        LoadData(nguoidungSV.getListNhanVien("CV2"));
    }//GEN-LAST:event_btn_scanqrActionPerformed
    public void clearForm() {
        tb_nhanvien.setRowSelectionAllowed(false);
        txt_ma.setEditable(true);
        txt_ma.setText("");
        txt_ten.setText("");
        txt_email.setText("");
        txt_sdt.setText("");
        txt_diachi.setText("");
        txt_matkhau.setText("");
        rd_nam.setSelected(true);
        cb_trangthai.setSelectedIndex(0);
    }
    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        if (checkNull()) {
            return;
        }
        if (nguoidungSV.getObj(txt_ma.getText()) == null) {
            this.nguoidungSV.save(getForm());
            pagination();
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Thêm thành công");
            panel.showNotification();
            clearForm();
        } else {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Mã này đã có không thể thêm");
            panel.showNotification();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int row = tb_nhanvien.getSelectedRow();
        if (row == -1) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Chọn 1 dòng nhân viên để cập nhật");
            panel.showNotification();
            return;
        }
        if (checkNull()) {
            return;
        }
        NguoiDung nd = nguoidungSV.getObj(tb_nhanvien.getValueAt(row, 1).toString());
        nd.setTen(txt_ten.getText());
        nd.setDiaChi(txt_diachi.getText());
        nd.setEmail(txt_email.getText());
        nd.setSdt(txt_sdt.getText());
        if (rd_nam.isSelected()) {
            nd.setGioiTinh(0);
        } else {
            nd.setGioiTinh(1);
        }
        if (cb_trangthai.getSelectedItem().equals("Đang làm")) {
            nd.setTrangThai(0);
        } else {
            nd.setTrangThai(1);
        }
        nd.setMatKhau(txt_matkhau.getText());
        this.nguoidungSV.save(nd);
        if (checkSearchCT == 0) {
                nd = nguoidungSV.pagination("CV2",pg.getCurrent(), limit).get(row);
            } else {
                nd = nguoidungSV.findByName("CV2",txt_timkiem.getText()).get(row);
            }
        pagination();
        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Cập nhật thành công");
        panel.showNotification();
        clearForm();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        int row = tb_nhanvien.getSelectedRow();
        if (row == -1) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Chọn 1 dòng nhân viên để xóa");
            panel.showNotification();
            return;
        }
        NguoiDung nguoiDung = nguoidungSV.getListNhanVien("CV2").get(row);
        this.nguoidungSV.delete(nguoiDung);
        if (checkSearchCT == 0) {
                nguoiDung = nguoidungSV.pagination("CV2",pg.getCurrent(), limit).get(row);
            } else {
                nguoiDung = nguoidungSV.findByName("CV2",txt_timkiem.getText()).get(row);
            }
        pagination();
        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Xóa thành công");
        panel.showNotification();
        clearForm();

    }//GEN-LAST:event_btn_xoaActionPerformed

    private void txt_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkiemCaretUpdate
        LoadData(nguoidungSV.findByName("CV2", txt_timkiem.getText().trim()));
    }//GEN-LAST:event_txt_timkiemCaretUpdate

    private void tb_nhanvienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_nhanvienMousePressed
        // TODO add your handling code here:
        int row = tb_nhanvien.getSelectedRow();
        tb_nhanvien.setRowSelectionAllowed(true);
        txt_ma.setEditable(false);
        NguoiDung nd = nguoidungSV.pagination("CV2",pg.getCurrent(), limit).get(row);
        txt_ma.setText(nd.getMa());
        txt_diachi.setText(nd.getDiaChi());
        txt_email.setText(nd.getEmail());
        txt_matkhau.setText(nd.getMatKhau());
        txt_sdt.setText(nd.getSdt());
        txt_ten.setText(nd.getTen());
        cb_trangthai.setSelectedIndex(nd.getTrangThai());
        rd_nam.setSelected(nd.getGioiTinh() == 0);
        rd_nu.setSelected(nd.getGioiTinh() == 1);
        ImageIcon i = utilities.ImageUltil.resizeIcon(new ImageIcon("images/users/" + nd.getHinhAnh()), lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
        lblHinhAnh.setIcon(i);
        filename = nd.getHinhAnh();
    }//GEN-LAST:event_tb_nhanvienMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_scanqr;
    private swing.Button btn_sua;
    private swing.Button btn_them;
    private swing.Button btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private swing.Combobox cb_trangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lbl_Total;
    private swing.Pagination pagination1;
    private swing.RadioButtonCustom rd_nam;
    private swing.RadioButtonCustom rd_nu;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tb_nhanvien;
    private swing.TextField txt_diachi;
    private swing.TextField txt_email;
    private swing.TextField txt_ma;
    private swing.PasswordField txt_matkhau;
    private swing.TextField txt_sdt;
    private swing.TextField txt_ten;
    private swing.TextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
