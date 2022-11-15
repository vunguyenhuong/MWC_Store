package UI;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import models.NguoiDung;

/**
 *
 * @author KenTizz
 */
public class Header extends javax.swing.JPanel {

    private NguoiDung nguoidung = new NguoiDung();

    public Header(NguoiDung nd) {
        initComponents();
        cmdMenu.setIcon(new ImageIcon(getClass().getResource("/icons/menu.png")));
        this.nguoidung = nd;
        lbl_tenUser.setText(nd.getTen());
        lbl_role.setText(nd.getChucVu().getTen());
        imageAvatar.setIcon(new ImageIcon("images/users/" + nd.getHinhAnh()));
    }

    public Header() {
        initComponents();
        cmdMenu.setIcon(new ImageIcon(getClass().getResource("/icons/menu.png")));
    }

    public void addMenuEvent(ActionListener event) {
        cmdMenu.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMenu = new UI.Button();
        imageAvatar = new UI.ImageAvatar();
        lbl_tenUser = new javax.swing.JLabel();
        lbl_role = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        lbl_tenUser.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbl_tenUser.setForeground(new java.awt.Color(127, 127, 127));
        lbl_tenUser.setText("User Name");

        lbl_role.setForeground(new java.awt.Color(127, 127, 127));
        lbl_role.setText("Admin");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 453, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_tenUser, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_role, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_tenUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_role))
                    .addComponent(cmdMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.Button cmdMenu;
    private UI.ImageAvatar imageAvatar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_role;
    private javax.swing.JLabel lbl_tenUser;
    // End of variables declaration//GEN-END:variables
}
