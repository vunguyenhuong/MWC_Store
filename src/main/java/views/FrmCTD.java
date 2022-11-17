package views;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.ChatLieu;
import models.ChiTietDep;
import models.Dep;
import models.LoaiDep;
import models.MauSac;
import models.NhaSX;
import models.Size;
import services.IChiTietDepService;
import services.impl.ChiTietDepService;
import utilities.ExportSP;
import utilities.Helper;
import utilities.ImageUltil;
import utilities.ImportSP;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class FrmCTD extends javax.swing.JPanel {

    private Helper helper = new Helper();
    private ImageUltil imageUltil = new ImageUltil();
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    private DefaultTableModel defaultTableModel;
    private IChiTietDepService iChiTietDepService;

    private DefaultComboBoxModel<Dep> comboDep = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<LoaiDep> comboLoaiDep = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<ChatLieu> comboChatLieu = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<MauSac> comboMauSac = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<Size> comboSize = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<NhaSX> comboNSX = new DefaultComboBoxModel<>();

    private int checkSearchCT = 0;

    public FrmCTD() {
        initComponents();
        iChiTietDepService = new ChiTietDepService();
        loadData(iChiTietDepService.getAll());
    }
    
    private void loadData(List<ChiTietDep> list) {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_table.getModel();
        defaultTableModel.setRowCount(0);
        for (ChiTietDep x : list) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getDep().getTen(), x.getLoaiDep().getTen(), x.getMauSac().getTen(), x.getChatLieu().getTen(), x.getNhaSX().getTen(), x.getSize().getKichCo(), x.getMoTa(), x.getSoLuong(), x.getGiaNhap(), x.getGiaBan(), x.getTrangThai()
            });
        }
        lbl_total.setText("Total: " + list.size());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_table = new javax.swing.JTable();
        lbl_image = new javax.swing.JLabel();
        rd_ct_ngungkd = new swing.RadioButtonCustom();
        cb_loaidep = new swing.Combobox();
        rd_ct_dangkd = new swing.RadioButtonCustom();
        lbl_total = new javax.swing.JLabel();
        btn_exportExcel1 = new swing.Button();
        sp_soluong = new swing.Spinner();
        jLabel2 = new javax.swing.JLabel();
        btn_ctd_capnhat = new swing.Button();
        cb_mausac = new swing.Combobox();
        txt_timkiem = new swing.TextField();
        txt_giaban = new swing.TextField();
        btn_ctd_them = new swing.Button();
        cb_chatlieu = new swing.Combobox();
        cb_size = new swing.Combobox();
        txt_gianhap = new swing.TextField();
        btn_ctd_xoa = new swing.Button();
        cb_nsx = new swing.Combobox();
        cb_dep = new swing.Combobox();
        txt_mota = new swing.TextField();
        btn_exportExcel = new swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        tb_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên", "Loại", "Màu sắc", "Chất liệu", "NSX", "Size", "Mô tả", "Số lượng", "Giá nhập", "Giá bán", "Trạng thái"
            }
        ));
        tb_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_table);

        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setText(" ");

        rd_ct_ngungkd.setText("Ngừng kinh doanh");
        rd_ct_ngungkd.setFocusPainted(false);

        cb_loaidep.setFocusable(false);
        cb_loaidep.setLabeText("Loại dép");
        cb_loaidep.setLineColor(new java.awt.Color(102, 102, 102));
        cb_loaidep.setRequestFocusEnabled(false);

        rd_ct_dangkd.setText("Đang kinh doanh");
        rd_ct_dangkd.setFocusPainted(false);

        lbl_total.setForeground(java.awt.Color.red);
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setText("Total: 0");

        btn_exportExcel1.setBackground(new java.awt.Color(0, 126, 0));
        btn_exportExcel1.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportExcel1.setText("Import Excel");
        btn_exportExcel1.setFocusPainted(false);
        btn_exportExcel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportExcel1ActionPerformed(evt);
            }
        });

        sp_soluong.setLabelText("Số lượng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("THÔNG TIN SẢN PHẨM");

        btn_ctd_capnhat.setBackground(new java.awt.Color(153, 153, 153));
        btn_ctd_capnhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_ctd_capnhat.setText("Cập nhật");
        btn_ctd_capnhat.setFocusPainted(false);
        btn_ctd_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctd_capnhatActionPerformed(evt);
            }
        });

        cb_mausac.setFocusable(false);
        cb_mausac.setLabeText("Màu sắc");
        cb_mausac.setLineColor(new java.awt.Color(102, 102, 102));
        cb_mausac.setRequestFocusEnabled(false);

        txt_timkiem.setLabelText("Tìm kiếm");
        txt_timkiem.setLineColor(new java.awt.Color(102, 102, 102));
        txt_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkiemCaretUpdate(evt);
            }
        });

        txt_giaban.setLabelText("Giá bán");
        txt_giaban.setLineColor(new java.awt.Color(102, 102, 102));

        btn_ctd_them.setBackground(new java.awt.Color(153, 153, 153));
        btn_ctd_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_ctd_them.setText("Thêm");
        btn_ctd_them.setFocusPainted(false);
        btn_ctd_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctd_themActionPerformed(evt);
            }
        });

        cb_chatlieu.setFocusable(false);
        cb_chatlieu.setLabeText("Chất liệu");
        cb_chatlieu.setLineColor(new java.awt.Color(102, 102, 102));
        cb_chatlieu.setRequestFocusEnabled(false);

        cb_size.setFocusable(false);
        cb_size.setLabeText("Size");
        cb_size.setLineColor(new java.awt.Color(102, 102, 102));
        cb_size.setRequestFocusEnabled(false);

        txt_gianhap.setLabelText("Giá nhập");
        txt_gianhap.setLineColor(new java.awt.Color(102, 102, 102));

        btn_ctd_xoa.setBackground(new java.awt.Color(153, 153, 153));
        btn_ctd_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_ctd_xoa.setText("Xóa");
        btn_ctd_xoa.setFocusPainted(false);
        btn_ctd_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctd_xoaActionPerformed(evt);
            }
        });

        cb_nsx.setFocusable(false);
        cb_nsx.setLabeText("Nhà sản xuất");
        cb_nsx.setLineColor(new java.awt.Color(102, 102, 102));
        cb_nsx.setRequestFocusEnabled(false);

        cb_dep.setFocusable(false);
        cb_dep.setLabeText("Dép");
        cb_dep.setLineColor(new java.awt.Color(102, 102, 102));
        cb_dep.setRequestFocusEnabled(false);

        txt_mota.setLabelText("Mô tả");
        txt_mota.setLineColor(new java.awt.Color(102, 102, 102));

        btn_exportExcel.setBackground(new java.awt.Color(0, 126, 0));
        btn_exportExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportExcel.setText("Export Excel");
        btn_exportExcel.setFocusPainted(false);
        btn_exportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_gianhap, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(txt_mota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rd_ct_ngungkd, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sp_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rd_ct_dangkd, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_dep, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(cb_chatlieu, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_loaidep, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_size, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_timkiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btn_ctd_them, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ctd_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ctd_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_exportExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(cb_chatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cb_dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cb_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cb_loaidep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sp_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_ct_dangkd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_gianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_ct_ngungkd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ctd_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ctd_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ctd_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_total)
                    .addComponent(btn_exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exportExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cb_chatlieu, cb_dep, cb_loaidep, cb_mausac, cb_nsx, cb_size});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {rd_ct_dangkd, sp_soluong, txt_giaban, txt_gianhap, txt_mota});

    }// </editor-fold>//GEN-END:initComponents

    private void tb_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_tableMouseClicked
        int row = tb_table.getSelectedRow();
        ChiTietDep ctd = iChiTietDepService.getAll().get(row);
        comboDep.setSelectedItem(ctd.getDep());
        comboLoaiDep.setSelectedItem(ctd.getLoaiDep());
        comboChatLieu.setSelectedItem(ctd.getChatLieu());
        comboSize.setSelectedItem(ctd.getSize());
        comboNSX.setSelectedItem(ctd.getNhaSX());
        comboMauSac.setSelectedItem(ctd.getMauSac());
        txt_mota.setText(ctd.getMoTa());
        txt_gianhap.setText(ctd.getGiaNhap().toString());
        txt_giaban.setText(ctd.getGiaBan().toString());
        sp_soluong.setValue(ctd.getSoLuong());
        if (ctd.getTrangThai() == 0) {
            rd_ct_dangkd.setSelected(true);
        } else {
            rd_ct_ngungkd.setSelected(true);
        }
        lbl_image.setIcon(imageUltil.resizeIcon(new ImageIcon("images/products/" + ctd.getDep().getHinhAnh()), lbl_image.getWidth(), lbl_image.getHeight()));
        System.out.println(ctd.getDep().getHinhAnh());
    }//GEN-LAST:event_tb_tableMouseClicked

    private void btn_exportExcel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportExcel1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".xlsx", "xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Import Excel");
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileOpen = fileChooser.getSelectedFile();
            try {
                List<ChiTietDep> list = ImportSP.readExcel(fileOpen.getAbsolutePath());
                if (helper.confirm(this, "Xác nhận thêm " + list.size() + " sản phẩm ?")) {
                    for (ChiTietDep x : list) {
                        iChiTietDepService.save(x);
                    }
                    loadData(iChiTietDepService.getAll());
                    helper.alert(this, "Thêm thành công!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                helper.alert(this, "Add File thất bại!");
            }
            System.out.println("Save as file: " + fileOpen.getAbsolutePath());
        }
    }//GEN-LAST:event_btn_exportExcel1ActionPerformed

    private void btn_ctd_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctd_capnhatActionPerformed
        int row = tb_table.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần sửa!");
        } else {
            ChiTietDep ctd;
            if (checkSearchCT == 0) {
                ctd = iChiTietDepService.getAll().get(row);
            } else {
                ctd = iChiTietDepService.findByName(txt_timkiem.getText()).get(row);
            }
            ctd.setDep((Dep) comboDep.getSelectedItem());
            ctd.setLoaiDep((LoaiDep) comboLoaiDep.getSelectedItem());
            ctd.setMauSac((MauSac) comboMauSac.getSelectedItem());
            ctd.setChatLieu((ChatLieu) comboChatLieu.getSelectedItem());
            ctd.setNhaSX((NhaSX) comboNSX.getSelectedItem());
            ctd.setSize((Size) comboSize.getSelectedItem());
            ctd.setMoTa(txt_mota.getText());
            ctd.setSoLuong((int) sp_soluong.getValue());
            ctd.setGiaNhap(helper.convertToDecimal(txt_gianhap, "Error!"));
            ctd.setGiaBan(helper.convertToDecimal(txt_giaban, "Error!"));
            ctd.setNgaySuaCuoi(new Date());
            if (rd_ct_dangkd.isSelected()) {
                ctd.setTrangThai(0);
            } else {
                ctd.setTrangThai(1);
            }
            iChiTietDepService.save(ctd);
            loadData(iChiTietDepService.getAll());
            checkSearchCT = 0;
            helper.alert(this, "Sửa thành công!");
        }
    }//GEN-LAST:event_btn_ctd_capnhatActionPerformed

    private void txt_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkiemCaretUpdate
        loadData(iChiTietDepService.findByName(txt_timkiem.getText()));
        if (iChiTietDepService.findByName(txt_timkiem.getText()).size() == iChiTietDepService.getAll().size()) {
            checkSearchCT = 0;
        } else {
            checkSearchCT = 1;
        }
    }//GEN-LAST:event_txt_timkiemCaretUpdate

    private void btn_ctd_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctd_themActionPerformed
        ChiTietDep ctd = new ChiTietDep();
        ctd.setDep((Dep) comboDep.getSelectedItem());
        ctd.setLoaiDep((LoaiDep) comboLoaiDep.getSelectedItem());
        ctd.setMauSac((MauSac) comboMauSac.getSelectedItem());
        ctd.setChatLieu((ChatLieu) comboChatLieu.getSelectedItem());
        ctd.setNhaSX((NhaSX) comboNSX.getSelectedItem());
        ctd.setSize((Size) comboSize.getSelectedItem());
        ctd.setMoTa(txt_mota.getText());
        ctd.setSoLuong((int) sp_soluong.getValue());
        ctd.setGiaNhap(helper.convertToDecimal(txt_gianhap, "Error!"));
        ctd.setGiaBan(helper.convertToDecimal(txt_giaban, "Error!"));
        ctd.setNgayThem(new Date());
        ctd.setNgaySuaCuoi(new Date());
        if (rd_ct_dangkd.isSelected()) {
            ctd.setTrangThai(0);
        } else {
            ctd.setTrangThai(1);
        }
        iChiTietDepService.save(ctd);
        loadData(iChiTietDepService.getAll());
        helper.alert(this, "Thêm thành công!");
    }//GEN-LAST:event_btn_ctd_themActionPerformed

    private void btn_ctd_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctd_xoaActionPerformed
        int row = tb_table.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần sửa!");
        } else {
            ChiTietDep ctd;
            if (checkSearchCT == 0) {
                ctd = iChiTietDepService.getAll().get(row);
            } else {
                ctd = iChiTietDepService.findByName(txt_timkiem.getText()).get(row);
            }
            if (helper.confirm(this, "Xác nhận xóa")) {
                iChiTietDepService.delete(ctd);
                loadData(iChiTietDepService.getAll());
                checkSearchCT = 0;
                helper.alert(this, "Xóa thành công!");
            }
        }
    }//GEN-LAST:event_btn_ctd_xoaActionPerformed

    private void btn_exportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportExcelActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".xlsx", "xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Export Excel");
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                if (helper.confirm(this, "File Path: " + fileToSave.getAbsolutePath() + filter.getDescription() + ". Xác nhận xuất file ?")) {
                    ExportSP.writeExcel(iChiTietDepService.getAll(), fileToSave.getAbsolutePath() + filter.getDescription());
                    helper.alert(this, "Xuất File thành công!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                helper.alert(this, "Xuất File thất bại!");
            }
            System.out.println("Save as file: " + fileToSave.getAbsolutePath() + filter.getDescription());
        }
    }//GEN-LAST:event_btn_exportExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_ctd_capnhat;
    private swing.Button btn_ctd_them;
    private swing.Button btn_ctd_xoa;
    private swing.Button btn_exportExcel;
    private swing.Button btn_exportExcel1;
    private swing.Combobox cb_chatlieu;
    private swing.Combobox cb_dep;
    private swing.Combobox cb_loaidep;
    private swing.Combobox cb_mausac;
    private swing.Combobox cb_nsx;
    private swing.Combobox cb_size;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_total;
    private swing.RadioButtonCustom rd_ct_dangkd;
    private swing.RadioButtonCustom rd_ct_ngungkd;
    private swing.Spinner sp_soluong;
    private javax.swing.JTable tb_table;
    private swing.TextField txt_giaban;
    private swing.TextField txt_gianhap;
    private swing.TextField txt_mota;
    private swing.TextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}