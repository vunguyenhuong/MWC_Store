package views;

import customModel.CTDepCustom;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import models.*;
import services.*;
import services.impl.*;
import utilities.ExportSP;
import utilities.Helper;
import utilities.ImageUltil;
import utilities.ImportSP;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class FrmChiTietDep extends javax.swing.JInternalFrame {

    private Helper helper = new Helper();
    private ImageUltil imageUltil = new ImageUltil();
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    private DefaultTableModel defaultTableModel;
    private IChiTietDepService iChiTietDepService;
    private IMauSacService iMauSacService;
    private INhaSXService iNhaSXService;

    private IQLDepService iQLDepService = new QLDepService();

    private DefaultComboBoxModel<Dep> comboDep = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<LoaiDep> comboLoaiDep = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<ChatLieu> comboChatLieu = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<MauSac> comboMauSac = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<Size> comboSize = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<NhaSX> comboNSX = new DefaultComboBoxModel<>();

    public FrmChiTietDep() {
        initComponents();
        try {
            setMaximum(true);
            this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
            BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
            bi.setNorthPane(null);
        } catch (Exception e) {
        }
        iNhaSXService = new NhaSXService();
        iMauSacService = new MauSacService();
        iChiTietDepService = new ChiTietDepService();
        loadData();
    }

    private void loadDataChiTiet(List<CTDepCustom> list) {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_table.getModel();
        defaultTableModel.setRowCount(0);
        for (CTDepCustom x : list) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getDep().getTen(), x.getLoaiDep().getTen(), x.getMauSac().getTen(), x.getChatLieu().getTen(), x.getNhaSX().getTen(), x.getSize().getKichCo(), x.getCtd().getMoTa(), x.getCtd().getSoLuong(), x.getCtd().getGiaNhap(), x.getCtd().getGiaBan(), x.getCtd().getTrangThai()
            });
        }
        lbl_total.setText("Total: " + list.size());
    }
