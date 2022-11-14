package swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import models.ChucVu;
import models.NguoiDung;
import net.miginfocom.swing.MigLayout;
import services.IChucVuService;
import services.impl.ChucVuService;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    public NguoiDung getLogin() {
        return dataLogin;
    }

    public ChucVu getCV() {
        return dataChucVu;
    }

    public NguoiDung getRegister() {
        return dataRegister;
    }
    private ChucVu dataChucVu;
    private NguoiDung dataRegister;
    private NguoiDung dataLogin;
    private Combobox cb = new Combobox();
    private JButton cmdForget;
    private DefaultComboBoxModel<ChucVu> defaultComboBoxModel = new DefaultComboBoxModel<>();
    IChucVuService iChucVuService = new ChucVuService();

    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin, ActionListener eventReset) {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin, eventReset);
        login.setVisible(false);
        register.setVisible(true);
    }

    private ChucVu addComBo() {
        ChucVu cv = new ChucVu();
        cb.setModel((DefaultComboBoxModel) defaultComboBoxModel);
        cb.removeAllItems();
        for (ChucVu x : iChucVuService.getAll()) {
            defaultComboBoxModel.addElement(x);
        }
        return cv;
    }

    private void initRegister(ActionListener eventRegister) {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]1[]25[]push"));
        JLabel label = new JLabel("REGISTER");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(176, 196, 222));
        register.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icons/use.png")));
        txtUser.setHint("Tên đăng nhập");
        register.add(txtUser, "w 60%");
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icons/mail.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icons/pass.png")));
        txtPass.setHint("Mật khẩu");
        register.add(txtPass, "w 60%");
        cb.setLabeText("Chức vụ");
        cb.setFont(new Font("sansserif", 1, 13));
        cb.setForeground(new Color(176, 150, 222));
        cb.setSelectedItem(addComBo());
        register.add(cb, "w 60%");
        ButtonUI cmd = new ButtonUI();
        cmd.setBackground(new Color(176, 196, 222));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventRegister);
        cmd.setText("SIGN UP");
        cmd.setFocusPainted(false);
        register.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String userName = txtUser.getText().trim();
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                ChucVu chuc = (ChucVu) defaultComboBoxModel.getSelectedItem();
                dataRegister = new NguoiDung();
                dataRegister.setMa(userName);
                dataRegister.setEmail(email);
                dataRegister.setMatKhau(password);
                dataRegister.setChucVu(chuc);
            }
        });
    }

    private void initLogin(ActionListener eventLogin, ActionListener eventReset) {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("SIGN IN");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(176, 196, 222));
        login.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icons/use.png")));
        txtUser.setHint("Tên đăng nhập");
        login.add(txtUser, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icons/pass.png")));
        txtPass.setHint("Mật khẩu");
        login.add(txtPass, "w 60%");
        JButton cmdForget = new JButton("Quên mật khẩu ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdForget.addActionListener(eventReset);
        cmdForget.setFocusPainted(false);
        cmdForget.setBorderPainted(false);
        login.add(cmdForget);
        ButtonUI cmd = new ButtonUI();
        cmd.setBackground(new Color(176, 196, 222));
        cmd.setForeground(new Color(255, 255, 255));
        cmd.addActionListener(eventLogin);
        cmd.setText("SIGN IN");
        cmd.setFocusPainted(false);
        login.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String user = txtUser.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                dataLogin = new NguoiDung();
                dataLogin.setMa(user);
                dataLogin.setMatKhau(password);
            }
        });
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

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

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
