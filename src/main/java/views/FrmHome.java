package views;

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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.NguoiDung;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import services.INguoiDungService;
import services.impl.NguoiDungService;
import utilities.Helper;
import utilities.ImageUltil;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class FrmHome extends javax.swing.JFrame implements Runnable,ThreadFactory{
    
    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    private Webcam webcam = null;
    private WebcamPanel panel = null;

    private INguoiDungService iNguoiDungService = new NguoiDungService();
    ImageUltil imageUltil = new ImageUltil();
    private String fileName;
    private Helper helper = new Helper();
    private NguoiDung nguoidung = new NguoiDung();

    private CardLayout cardLayout;

    public FrmHome(NguoiDung nd) {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        this.nguoidung = nd;
        lbl_tenUser.setText(nd.getTen());
        lbl_role.setText(nd.getChucVu().getTen());
        imageAvatar.setImage(new ImageIcon("images/users/" + nd.getHinhAnh()));
        cardLayout = (CardLayout) main.getLayout();
        cardLayout.show(main, "general");
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
        imageAvatar1.setImage(new ImageIcon("images/users/" + nd.getHinhAnh()));
    }

    public FrmHome() {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        cardLayout = (CardLayout) main.getLayout();
        cardLayout.show(main, "general");
    }

    private void effectNav(JPanel pn_goc, JPanel pn1, JPanel pn2, JPanel pn3, JPanel pn4, JPanel pn5) {
        pn_goc.setBackground(Color.GRAY);
        pn1.setBackground(Color.BLACK);
        pn2.setBackground(Color.BLACK);
        pn3.setBackground(Color.BLACK);
        pn4.setBackground(Color.BLACK);
        pn5.setBackground(Color.BLACK);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        imageAvatar = new swing.ImageAvatar();
        lbl_tenUser = new javax.swing.JLabel();
        lbl_role = new javax.swing.JLabel();
        home = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nv = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        sp = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        hd = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        bh = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        thongke = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        dangxuat = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        txt_sdt = new swing.TextField();
        txt_email = new swing.TextField();
        jLabel8 = new javax.swing.JLabel();
        txt_ma = new swing.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_thongbao = new javax.swing.JTextArea();
        btn_changePass = new swing.Button();
        jLabel9 = new javax.swing.JLabel();
        btn_sua = new swing.Button();
        txt_reNewPassword = new swing.PasswordField();
        lbl_err_oldpass = new javax.swing.JLabel();
        txt_newPassword = new swing.PasswordField();
        lbl_err_newpass = new javax.swing.JLabel();
        txt_oldPassword = new swing.PasswordField();
        lbl_err_renewpass = new javax.swing.JLabel();
        rd_nu = new swing.RadioButtonCustom();
        jSeparator2 = new javax.swing.JSeparator();
        rd_nam = new swing.RadioButtonCustom();
        jLabel10 = new javax.swing.JLabel();
        txt_diachi = new swing.TextField();
        lbl_chucvu = new javax.swing.JLabel();
        imageAvatar1 = new swing.ImageAvatar();
        txt_ten = new swing.TextField();
        deskpane = new javax.swing.JDesktopPane();
        pn_banhang = new javax.swing.JPanel();
        pn_webcam = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(java.awt.Color.black);

        imageAvatar.setGradientColor1(new java.awt.Color(51, 51, 255));
        imageAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageAvatarMouseClicked(evt);
            }
        });

        lbl_tenUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_tenUser.setForeground(java.awt.Color.orange);
        lbl_tenUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tenUser.setText("User Name");

        lbl_role.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_role.setForeground(java.awt.Color.red);
        lbl_role.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_role.setText("Role");

        home.setBackground(new java.awt.Color(0, 0, 0));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Trang chủ");

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        nv.setBackground(new java.awt.Color(0, 0, 0));
        nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nvMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quản lý nhân viên");

        javax.swing.GroupLayout nvLayout = new javax.swing.GroupLayout(nv);
        nv.setLayout(nvLayout);
        nvLayout.setHorizontalGroup(
            nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        nvLayout.setVerticalGroup(
            nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        sp.setBackground(new java.awt.Color(0, 0, 0));
        sp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quản lý sản phẩm");

        javax.swing.GroupLayout spLayout = new javax.swing.GroupLayout(sp);
        sp.setLayout(spLayout);
        spLayout.setHorizontalGroup(
            spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        spLayout.setVerticalGroup(
            spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, spLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        hd.setBackground(new java.awt.Color(0, 0, 0));
        hd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hdMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Quản lý hóa đơn");

        javax.swing.GroupLayout hdLayout = new javax.swing.GroupLayout(hd);
        hd.setLayout(hdLayout);
        hdLayout.setHorizontalGroup(
            hdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        hdLayout.setVerticalGroup(
            hdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        bh.setBackground(new java.awt.Color(0, 0, 0));
        bh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bhMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Bán hàng");

        javax.swing.GroupLayout bhLayout = new javax.swing.GroupLayout(bh);
        bh.setLayout(bhLayout);
        bhLayout.setHorizontalGroup(
            bhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bhLayout.setVerticalGroup(
            bhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        thongke.setBackground(new java.awt.Color(0, 0, 0));
        thongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thongkeMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Thống kê");

        javax.swing.GroupLayout thongkeLayout = new javax.swing.GroupLayout(thongke);
        thongke.setLayout(thongkeLayout);
        thongkeLayout.setHorizontalGroup(
            thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thongkeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        thongkeLayout.setVerticalGroup(
            thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thongkeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        dangxuat.setBackground(new java.awt.Color(102, 102, 102));
        dangxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dangxuatMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Đăng xuất");

        javax.swing.GroupLayout dangxuatLayout = new javax.swing.GroupLayout(dangxuat);
        dangxuat.setLayout(dangxuatLayout);
        dangxuatLayout.setHorizontalGroup(
            dangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dangxuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        dangxuatLayout.setVerticalGroup(
            dangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dangxuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_tenUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_role, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(imageAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thongke, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {hd, home, nv, sp});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_tenUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_role, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bh, hd, home, nv, sp});

        main.setLayout(new java.awt.CardLayout());

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txt_sdt.setLabelText("Số điện thoại");
        txt_sdt.setLineColor(new java.awt.Color(153, 153, 255));
        txt_sdt.setSelectionColor(new java.awt.Color(153, 153, 255));

        txt_email.setLabelText("Email");
        txt_email.setLineColor(new java.awt.Color(153, 153, 255));
        txt_email.setSelectionColor(new java.awt.Color(153, 153, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("THÔNG TIN CÁ NHÂN");

        txt_ma.setEditable(false);
        txt_ma.setLabelText("Mã");
        txt_ma.setLineColor(new java.awt.Color(153, 153, 255));
        txt_ma.setSelectionColor(new java.awt.Color(153, 153, 255));

        txt_thongbao.setColumns(20);
        txt_thongbao.setRows(5);
        jScrollPane1.setViewportView(txt_thongbao);

        btn_changePass.setBackground(new java.awt.Color(102, 102, 102));
        btn_changePass.setForeground(new java.awt.Color(255, 255, 255));
        btn_changePass.setText("SUBMIT");
        btn_changePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changePassActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("THÔNG BÁO");

        btn_sua.setBackground(new java.awt.Color(102, 102, 102));
        btn_sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua.setText("Chỉnh sửa thông tin cá nhân");
        btn_sua.setFocusPainted(false);
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        txt_reNewPassword.setLabelText("Xác nhận mật khẩu mới");
        txt_reNewPassword.setLineColor(new java.awt.Color(153, 153, 255));
        txt_reNewPassword.setSelectionColor(new java.awt.Color(153, 153, 255));
        txt_reNewPassword.setShowAndHide(true);
        txt_reNewPassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_reNewPasswordCaretUpdate(evt);
            }
        });

        lbl_err_oldpass.setFont(lbl_err_oldpass.getFont().deriveFont(lbl_err_oldpass.getFont().getSize()-1f));
        lbl_err_oldpass.setForeground(java.awt.Color.red);
        lbl_err_oldpass.setText(" ");

        txt_newPassword.setLabelText("Mật khẩu mới");
        txt_newPassword.setLineColor(new java.awt.Color(153, 153, 255));
        txt_newPassword.setSelectionColor(new java.awt.Color(153, 153, 255));
        txt_newPassword.setShowAndHide(true);
        txt_newPassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_newPasswordCaretUpdate(evt);
            }
        });

        lbl_err_newpass.setFont(lbl_err_newpass.getFont().deriveFont(lbl_err_newpass.getFont().getSize()-1f));
        lbl_err_newpass.setForeground(java.awt.Color.red);
        lbl_err_newpass.setText(" ");

        txt_oldPassword.setLabelText("Mật khẩu hiện tại");
        txt_oldPassword.setLineColor(new java.awt.Color(153, 153, 255));
        txt_oldPassword.setSelectionColor(new java.awt.Color(153, 153, 255));
        txt_oldPassword.setShowAndHide(true);
        txt_oldPassword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_oldPasswordCaretUpdate(evt);
            }
        });

        lbl_err_renewpass.setFont(lbl_err_renewpass.getFont().deriveFont(lbl_err_renewpass.getFont().getSize()-1f));
        lbl_err_renewpass.setForeground(java.awt.Color.red);
        lbl_err_renewpass.setText(" ");

        buttonGroup1.add(rd_nu);
        rd_nu.setText("Nữ");
        rd_nu.setFocusPainted(false);

        buttonGroup1.add(rd_nam);
        rd_nam.setText("Nam");
        rd_nam.setFocusPainted(false);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("ĐỔI MẬT KHẨU");

        txt_diachi.setLabelText("Địa chỉ");
        txt_diachi.setLineColor(new java.awt.Color(153, 153, 255));
        txt_diachi.setSelectionColor(new java.awt.Color(153, 153, 255));

        lbl_chucvu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_chucvu.setForeground(java.awt.Color.red);
        lbl_chucvu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_chucvu.setText("Chức vụ");

        imageAvatar1.setGradientColor1(new java.awt.Color(255, 51, 51));
        imageAvatar1.setGradientColor2(new java.awt.Color(51, 0, 255));
        imageAvatar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageAvatar1MouseClicked(evt);
            }
        });

        txt_ten.setLabelText("Tên");
        txt_ten.setLineColor(new java.awt.Color(153, 153, 255));
        txt_ten.setSelectionColor(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(txt_diachi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txt_ten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txt_ma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lbl_chucvu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_err_oldpass, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                    .addComponent(lbl_err_newpass, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                    .addComponent(txt_reNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                    .addComponent(lbl_err_renewpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_oldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                    .addComponent(txt_newPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                    .addComponent(jLabel10)
                                    .addComponent(btn_changePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
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
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_err_oldpass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_err_newpass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_reNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_err_renewpass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_changePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );

        main.add(jPanel3, "ttcanhan");

        deskpane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout deskpaneLayout = new javax.swing.GroupLayout(deskpane);
        deskpane.setLayout(deskpaneLayout);
        deskpaneLayout.setHorizontalGroup(
            deskpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
        );
        deskpaneLayout.setVerticalGroup(
            deskpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 753, Short.MAX_VALUE)
        );

        main.add(deskpane, "general");

        pn_webcam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout pn_banhangLayout = new javax.swing.GroupLayout(pn_banhang);
        pn_banhang.setLayout(pn_banhangLayout);
        pn_banhangLayout.setHorizontalGroup(
            pn_banhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_banhangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_webcam, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(641, Short.MAX_VALUE))
        );
        pn_banhangLayout.setVerticalGroup(
            pn_banhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_banhangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_webcam, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(567, Short.MAX_VALUE))
        );

        main.add(pn_banhang, "banhang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        effectNav(home, nv, sp, hd, bh, thongke);
        cardLayout.show(main, "general");
        deskpane.removeAll();
        deskpane.add(new FrmWelcome()).setVisible(true);
    }//GEN-LAST:event_homeMouseClicked

    private void nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nvMouseClicked
        if (nguoidung.getChucVu().getTen().equals("Nhân viên")) {
            helper.error(this, "Bạn không có quyền truy cập chức năng này!");
        } else {
            effectNav(nv, home, sp, hd, bh, thongke);
            cardLayout.show(main, "general");
            deskpane.add(new FrmQLNhanVien()).setVisible(true);
        }
    }//GEN-LAST:event_nvMouseClicked

    private void spMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spMouseClicked
        effectNav(sp, home, nv, hd, bh, thongke);
        cardLayout.show(main, "general");
        deskpane.removeAll();
    }//GEN-LAST:event_spMouseClicked

    private void hdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hdMouseClicked
        effectNav(hd, home, nv, sp, bh, thongke);
        cardLayout.show(main, "general");
    }//GEN-LAST:event_hdMouseClicked

    private void bhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhMouseClicked
        effectNav(bh, hd, home, nv, sp, thongke);
        cardLayout.show(main, "banhang");
    }//GEN-LAST:event_bhMouseClicked

    private void thongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thongkeMouseClicked
        if (nguoidung.getChucVu().getTen().equals("Nhân viên")) {
            helper.error(this, "Bạn không có quyền truy cập chức năng này!");
        } else {
            effectNav(thongke, bh, hd, home, nv, sp);
            cardLayout.show(main, "general");
        }
    }//GEN-LAST:event_thongkeMouseClicked

    private void imageAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAvatarMouseClicked
