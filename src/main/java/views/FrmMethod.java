package views;

import java.awt.Image;
import java.awt.Toolkit;
import ui.Message;
import ui.PanelCover;
import ui.PanelLoading;
import ui.PanelLoginAndResetPass;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.UUID;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import models.NguoiDung;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import services.INguoiDungService;
import services.impl.NguoiDungService;
import utilities.Helper;
import utilities.SendMailUltil;

/**
 *
 * @author KenTizz
 */
public class FrmMethod extends javax.swing.JFrame {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private INguoiDungService iNguoiDungService = new NguoiDungService();
    private MigLayout layout;
    private PanelCover cover;
    String icon1 = "images/suportUI/loading3.gif";
    String icon2 = "images/suportUI/loading.gif";
    private final PanelLoading loading1 = new PanelLoading(new ImageIcon(icon1));
    private final PanelLoading loading2 = new PanelLoading(new ImageIcon(icon2));
    private PanelLoginAndResetPass loginAndRegister;
    private final Helper helper = new Helper();
    private SendMailUltil mailUltil = new SendMailUltil();
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;

    public FrmMethod() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("images/suportUI/logo.png");
        this.setIconImage(icon);
        init();
    }

    private void init() {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                login();
            }
        };
        ActionListener eventReset = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Reset();
            }
        };
        loginAndRegister = new PanelLoginAndResetPass(eventLogin, eventReset);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                if (fraction >= 0.5f) {
                    loginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
        };
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);  //  for smooth animation
        bg.setLayout(layout);
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(loginAndRegister, "width " + loginSize + "%, pos 1al 0 n 100%"); //  1al as 100%
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
    }

    private void login() {
        NguoiDung nd1 = loginAndRegister.getLogin();
        String username = nd1.getMa(); //txt
        String password = nd1.getMatKhau(); //txt
        if (username.isEmpty()) {
            showMessage(Message.MessageType.ERROR, "Tên người dùng không được để trống!");
        } else if (password.isEmpty()) {
            showMessage(Message.MessageType.ERROR, "Mật khẩu không được để trống!");
        } else {
            if (iNguoiDungService.getObj(username) == null) {
                showMessage(Message.MessageType.ERROR, "Tên người dùng không tồn tại!");
            } else {
                NguoiDung nd = iNguoiDungService.getObj(username);
                if (!nd.getMatKhau().equals(password)) {
                    showMessage(Message.MessageType.ERROR, "Mật khẩu không chính xác!");
                    return;
                }
                if (nd.getTrangThai() == 1) {
                    showMessage(Message.MessageType.ERROR, "Bạn đã nghỉ làm không thể đăng nhập vào hệ thống !");
                    return;
                }
                if (nd.getMa().equals(username) && nd.getMatKhau().equals(password)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                showMessage(Message.MessageType.SUCCESS, "Đăng nhập thành công vào hệ thống");
                                bg.setLayer(loading1, JLayeredPane.POPUP_LAYER);
                                bg.add(loading1, "pos 0 0 100% 100%");
                                loading1.setVisible(true);
                                Thread.sleep(3000);
                                new FrmHome(nd).setVisible(true);
                                dispose();
                            } catch (InterruptedException e) {
                                System.err.println(e);
                            }
                        }
                    }).start();
                }
            }
        }
    }

    private void Reset() {
        NguoiDung ndreset = loginAndRegister.getReset();
        String username = ndreset.getMa(); //txt
        String email = ndreset.getEmail(); //txt
        String lbl_reset_capcha = ndreset.getSdt();
        String txt_reset_capcha = ndreset.getDiaChi();
        String newPassword = UUID.randomUUID().toString().substring(0, 8);
        NguoiDung getND = new NguoiDung();
        getND.setMa(username);
        getND.setEmail(email);
        NguoiDung nd = iNguoiDungService.getObj(username);
        if (nd == null) {
            showMessage(Message.MessageType.ERROR, "Tên đăng nhập không tồn tại!");
        } else {
            if (nd.getEmail().equals(email)) {
                if (!txt_reset_capcha.equals(lbl_reset_capcha)) {
                    showMessage(Message.MessageType.ERROR, "Mã capcha không chính xác!");
                } else {
                    if (helper.confirm(this, "Mật khẩu mới sẽ được gửi đến " + email + ". Chọn YES để xác nhận!")) {
                        showMessage(Message.MessageType.SUCCESS, "Đang gửi mật khẩu mới đến Mail của bạn...");
                        sendMail(nd, newPassword);
                        nd.setMatKhau(newPassword);
                        iNguoiDungService.save(nd);
                    }
                }
            } else {
                showMessage(Message.MessageType.ERROR, "Email không chính xác!");
            }
        }

    }

    private void sendMail(NguoiDung user, String newPassword) {
        String email = user.getEmail();
        new Thread(new Runnable() {
            @Override
            public void run() {
                bg.setLayer(loading2, JLayeredPane.POPUP_LAYER);
                bg.add(loading2, "pos 0 0 100% 100%");
                loading2.setVisible(true);
                showMessage(Message.MessageType.SUCCESS, mailUltil.sendEmail(email, "[MWC_STORE] Mật khẩu đã được đặt lại!", "Xin chào, mật khẩu mới của bạn là: " + newPassword));
                loading2.setVisible(false);
                loginAndRegister.showRegister(isLogin);
            }
        }).start();
    }

    private void showMessage(Message.MessageType messageType, String message) {
        Message ms = new Message();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    bg.add(ms, "pos 0.5al -30", 0); //  Insert to bg fist index 0
                    ms.setVisible(true);
                    bg.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if (ms.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
                layout.setComponentConstraints(ms, "pos 0.5al " + (int) (f - 30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void end() {
                if (ms.isShow()) {
                    bg.remove(ms);
                    bg.repaint();
                    bg.revalidate();
                } else {
                    ms.setShow(true);
                }
            }
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    animator.start();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MWC_Store");
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 933, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMethod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
