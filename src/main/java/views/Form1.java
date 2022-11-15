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
public class Form1 extends javax.swing.JPanel {

    private INguoiDungService iNguoiDungService = new NguoiDungService();
    private NguoiDung nguoidung;
    private Helper helper = new Helper();
    private String fileName;

    public Form1() {
        initComponents();
        setOpaque(false);
        setSize(100, 100);
    }

    public Form1(NguoiDung nd) {
        initComponents();
        this.nguoidung = nd;
        txt_ma.setText(nd.getMa());
        txt_ten.setText(nd.getTen());
        txt_email.setText(nd.getEmail());
        txt_sdt.setText(nd.getSdt());
        txt_diachi.setText(nd.getDiaChi());
        if (nd.getGioiTinh() == 0) {
            rd_nam.setSelected(true);
        } else {
            rd_nu.setSelected(true);
        }
        try {
            lbl_chucvu.setText(nd.getChucVu().getTen());
        } catch (Exception e) {
        }
        imageAvatar.setImage(new ImageIcon("images/users/" + nd.getHinhAnh()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lbl_chucvu = new javax.swing.JLabel();
        imageAvatar = new swing.ImageAvatar();
        rd_nu = new swing.RadioButtonCustom();
        rd_nam = new swing.RadioButtonCustom();
        btn_sua = new swing.Button();
        txt_sdt = new swing.TextField();
        txt_diachi = new swing.TextField();
        txt_email = new swing.TextField();
        txt_ten = new swing.TextField();
        txt_ma = new swing.TextField();

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

        rd_nu.setText("Nữ");
        rd_nu.setFocusPainted(false);

        rd_nam.setText("Nam");
        rd_nam.setFocusPainted(false);

        btn_sua.setBackground(new java.awt.Color(102, 102, 102));
        btn_sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua.setText("Chỉnh sửa thông tin cá nhân");
        btn_sua.setFocusPainted(false);
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        txt_sdt.setLabelText("Số điện thoại");
        txt_sdt.setLineColor(new java.awt.Color(153, 153, 255));
        txt_sdt.setSelectionColor(new java.awt.Color(153, 153, 255));

        txt_diachi.setLabelText("Địa chỉ");
        txt_diachi.setLineColor(new java.awt.Color(153, 153, 255));
        txt_diachi.setSelectionColor(new java.awt.Color(153, 153, 255));

        txt_email.setLabelText("Email");
        txt_email.setLineColor(new java.awt.Color(153, 153, 255));
        txt_email.setSelectionColor(new java.awt.Color(153, 153, 255));

        txt_ten.setLabelText("Tên");
        txt_ten.setLineColor(new java.awt.Color(153, 153, 255));
        txt_ten.setSelectionColor(new java.awt.Color(153, 153, 255));

        txt_ma.setEditable(false);
        txt_ma.setLabelText("Mã");
        txt_ma.setLineColor(new java.awt.Color(153, 153, 255));
        txt_ma.setSelectionColor(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txt_diachi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_chucvu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(56, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbl_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(48, Short.MAX_VALUE)))
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

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
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
            imageAvatar.setImage(new ImageIcon("images/users/" + nguoidung.getHinhAnh()));
            helper.alert(this, "Cập nhật thông tin thành công!");
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_sua;
    private javax.swing.ButtonGroup buttonGroup1;
    private swing.ImageAvatar imageAvatar;
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
