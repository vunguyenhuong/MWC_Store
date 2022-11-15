package views;

import swing.Message;
import swing.PanelCover;
import swing.PanelLoading;
import swing.PanelLoginAndRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JLayeredPane;
import models.ChucVu;
import models.NguoiDung;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import services.INguoiDungService;
import services.impl.NguoiDungService;

public class MainLoginFrame extends javax.swing.JFrame {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    INguoiDungService iNguoiDungService = new NguoiDungService();
    private MigLayout layout;
    private PanelCover cover;
    private PanelLoading loading;
    private PanelLoginAndRegister loginAndRegister;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;

    public MainLoginFrame() {
        initComponents();
        init();
        setExtendedState(MAXIMIZED_HORIZ);
    }

    private void init() {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        loading = new PanelLoading();
        ActionListener eventRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                register();
            }
        };
        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                login();
            }
        };
        ActionListener eventReset = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new PanelLoading().setVisible(true);
                new MainResetPassFrame().setVisible(true);
                dispose();
            }
        };
        loginAndRegister = new PanelLoginAndRegister(eventRegister, eventLogin, eventReset);
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
        bg.setLayer(loading, JLayeredPane.POPUP_LAYER);
        bg.add(loading, "pos 0 0 100% 100%");
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

    private void register() {
        NguoiDung nd2 = loginAndRegister.getRegister();
        String username = nd2.getMa(); //txt
        String email = nd2.getEmail(); //txt
        String password = nd2.getMatKhau(); //txt
        ChucVu cb = nd2.getChucVu();
        NguoiDung getND = new NguoiDung();
        getND.setMa(username);
        getND.setEmail(email);
        getND.setMatKhau(password);
        getND.setChucVu(cb);
        if (username.isEmpty()) {
            showMessage(Message.MessageType.ERROR, "Tên người dùng không được để trống!");
        } else if (email.isEmpty()) {
            showMessage(Message.MessageType.ERROR, "Email không được để trống!");
        } else if (password.isEmpty()) {
            showMessage(Message.MessageType.ERROR, "Mật khẩu không được để trống!");
        } else if (password.length() < 8) {
            showMessage(Message.MessageType.ERROR, "Mật khẩu tối thiểu 8 kí tự!");
        } else if (iNguoiDungService.getObj(username) != null) {
            showMessage(Message.MessageType.ERROR, "Tên đăng nhập đã tồn tại!");
        } else {
            iNguoiDungService.save(getND);
            showMessage(Message.MessageType.SUCCESS, "Đăng ký thành công !");
        }

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
                if (nd.getMa().equals(username) && nd.getMatKhau().equals(password)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                loading.setVisible(true);
                                Thread.sleep(2350);
//                                new FrmHome(nd).setVisible(true);
                                new MainHome(nd).setVisible(true);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainLoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
