package views;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.NguoiDung;
import services.INguoiDungService;
import services.impl.NguoiDungService;
import utilities.Helper;

/**
 *
 * @author KenTizz
 */
public class FrmProfile extends javax.swing.JPanel {

    private INguoiDungService iNguoiDungService;
    private NguoiDung nguoidung = new NguoiDung();
    private Helper helper = new Helper();
    private String fileName;

    public FrmProfile() {
        initComponents();
        setOpaque(false);
        setSize(100, 100);
    }

    public FrmProfile(NguoiDung nd) {
        initComponents();
        this.nguoidung = nd;
        iNguoiDungService = new NguoiDungService();
        txt_ma.setText(nd.getMa());
        txt_ten.setText(nd.getTen());
        txt_email.setText(nd.getEmail());
        txt_sdt.setText(nd.getSdt());
        txt_diachi.setText(nd.getDiaChi());
        fileName = nd.getHinhAnh();
        if (nd.getGioiTinh() == 0) {
            rd_nam.setSelected(true);
        } else {
            rd_nu.setSelected(true);
        }
        try {
            lbl_chucvu.setText(nd.getChucVu().getTen());
        } catch (Exception e) {
        }
        imageAvatar.setImage(new ImageIcon("images/users/" + fileName));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lbl_chucvu = new javax.swing.JLabel();
        imageAvatar = new swing.ImageAvatar();
        rd_nu = new swing.RadioButtonCustom();
        rd_nam = new swing.RadioButtonCustom();
        txt_sdt = new swing.TextField();
        txt_diachi = new swing.TextField();
        txt_email = new swing.TextField();
        txt_ten = new swing.TextField();
        txt_ma = new swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        buttonLG1 = new swing.ButtonLG();

        setBackground(new java.awt.Color(255, 255, 255));

        lbl_chucvu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_chucvu.setForeground(java.awt.Color.red);
        lbl_chucvu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_chucvu.setText("Chức vụ");

        imageAvatar.setGradientColor1(new java.awt.Color(255, 51, 51));
        imageAvatar.setGradientColor2(new java.awt.Color(51, 0, 255));
        imageAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageAvatarMouseClicked(evt);
            }
        });

        buttonGroup1.add(rd_nu);
        rd_nu.setText("Nữ");
        rd_nu.setFocusPainted(false);

        buttonGroup1.add(rd_nam);
        rd_nam.setText("Nam");
        rd_nam.setFocusPainted(false);

        txt_sdt.setEditable(false);
        txt_sdt.setLabelText("Số điện thoại");
        txt_sdt.setLineColor(new java.awt.Color(153, 153, 255));
        txt_sdt.setSelectionColor(new java.awt.Color(153, 153, 255));

        txt_diachi.setEditable(false);
        txt_diachi.setLabelText("Địa chỉ");
        txt_diachi.setLineColor(new java.awt.Color(153, 153, 255));
        txt_diachi.setSelectionColor(new java.awt.Color(153, 153, 255));

        txt_email.setEditable(false);
        txt_email.setLabelText("Email");
        txt_email.setLineColor(new java.awt.Color(153, 153, 255));
        txt_email.setSelectionColor(new java.awt.Color(153, 153, 255));

        txt_ten.setEditable(false);
        txt_ten.setLabelText("Tên");
        txt_ten.setLineColor(new java.awt.Color(153, 153, 255));
        txt_ten.setSelectionColor(new java.awt.Color(153, 153, 255));

        txt_ma.setEditable(false);
        txt_ma.setLabelText("Mã");
        txt_ma.setLineColor(new java.awt.Color(153, 153, 255));
        txt_ma.setSelectionColor(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("THÔNG TIN CÁ NHÂN");

        buttonLG1.setForeground(new java.awt.Color(255, 255, 255));
        buttonLG1.setText("Chỉnh sửa thông tin cá nhân");
        buttonLG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLG1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(buttonLG1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                            .addComponent(txt_diachi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_ten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_ma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonLG1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imageAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAvatarMouseClicked
        JFileChooser fileChooser = new JFileChooser("images/users/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*jpg", "jpg");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = new File(fileChooser.getSelectedFile().getPath());
                file.renameTo(new File("images/users/" + file.getName()));
                fileName = file.getName();
                imageAvatar.setImage(new ImageIcon("images/users/" + file.getName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_imageAvatarMouseClicked

    private void buttonLG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLG1ActionPerformed
        nguoidung.setHinhAnh(fileName);
        nguoidung.setTen(txt_ten.getText());
        nguoidung.setEmail(txt_email.getText());
        nguoidung.setSdt(txt_sdt.getText());
        nguoidung.setDiaChi(txt_diachi.getText());
        if (rd_nam.isSelected()) {
            nguoidung.setGioiTinh(0);
        } else {
            nguoidung.setGioiTinh(1);
        }
        if (fileName == null) {
            helper.error(this, "Vui lòng chọn hình ảnh!");
        } else {
            iNguoiDungService.save(nguoidung);
            imageAvatar.setImage(new ImageIcon("images/users/" + fileName));
            helper.alert(this, "Cập nhật thông tin thành công!");
        }
    }//GEN-LAST:event_buttonLG1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private swing.ButtonLG buttonLG1;
    private swing.ImageAvatar imageAvatar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_chucvu;
    private swing.RadioButtonCustom rd_nam;
    private swing.RadioButtonCustom rd_nu;
    private swing.TextField txt_diachi;
    private swing.TextField txt_email;
    private swing.TextField txt_ma;
    private swing.TextField txt_sdt;
    private swing.TextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
