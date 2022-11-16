package views;

import UI.EventMenuSelected;
import UI.EventShowPopupMenu;
import UI.Header;
import UI.MainForm;
import UI.Menu;
import UI.MenuItem;
import UI.PopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.NguoiDung;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import utilities.Helper;

/**
 *
 * @author KenTizz
 */
public class MainHome extends javax.swing.JFrame {

    private Helper helper = new Helper();
    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;
    NguoiDung nguoiDung = new NguoiDung();

    public MainHome(NguoiDung nd) {
        initComponents();
        this.nguoiDung = nd;
        setExtendedState(MAXIMIZED_BOTH);
        header = new Header(nguoiDung);
        init();
    }

    public MainHome() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        header = new Header();
        init();
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    if (subMenuIndex == 0) {
                        main.showForm(new Form1(nguoiDung));
                    } else if (subMenuIndex == 1) {
// Đổi MK
                    }
                }
                if (menuIndex == 1) {
                    if (subMenuIndex == 0) {
// QLNV
                    } else if (subMenuIndex == 1) {
// abc
                    }
                }
                if (menuIndex == 2) {
                    if (subMenuIndex == 0) {
// CTSPFrmCTD
                        main.showForm(new FrmCTD());
                    } else if (subMenuIndex == 1) {
// Dép
                    } else if (subMenuIndex == 2) {
// Loại dép
                    } else if (subMenuIndex == 3) {
// Size
                    } else if (subMenuIndex == 4) {
// Chất liệu
                    } else if (subMenuIndex == 5) {
// Màu sắc
                        main.showForm(new FrmMS());
                    } else if (subMenuIndex == 6) {
// NSX
                    }
                }
                if (menuIndex == 3) {
                    if (subMenuIndex == 0) {

                    } else if (subMenuIndex == 1) {

                    }
                }
                if (menuIndex == 4) {
                    if (subMenuIndex == 0) {

                    } else if (subMenuIndex == 1) {

                    }
                }
                if (menuIndex == 5) {
                    if (subMenuIndex == 0) {

                    } else if (subMenuIndex == 1) {

                    }
                }
                if (menuIndex == 6) {
                    if (subMenuIndex == 0) {
                        if (helper.confirm(rootPane, "Bạn có chắc muốn đăng xuất ?")) {
                            dispose();
                            new MainLoginFrame().setVisible(true);
                        }
                    } else if (subMenuIndex == 1) {
                        if (helper.confirm(rootPane, "Bạn có chắc muốn thoát không ?")) {
                            System.exit(0);
                        }
                    }
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(MainHome.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = MainHome.this.getX() + 52;
                int y = MainHome.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        menu.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.showForm(new HomeFrame());
            }
        });
        //  Init google icon font
        //  Start with this form
        main.showForm(new HomeFrame());
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
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
