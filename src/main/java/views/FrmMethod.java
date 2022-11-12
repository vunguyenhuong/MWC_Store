package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import models.ChucVu;
import models.NguoiDung;
import services.IChucVuService;
import services.INguoiDungService;
import services.impl.ChucVuService;
import services.impl.NguoiDungService;
import utilities.Helper;
import utilities.SendMailUltil;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class FrmMethod extends javax.swing.JFrame {

    Helper helper = new Helper();
    INguoiDungService iNguoiDungService = new NguoiDungService();
    IChucVuService iChucVuService = new ChucVuService();
    SendMailUltil mailUltil = new SendMailUltil();

    private DefaultComboBoxModel<ChucVu> defaultComboBoxModel = new DefaultComboBoxModel<>();

    CardLayout cardLayout;

    public FrmMethod() {
        initComponents();
        addComBo();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cardLayout = (CardLayout) main.getLayout();
    }

    private void addComBo() {
        cb_chucvu.setModel((DefaultComboBoxModel) defaultComboBoxModel);
        cb_chucvu.removeAllItems();
        for (ChucVu x : iChucVuService.getAll()) {
            defaultComboBoxModel.addElement(x);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        pn_signin = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_forgotPassword = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_username = new swing.TextField_1();
        txt_password = new swing.PasswordField();
        button1 = new swing.Button();
        button6 = new swing.Button();
        pn_reset = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbl_reset_capcha = new javax.swing.JLabel();
        txt_reset_username = new swing.TextField_1();
        txt_reset_email = new swing.TextField_1();
        txt_reset_capcha = new swing.TextField_1();
        button2 = new swing.Button();
        button3 = new swing.Button();
        pn_register = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txt_reg_user = new swing.TextField_1();
        txt_reg_email = new swing.TextField_1();
        txt_reg_password = new swing.PasswordField();
        button4 = new swing.Button();
        button5 = new swing.Button();
        cb_chucvu = new swing.Combobox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MWC");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 234, 312));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("\"Sự lựa chọn hoàn hảo\"");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 220, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Man Women Choices");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/facebook.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 20, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gmail.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 20, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/github.png"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 20, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("mwcstore@gmail.com");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 220, 20));

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        main.setLayout(new java.awt.CardLayout());

        pn_signin.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        lbl_forgotPassword.setForeground(new java.awt.Color(102, 102, 102));
        lbl_forgotPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_forgotPassword.setText("Quên mật khẩu ?");
        lbl_forgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_forgotPasswordMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("SIGN IN");

        txt_username.setLabelText("Tên đăng nhập");
        txt_username.setLineColor(new java.awt.Color(102, 102, 102));
        txt_username.setSelectionColor(new java.awt.Color(204, 204, 204));

        txt_password.setToolTipText("");
        txt_password.setLabelText("Mật khẩu");
        txt_password.setLineColor(new java.awt.Color(102, 102, 102));
        txt_password.setSelectionColor(new java.awt.Color(204, 204, 204));
        txt_password.setShowAndHide(true);

        button1.setBackground(new java.awt.Color(0, 0, 0));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Đăng nhập");
        button1.setFocusPainted(false);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button6.setBackground(new java.awt.Color(102, 102, 102));
        button6.setForeground(new java.awt.Color(255, 255, 255));
        button6.setText("Đăng ký");
        button6.setFocusPainted(false);
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_signinLayout = new javax.swing.GroupLayout(pn_signin);
        pn_signin.setLayout(pn_signinLayout);
        pn_signinLayout.setHorizontalGroup(
            pn_signinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_signinLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pn_signinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_signinLayout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pn_signinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_signinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_forgotPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_signinLayout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_signinLayout.setVerticalGroup(
            pn_signinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_signinLayout.createSequentialGroup()
                .addGroup(pn_signinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_signinLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(pn_signinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_forgotPassword)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pn_signinLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {button1, button6});

        main.add(pn_signin, "signin");

        pn_reset.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("RESET PASSWORD");

        lbl_reset_capcha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_reset_capcha.setForeground(java.awt.Color.red);
        lbl_reset_capcha.setText("Capcha here");

        txt_reset_username.setLabelText("Tên đăng nhập");
        txt_reset_username.setLineColor(new java.awt.Color(102, 102, 102));
        txt_reset_username.setSelectionColor(new java.awt.Color(204, 204, 204));

        txt_reset_email.setLabelText("Email");
        txt_reset_email.setLineColor(new java.awt.Color(102, 102, 102));
        txt_reset_email.setSelectionColor(new java.awt.Color(204, 204, 204));

        txt_reset_capcha.setLabelText("Capcha");
        txt_reset_capcha.setLineColor(new java.awt.Color(102, 102, 102));
        txt_reset_capcha.setSelectionColor(new java.awt.Color(204, 204, 204));

        button2.setBackground(new java.awt.Color(0, 0, 0));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Submit");
        button2.setFocusPainted(false);
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setBackground(new java.awt.Color(102, 102, 102));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("Cancel");
        button3.setFocusPainted(false);
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_resetLayout = new javax.swing.GroupLayout(pn_reset);
        pn_reset.setLayout(pn_resetLayout);
        pn_resetLayout.setHorizontalGroup(
            pn_resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_resetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_resetLayout.createSequentialGroup()
                        .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_reset_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_reset_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_reset_capcha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_reset_capcha, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_resetLayout.setVerticalGroup(
            pn_resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_resetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_reset_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_reset_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_reset_capcha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_reset_capcha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(pn_resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        main.add(pn_reset, "resetpass");

        pn_register.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("REGISTER");

        txt_reg_user.setLabelText("Tên đăng nhập");
        txt_reg_user.setLineColor(new java.awt.Color(102, 102, 102));
        txt_reg_user.setSelectionColor(new java.awt.Color(204, 204, 204));

        txt_reg_email.setLabelText("Email");
        txt_reg_email.setLineColor(new java.awt.Color(102, 102, 102));
        txt_reg_email.setSelectionColor(new java.awt.Color(204, 204, 204));

        txt_reg_password.setLabelText("Mật khẩu");
        txt_reg_password.setLineColor(new java.awt.Color(102, 102, 102));
        txt_reg_password.setSelectionColor(new java.awt.Color(204, 204, 204));

        button4.setBackground(new java.awt.Color(0, 0, 0));
        button4.setForeground(new java.awt.Color(255, 255, 255));
        button4.setText("Đăng ký");
        button4.setFocusPainted(false);
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.setBackground(new java.awt.Color(102, 102, 102));
        button5.setForeground(new java.awt.Color(255, 255, 255));
        button5.setText("Quay lại đăng nhập");
        button5.setFocusPainted(false);
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        cb_chucvu.setLabeText("Chức vụ");
        cb_chucvu.setLineColor(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout pn_registerLayout = new javax.swing.GroupLayout(pn_register);
        pn_register.setLayout(pn_registerLayout);
        pn_registerLayout.setHorizontalGroup(
            pn_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_registerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                    .addComponent(txt_reg_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_reg_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_reg_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_registerLayout.createSequentialGroup()
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cb_chucvu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_registerLayout.setVerticalGroup(
            pn_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_registerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_reg_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_reg_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_reg_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pn_registerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cb_chucvu, txt_reg_password});

        main.add(pn_register, "register");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        if (helper.confirm(this, "Xác nhận thoát ?")) {
            helper.alert(this, "Thoát thành công!");
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void lbl_forgotPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_forgotPasswordMouseClicked
        cardLayout.show(main, "resetpass");
        lbl_reset_capcha.setText(UUID.randomUUID().toString().substring(30, 36));
    }//GEN-LAST:event_lbl_forgotPasswordMouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        String username = txt_username.getText();
        String password = new String(txt_password.getPassword());
        if (username.isEmpty()) {
            helper.error(this, "Tên người dùng không được để trống!");
        } else if (password.isEmpty()) {
            helper.error(this, "Mật khẩu không được để trống!");
        } else {
            if (iNguoiDungService.getObj(username) == null) {
                helper.error(this, "Tên người dùng không tồn tại!");
            } else {
                NguoiDung nd = iNguoiDungService.getObj(username);
                if (!nd.getMatKhau().equals(password)) {
                    helper.error(this, "Mật khẩu không chính xác!");
                    return;
                }
                if (nd.getMa().equals(username) && nd.getMatKhau().equals(password)) {
                    helper.alert(this, "Đăng nhập thành công!");
                    this.dispose();
                    new FrmHome(nd).setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        String username = txt_reset_username.getText();
        String email = txt_reset_email.getText();
        String newPassword = UUID.randomUUID().toString().substring(0, 8);
        NguoiDung nd = iNguoiDungService.getObj(username);

        if (nd == null) {
            helper.error(this, "Tên đăng nhập không tồn tại!");
        } else {
            if (nd.getEmail().equals(email)) {
                if (!txt_reset_capcha.getText().equals(lbl_reset_capcha.getText())) {
                    helper.error(this, "Mã capcha không chính xác!");
                } else {
                    if (helper.confirm(this, "Mật khẩu mới sẽ được gửi đến " + email + ". Chọn YES để xác nhận!")) {
                        nd.setMatKhau(newPassword);
                        iNguoiDungService.save(nd);
                        helper.alert(this, mailUltil.sendEmail(email, "[MWC_STORE] Mật khẩu đã được đặt lại!", "Xin chao, mat khau moi cua ban la: " + newPassword));
                        cardLayout.show(main, "signin");
                    }
                }
            } else {
                helper.error(this, "Email không chính xác!");
            }
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        cardLayout.show(main, "signin");
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        String username = txt_reg_user.getText();
        String password = new String(txt_reg_password.getPassword());
        String email = txt_reg_email.getText();
        ChucVu chucVu = (ChucVu) defaultComboBoxModel.getSelectedItem();

        NguoiDung nd = new NguoiDung();
        nd.setMa(username);
        nd.setMatKhau(password);
        nd.setEmail(email);
        nd.setChucVu(chucVu);

        if (helper.checkNull(txt_reg_user, "Tên người dùng")
                || helper.checkNull(txt_reg_email, "Email")) {
            return;
        }
        if (password.length() < 8) {
            helper.error(this, "Mật khẩu tối thiểu 8 kí tự!");
        } else {
            iNguoiDungService.save(nd);
            helper.alert(this, "Đăng ký thành công!");
            cardLayout.show(main, "signin");
        }
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        cardLayout.show(main, "signin");
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        cardLayout.show(main, "register");
    }//GEN-LAST:event_button6ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMethod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button button1;
    private swing.Button button2;
    private swing.Button button3;
    private swing.Button button4;
    private swing.Button button5;
    private swing.Button button6;
    private swing.Combobox cb_chucvu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_forgotPassword;
    private javax.swing.JLabel lbl_reset_capcha;
    private javax.swing.JPanel main;
    private javax.swing.JPanel pn_register;
    private javax.swing.JPanel pn_reset;
    private javax.swing.JPanel pn_signin;
    private swing.PasswordField txt_password;
    private swing.TextField_1 txt_reg_email;
    private swing.PasswordField txt_reg_password;
    private swing.TextField_1 txt_reg_user;
    private swing.TextField_1 txt_reset_capcha;
    private swing.TextField_1 txt_reset_email;
    private swing.TextField_1 txt_reset_username;
    private swing.TextField_1 txt_username;
    // End of variables declaration//GEN-END:variables
}