//    private void loadData(List<ChiTietDep> list) {
//        int stt = 1;
//        defaultTableModel = (DefaultTableModel) tb_table.getModel();
//        defaultTableModel.setRowCount(0);
//        for (ChiTietDep x : list) {
//            defaultTableModel.addRow(new Object[]{
//                stt++, x.getDep().getTen(), x.getLoaiDep().getTen(), x.getMauSac().getTen(), x.getChatLieu().getTen(), x.getNhaSX().getTen(), x.getSize().getKichCo(), x.getMoTa(), x.getSoLuong(), x.getGiaNhap(), x.getGiaBan(), x.getTrangThai()
//            });
//        }
//        lbl_total.setText("Total: " + list.size());
//    }

    private void loadData() {
//        loadData(iChiTietDepService.getAll());
        loadDataMauSac(iMauSacService.getAll());
        loadDataNSX(iNhaSXService.getAll());
        addCbDep();
        addCbLoaiDep();
        addCbChatLieu();
        addCbMauSac();
        addCbSize();
        addCbNhaSX();
        loadDataChiTiet(iQLDepService.getAll());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonMS = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbl_image = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_giaban = new swing.TextField();
        txt_gianhap = new swing.TextField();
        txt_mota = new swing.TextField();
        rd_ct_dangkd = new swing.RadioButtonCustom();
        rd_ct_ngungkd = new swing.RadioButtonCustom();
        sp_soluong = new swing.Spinner();
        txt_timkiem = new swing.TextField();
        cb_size = new swing.Combobox();
        cb_dep = new swing.Combobox();
        cb_loaidep = new swing.Combobox();
        cb_mausac = new swing.Combobox();
        cb_chatlieu = new swing.Combobox();
        cb_nsx = new swing.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_table = new javax.swing.JTable();
        lbl_total = new javax.swing.JLabel();
        btn_ctd_capnhat = new swing.Button();
        btn_ctd_them = new swing.Button();
        btn_ctd_xoa = new swing.Button();
        btn_exportExcel = new swing.Button();
        btn_exportExcel1 = new swing.Button();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_ms_timkiem = new swing.TextField();
        btn_ms_capnhat = new swing.Button();
        lbl_ms_total = new javax.swing.JLabel();
        txt_ms_ten = new swing.TextField();
        rd_ms_ngungkd = new swing.RadioButtonCustom();
        rd_ms_dangkd = new swing.RadioButtonCustom();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_mausac = new javax.swing.JTable();
        txt_ms_ma = new swing.TextField();
        btn_ms_them = new swing.Button();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_nsx_ma = new swing.TextField();
        btn_nsx_capnhat = new swing.Button();
        txt_nsx_ten = new swing.TextField();
        rd_nsx_ngungkd = new swing.RadioButtonCustom();
        rd_nsx_dangkd = new swing.RadioButtonCustom();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_nsx = new javax.swing.JTable();
        btn_nsx_them = new swing.Button();
        txt_nsx_timkiem = new swing.TextField();
        lbl_nsx_total = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(100, 200));
        jTabbedPane1.setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setText(" ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("THÔNG TIN SẢN PHẨM");

        txt_giaban.setLabelText("Giá bán");
        txt_giaban.setLineColor(new java.awt.Color(102, 102, 102));

        txt_gianhap.setLabelText("Giá nhập");
        txt_gianhap.setLineColor(new java.awt.Color(102, 102, 102));

        txt_mota.setLabelText("Mô tả");
        txt_mota.setLineColor(new java.awt.Color(102, 102, 102));

        buttonGroup1.add(rd_ct_dangkd);
        rd_ct_dangkd.setText("Đang kinh doanh");
        rd_ct_dangkd.setFocusPainted(false);

        buttonGroup1.add(rd_ct_ngungkd);
        rd_ct_ngungkd.setText("Ngừng kinh doanh");
        rd_ct_ngungkd.setFocusPainted(false);

        sp_soluong.setLabelText("Số lượng");

        txt_timkiem.setLabelText("Tìm kiếm");
        txt_timkiem.setLineColor(new java.awt.Color(102, 102, 102));
        txt_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkiemCaretUpdate(evt);
            }
        });

        cb_size.setFocusable(false);
        cb_size.setLabeText("Size");
        cb_size.setLineColor(new java.awt.Color(102, 102, 102));
        cb_size.setRequestFocusEnabled(false);

        cb_dep.setFocusable(false);
        cb_dep.setLabeText("Dép");
        cb_dep.setLineColor(new java.awt.Color(102, 102, 102));
        cb_dep.setRequestFocusEnabled(false);

        cb_loaidep.setFocusable(false);
        cb_loaidep.setLabeText("Loại dép");
        cb_loaidep.setLineColor(new java.awt.Color(102, 102, 102));
        cb_loaidep.setRequestFocusEnabled(false);

        cb_mausac.setFocusable(false);
        cb_mausac.setLabeText("Màu sắc");
        cb_mausac.setLineColor(new java.awt.Color(102, 102, 102));
        cb_mausac.setRequestFocusEnabled(false);

        cb_chatlieu.setFocusable(false);
        cb_chatlieu.setLabeText("Chất liệu");
        cb_chatlieu.setLineColor(new java.awt.Color(102, 102, 102));
        cb_chatlieu.setRequestFocusEnabled(false);

        cb_nsx.setFocusable(false);
        cb_nsx.setLabeText("Nhà sản xuất");
        cb_nsx.setLineColor(new java.awt.Color(102, 102, 102));
        cb_nsx.setRequestFocusEnabled(false);

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

        lbl_total.setForeground(java.awt.Color.red);
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setText("Total: 0");

        btn_ctd_capnhat.setBackground(new java.awt.Color(153, 153, 153));
        btn_ctd_capnhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_ctd_capnhat.setText("Cập nhật");
        btn_ctd_capnhat.setFocusPainted(false);
        btn_ctd_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctd_capnhatActionPerformed(evt);
            }
        });

        btn_ctd_them.setBackground(new java.awt.Color(153, 153, 153));
        btn_ctd_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_ctd_them.setText("Thêm");
        btn_ctd_them.setFocusPainted(false);
        btn_ctd_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctd_themActionPerformed(evt);
            }
        });

        btn_ctd_xoa.setBackground(new java.awt.Color(153, 153, 153));
        btn_ctd_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_ctd_xoa.setText("Xóa");
        btn_ctd_xoa.setFocusPainted(false);
        btn_ctd_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctd_xoaActionPerformed(evt);
            }
        });

        btn_exportExcel.setBackground(new java.awt.Color(0, 126, 0));
        btn_exportExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportExcel.setText("Export Excel");
        btn_exportExcel.setFocusPainted(false);
        btn_exportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportExcelActionPerformed(evt);
            }
        });

        btn_exportExcel1.setBackground(new java.awt.Color(0, 126, 0));
        btn_exportExcel1.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportExcel1.setText("Import Excel");
        btn_exportExcel1.setFocusPainted(false);
        btn_exportExcel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportExcel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_ctd_them, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ctd_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ctd_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lbl_total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_exportExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_dep, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_chatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_mota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_gianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sp_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_loaidep, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rd_ct_dangkd, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_size, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rd_ct_ngungkd, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_chatlieu, txt_mota});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cb_dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_chatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_gianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(cb_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cb_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(cb_loaidep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cb_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(sp_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(rd_ct_dangkd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_giaban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rd_ct_ngungkd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ctd_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ctd_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ctd_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_total)
                    .addComponent(btn_exportExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cb_chatlieu, cb_dep, cb_loaidep, cb_mausac, cb_nsx, cb_size, rd_ct_dangkd, rd_ct_ngungkd, sp_soluong, txt_giaban, txt_gianhap, txt_mota});

        jTabbedPane1.addTab("Chi tiết dép", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("DÉP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(839, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(592, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dép", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("LOẠI DÉP");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(802, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(592, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Loại dép", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("CHẤT LIỆU");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(794, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(592, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chất liệu", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("SIZE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(836, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(592, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Size", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("MÀU SẮC");

        txt_ms_timkiem.setLabelText("Tìm kiếm");
        txt_ms_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_ms_timkiemCaretUpdate(evt);
            }
        });

        btn_ms_capnhat.setBackground(new java.awt.Color(153, 153, 153));
        btn_ms_capnhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_ms_capnhat.setLabel("Cập nhật");
        btn_ms_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ms_capnhatActionPerformed(evt);
            }
        });

        lbl_ms_total.setForeground(new java.awt.Color(255, 0, 51));
        lbl_ms_total.setText("Total: 0");

        txt_ms_ten.setLabelText("Tên màu sắc");

        buttonMS.add(rd_ms_ngungkd);
        rd_ms_ngungkd.setText(" Ngừng kinh doanh");
        rd_ms_ngungkd.setActionCommand("");

        buttonMS.add(rd_ms_dangkd);
        rd_ms_dangkd.setSelected(true);
        rd_ms_dangkd.setText("Đang kinh doanh");

        tb_mausac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Ngày thêm", "Ngày  sửa cuối", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_mausac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_mausacMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_mausac);

        txt_ms_ma.setEditable(false);
        txt_ms_ma.setToolTipText("");
        txt_ms_ma.setLabelText("Mã :");

        btn_ms_them.setBackground(new java.awt.Color(153, 153, 153));
        btn_ms_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_ms_them.setLabel("Thêm");
        btn_ms_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ms_themActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ms_ten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_ms_ma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_ms_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rd_ms_dangkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_ms_ngungkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ms_total))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btn_ms_them, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ms_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ms_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_ms_dangkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ms_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_ms_ngungkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ms_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ms_total))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_ms_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ms_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(379, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Màu sắc", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("NHÀ SẢN XUẤT");

        txt_nsx_ma.setEditable(false);
        txt_nsx_ma.setToolTipText("");
        txt_nsx_ma.setLabelText("Mã :");

        btn_nsx_capnhat.setBackground(new java.awt.Color(153, 153, 153));
        btn_nsx_capnhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_nsx_capnhat.setFocusPainted(false);
        btn_nsx_capnhat.setLabel("Cập nhật");
        btn_nsx_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nsx_capnhatActionPerformed(evt);
            }
        });

        txt_nsx_ten.setLabelText("Tên NSX");

        rd_nsx_ngungkd.setText("Ngừng kinh doanh");
        rd_nsx_ngungkd.setActionCommand("");
        rd_nsx_ngungkd.setFocusPainted(false);

        rd_nsx_dangkd.setSelected(true);
        rd_nsx_dangkd.setText("Đang kinh doanh");
        rd_nsx_dangkd.setFocusPainted(false);

        tb_nsx.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Ngày thêm", "Ngày  sửa cuối", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_nsx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_nsxMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_nsx);

        btn_nsx_them.setBackground(new java.awt.Color(153, 153, 153));
        btn_nsx_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_nsx_them.setFocusPainted(false);
        btn_nsx_them.setLabel("Thêm");
        btn_nsx_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nsx_themActionPerformed(evt);
            }
        });

        txt_nsx_timkiem.setLabelText("Tìm kiếm");
        txt_nsx_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_nsx_timkiemCaretUpdate(evt);
            }
        });

        lbl_nsx_total.setForeground(new java.awt.Color(255, 0, 51));
        lbl_nsx_total.setText("Total: 0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txt_nsx_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rd_nsx_dangkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_nsx_timkiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_nsx_ten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rd_nsx_ngungkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_nsx_total)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btn_nsx_them, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(btn_nsx_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nsx_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_nsx_dangkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_nsx_ngungkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nsx_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nsx_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nsx_total))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_nsx_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_nsx_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(379, 379, 379))
        );

        jTabbedPane1.addTab("Nhà sản xuất", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
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

    private void txt_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkiemCaretUpdate
//        loadData(iChiTietDepService.findByName(txt_timkiem.getText()));
        loadDataChiTiet(iQLDepService.findByName(txt_timkiem.getText()));
        if (iChiTietDepService.findByName(txt_timkiem.getText()).size() == iChiTietDepService.getAll().size()) {
            checkSearchCT = 0;
        } else {
            checkSearchCT = 1;
        }
    }//GEN-LAST:event_txt_timkiemCaretUpdate

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

    private void txt_ms_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_ms_timkiemCaretUpdate
        loadDataMauSac(iMauSacService.findByName(txt_ms_timkiem.getText()));
    }//GEN-LAST:event_txt_ms_timkiemCaretUpdate

    private void btn_ms_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ms_capnhatActionPerformed
        int row = tb_mausac.getSelectedRow();
        MauSac m = iMauSacService.getObj(tb_mausac.getValueAt(row, 0).toString());
        if (checkNullMS()) {
            return;
        }

        m.setTen(txt_ms_ten.getText());
        m.setNgaySuaCuoi(new Date());
        if (rd_ms_dangkd.isSelected()) {
            m.setTrangThai(0);
        } else {
            m.setTrangThai(1);
        }
        iMauSacService.save(m);
        loadData();
        helper.alert(this, "Sửa thành công!");
    }//GEN-LAST:event_btn_ms_capnhatActionPerformed

    private void tb_mausacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_mausacMouseClicked
        int row = tb_mausac.getSelectedRow();
        MauSac m = iMauSacService.getObj((String) tb_mausac.getValueAt(row, 0));
        txt_ms_ma.setText(m.getMa());
        txt_ms_ten.setText(m.getTen());
        rd_ms_dangkd.setSelected(m.getTrangThai() == 0);
        rd_ms_ngungkd.setSelected(m.getTrangThai() == 1);
    }//GEN-LAST:event_tb_mausacMouseClicked

    private void btn_ms_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ms_themActionPerformed
        MauSac m = new MauSac();
        if (checkNullMS()) {
            return;
        }
        String result;
        for (int i = 0; i < iMauSacService.getAll().size() + 1; i++) {
            result = "NX" + i;
            if (iMauSacService.getObj(result) == null) {
                m.setMa(result);
                break;
            } else {
                continue;
            }
        }
        if (iMauSacService.getObj(txt_ms_ma.getText()) == null) {
            //            if (iMauSacService.getObj(txt_Ma.getText()) != null) {
            //                JOptionPane.showMessageDialog(this, "Da ton tai !");
            //                return;
            //            }
            m.setMa(txt_ms_ma.getText());
            m.setTen(txt_ms_ten.getText());
            m.setNgayThem(new Date());
            m.setNgaySuaCuoi(new Date());
            if (rd_ms_dangkd.isSelected()) {
                m.setTrangThai(0);
            } else {
                m.setTrangThai(1);
            }
            iMauSacService.save(m);
            loadData();
            helper.alert(this, "Thêm thành công!");

        }
    }//GEN-LAST:event_btn_ms_themActionPerformed

    private void btn_nsx_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nsx_capnhatActionPerformed
        int row = tb_nsx.getSelectedRow();
        NhaSX n = iNhaSXService.getObj(tb_nsx.getValueAt(row, 0).toString());
        if (checkNullNSX()) {
            return;
        }
        n.setTen(txt_nsx_ten.getText());
        n.setNgaySuaCuoi(new Date());
        if (rd_nsx_dangkd.isSelected()) {
            n.setTrangThai(0);
        } else {
            n.setTrangThai(1);
        }
        iNhaSXService.save(n);
        loadData();
        helper.alert(this, "Sửa thành công!");
    }//GEN-LAST:event_btn_nsx_capnhatActionPerformed

    private void tb_nsxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_nsxMouseClicked
        int row = tb_nsx.getSelectedRow();
        NhaSX n = iNhaSXService.getObj((String) tb_nsx.getValueAt(row, 0));
        txt_nsx_ma.setText(n.getMa());
        txt_nsx_ten.setText(n.getTen());
        rd_nsx_dangkd.setSelected(n.getTrangThai() == 0);
        rd_nsx_ngungkd.setSelected(n.getTrangThai() == 1);
    }//GEN-LAST:event_tb_nsxMouseClicked

    private void btn_nsx_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nsx_themActionPerformed
        NhaSX n = new NhaSX();
        if (checkNullNSX()) {
            return;
        }
        String result;
        for (int i = 0; i < iNhaSXService.getAll().size() + 1; i++) {
            result = "NX" + i;
            if (iNhaSXService.getObj(result) == null) {
                n.setMa(result);
                break;
            } else {
                continue;
            }
        }
        if (iNhaSXService.getObj(txt_nsx_ma.getText()) == null) {
            n.setMa(txt_nsx_ma.getText());
            n.setTen(txt_nsx_ten.getText());
            n.setNgayThem(new Date());
            n.setNgaySuaCuoi(new Date());
            if (rd_nsx_dangkd.isSelected()) {
                n.setTrangThai(0);
            } else {
                n.setTrangThai(1);
            }
            iNhaSXService.save(n);
            loadData();
            helper.alert(this, "Thêm thành công!");

        }
    }//GEN-LAST:event_btn_nsx_themActionPerformed

    private void txt_nsx_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_nsx_timkiemCaretUpdate
        loadDataNSX(iNhaSXService.findByName(txt_nsx_timkiem.getText()));
    }//GEN-LAST:event_txt_nsx_timkiemCaretUpdate

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
        loadData();
        helper.alert(this, "Thêm thành công!");
    }//GEN-LAST:event_btn_ctd_themActionPerformed

    private int checkSearchCT = 0;
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
            loadData();
            checkSearchCT = 0;
            helper.alert(this, "Sửa thành công!");
        }
    }//GEN-LAST:event_btn_ctd_capnhatActionPerformed

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
                loadData();
                checkSearchCT = 0;
                helper.alert(this, "Xóa thành công!");
            }
        }
    }//GEN-LAST:event_btn_ctd_xoaActionPerformed

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
                    loadData();
                    helper.alert(this, "Thêm thành công!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                helper.alert(this, "Add File thất bại!");
            }
            System.out.println("Save as file: " + fileOpen.getAbsolutePath());
        }
    }//GEN-LAST:event_btn_exportExcel1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_ctd_capnhat;
    private swing.Button btn_ctd_them;
    private swing.Button btn_ctd_xoa;
    private swing.Button btn_exportExcel;
    private swing.Button btn_exportExcel1;
    private swing.Button btn_ms_capnhat;
    private swing.Button btn_ms_them;
    private swing.Button btn_nsx_capnhat;
    private swing.Button btn_nsx_them;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonMS;
    private swing.Combobox cb_chatlieu;
    private swing.Combobox cb_dep;
    private swing.Combobox cb_loaidep;
    private swing.Combobox cb_mausac;
    private swing.Combobox cb_nsx;
    private swing.Combobox cb_size;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_ms_total;
    private javax.swing.JLabel lbl_nsx_total;
    private javax.swing.JLabel lbl_total;
    private swing.RadioButtonCustom rd_ct_dangkd;
    private swing.RadioButtonCustom rd_ct_ngungkd;
    private swing.RadioButtonCustom rd_ms_dangkd;
    private swing.RadioButtonCustom rd_ms_ngungkd;
    private swing.RadioButtonCustom rd_nsx_dangkd;
    private swing.RadioButtonCustom rd_nsx_ngungkd;
    private swing.Spinner sp_soluong;
    private javax.swing.JTable tb_mausac;
    private javax.swing.JTable tb_nsx;
    private javax.swing.JTable tb_table;
    private swing.TextField txt_giaban;
    private swing.TextField txt_gianhap;
    private swing.TextField txt_mota;
    private swing.TextField txt_ms_ma;
    private swing.TextField txt_ms_ten;
    private swing.TextField txt_ms_timkiem;
    private swing.TextField txt_nsx_ma;
    private swing.TextField txt_nsx_ten;
    private swing.TextField txt_nsx_timkiem;
    private swing.TextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
    private void addCbDep() {
        cb_dep.setModel((DefaultComboBoxModel) comboDep);
        cb_dep.removeAllItems();
        for (Dep x : iChiTietDepService.getAllDep()) {
            comboDep.addElement(x);
        }
    }

    private void addCbLoaiDep() {
        cb_loaidep.setModel((DefaultComboBoxModel) comboLoaiDep);
        cb_loaidep.removeAllItems();
        for (LoaiDep x : iChiTietDepService.getAllLoaiDep()) {
            comboLoaiDep.addElement(x);
        }
    }

    private void addCbChatLieu() {
        cb_chatlieu.setModel((DefaultComboBoxModel) comboChatLieu);
        cb_chatlieu.removeAllItems();
        for (ChatLieu x : iChiTietDepService.getAllChatLieu()) {
            comboChatLieu.addElement(x);
        }
    }

    private void addCbMauSac() {
        cb_mausac.setModel((DefaultComboBoxModel) comboMauSac);
        cb_mausac.removeAllItems();
        for (MauSac x : iMauSacService.getAll()) {
            comboMauSac.addElement(x);
        }
    }

    private void addCbSize() {
        cb_size.setModel((DefaultComboBoxModel) comboSize);
        cb_size.removeAllItems();
        for (Size x : iChiTietDepService.getAllSize()) {
            comboSize.addElement(x);
        }
    }

    private void addCbNhaSX() {
        cb_nsx.setModel((DefaultComboBoxModel) comboNSX);
        cb_nsx.removeAllItems();
        for (NhaSX x : iNhaSXService.getAll()) {
            comboNSX.addElement(x);
        }
    }

