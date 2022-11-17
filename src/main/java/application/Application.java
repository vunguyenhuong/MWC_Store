package application;

import views.MainLoginFrame;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class Application {

    public static void main(String[] args) {
        //<editor-fold>
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
        new MainLoginFrame().setVisible(true);
    }
}
