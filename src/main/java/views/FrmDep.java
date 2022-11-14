package views;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.Dep;
import services.IDepService;
import services.impl.DepService;
import utilities.Helper;

/**
 *
 * @author dell
 */
public class FrmDep extends javax.swing.JFrame {

    private ButtonGroup buttonGroup;
    private DefaultTableModel dtm;
    private IDepService iDepService;
    private Helper helper;
    private String fileName;

    /**
     * Creates new form FrmDep
     */
    public FrmDep() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Quản lý Dép");

        this.buttonGroup = new ButtonGroup();
        tinhTrang();

        this.dtm = new DefaultTableModel();

        this.iDepService = new DepService();

        loadDataToTable(this.iDepService.getList());

        this.helper = new Helper();

        tblDep.getTableHeader().setReorderingAllowed(false);
    }

    private void tinhTrang() {
        buttonGroup.add(rdoDangkinhdoanh);
        buttonGroup.add(rdoNgungkinhdoanh);
    }

    private void loadDataToTable(List<Dep> list) {
        dtm = (DefaultTableModel) tblDep.getModel();

        dtm.setRowCount(0);

        for (Dep dep : list) {
            Object[] rowData = new Object[]{
                dep.getMa(),
                dep.getTen(),
                dep.getHinhAnh(),
                dep.getNgayThem(),
                dep.getNgaySuaCuoi(),
                dep.getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh"
            };
            dtm.addRow(rowData);
        }
    }

    private Dep getDataFromInput() {

        Dep dep = new Dep();

        int index = tblDep.getSelectedRow();

        String ten = txtTen.getText().trim();
        int trangthai;

        String result;
        for (int i = 5; i < iDepService.getList().size() + 1; i++) {

            result = "SP0" + i;
            if (iDepService.getObj(result) == null) {
                dep.setMa(result);
                break;
            } else {
                continue;
            }
        }

        if (rdoDangkinhdoanh.isSelected() == false && rdoNgungkinhdoanh.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Hãy set Trạng thái cho sản phẩm");
            return null;
        }

        if (rdoDangkinhdoanh.isSelected()) {
            trangthai = 0;
        } else {
            trangthai = 1;
        }

        if (fileName == null) {
            fileName = tblDep.getValueAt(index, 2).toString();
        } else {
            fileName = fileName;
        }

        if (lblHinhAnh.getIcon() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng đính kèm ảnh !", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        dep.setTen(ten);
        dep.setHinhAnh(fileName);
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        dep.setNgayThem(date);
        dep.setNgaySuaCuoi(date);
        dep.setTrangThai(trangthai);

        return dep;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMa = new swing.TextField();
        txtTen = new swing.TextField();
        rdoDangkinhdoanh = new swing.RadioButtonCustom();
        rdoNgungkinhdoanh = new swing.RadioButtonCustom();
        lblHinhAnh = new javax.swing.JLabel();
        btnThem = new swing.Button();
        btnSua = new swing.Button();
        txtTimKiem = new swing.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDep = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMa.setEditable(false);
        txtMa.setLabelText("Mã");

        txtTen.setLabelText("Tên");

        rdoDangkinhdoanh.setText("Ðang kinh doanh");

        rdoNgungkinhdoanh.setText("Ngừng kinh doanh");

        lblHinhAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Cập nhật");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        txtTimKiem.setLabelText("Tìm kiếm");
        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        tblDep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Hình Ảnh", "Ngày thêm", "Ngày Sửa Cuối", "Trạng thái"
            }
        ));
        tblDep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDep);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoDangkinhdoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNgungkinhdoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoDangkinhdoanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNgungkinhdoanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepMouseClicked
        int index = tblDep.getSelectedRow();

        Dep dep = iDepService.getObj(tblDep.getValueAt(index, 0).toString());

        txtMa.setText(tblDep.getValueAt(index, 0).toString());
        txtTen.setText(tblDep.getValueAt(index, 1).toString());
        ImageIcon i = utilities.ImageUltil.resizeIcon(new ImageIcon("images/products/" + dep.getHinhAnh()), lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
        lblHinhAnh.setIcon(i);
        if (tblDep.getValueAt(index, 5).toString().equals("Đang kinh doanh")) {
            rdoDangkinhdoanh.setSelected(true);
        } else {
            rdoNgungkinhdoanh.setSelected(true);
        }
    }//GEN-LAST:event_tblDepMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        Dep dep = this.getDataFromInput();

        if (dep == null) {
            return;
        }

        this.iDepService.save(dep);
        this.loadDataToTable(this.iDepService.getList());
        helper.alert(this, "Thêm thành công");
    }//GEN-LAST:event_btnThemActionPerformed

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        JFileChooser fileChooser = new JFileChooser("images/products/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*jpg", "jpg");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                fileName = fileChooser.getSelectedFile().getPath();
                ImageIcon icon = new ImageIcon(fileName);
                Image image = icon.getImage();
                Image imageResize = utilities.ImageUltil.resize(image, lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
                icon = new ImageIcon(imageResize);
                lblHinhAnh.setIcon(icon);
                File file = new File(fileName);
                file.renameTo(new File("images/products/" + file.getName()));
                fileName = file.getName();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_lblHinhAnhMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int index = tblDep.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn 1 sản phẩm");
            return;
        }

        Dep dep = this.getDataFromInput();

        Dep d = this.iDepService.getObj(txtMa.getText().trim());
        d.setTen(dep.getTen());
        d.setHinhAnh(fileName);
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        d.setNgaySuaCuoi(date);
        d.setTrangThai(dep.getTrangThai());

        this.iDepService.save(d);
        loadDataToTable(this.iDepService.getList());
        JOptionPane.showMessageDialog(this, "Đã cập nhật");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        loadDataToTable(iDepService.getObjByName(txtTimKiem.getText()));
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnSua;
    private swing.Button btnThem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinhAnh;
    private swing.RadioButtonCustom rdoDangkinhdoanh;
    private swing.RadioButtonCustom rdoNgungkinhdoanh;
    private javax.swing.JTable tblDep;
    private swing.TextField txtMa;
    private swing.TextField txtTen;
    private swing.TextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
