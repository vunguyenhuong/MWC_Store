package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import models.NguoiDung;
import net.miginfocom.swing.MigLayout;
import swing.ButtonLG;
import swing.MyPasswordField;
import swing.MyTextField;

/**
 *
 * @author KenTizz
 */
public class PanelLoginAndResetPass extends javax.swing.JLayeredPane {

    public NguoiDung getReset() {
        return dataReset;
    }

    public NguoiDung getLogin() {
        return dataLogin;
    }
    private NguoiDung dataLogin;
    private NguoiDung dataReset;
    MyTextField txtcapcha = new MyTextField();
    JLabel lblcapCha = new JLabel();

    public PanelLoginAndResetPass(ActionListener eventLogin, ActionListener eventReset) {
        initComponents();
        initLogin(eventLogin);
        initReset(eventReset);
        login.setVisible(true);
        reset.setVisible(false);
    }

    private void initLogin(ActionListener eventLogin) {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]25[]push"));
        JLabel label = new JLabel("SIGN IN");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(85, 184, 236));
        login.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icons/use.png")));
        txtUser.setHint("Tên đăng nhập");
        login.add(txtUser, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icons/pass.png")));
        txtPass.setHint("Mật khẩu");
        txtPass.setShowAndHide(true);
        login.add(txtPass, "w 60%");
        ButtonLG cmd = new ButtonLG();
        cmd.setForeground(new Color(255, 255, 255));
        cmd.addActionListener(eventLogin);
        cmd.setText("SIGN IN");
        cmd.setFocusPainted(false);
        login.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String user = txtUser.getText().trim();
                String password = txtPass.getText().trim();
                dataLogin = new NguoiDung();
                dataLogin.setMa(user);
                dataLogin.setMatKhau(password);
            }
        });
    }

    private void initReset(ActionListener eventReset) {
        reset.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]1[]1[]25[]10[]push"));
        JLabel label = new JLabel("Reset Password");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(85, 184, 236));
        reset.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icons/use.png")));
        txtUser.setHint("Tên đăng nhập");
        reset.add(txtUser, "w 60%");
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icons/mail.png")));
        txtEmail.setHint("Email");
        reset.add(txtEmail, "w 60%");
        lblcapCha.setText(UUID.randomUUID().toString().substring(30, 36));
        lblcapCha.setFont(new Font("sansserif", 1, 15));
        lblcapCha.setForeground(new Color(255, 0, 0));
        reset.add(lblcapCha, "w 60%");
        txtcapcha.setPrefixIcon(new ImageIcon(getClass().getResource("/icons/capcha.png")));
        txtcapcha.setHint("Capcha");
        reset.add(txtcapcha, "w 60%");
        ButtonLG cmd = new ButtonLG();
        cmd.setBackground(new Color(176, 196, 222));
        cmd.setForeground(new Color(255, 255, 255));
        cmd.addActionListener(eventReset);
        cmd.setText("SUBMIT");
        cmd.setFocusPainted(false);
        reset.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String user = txtUser.getText().trim();
                String email = txtEmail.getText().trim();
                String lblCapCha = lblcapCha.getText().trim();
                String txtCapCha = txtcapcha.getText().trim();
                dataReset = new NguoiDung();
                dataReset.setMa(user);
                dataReset.setEmail(email);
                dataReset.setDiaChi(lblCapCha);
                dataReset.setSdt(txtCapCha);
                lblcapCha.setText(UUID.randomUUID().toString().substring(30, 36));
            }
        });
    }

    public void showRegister(boolean show) {
        if (show) {
            login.setVisible(true);
            reset.setVisible(false);
        } else {
            login.setVisible(false);
            reset.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reset = new javax.swing.JPanel();
        login = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        reset.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout resetLayout = new javax.swing.GroupLayout(reset);
        reset.setLayout(resetLayout);
        resetLayout.setHorizontalGroup(
            resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        resetLayout.setVerticalGroup(
            resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(reset, "card3");

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel reset;
    // End of variables declaration//GEN-END:variables
}
