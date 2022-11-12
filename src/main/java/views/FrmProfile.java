package views;

import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import models.NguoiDung;
import services.INguoiDungService;
import services.impl.NguoiDungService;
import utilities.Helper;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class FrmProfile extends javax.swing.JInternalFrame {

    private INguoiDungService iNguoiDungService = new NguoiDungService();
    private NguoiDung nguoidung;
    private Helper helper = new Helper();

    public FrmProfile(NguoiDung nd) {
        initComponents();
        this.nguoidung = nd;
        try {
            setMaximum(true);
            this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
            BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
            bi.setNorthPane(null);
        } catch (Exception e) {
        }
        txt_ma.setText(nd.getMa());
        txt_ten.setText(nd.getTen());
        txt_email.setText(nd.getEmail());
        txt_sdt.setText(nd.getSdt());
        txt_diachi.setText(nd.getDiaChi());
        if (nd.getGioiTinh() == 0) {
            rd_nam.setSelected(true);
        } else {
            rd_nu.setSelected(true);
        }
        try {
            lbl_chucvu.setText(nd.getChucVu().getTen());
        } catch (Exception e) {
        }
        imageAvatar.setImage(new ImageIcon("images/users/" + nd.getHinhAnh()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        imageAvatar = new swing.ImageAvatar();
        lbl_chucvu = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_err_renewpass = new javax.swing.JLabel();
        lbl_err_newpass = new javax.swing.JLabel();
        lbl_err_oldpass = new javax.swing.JLabel();
        btn_sua = new swing.Button();
        btn_changePass = new swing.Button();
        txt_ma = new swing.TextField();
        txt_ten = new swing.TextField();
        txt_email = new swing.TextField();
        txt_sdt = new swing.TextField();
        txt_diachi = new swing.TextField();
        rd_nam = new swing.RadioButtonCustom();
        rd_nu = new swing.RadioButtonCustom();
        txt_oldPassword = new swing.PasswordField();
        txt_newPassword = new swing.PasswordField();
        txt_reNewPassword = new swing.PasswordField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_thongbao = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("THÔNG TIN CÁ NHÂN");

        imageAvatar.setGradientColor1(new java.awt.Color(255, 51, 51));
        imageAvatar.setGradientColor2(new java.awt.Color(51, 0, 255));

        lbl_chucvu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_chucvu.setForeground(java.awt.Color.red);
        lbl_chucvu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_chucvu.setText("Chức vụ");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("ĐỔI MẬT KHẨU");

        lbl_err_renewpass.setFont(lbl_err_renewpass.getFont().deriveFont(lbl_err_renewpass.getFont().getSize()-1f));
        lbl_err_renewpass.setForeground(java.awt.Color.red);
        lbl_err_renewpass.setText(" ");

        lbl_err_newpass.setFont(lbl_err_newpass.getFont().deriveFont(lbl_err_newpass.getFont().getSize()-1f));
        lbl_err_newpass.setForeground(java.awt.Color.red);
        lbl_err_newpass.setText(" ");

        lbl_err_oldpass.setFont(lbl_err_oldpass.getFont().deriveFont(lbl_err_oldpass.getFont().getSize()-1f));
        lbl_err_oldpass.setForeground(java.awt.Color.red);
        lbl_err_oldpass.setText(" ");

        btn_sua.setBackground(new java.awt.Color(102, 102, 102));
        btn_sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua.setText("Chỉnh sửa thông tin cá nhân");
        btn_sua.setFocusPainted(false);
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_changePass.setBackground(new java.awt.Color(102, 102, 102));
        btn_changePass.setForeground(new java.awt.Color(255, 255, 255));
        btn_changePass.setText("SUBMIT");
        btn_changePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changePassActionPerformed(evt);
            }
        });

        txt_ma.setEditable(false);
        txt_ma.setLabelText("Mã");
        txt_ma.setLineColor(new java.awt.Color(153, 153, 255));
        txt_ma.setSelectionColor(new java.awt.Color(153, 153, 255));

        txt_ten.setLabelText("Tên");
        txt_ten.setLineColor(new java.awt.Color(153, 153, 255));
        txt_ten.setSelectionColor(new java.awt.Color(153, 153, 255));

        txt_email.setLabelText("Email");
        txt_email.setLineColor(new java.awt.Color(153, 153, 255));
        txt_email.setSelectionColor(new java.awt.Color(153, 153, 255));

        txt_sdt.setLabelText("Số điện thoại");
        txt_sdt.setLineColor(new java.awt.Color(153, 153, 255));
        txt_sdt.setSelectionColor(new java.awt.Color(153, 153, 255));

        txt_diachi.setLabelText("Địa chỉ");
        txt_diachi.setLineColor(new java.awt.Color(153, 153, 255));
        txt_diachi.setSelectionColor(new java.awt.Color(153, 153, 255));

        buttonGroup1.add(rd_nam);
        rd_nam.setText("Nam");
        rd_nam.setFocusPainted(false);

        buttonGroup1.add(rd_nu);
        rd_nu.setText("Nữ");
        rd_nu.setFocusPainted(false);

        txt_oldPassword.setLabelText("Mật khẩu hiện tại");
        txt_oldPassword.setLineColor(new java.awt.Color(153, 153, 255));
        txt_oldPassword.setSelectionColor(new java.awt.Color(153, 153, 255));
        txt_oldPassword.setShowAndHide(true);
        txt_oldPassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_oldPasswordCaretUpdate(evt);
            }
        });

        txt_newPassword.setLabelText("Mật khẩu mới");
        txt_newPassword.setLineColor(new java.awt.Color(153, 153, 255));
        txt_newPassword.setSelectionColor(new java.awt.Color(153, 153, 255));
        txt_newPassword.setShowAndHide(true);
        txt_newPassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_newPasswordCaretUpdate(evt);
            }
        });

        txt_reNewPassword.setLabelText("Xác nhận mật khẩu mới");
        txt_reNewPassword.setLineColor(new java.awt.Color(153, 153, 255));
        txt_reNewPassword.setSelectionColor(new java.awt.Color(153, 153, 255));
        txt_reNewPassword.setShowAndHide(true);
        txt_reNewPassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_reNewPasswordCaretUpdate(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("THÔNG BÁO");

        txt_thongbao.setColumns(20);
        txt_thongbao.setRows(5);
        jScrollPane1.setViewportView(txt_thongbao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(txt_diachi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txt_ten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txt_ma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lbl_chucvu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_err_oldpass, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                    .addComponent(lbl_err_newpass, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                    .addComponent(txt_reNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                    .addComponent(lbl_err_renewpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_oldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                    .addComponent(txt_newPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                    .addComponent(jLabel8)
                                    .addComponent(btn_changePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbl_err_newpass, lbl_err_oldpass, lbl_err_renewpass, txt_newPassword, txt_oldPassword, txt_reNewPassword});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_err_oldpass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_err_newpass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_reNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_err_renewpass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_changePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_changePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changePassActionPerformed
        String oldPass = new String(txt_oldPassword.getPassword());
        String newPass = new String(txt_newPassword.getPassword());
        String reNewPass = new String(txt_reNewPassword.getPassword());
        if (oldPass.equals(nguoidung.getMatKhau()) && newPass.length() >= 8 && newPass.equals(reNewPass)) {
            if (helper.confirm(this, "Xác nhận đổi mật khẩu ?")) {
                nguoidung.setMatKhau(reNewPass);
                iNguoiDungService.save(nguoidung);
                helper.alert(this, "Mật khẩu đã được thay đổi!");
                txt_oldPassword.setText("");
                txt_newPassword.setText("");
                txt_reNewPassword.setText("");
            }
        } else {
            helper.error(this, "Không thành công!");
        }
    }//GEN-LAST:event_btn_changePassActionPerformed

    private void txt_oldPasswordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_oldPasswordCaretUpdate
        String oldPass = new String(txt_oldPassword.getPassword());
        if (!oldPass.equals(nguoidung.getMatKhau())) {
            lbl_err_oldpass.setText("Mật khẩu không chính xác!");
        } else {
            lbl_err_oldpass.setText(" ");
        }
    }//GEN-LAST:event_txt_oldPasswordCaretUpdate

    private void txt_newPasswordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_newPasswordCaretUpdate
         if (txt_newPassword.getPassword().length < 8) {
            lbl_err_newpass.setText("Tối thiểu 8 kí tự!");
        } else {
            lbl_err_newpass.setText(" ");
        }
    }//GEN-LAST:event_txt_newPasswordCaretUpdate

    private void txt_reNewPasswordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_reNewPasswordCaretUpdate
        String newPass = new String(txt_newPassword.getPassword());
        String reNewPass = new String(txt_reNewPassword.getPassword());
        if (!reNewPass.equals(newPass)) {
            lbl_err_renewpass.setText("Xác nhận mật khẩu không khớp!");
        } else {
            lbl_err_renewpass.setText(" ");
        }
    }//GEN-LAST:event_txt_reNewPasswordCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_changePass;
    private swing.Button btn_sua;
    private javax.swing.ButtonGroup buttonGroup1;
    private swing.ImageAvatar imageAvatar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_chucvu;
    private javax.swing.JLabel lbl_err_newpass;
    private javax.swing.JLabel lbl_err_oldpass;
    private javax.swing.JLabel lbl_err_renewpass;
    private swing.RadioButtonCustom rd_nam;
    private swing.RadioButtonCustom rd_nu;
    private swing.TextField txt_diachi;
    private swing.TextField txt_email;
    private swing.TextField txt_ma;
    private swing.PasswordField txt_newPassword;
    private swing.PasswordField txt_oldPassword;
    private swing.PasswordField txt_reNewPassword;
    private swing.TextField txt_sdt;
    private swing.TextField txt_ten;
    private javax.swing.JTextArea txt_thongbao;
    // End of variables declaration//GEN-END:variables
}
