package UI;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import models.NguoiDung;

/**
 *
 * @author KenTizz
 */
public class Header extends javax.swing.JPanel {

    private NguoiDung nguoidung = new NguoiDung();

    public Header(NguoiDung nd) {
        initComponents();
//        cmdMenu.setIcon(new ImageIcon(getClass().getResource("/icons/menu.png")));
        this.nguoidung = nd;
        lbl_tenUser.setText(nd.getTen());
        lbl_role.setText(nd.getChucVu().getTen());
        imageAvatar.setIcon(new ImageIcon("images/users/" + nd.getHinhAnh()));
    }

    public Header() {
        initComponents();
//        cmdMenu.setIcon(new ImageIcon(getClass().getResource("/icons/menu.png")));
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
        buttonBadges1 = new UI.ButtonBadges();
        buttonBadges2 = new UI.ButtonBadges();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu.png"))); // NOI18N

        lbl_tenUser.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbl_tenUser.setForeground(new java.awt.Color(127, 127, 127));
        lbl_tenUser.setText("User Name");

        lbl_role.setForeground(new java.awt.Color(127, 127, 127));
        lbl_role.setText("Admin");

        buttonBadges1.setForeground(new java.awt.Color(0, 204, 255));
        buttonBadges1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/message.png"))); // NOI18N
        buttonBadges1.setBadges(4);

        buttonBadges2.setForeground(new java.awt.Color(255, 0, 0));
        buttonBadges2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/notification.png"))); // NOI18N
        buttonBadges2.setBadges(12);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 367, Short.MAX_VALUE)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_tenUser, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_role, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbl_tenUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(lbl_role))
                    .addComponent(cmdMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageAvatar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonBadges1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonBadges2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.ButtonBadges buttonBadges1;
    private UI.ButtonBadges buttonBadges2;
    private UI.Button cmdMenu;
    private UI.ImageAvatar imageAvatar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_role;
    private javax.swing.JLabel lbl_tenUser;
    // End of variables declaration//GEN-END:variables
}
