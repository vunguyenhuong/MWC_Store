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
        imageAvatar.setImage(new ImageIcon("images/" + nd.getHinhAnh()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        txt_diachi = new javax.swing.JTextField();
        rd_nam = new javax.swing.JRadioButton();
        rd_nu = new javax.swing.JRadioButton();
        imageAvatar = new utilities.ImageAvatar();
        lbl_chucvu = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_oldPassword = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        txt_newPassword = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        txt_reNewPassword = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_err_renewpass = new javax.swing.JLabel();
        lbl_err_newpass = new javax.swing.JLabel();
        lbl_err_oldpass = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("THÔNG TIN CÁ NHÂN");

        jLabel2.setText("Mã");

        jLabel3.setText("Tên");

        txt_ma.setEditable(false);

        jLabel4.setText("Email");

        jLabel5.setText("Số điện thoại");

        jLabel6.setText("Địa chỉ");

        jLabel7.setText("Giới tính");

        rd_nam.setBackground(new java.awt.Color(255, 255, 255));
        rd_nam.setText("Nam");

        rd_nu.setBackground(new java.awt.Color(255, 255, 255));
        rd_nu.setText("Nữ");

        imageAvatar.setGradientColor1(new java.awt.Color(255, 51, 51));
        imageAvatar.setGradientColor2(new java.awt.Color(51, 0, 255));

        lbl_chucvu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_chucvu.setForeground(java.awt.Color.red);
        lbl_chucvu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_chucvu.setText("Chức vụ");

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Chỉnh sửa thông tin cá nhân");
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("ĐỔI MẬT KHẨU");

        jLabel9.setText("Mật khẩu hiện tại");

        txt_oldPassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_oldPasswordCaretUpdate(evt);
            }
        });

        jLabel10.setText("Mật khẩu mới");

        txt_newPassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_newPasswordCaretUpdate(evt);
            }
        });

        jLabel11.setText("Xác nhận mật khẩu mới");

        txt_reNewPassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_reNewPasswordCaretUpdate(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("SUBMIT");
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbl_err_renewpass.setFont(lbl_err_renewpass.getFont().deriveFont(lbl_err_renewpass.getFont().getSize()-1f));
        lbl_err_renewpass.setForeground(java.awt.Color.red);
        lbl_err_renewpass.setText(" ");

        lbl_err_newpass.setFont(lbl_err_newpass.getFont().deriveFont(lbl_err_newpass.getFont().getSize()-1f));
        lbl_err_newpass.setForeground(java.awt.Color.red);
        lbl_err_newpass.setText(" ");

        lbl_err_oldpass.setFont(lbl_err_oldpass.getFont().deriveFont(lbl_err_oldpass.getFont().getSize()-1f));
        lbl_err_oldpass.setForeground(java.awt.Color.red);
        lbl_err_oldpass.setText(" ");

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_diachi, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_sdt))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_email))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txt_ma, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                                    .addComponent(txt_ten))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(18, 18, 18)
                                            .addComponent(rd_nam)
                                            .addGap(18, 18, 18)
                                            .addComponent(rd_nu))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_chucvu, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                    .addComponent(imageAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_reNewPassword)
                            .addComponent(jLabel11)
                            .addComponent(txt_newPassword)
                            .addComponent(txt_oldPassword)
                            .addComponent(lbl_err_renewpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_err_newpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_err_oldpass, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel9});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(rd_nam)
                            .addComponent(rd_nu)
                            .addComponent(lbl_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_err_oldpass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_err_newpass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_reNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_err_renewpass)
                                .addGap(12, 12, 12)
                                .addComponent(jButton2))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, rd_nam, rd_nu, txt_diachi, txt_email, txt_ma, txt_newPassword, txt_oldPassword, txt_reNewPassword, txt_sdt, txt_ten});

        pack();
    }// </editor-fold>//GEN-END:initComponents


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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.ImageAvatar imageAvatar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_chucvu;
    private javax.swing.JLabel lbl_err_newpass;
    private javax.swing.JLabel lbl_err_oldpass;
    private javax.swing.JLabel lbl_err_renewpass;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_nu;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JPasswordField txt_newPassword;
    private javax.swing.JPasswordField txt_oldPassword;
    private javax.swing.JPasswordField txt_reNewPassword;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
