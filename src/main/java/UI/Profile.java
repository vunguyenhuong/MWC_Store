package UI;



/**
 *
 * @author KenTizz
 */
public class Profile extends javax.swing.JPanel {
    
    public Profile() {
        initComponents();
        setOpaque(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new UI.ImageAvatar();
        logo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo1.png"))); // NOI18N
        add(imageAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 80));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo2.png"))); // NOI18N
        add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 170, 80));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.ImageAvatar imageAvatar1;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables

}
