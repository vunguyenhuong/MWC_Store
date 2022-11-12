package views;

import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import models.*;
import services.IChiTietDepService;
import services.impl.ChiTietDepService;
import utilities.ExportSP;
import utilities.Helper;
import utilities.ImageUltil;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class FrmChiTietDep extends javax.swing.JInternalFrame {
    
    private Helper helper = new Helper();
    
    private DefaultTableModel defaultTableModel;
    private IChiTietDepService iChiTietDepService = new ChiTietDepService();
    private ImageUltil imageUltil = new ImageUltil();
    
    private DefaultComboBoxModel<Dep> comboDep = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<LoaiDep> comboLoaiDep = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<ChatLieu> comboChatLieu = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<MauSac> comboMauSac = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<Size> comboSize = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<NhaSX> comboNSX = new DefaultComboBoxModel<>();
    
    private void addCbDep(){
        cb_dep.setModel((DefaultComboBoxModel)comboDep);
        cb_dep.removeAllItems();
        for (Dep x : iChiTietDepService.getAllDep()) {
            comboDep.addElement(x);
        }
    }
    
    private void addCbLoaiDep(){
        cb_loaidep.setModel((DefaultComboBoxModel)comboLoaiDep);
        cb_loaidep.removeAllItems();
        for (LoaiDep x : iChiTietDepService.getAllLoaiDep()) {
            comboLoaiDep.addElement(x);
        }
    }
    
    private void addCbChatLieu(){
        cb_chatlieu.setModel((DefaultComboBoxModel)comboChatLieu);
        cb_chatlieu.removeAllItems();
        for (ChatLieu x : iChiTietDepService.getAllChatLieu()) {
            comboChatLieu.addElement(x);
        }
    }
    
    private void addCbMauSac(){
        cb_mausac.setModel((DefaultComboBoxModel)comboMauSac);
        cb_mausac.removeAllItems();
        for (MauSac x : iChiTietDepService.getAllMauSac()) {
            comboMauSac.addElement(x);
        }
    }
    
    private void addCbSize(){
        cb_size.setModel((DefaultComboBoxModel)comboSize);
        cb_size.removeAllItems();
        for (Size x : iChiTietDepService.getAllSize()) {
            comboSize.addElement(x);
        }
    }
    
    private void addCbNhaSX(){
        cb_nsx.setModel((DefaultComboBoxModel)comboNSX);
        cb_nsx.removeAllItems();
        for (NhaSX x : iChiTietDepService.getAllNSX()) {
            comboNSX.addElement(x);
        }
    }
    
    public FrmChiTietDep() {
        initComponents();
        try {
            setMaximum(true);
            this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
            BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
            bi.setNorthPane(null);
        } catch (Exception e) {
        }
        loadData(iChiTietDepService.getAll());
        addCbDep();
        addCbLoaiDep();
        addCbChatLieu();
        addCbMauSac();
        addCbSize();
        addCbNhaSX();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        cb_size = new swing.Combobox();
        cb_dep = new swing.Combobox();
        cb_loaidep = new swing.Combobox();
        cb_mausac = new swing.Combobox();
        cb_chatlieu = new swing.Combobox();
        cb_nsx = new swing.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_table = new javax.swing.JTable();
        lbl_image = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textField_12 = new swing.TextField();
        textField_13 = new swing.TextField();
        textField_14 = new swing.TextField();
        radioButtonCustom1 = new swing.RadioButtonCustom();
        radioButtonCustom2 = new swing.RadioButtonCustom();
        spinner1 = new swing.Spinner();
        txt_timkiem = new swing.TextField();
        lbl_total = new javax.swing.JLabel();
        button1 = new swing.Button();
        button2 = new swing.Button();
        button3 = new swing.Button();
        btn_exportExcel = new swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

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

        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setText(" ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("THÔNG TIN SẢN PHẨM");

        textField_12.setLabelText("Giá bán");
        textField_12.setLineColor(new java.awt.Color(102, 102, 102));

        textField_13.setLabelText("Giá nhập");
        textField_13.setLineColor(new java.awt.Color(102, 102, 102));

        textField_14.setLabelText("Mô tả");
        textField_14.setLineColor(new java.awt.Color(102, 102, 102));

        buttonGroup1.add(radioButtonCustom1);
        radioButtonCustom1.setText("Đang kinh doanh");
        radioButtonCustom1.setFocusPainted(false);

        buttonGroup1.add(radioButtonCustom2);
        radioButtonCustom2.setText("Ngừng kinh doanh");
        radioButtonCustom2.setFocusPainted(false);

        spinner1.setLabelText("Số lượng");

        txt_timkiem.setLabelText("Tìm kiếm");
        txt_timkiem.setLineColor(new java.awt.Color(102, 102, 102));
        txt_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkiemCaretUpdate(evt);
            }
        });

        lbl_total.setForeground(java.awt.Color.red);
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setText("Total: 0");

        button1.setBackground(new java.awt.Color(153, 153, 153));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Cập nhật");
        button1.setFocusPainted(false);

        button2.setBackground(new java.awt.Color(153, 153, 153));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Thêm");
        button2.setFocusPainted(false);

        button3.setBackground(new java.awt.Color(153, 153, 153));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("Xóa");
        button3.setFocusPainted(false);

        btn_exportExcel.setBackground(new java.awt.Color(0, 126, 0));
        btn_exportExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportExcel.setText("Export Excel");
        btn_exportExcel.setFocusPainted(false);
        btn_exportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cb_dep, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_loaidep, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(textField_14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cb_chatlieu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                                    .addComponent(textField_13, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cb_nsx, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(spinner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textField_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_size, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(radioButtonCustom2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(radioButtonCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_loaidep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_chatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(textField_14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioButtonCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioButtonCustom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_total)
                        .addComponent(btn_exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cb_chatlieu, cb_dep, cb_loaidep, cb_mausac, cb_nsx, cb_size, radioButtonCustom1, radioButtonCustom2, spinner1, textField_12, textField_13, textField_14});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_tableMouseClicked
        int row = tb_table.getSelectedRow();
        ChiTietDep ctd = iChiTietDepService.getAll().get(row);
        lbl_image.setIcon(imageUltil.resizeIcon(new ImageIcon("images/products/" + ctd.getDep().getHinhAnh()), lbl_image.getWidth(), lbl_image.getHeight()));
        System.out.println(ctd.getDep().getHinhAnh());
    }//GEN-LAST:event_tb_tableMouseClicked

    private void txt_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkiemCaretUpdate
        loadData(iChiTietDepService.findByName(txt_timkiem.getText()));
    }//GEN-LAST:event_txt_timkiemCaretUpdate

    private void btn_exportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportExcelActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".xlsx","xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Export Excel");
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                if(helper.confirm(this, "File Path: "+fileToSave.getAbsolutePath() +filter.getDescription()+". Xác nhận xuất file ?")){
                    ExportSP.writeExcel(iChiTietDepService.getAll(), fileToSave.getAbsolutePath() +filter.getDescription());
                helper.alert(this, "Xuất File thành công!");
                }
            } catch (Exception e) {
               e.printStackTrace();
               helper.alert(this, "Xuất File thất bại!");
            }
            System.out.println("Save as file: " + fileToSave.getAbsolutePath() +filter.getDescription());
        }
    }//GEN-LAST:event_btn_exportExcelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_exportExcel;
    private swing.Button button1;
    private swing.Button button2;
    private swing.Button button3;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private swing.RadioButtonCustom radioButtonCustom1;
    private swing.RadioButtonCustom radioButtonCustom2;
    private swing.Spinner spinner1;
    private javax.swing.JTable tb_table;
    private swing.TextField textField_12;
    private swing.TextField textField_13;
    private swing.TextField textField_14;
    private swing.TextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