//        deskpane.removeAll();
//        deskpane.add(new FrmProfile(nguoidung)).setVisible(true);
        home.setBackground(Color.BLACK);
        nv.setBackground(Color.BLACK);
        sp.setBackground(Color.BLACK);
        bh.setBackground(Color.BLACK);
        hd.setBackground(Color.BLACK);
        cardLayout.show(main, "ttcanhan");
    }//GEN-LAST:event_imageAvatarMouseClicked

    private void dangxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dangxuatMouseClicked
        if (helper.confirm(this, "Bạn có chắc muốn đăng xuất ?")) {
            helper.alert(this, "Đăng xuất thành công!");
            this.dispose();
//            new SplashScreen().setVisible(true);
        }
    }//GEN-LAST:event_dangxuatMouseClicked

    private void btn_changePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changePassActionPerformed
        String oldPass = new String(txt_oldPassword.getPassword());
        String newPass = new String(txt_newPassword.getPassword());
        String reNewPass = new String(txt_reNewPassword.getPassword());
        if (oldPass.equals(nguoidung.getMatKhau()) && newPass.length() >= 8 && newPass.equals(reNewPass)) {
            if (helper.confirm(this, "Xác nhận đổi mật khẩu ?")) {
                nguoidung.setMatKhau(reNewPass);
                iNguoiDungService.save(nguoidung);
                helper.alert(this, "Mật khẩu đã được thay đổi!");
                txt_oldPassword.setText("");
                txt_newPassword.setText("");
                txt_reNewPassword.setText("");
            }
        } else {
            helper.error(this, "Không thành công!");
        }
    }//GEN-LAST:event_btn_changePassActionPerformed

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

    private void txt_reNewPasswordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_reNewPasswordCaretUpdate
        String newPass = new String(txt_newPassword.getPassword());
        String reNewPass = new String(txt_reNewPassword.getPassword());
        if (!reNewPass.equals(newPass)) {
            lbl_err_renewpass.setText("Xác nhận mật khẩu không khớp!");
        } else {
            lbl_err_renewpass.setText(" ");
        }
    }//GEN-LAST:event_txt_reNewPasswordCaretUpdate

    private void txt_newPasswordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_newPasswordCaretUpdate
        if (txt_newPassword.getPassword().length < 8) {
            lbl_err_newpass.setText("Tối thiểu 8 kí tự!");
        } else {
            lbl_err_newpass.setText(" ");
        }
    }//GEN-LAST:event_txt_newPasswordCaretUpdate

    private void txt_oldPasswordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_oldPasswordCaretUpdate
        String oldPass = new String(txt_oldPassword.getPassword());
        if (!oldPass.equals(nguoidung.getMatKhau())) {
            lbl_err_oldpass.setText("Mật khẩu không chính xác!");
        } else {
            lbl_err_oldpass.setText(" ");
        }
    }//GEN-LAST:event_txt_oldPasswordCaretUpdate

    private void imageAvatar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAvatar1MouseClicked
        JFileChooser fileChooser = new JFileChooser("images/users/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*jpg", "jpg");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = new File(fileChooser.getSelectedFile().getPath());
                file.renameTo(new File("images/users/" + file.getName()));
                fileName = file.getName();
                imageAvatar1.setImage(new ImageIcon("images/users/" + file.getName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_imageAvatar1MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bh;
    private swing.Button btn_changePass;
    private swing.Button btn_sua;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel dangxuat;
    private javax.swing.JDesktopPane deskpane;
    private javax.swing.JPanel hd;
    private javax.swing.JPanel home;
    private swing.ImageAvatar imageAvatar;
    private swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_chucvu;
    private javax.swing.JLabel lbl_err_newpass;
    private javax.swing.JLabel lbl_err_oldpass;
    private javax.swing.JLabel lbl_err_renewpass;
    private javax.swing.JLabel lbl_role;
    private javax.swing.JLabel lbl_tenUser;
    private javax.swing.JPanel main;
    private javax.swing.JPanel nv;
    private javax.swing.JPanel pn_banhang;
    private javax.swing.JPanel pn_webcam;
    private swing.RadioButtonCustom rd_nam;
    private swing.RadioButtonCustom rd_nu;
    private javax.swing.JPanel sp;
    private javax.swing.JPanel thongke;
    private swing.TextField txt_diachi;
    private swing.TextField txt_email;
    private swing.TextField txt_ma;
    private swing.PasswordField txt_newPassword;
    private swing.PasswordField txt_oldPassword;
    private swing.PasswordField txt_reNewPassword;
    private swing.TextField txt_sdt;
    private swing.TextField txt_ten;
    private javax.swing.JTextArea txt_thongbao;
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
        do {
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
//                    String maSP = result.getText().replace("VuNguyenHuong05102003", "");
//                    for (int i = 0; i < tb_sanpham.getRowCount(); i++) {
//                        if (tb_sanpham.getValueAt(i, 1).equals(maSP)) {
//                            tb_sanpham.setRowSelectionInterval(i, i);
//                            helper.alert(this, "Đã tìm thấy " + maSP);
//                            addSanPham();
//                        }
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "example-runner");
        t.setDaemon(true);
        return t;
    }
}