//    MÀU SẮC
    private void loadDataMauSac(List<MauSac> list) {
        defaultTableModel = (DefaultTableModel) tb_mausac.getModel();
        defaultTableModel.setRowCount(0);
        for (MauSac x : list) {
            defaultTableModel.addRow(new Object[]{
                x.getMa(),
                x.getTen(),
                format.format(x.getNgayThem()),
                format.format(x.getNgaySuaCuoi()),
                x.getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh"
            });
        }
        lbl_ms_total.setText("Total: " + list.size());
    }

    private boolean checkNullMS() {
        if (helper.checkNull(txt_ms_ten, "Tên")
                || helper.checkRegex(txt_ms_ten, "(\\S+ )*\\S+", "Tên không hợp lệ!")) {
            return true;
        } else if (!rd_ms_ngungkd.isSelected() && !rd_ms_dangkd.isSelected()) {
            helper.error(this, "chưa chọn trạng thái");
            return true;
        }
        return false;

    }

//    NHÀ SẢN XUẤT
    private void loadDataNSX(List<NhaSX> list) {
        defaultTableModel = (DefaultTableModel) tb_nsx.getModel();
        defaultTableModel.setRowCount(0);
        for (NhaSX x : list) {
            defaultTableModel.addRow(new Object[]{
                x.getMa(),
                x.getTen(),
                format.format(x.getNgayThem()),
                format.format(x.getNgaySuaCuoi()),
                x.getTrangThai() == 0 ? "Đang nhập hàng" : "Ngừng nhập hàng"
            });
        }
        lbl_nsx_total.setText("Total: " + list.size());
    }

    private boolean checkNullNSX() {
        if (helper.checkNull(txt_nsx_ten, "Tên")
                || helper.checkRegex(txt_nsx_ten, "(\\S+ )*\\S+", "Tên không hợp lệ!")) {
            return true;
        } else if (!rd_nsx_dangkd.isSelected() && !rd_nsx_ngungkd.isSelected()) {
            helper.error(this, "Chưa chọn trạng thái");
            return true;
        }
        return false;

    }
}
