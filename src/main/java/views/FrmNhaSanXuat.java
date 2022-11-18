package views;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import models.NhaSX;
import services.INhaSXService;
import services.impl.NhaSXService;
import swing.Table;
import utilities.Helper;

/**
 *
 * @author dell
 */
public class FrmNhaSanXuat extends javax.swing.JPanel {
    
    private DefaultTableModel dtm;
    private INhaSXService iNhaSXService;
    private Helper helper;
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Creates new form FrmNhaSanXuat
     */
    public FrmNhaSanXuat() {
        initComponents();
        iNhaSXService = new NhaSXService();
        loadToTable(iNhaSXService.getAll());
        helper = new Helper();
        Table.apply(jScrollPane1, Table.TableType.MULTI_LINE);
    }
    
    private void loadToTable(List<NhaSX> list) {
        dtm = (DefaultTableModel) tblBang.getModel();
        dtm.setRowCount(0);
        for (NhaSX x : list) {
            dtm.addRow(new Object[]{
                x.getMa(),
                x.getTen(),
                format.format(x.getNgayThem()),
                format.format(x.getNgaySuaCuoi()),
                x.getTrangThai() == 0 ? "Đang nhập hàng" : "Ngừng nhập hàng"
            });
        }
        lbl_Total.setText("Total: " + list.size());
    }
    
    private boolean checkNull() {
        if (helper.checkNull(txt_Ten, "Tên")
                || helper.checkRegex(txt_Ten, "(\\S+ )*\\S+", "Tên không hợp lệ!")) {
            return true;
        } else if (!rd_Ngungnhap.isSelected() && !rd_Dangnhap.isSelected()) {
            helper.error(this, "chưa chọn trạng thái");
            return true;
        }
        return false;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lbl_Total = new javax.swing.JLabel();
        btn_Xoa = new swing.Button();
        txt_Ma1 = new swing.TextField();
        btn_Capnhat = new swing.Button();
        txt_Ten = new swing.TextField();
        rd_Ngungnhap = new swing.RadioButtonCustom();
        rd_Dangnhap = new swing.RadioButtonCustom();
        btn_Them = new swing.Button();
        txt_Timkiem = new swing.TextField();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbl_Total.setForeground(new java.awt.Color(255, 0, 51));
        lbl_Total.setText("Total: 0");

        btn_Xoa.setBackground(new java.awt.Color(153, 153, 153));
        btn_Xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_Xoa.setText("Xóa");
        btn_Xoa.setFocusPainted(false);
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        txt_Ma1.setEditable(false);
        txt_Ma1.setToolTipText("");
        txt_Ma1.setLabelText("Mã :");

        btn_Capnhat.setBackground(new java.awt.Color(153, 153, 153));
        btn_Capnhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_Capnhat.setFocusPainted(false);
        btn_Capnhat.setLabel("Cập nhật");
        btn_Capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapnhatActionPerformed(evt);
            }
        });

        txt_Ten.setLabelText("Tên NSX");

        buttonGroup1.add(rd_Ngungnhap);
        rd_Ngungnhap.setText("Ngừng kinh doanh");
        rd_Ngungnhap.setActionCommand("");
        rd_Ngungnhap.setFocusPainted(false);

        buttonGroup1.add(rd_Dangnhap);
        rd_Dangnhap.setSelected(true);
        rd_Dangnhap.setText("Đang kinh doanh");
        rd_Dangnhap.setFocusPainted(false);

        btn_Them.setBackground(new java.awt.Color(153, 153, 153));
        btn_Them.setForeground(new java.awt.Color(255, 255, 255));
        btn_Them.setFocusPainted(false);
        btn_Them.setLabel("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        txt_Timkiem.setLabelText("Tìm kiếm");
        txt_Timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_TimkiemCaretUpdate(evt);
            }
        });

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("NHÀ SẢN XUẤT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_Ma1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rd_Dangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_Timkiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_Ten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rd_Ngungnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_Total)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(btn_Capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Ma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_Dangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_Ngungnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Total))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        int row = tblBang.getSelectedRow();
        NhaSX n = iNhaSXService.getObj(tblBang.getValueAt(row, 1).toString());
        iNhaSXService.delete(n);
        loadToTable(iNhaSXService.getAll());
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_CapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapnhatActionPerformed
        int row = tblBang.getSelectedRow();
        NhaSX n = iNhaSXService.getObj(tblBang.getValueAt(row, 0).toString());
        if (checkNull()) {
            return;
        }
        n.setTen(txt_Ten.getText());
        n.setNgaySuaCuoi(new Date());
        if (rd_Dangnhap.isSelected()) {
            n.setTrangThai(0);
        } else {
            n.setTrangThai(1);
        }
        iNhaSXService.save(n);
        loadToTable(iNhaSXService.getAll());
        helper.alert(this, "Sửa thành công!");
    }//GEN-LAST:event_btn_CapnhatActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        int row = tblBang.getSelectedRow();
        NhaSX n = iNhaSXService.getObj((String) tblBang.getValueAt(row, 0));
        txt_Ma1.setText(n.getMa());
        txt_Ten.setText(n.getTen());
        rd_Dangnhap.setSelected(n.getTrangThai() == 0);
        rd_Ngungnhap.setSelected(n.getTrangThai() == 1);
    }//GEN-LAST:event_tblBangMouseClicked

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        NhaSX n = new NhaSX();
        if (checkNull()) {
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
        if (iNhaSXService.getObj(txt_Ma1.getText()) == null) {
            if (iNhaSXService.getObj(txt_Ma1.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Da ton tai !");
                return;
            }
            n.setMa(txt_Ma1.getText());
            n.setTen(txt_Ten.getText());
            n.setNgayThem(new Date());
            n.setNgaySuaCuoi(new Date());
            if (rd_Dangnhap.isSelected()) {
                n.setTrangThai(0);
            } else {
                n.setTrangThai(1);
            }
            iNhaSXService.save(n);
            loadToTable(iNhaSXService.getAll());
            helper.alert(this, "Thêm thành công!");

        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void txt_TimkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_TimkiemCaretUpdate
        loadToTable(iNhaSXService.findByName(txt_Timkiem.getText()));
    }//GEN-LAST:event_txt_TimkiemCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_Capnhat;
    private swing.Button btn_Them;
    private swing.Button btn_Xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Total;
    private swing.RadioButtonCustom rd_Dangnhap;
    private swing.RadioButtonCustom rd_Ngungnhap;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tblBang;
    private swing.TextField txt_Ma1;
    private swing.TextField txt_Ten;
    private swing.TextField txt_Timkiem;
    // End of variables declaration//GEN-END:variables
}