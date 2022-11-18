package views;

import UI.EventMenuSelected;
import UI.EventShowPopupMenu;
import UI.Header;
import UI.MainForm;
import UI.Menu;
import UI.MenuItem;
import UI.PopupMenu;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JPanel;
import models.NguoiDung;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import utilities.Helper;

/**
 *
 * @author KenTizz
 */
public class FrmMainHome extends javax.swing.JFrame implements Runnable, ThreadFactory {
    
    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    private Webcam webcam = null;
    private WebcamPanel panel = null;
    private Helper helper = new Helper();
    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;
    NguoiDung nguoiDung = new NguoiDung();
    private CardLayout cardLayout;
    
    public FrmMainHome(NguoiDung nd) {
        initComponents();
        this.nguoiDung = nd;
        setExtendedState(MAXIMIZED_BOTH);
        header = new Header(nguoiDung);
        init();
        cardLayout = (CardLayout) pn_main.getLayout();
        cardLayout.show(pn_main, "general");
        initWebcam(pn_webcam);
    }
    
    public FrmMainHome() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        header = new Header();
        init();
        cardLayout = (CardLayout) pn_main.getLayout();
        cardLayout.show(pn_main, "general");
        initWebcam(pn_webcam);
    }
    
    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        main = new MainForm();
        MouseListener even = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed");
                main.showForm(new FrmTrangChu());
            }
        };
        menu = new Menu(even);
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    if (subMenuIndex == 0) {
                        main.showForm(new FrmProfile(nguoiDung));
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
                        main.showForm(new FrmChiTietDep());
                    } else if (subMenuIndex == 1) {
// Dép
                    } else if (subMenuIndex == 2) {
// Loại dép
                    } else if (subMenuIndex == 3) {
// Size
                    } else if (subMenuIndex == 4) {
// Chất liệu
                        main.showForm(new FrmChatLieuOK());
                    } else if (subMenuIndex == 5) {
// Màu sắc
                        main.showForm(new FrmMauSac());
                    } else if (subMenuIndex == 6) {
// NSX
                        main.showForm(new FrmNhaSanXuat());
                    }
                }
                if (menuIndex == 3) {
                    if (subMenuIndex == 0) {
                        
                    } else if (subMenuIndex == 1) {
                        
                    }
                }
                if (menuIndex == 4) {
                    cardLayout.show(pn_main, "banhang");
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
                            webcam.close();
                            new FrmMethod().setVisible(true);
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
                PopupMenu popup = new PopupMenu(FrmMainHome.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = FrmMainHome.this.getX() + 52;
                int y = FrmMainHome.this.getY() + com.getY() + 86;
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
        //  Init google icon font
        //  Start with this form
        main.showForm(new FrmTrangChu());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        
        pn_main = new javax.swing.JPanel();
        bg = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        pn_webcam = new javax.swing.JPanel();
        button1 = new swing.Button();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        
        pn_main.setLayout(new java.awt.CardLayout());
        
        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);
        
        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 2035, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1163, Short.MAX_VALUE)
        );
        
        pn_main.add(bg, "general");
        
        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        
        pn_webcam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        button1.setBackground(new java.awt.Color(102, 102, 102));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Trở về màn hình chính");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(1779, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pn_webcam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pn_webcam, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(953, Short.MAX_VALUE))
        );
        
        pn_main.add(jPanel2, "banhang");
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pn_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pn_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        cardLayout.show(pn_main, "general");
    }//GEN-LAST:event_button1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(FrmMainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmMainHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private swing.Button button1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pn_main;
    private javax.swing.JPanel pn_webcam;
    // End of variables declaration//GEN-END:variables

    public void initWebcam(JPanel panelShow) {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);
        
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
        panel.setMirrored(true);
        
        panelShow.add(panel, new AbsoluteConstraints(0, 0, panelShow.getWidth(), panelShow.getHeight()));
        
        executor.execute(this);
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            Result result = null;
            BufferedImage image = null;
            
            if (webcam.isOpen()) {
                
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
                
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                
                try {
                    result = new MultiFormatReader().decode(bitmap);
                } catch (NotFoundException e) {
                    // fall thru, it means there is no QR code in image
                }
            }
            
            if (result != null) {
                try {
                    Desktop.getDesktop().browse(new URL(result.getText()).toURI());
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "example-runner");
        t.setDaemon(true);
        return t;
    }
}
