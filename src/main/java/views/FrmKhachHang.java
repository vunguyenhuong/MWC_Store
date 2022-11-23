package views;

import java.awt.Frame;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.KhachHang;
import services.IKhachHangService;
import services.impl.KhachHangService;
import swing.Table;
import ui.NotificationMess;
import utilities.Helper;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class FrmKhachHang extends java.awt.Dialog {

    private IKhachHangService iKhachHangService;
    private DefaultTableModel dtm = new DefaultTableModel();
    private Helper helper;

    private KhachHang khachHang = null;

    public FrmKhachHang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Danh sách khách hàng");
        setLocationRelativeTo(null);
        this.iKhachHangService = new KhachHangService();
        loadDataToTabel(iKhachHangService.getAll());
        this.helper = new Helper();
        Table.apply(jScrollPane1, Table.TableType.MULTI_LINE);
    }

    private void loadDataToTabel(List<KhachHang> list) {
        dtm = (DefaultTableModel) tbl_KhachHang.getModel();

        dtm.setRowCount(0);
        int i = 1;

        for (KhachHang kh : list) {
            Object[] rowData = new Object[]{
                i++,
                kh.getMa(),
                kh.getTen(),
                kh.getDiaChi(),
                kh.getSoDt(),
                kh.getDiemTichLuy()
            };
            dtm.addRow(rowData);
        }
        lbl_Total.setText("Total:" + list.size());
    }

    private boolean checkNull() {
        if (helper.checkNull(txt_TenKH, "Tên")
                || helper.checkRegex(txt_TenKH, "(\\S+ )*\\S+", "Tên không hợp lệ!")) {
            return true;
        }
        if (helper.checkNull(txt_Diachi, "Ðịa chỉ")
                || helper.checkRegex(txt_Diachi, "(\\S+ )*\\S+", "Địa chỉ không hợp lệ!")) {
            return true;
        }
        if (helper.checkNull(txt_Sodienthoai, "Số điện thoại")
                || helper.checkRegex(txt_Sodienthoai, "^0[0-9]{9,10}$", "Số điện thoại không hợp lệ!")) {
            return true;
        }

        return false;

    }

    private KhachHang getDataFromInput() {
        KhachHang kh = new KhachHang();

        String result;
        for (int i = 0; i < iKhachHangService.getAll().size() + 1; i++) {
            result = "KH" + i;
            if (iKhachHangService.getObj(result) == null) {
                kh.setMa(result);
                break;
            } else {
                continue;
            }
        }

        String tenKH = txt_TenKH.getText().trim();
        String diachi = txt_Diachi.getText().trim();
        String sdt = txt_Sodienthoai.getText().trim();

        kh.setTen(tenKH);
        kh.setDiaChi(diachi);
        kh.setSoDt(sdt);
        kh.setDiemTichLuy(0);

        return kh;
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btn_update = new swing.Button();
        btn_add = new swing.Button();
        txt_Diachi = new swing.TextField();
        txt_TenKH = new swing.TextField();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_KhachHang = new javax.swing.JTable();
        lbl_Total = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_Ma = new swing.TextField();
        btn_Chon = new swing.Button();
        txt_Sodienthoai = new swing.TextField();
        txt_Search = new swing.TextField();
        txt_Diemtichluy = new swing.TextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btn_update.setBackground(new java.awt.Color(102, 102, 102));
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Cập nhật");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(102, 102, 102));
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        txt_Diachi.setLabelText("Địa chỉ : ");

        txt_TenKH.setToolTipText("");
        txt_TenKH.setLabelText("Tên khách hàng :");

        tbl_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên", "Ðịa chỉ", "Số điện thoại", "Điểm tích lũy"
            }
        ));
        tbl_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_KhachHang);
        if (tbl_KhachHang.getColumnModel().getColumnCount() > 0) {
            tbl_KhachHang.getColumnModel().getColumn(0).setResizable(false);
            tbl_KhachHang.getColumnModel().getColumn(4).setResizable(false);
        }

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lbl_Total.setForeground(new java.awt.Color(255, 0, 51));
        lbl_Total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_Total.setText("Total: 0");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("KHÁCH HÀNG");

        txt_Ma.setEditable(false);
        txt_Ma.setToolTipText("");
        txt_Ma.setLabelText("Mã :");

        btn_Chon.setBackground(new java.awt.Color(0, 137, 187));
        btn_Chon.setForeground(new java.awt.Color(255, 255, 255));
        btn_Chon.setText("Chọn khách hàng");
        btn_Chon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChonActionPerformed(evt);
            }
        });

        txt_Sodienthoai.setLabelText("Số điện thoại : ");

        txt_Search.setLabelText("Search");
        txt_Search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_SearchCaretUpdate(evt);
            }
        });
        txt_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SearchActionPerformed(evt);
            }
        });

        txt_Diemtichluy.setEditable(false);
        txt_Diemtichluy.setLabelText("Điểm tích lũy : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_Sodienthoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Diachi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_TenKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_Diemtichluy, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Total))))
                    .addComponent(btn_Chon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_add, btn_update});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(txt_Diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Sodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Diemtichluy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Chon, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void tbl_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhachHangMouseClicked
        try {
            int index = tbl_KhachHang.getSelectedRow();

            txt_Ma.setText(tbl_KhachHang.getValueAt(index, 1).toString());
            txt_TenKH.setText(tbl_KhachHang.getValueAt(index, 2).toString());
            txt_Diachi.setText(tbl_KhachHang.getValueAt(index, 3).toString());
            txt_Sodienthoai.setText(tbl_KhachHang.getValueAt(index, 4).toString());
            txt_Diemtichluy.setText(tbl_KhachHang.getValueAt(index, 5).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbl_KhachHangMouseClicked

    private void txt_SearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_SearchCaretUpdate
        // TODO add your handling code here:
        String ten = txt_Search.getText().trim();
        loadDataToTabel(this.iKhachHangService.findByName(ten));
    }//GEN-LAST:event_txt_SearchCaretUpdate

    private void btn_ChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChonActionPerformed
        int row = tbl_KhachHang.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn khách hàng!");
        } else {
            khachHang = iKhachHangService.getObj((String) tbl_KhachHang.getValueAt(row, 1));
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Chọn thành công khách hàng " + khachHang.getTen());
            panel.showNotification();
            this.dispose();
        }
    }//GEN-LAST:event_btn_ChonActionPerformed

    private void txt_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SearchActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        int row = tbl_KhachHang.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Chọn 1 dòng khách hàng");
            return;
        }
        KhachHang kh = this.getDataFromInput();
        KhachHang khach = iKhachHangService.getObj(txt_Ma.getText().trim());
        khach.setTen(kh.getTen());
        khach.setDiaChi(kh.getDiaChi());
        khach.setSoDt(kh.getSoDt());
        this.iKhachHangService.save(khach);
        loadDataToTabel(iKhachHangService.getAll());
        helper.alert(this, "Sửa thành công");
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (checkNull()) {
            return;
        }
        KhachHang kh = this.getDataFromInput();
        this.iKhachHangService.save(kh);
        this.loadDataToTabel(this.iKhachHangService.getAll());
        helper.alert(this, "Thêm thành công");
    }//GEN-LAST:event_btn_addActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmKhachHang dialog = new FrmKhachHang(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_Chon;
    private swing.Button btn_add;
    private swing.Button btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbl_Total;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tbl_KhachHang;
    private swing.TextField txt_Diachi;
    private swing.TextField txt_Diemtichluy;
    private swing.TextField txt_Ma;
    private swing.TextField txt_Search;
    private swing.TextField txt_Sodienthoai;
    private swing.TextField txt_TenKH;
    // End of variables declaration//GEN-END:variables

    public KhachHang getKH() {
        return khachHang;
    }
}
