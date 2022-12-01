package views;

import ui.EventMenuSelected;
import ui.EventShowPopupMenu;
import ui.Header;
import ui.MainForm;
import ui.Menu;
import ui.MenuItem;
import ui.NotificationMess;
import ui.PopupMenu;
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
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import models.ChiTietDep;
import models.HoaDon;
import models.HoaDonChiTiet;
import models.KhachHang;
import models.KhuyenMai;
import models.NguoiDung;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import services.IChiTietDepService;
import services.IHoaDonCTService;
import services.IHoaDonService;
import services.IKhachHangService;
import services.IKhuyenMaiService;
import services.impl.ChiTietDepService;
import services.impl.HoaDonCTService;
import services.impl.HoaDonService;
import services.impl.KhachHangService;
import services.impl.KhuyenMaiService;
import swing.Table;
import utilities.ExportWord;
import utilities.Helper;

/**
 *
 * @author KenTizz
 */
public class FrmHome extends javax.swing.JFrame implements Runnable, ThreadFactory {
    
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
    private NguoiDung nguoiDung = new NguoiDung();
    private KhachHang khachHang = null;
    private KhuyenMai khuyenMai = null;
    private DefaultTableModel defaultTableModel;
    private DefaultTableModel modelGioHang;
    private IChiTietDepService iChiTietDepService = new ChiTietDepService();
    private IHoaDonService iHoaDonService = new HoaDonService();
    private IHoaDonCTService iHoaDonCTService = new HoaDonCTService();
    private IKhachHangService iKhachHangService = new KhachHangService();
    private IKhuyenMaiService iKhuyenMaiService = new KhuyenMaiService();
    private CardLayout cardLayout;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private ExportWord exportWord = new ExportWord();
    
    public FrmHome(NguoiDung nd) {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("images/suportUI/logo.png");
        this.setIconImage(icon);
        this.nguoiDung = nd;
        setExtendedState(MAXIMIZED_BOTH);
        header = new Header(nguoiDung);
        init();
        cardLayout = (CardLayout) pn_main.getLayout();
        cardLayout.show(pn_main, "general");
        Table.apply(jScrollPane1, Table.TableType.MULTI_LINE);
        Table.apply(jScrollPane2, Table.TableType.MULTI_LINE);
        Table.apply(jScrollPane3, Table.TableType.MULTI_LINE);
        loadSP(iChiTietDepService.findByTT(0, txt_sp_timkiem.getText(), "DESC"));
        loadHD(iHoaDonService.getByTT(0));
    }
    
    public FrmHome() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("images/suportUI/logo.png");
        this.setIconImage(icon);
        setExtendedState(MAXIMIZED_BOTH);
        header = new Header();
        init();
        cardLayout = (CardLayout) pn_main.getLayout();
        cardLayout.show(pn_main, "general");
        Table.apply(jScrollPane1, Table.TableType.MULTI_LINE);
        Table.apply(jScrollPane2, Table.TableType.MULTI_LINE);
        Table.apply(jScrollPane3, Table.TableType.MULTI_LINE);
        loadSP(iChiTietDepService.findByTT(0, txt_sp_timkiem.getText(), "DESC"));
        loadHD(iHoaDonService.getByTT(0));
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
                        main.showForm(new FrmDoiMatKhau(nguoiDung));
// Đổi MK               
                    }
                }
                if (menuIndex == 1) {
                    if (nguoiDung.getChucVu().getTen().equals("Nhân viên")) {
                        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.CENTER, "Bạn không có quyền sử dụng chức năng này! ");
                        panel.showNotification();
                    } else {
                        main.showForm(new FrmNhanVien());
                    }
                    if (subMenuIndex == 0) {
// QLNV
                    } else if (subMenuIndex == 1) {
// abc
                    }
                }
                if (menuIndex == 2) {
                    main.showForm(new FrmQLKH());
                }
                if (menuIndex == 3) {
                    if (subMenuIndex == 0) {
// CTSPFrmCTD
                        main.showForm(new FrmChiTietDep());
                    } else if (subMenuIndex == 1) {
// Dép
                        main.showForm(new FrmDep());
                    } else if (subMenuIndex == 2) {
// Loại dép

                        main.showForm(new FrmLoaiDep());
                    } else if (subMenuIndex == 3) {
// Size
                        main.showForm(new FrmSize());
                    } else if (subMenuIndex == 4) {
// Chất liệu
                        main.showForm(new FrmChatLieu());
                    } else if (subMenuIndex == 5) {
// Màu sắc
                        main.showForm(new FrmMauSac());
                    } else if (subMenuIndex == 6) {
// NSX
                        main.showForm(new FrmNhaSanXuat());
                        
                    }
                }
                if (menuIndex == 4) {
//                    if (subMenuIndex == 0) {
//                        
//                    } else if (subMenuIndex == 1) {
//                        
//                    }
                    main.showForm(new FrmQLHD());
                }
                if (menuIndex == 5) {
                    cardLayout.show(pn_main, "banhang");
                    if (tb_giohang.getRowCount() > 0 && tb_sanpham.getRowCount() > 0) {
                        HoaDon hd = iHoaDonService.getObj(txt_mahd.getText());
                        List<HoaDonChiTiet> listHDCT = iHoaDonCTService.findByMa(hd.getMa());
                        ChiTietDep ctd;
                        if (hd.getTrangThai() == 0) {
                            for (int i = 0; i < tb_giohang.getRowCount(); i++) {
                                ctd = iChiTietDepService.getObj(listHDCT.get(i).getCtdep().getId());
                                if (listHDCT.get(i).getDonGia() != ctd.getGiaBan()) {
                                    listHDCT.get(i).setDonGia(ctd.getGiaBan());
                                    iHoaDonCTService.save(listHDCT.get(i));
                                }
                            }
                        }
                    }
                    loadSP(iChiTietDepService.findByTT(0, txt_sp_timkiem.getText(), "DESC"));
                    loadHD(iHoaDonService.getByTT(0));
                    loadGioHang(txt_mahd.getText());
                    initWebcam(pn_webcam);
                }
                if (menuIndex == 6) {
                    if (nguoiDung.getChucVu().getTen().equals("Nhân viên")) {
                        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.CENTER, "Bạn không có quyền sử dụng chức năng này! ");
                        panel.showNotification();
                    } else {
                        if (subMenuIndex == 0) {
                            main.showForm(new FrmThongKe());
                        } else if (subMenuIndex == 1) {
                            main.showForm(new FrmThongKeDoanhThu());
                        }
                    }
                }
                if (menuIndex == 7) {
                    if (subMenuIndex == 0) {
                        if (helper.confirm(rootPane, "Bạn có chắc muốn đăng xuất ?")) {
                            dispose();
                            try {
                                webcam.close();
                            } catch (Exception e) {
                            }
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
                PopupMenu popup = new PopupMenu(FrmHome.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = FrmHome.this.getX() + 52;
                int y = FrmHome.this.getY() + com.getY() + 86;
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
    
    private void loadSP(List<ChiTietDep> list) {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_sanpham.getModel();
        defaultTableModel.setRowCount(0);
        for (ChiTietDep x : list) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getDep().getMa(), x.getDep().getTen(), x.getLoaiDep().getTen(), x.getSize().getKichCo(), x.getNhaSX().getTen(), x.getSoLuong(), x.getGiaBan().doubleValue()
            });
        }
    }
    
    private void loadHD(List<HoaDon> list) {
        defaultTableModel = (DefaultTableModel) tb_hoadon.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDon x : list) {
            defaultTableModel.addRow(new Object[]{
                x.getMa(), x.getNguoiDung().getTen(),
                x.getKhachHang() == null ? "Khách hàng lẻ" : x.getKhachHang().getTen(),
                helper.formatDate(x.getNgayTao()),
                x.getTrangThai() == 0 ? "Chưa thanh toán" : "Đã thanh toán",
                x.getNguoiDungTT() == null ? "" : x.getNguoiDungTT().getTen()
            });
        }
    }
    
    private void loadGioHang(String maHD) {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_giohang.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDonChiTiet x : iHoaDonCTService.findByMa(maHD)) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getCtdep().getDep().getMa(), x.getCtdep().getDep().getTen(), x.getSoLuong(), x.getDonGia(), x.getSoLuong() * x.getDonGia().doubleValue()
            });
        }
    }
    
    private void tongTien() {
        int row = tb_giohang.getRowCount();
        if (row > 0) {
            double tongTien = 0;
            double giamGia;
            for (int i = 0; i < tb_giohang.getRowCount(); i++) {
                tongTien = tongTien + Double.parseDouble(tb_giohang.getValueAt(i, 5).toString());
            }
            if (txt_giamgia.getText().isEmpty()) {
                txt_giamgia.setText("0");
            }
            giamGia = tongTien - Double.parseDouble(txt_giamgia.getText());
            
            txt_tongtien.setText(String.valueOf(tongTien));
            txt_phaitra.setText(String.valueOf(giamGia));
        } else {
            txt_tongtien.setText("0");
            txt_phaitra.setText("0");
        }
//        if()
//            for (int i = 0; i < tb_giohang.getRowCount(); i++) {
//                tongTien = tongTien + Double.parseDouble(tb_giohang.getValueAt(i, 5).toString());
//            }
//            giamGia = tongTien - Double.parseDouble(txt_giamgia.getText());
//            txt_tongtien.setText(String.valueOf(tongTien));
//            txt_phaitra.setText(String.valueOf(giamGia));
//        } catch (Exception e) {
//        }
    }
    
    private void addSpToGH() {
        int row = tb_sanpham.getSelectedRow();
        int rowHD = tb_hoadon.getSelectedRow();
        String inPutSL = null;
        Integer soLuongNhap;
        if (rowHD == -1) {
            tb_sanpham.clearSelection();
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Bạn chưa chọn hóa đơn!");
            panel.showNotification();
        } else {
            HoaDon hd = iHoaDonService.getObj((String) tb_hoadon.getValueAt(rowHD, 0));
            ChiTietDep ctd = iChiTietDepService.findByTT(0, txt_sp_timkiem.getText(), "DESC").get(row);
            if (hd.getTrangThai() == 1) {
                tb_sanpham.clearSelection();
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Hóa đơn đã được thanh toán!");
                panel.showNotification();
                return;
            }
            if (ctd.getSoLuong() == 0) {
                tb_sanpham.clearSelection();
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Sản phẩm này đã hết hàng");
                panel.showNotification();
                return;
            }
            inPutSL = helper.input(this, "Vui lòng nhập số lượng: ", "Số lượng");
            try {
                soLuongNhap = Integer.parseInt(inPutSL);
                if (soLuongNhap <= 0) {
                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Vui lòng nhập lại!");
                    panel.showNotification();
                    return;
                } else if (soLuongNhap > ctd.getSoLuong()) {
                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Quá số lượng cho phép !");
                    panel.showNotification();
                    return;
                }
            } catch (Exception e) {
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Vui lòng nhập lại !");
                panel.showNotification();
                return;
            }
            if (iHoaDonCTService.getobj(ctd.getId(), hd.getId()) == null) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setCtdep(ctd);
                hdct.setHoaDon(hd);
                hdct.setSoLuong(soLuongNhap);
                hdct.setDonGia(ctd.getGiaBan());
                hdct.setTrangThai(0);
                ctd.setSoLuong(ctd.getSoLuong() - soLuongNhap);
                iChiTietDepService.save(ctd);
                iHoaDonCTService.save(hdct);
            } else {
                HoaDonChiTiet hdct = iHoaDonCTService.getobj(ctd.getId(), hd.getId());
                hdct.setSoLuong(hdct.getSoLuong() + soLuongNhap);
                ctd.setSoLuong(ctd.getSoLuong() - soLuongNhap);
                iChiTietDepService.save(ctd);
                iHoaDonCTService.save(hdct);
            }
            loadSP(iChiTietDepService.findByTT(0, txt_sp_timkiem.getText(), "DESC"));
            loadGioHang(hd.getMa());
        }
        tongTien();
    }
    
    private void clearForm() {
        tb_giohang.clearSelection();
        tb_hoadon.clearSelection();
        tb_sanpham.clearSelection();
        khachHang = null;
        khuyenMai = null;
        txt_makh.setText("");
        txt_tenkh.setText("");
        txt_mahd.setText("");
        txt_tongtien.setText("0");
        txt_giamgia.setText("0");
        lbl_diemtichluy.setText("Khách hàng lẻ đang có 0 điểm tích lũy");
        chk_tichluy.setSelected(false);
        txt_phaitra.setText("0");
        txt_makm.setText("");
        txt_tenkm.setText("");
        txt_tienkhachdua.setText("");
        txt_tienthua.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_main = new javax.swing.JPanel();
        bg = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        pn_webcam = new javax.swing.JPanel();
        btn_return = new swing.Button();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_makh = new swing.TextField();
        txt_tenkh = new swing.TextField();
        btn_themKH = new swing.Button();
        btn_khLe = new swing.Button();
        jSeparator1 = new javax.swing.JSeparator();
        txt_mahd = new swing.TextField();
        txt_tongtien = new swing.TextField();
        txt_giamgia = new swing.TextField();
        btn_taohd = new swing.Button();
        txt_phaitra = new swing.TextField();
        chk_tichluy = new swing.JCheckBoxCustom();
        lbl_diemtichluy = new javax.swing.JLabel();
        txt_tienkhachdua = new swing.TextField();
        txt_tienthua = new swing.TextField();
        btn_themkm = new swing.Button();
        txt_makm = new swing.TextField();
        txt_tenkm = new swing.TextField();
        btn_thanhtoan = new swing.ButtonLG();
        lbl_removekm = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tableScrollButton2 = new swing.TableScrollButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_giohang = new javax.swing.JTable();
        btn_gh_xoa = new swing.Button();
        bnt_gh_xoatatca = new swing.Button();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tableScrollButton3 = new swing.TableScrollButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_sanpham = new javax.swing.JTable();
        txt_sp_timkiem = new swing.TextField();
        jLabel2 = new javax.swing.JLabel();
        cb_loc_soLuong = new swing.Combobox();
        jPanel5 = new javax.swing.JPanel();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_hoadon = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MWC_Store");
        setUndecorated(true);

        pn_main.setLayout(new java.awt.CardLayout());

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1336, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );

        pn_main.add(bg, "general");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pn_webcam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_return.setBackground(new java.awt.Color(102, 102, 102));
        btn_return.setForeground(new java.awt.Color(255, 255, 255));
        btn_return.setText("Trở về màn hình chính");
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel3.setText("Thông tin");

        txt_makh.setEditable(false);
        txt_makh.setText("null");
        txt_makh.setLabelText("Mã khách hàng");
        txt_makh.setLineColor(new java.awt.Color(102, 102, 102));

        txt_tenkh.setEditable(false);
        txt_tenkh.setText("Khách hàng lẻ");
        txt_tenkh.setLabelText("Tên khách hàng");
        txt_tenkh.setLineColor(new java.awt.Color(102, 102, 102));

        btn_themKH.setBackground(new java.awt.Color(102, 102, 102));
        btn_themKH.setForeground(new java.awt.Color(255, 255, 255));
        btn_themKH.setText("Thêm/Cập nhật KH");
        btn_themKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themKHActionPerformed(evt);
            }
        });

        btn_khLe.setBackground(new java.awt.Color(102, 102, 102));
        btn_khLe.setForeground(new java.awt.Color(255, 255, 255));
        btn_khLe.setText("Khách hàng lẻ");
        btn_khLe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_khLeActionPerformed(evt);
            }
        });

        txt_mahd.setEditable(false);
        txt_mahd.setLabelText("Mã hóa đơn");
        txt_mahd.setLineColor(new java.awt.Color(102, 102, 102));

        txt_tongtien.setEditable(false);
        txt_tongtien.setText("0");
        txt_tongtien.setLabelText("Tổng tiền");
        txt_tongtien.setLineColor(new java.awt.Color(102, 102, 102));

        txt_giamgia.setEditable(false);
        txt_giamgia.setText("0");
        txt_giamgia.setToolTipText("");
        txt_giamgia.setLabelText("Giảm giá");
        txt_giamgia.setLineColor(new java.awt.Color(102, 102, 102));

        btn_taohd.setBackground(new java.awt.Color(102, 102, 102));
        btn_taohd.setForeground(new java.awt.Color(255, 255, 255));
        btn_taohd.setText("Tạo hóa đơn");
        btn_taohd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taohdActionPerformed(evt);
            }
        });

        txt_phaitra.setEditable(false);
        txt_phaitra.setText("0");
        txt_phaitra.setLabelText("Phải trả");
        txt_phaitra.setLineColor(new java.awt.Color(102, 102, 102));

        chk_tichluy.setText("Sử dụng ?");
        chk_tichluy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_tichluyActionPerformed(evt);
            }
        });

        lbl_diemtichluy.setForeground(java.awt.Color.blue);
        lbl_diemtichluy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_diemtichluy.setText("Khách hàng lẻ đang có 0 điểm tích lũy");

        txt_tienkhachdua.setLabelText("Tiền khách đưa");
        txt_tienkhachdua.setLineColor(new java.awt.Color(102, 102, 102));
        txt_tienkhachdua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_tienkhachduaCaretUpdate(evt);
            }
        });

        txt_tienthua.setEditable(false);
        txt_tienthua.setLabelText("Tiền thừa");
        txt_tienthua.setLineColor(new java.awt.Color(102, 102, 102));

        btn_themkm.setBackground(new java.awt.Color(102, 102, 102));
        btn_themkm.setForeground(new java.awt.Color(255, 255, 255));
        btn_themkm.setText("Thêm khuyến mãi");
        btn_themkm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themkmActionPerformed(evt);
            }
        });

        txt_makm.setEditable(false);
        txt_makm.setLabelText("Mã khuyến mãi");
        txt_makm.setLineColor(new java.awt.Color(102, 102, 102));

        txt_tenkm.setEditable(false);
        txt_tenkm.setLabelText("Tên khuyến mãi");
        txt_tenkm.setLineColor(new java.awt.Color(102, 102, 102));

        btn_thanhtoan.setForeground(new java.awt.Color(255, 255, 255));
        btn_thanhtoan.setText("Thanh toán");
        btn_thanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhtoanActionPerformed(evt);
            }
        });

        lbl_removekm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_removekm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        lbl_removekm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_removekmMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_thanhtoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 151, Short.MAX_VALUE)
                        .addComponent(btn_khLe, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_taohd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_phaitra, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_giamgia, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_diemtichluy, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(chk_tichluy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_makm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tienkhachdua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tienthua, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tenkm, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_themkm, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_removekm, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_makh, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_themKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_giamgia, txt_mahd, txt_phaitra, txt_tienkhachdua, txt_tongtien});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_makh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_khLe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taohd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_diemtichluy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chk_tichluy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_giamgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_phaitra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_makm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tenkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tienkhachdua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_removekm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_themkm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tienthua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(btn_thanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tb_giohang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_giohang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_giohangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_giohang);

        tableScrollButton2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        btn_gh_xoa.setBackground(new java.awt.Color(102, 102, 102));
        btn_gh_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_gh_xoa.setText("Xóa");
        btn_gh_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gh_xoaActionPerformed(evt);
            }
        });

        bnt_gh_xoatatca.setBackground(new java.awt.Color(102, 102, 102));
        bnt_gh_xoatatca.setForeground(new java.awt.Color(255, 255, 255));
        bnt_gh_xoatatca.setText("Xóa tất cả");
        bnt_gh_xoatatca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_gh_xoatatcaActionPerformed(evt);
            }
        });

        jLabel1.setText("Giỏ hàng");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_gh_xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bnt_gh_xoatatca, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_gh_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bnt_gh_xoatatca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 91, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tableScrollButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tb_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên", "Loại", "Size", "NSX", "Số lượng tồn", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_sanphamMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tb_sanpham);

        tableScrollButton3.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        txt_sp_timkiem.setLabelText("Tìm kiếm sản phẩm");
        txt_sp_timkiem.setLineColor(new java.awt.Color(102, 102, 102));
        txt_sp_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_sp_timkiemCaretUpdate(evt);
            }
        });

        jLabel2.setText("Sản phẩm");

        cb_loc_soLuong.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Giảm dần", "Tăng dần" }));
        cb_loc_soLuong.setLabeText("Số lượng");
        cb_loc_soLuong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_loc_soLuongItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_sp_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cb_loc_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_sp_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_loc_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tb_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Nhân viên", "Khách hàng", "Ngày tạo", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_hoadonMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_hoadon);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_webcam, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_return, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_webcam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
            .addComponent(pn_main, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        cardLayout.show(pn_main, "general");
        try {
            webcam.close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_returnActionPerformed

    private void txt_sp_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_sp_timkiemCaretUpdate
        if (cb_loc_soLuong.getSelectedIndex() == 1) {
            loadSP(iChiTietDepService.findByTT(0, txt_sp_timkiem.getText(), "ASC"));
        } else {
            loadSP(iChiTietDepService.findByTT(0, txt_sp_timkiem.getText(), "DESC"));
        }
    }//GEN-LAST:event_txt_sp_timkiemCaretUpdate

    private void btn_themKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themKHActionPerformed
        FrmKhachHang fkh = new FrmKhachHang(this, true);
        fkh.setVisible(true);
        khachHang = fkh.getKH();
        if (khachHang == null) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Bạn chưa chọn khách hàng!");
            panel.showNotification();
        } else {
            txt_makh.setText(khachHang.getMa());
            txt_tenkh.setText(khachHang.getTen());
            lbl_diemtichluy.setText(khachHang.getMa() + " đang có " + khachHang.getDiemTichLuy() + " điểm tích lũy");
        }
    }//GEN-LAST:event_btn_themKHActionPerformed

    private void btn_khLeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khLeActionPerformed
        khachHang = null;
        txt_makh.setText("Khách hàng mua lẻ");
        txt_tenkh.setText("Khách hàng mua lẻ");
        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.INFO, NotificationMess.Location.TOP_CENTER, "Bạn chọn khách hàng mua lẻ");
        panel.showNotification();
    }//GEN-LAST:event_btn_khLeActionPerformed

    private void btn_taohdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taohdActionPerformed
        HoaDon hd = new HoaDon();
        if (helper.confirm(this, "Xác nhận tạo hóa đơn ?")) {
            String result;
            for (int i = 0; i < iHoaDonService.getAll().size() + 1; i++) {
                result = "HD" + i;
                if (iHoaDonService.getObj(result) == null) {
                    hd.setMa(result);
                    break;
                } else {
                    continue;
                }
            }
            hd.setNgayTao(new Date());
            hd.setTrangThai(0);
            hd.setNguoiDung(nguoiDung);
            hd.setKhachHang(khachHang);
            iHoaDonService.save(hd);
            loadHD(iHoaDonService.getByTT(0));
            txt_giamgia.setText("0");
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Tạo hóa đơn thành công !");
            panel.showNotification();
        }
    }//GEN-LAST:event_btn_taohdActionPerformed

    private void btn_gh_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gh_xoaActionPerformed
        int row = tb_giohang.getSelectedRow();
        if (row == -1) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Vui lòng chọn sản phẩm cần xóa khỏi giỏ hàng!");
            panel.showNotification();
        } else {
            HoaDonChiTiet hdct = iHoaDonCTService.findByMa(txt_mahd.getText()).get(row);
            ChiTietDep ctd = iChiTietDepService.getObj(hdct.getCtdep().getId());
            if (helper.confirm(this, "Xác nhận xóa " + hdct.getCtdep().getDep().getTen() + " khỏi giỏ hàng ?")) {
                ctd.setSoLuong(ctd.getSoLuong() + hdct.getSoLuong());
                iHoaDonCTService.delete(hdct);
                iChiTietDepService.save(ctd);
                loadGioHang(txt_mahd.getText());
                loadSP(iChiTietDepService.findByTT(0, txt_sp_timkiem.getText(), "DESC"));
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Xóa thành công !");
                panel.showNotification();
            }
        }
    }//GEN-LAST:event_btn_gh_xoaActionPerformed

    private void chk_tichluyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_tichluyActionPerformed
        HoaDon hd = iHoaDonService.getObj(txt_mahd.getText());
        if (hd == null) {
            chk_tichluy.setSelected(false);
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Vui lòng chọn hóa đơn để sử dụng chức năng này!");
            panel.showNotification();
        } else if (hd.getTrangThai() == 1) {
            chk_tichluy.setSelected(false);
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Hóa đơn đã được thanh toán!");
            panel.showNotification();
        } else {
            Double giamGia = Double.parseDouble(txt_giamgia.getText());
            Double phaiTra = 0.0;
            if (chk_tichluy.isSelected()) {
                if (giamGia == null) {
                    giamGia = 0.0;
                }
                if (khachHang != null) {
                    giamGia = giamGia + khachHang.getDiemTichLuy() * 1000;
                    txt_giamgia.setText(giamGia.toString());
                    phaiTra = Double.parseDouble(txt_tongtien.getText()) - giamGia;
                    txt_phaitra.setText(phaiTra.toString());
                }
            } else {
                if (giamGia == null) {
                    giamGia = 0.0;
                }
                if (khachHang != null) {
                    giamGia = giamGia - khachHang.getDiemTichLuy() * 1000;
                    phaiTra = Double.parseDouble(txt_tongtien.getText()) - giamGia;
                    txt_giamgia.setText(giamGia.toString());
                    txt_phaitra.setText(phaiTra.toString());
                }
            }
            tongTien();
        }
    }//GEN-LAST:event_chk_tichluyActionPerformed

    private void btn_thanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhtoanActionPerformed
        int row = tb_hoadon.getSelectedRow();
        if (row == -1) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Vui lòng chọn hóa đơn cần thanh toán!");
            panel.showNotification();
        } else {
            HoaDon hd = iHoaDonService.getObj(txt_mahd.getText());
            List<HoaDonChiTiet> listHDCT = iHoaDonCTService.findByMa(hd.getMa());
            if (hd.getTrangThai() == 1) {
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Hóa đơn đã được thanh toán!");
                panel.showNotification();
                return;
            }
            if (tb_giohang.getRowCount() == 0) {
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Hãy thêm gì đó vào giỏ hàng!");
                panel.showNotification();
                return;
            }
            Double tienKhachDua = null;
            Double phaiTra = null;
            try {
                if (txt_tienkhachdua.getText().isEmpty()) {
                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, " Bạn chưa nhập tiền khách đưa!");
                    panel.showNotification();
                    return;
                } else {
                    tienKhachDua = Double.parseDouble(txt_tienkhachdua.getText());
                }
                if (txt_phaitra.getText().isEmpty()) {
                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Vui lòng chọn sản phẩm rồi thanh toán!");
                    panel.showNotification();
                    return;
                } else {
                    phaiTra = Double.parseDouble(txt_phaitra.getText());
                }
            } catch (Exception e) {
            }
            
            if (tienKhachDua >= phaiTra) {
                if (helper.confirm(this, "Trả lại khách " + (tienKhachDua - phaiTra) + ". Xác nhận thanh toán " + txt_phaitra.getText() + "?")) {
                    hd.setNguoiDungTT(nguoiDung);
                    hd.setTrangThai(1);
                    hd.setNgayThanhToan(new Date());
                    if (khachHang != null) {
                        hd.setKhachHang(khachHang);
                        if (chk_tichluy.isSelected()) {
                            hd.setDiemTichLuy(khachHang.getDiemTichLuy());
                            khachHang.setDiemTichLuy(1);
                            khachHang.setTongDiemTichLuy(khachHang.getTongDiemTichLuy() + 1);
                        } else {
                            hd.setDiemTichLuy(0);
                            khachHang.setDiemTichLuy(khachHang.getDiemTichLuy() + 1);
                            khachHang.setTongDiemTichLuy(khachHang.getTongDiemTichLuy() + 1);
                        }
                    }
                    if (khuyenMai != null) {
                        hd.setKhuyenMai(khuyenMai);
                        khuyenMai.setSoLuong(khuyenMai.getSoLuong() - 1);
                    }
                    hd.setTongTien(BigDecimal.valueOf(phaiTra));
                    for (HoaDonChiTiet x : listHDCT) {
                        ChiTietDep ctd = x.getCtdep();
                        ctd.setSoLuongBanRa(ctd.getSoLuongBanRa() + x.getSoLuong());
                        iChiTietDepService.save(ctd);
                    }
                    iHoaDonService.save(hd);
                    loadHD(iHoaDonService.getByTT(0));
                    iKhachHangService.save(khachHang);
                    iKhuyenMaiService.save(khuyenMai);
                    modelGioHang = (DefaultTableModel) tb_giohang.getModel();
                    modelGioHang.setRowCount(0);
                    exportWord.ExportToWord(hd, Double.parseDouble(txt_giamgia.getText()), Double.parseDouble(txt_tienkhachdua.getText()), Double.parseDouble(txt_tienthua.getText()));
                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Thanh toán thành công ! ");
                    panel.showNotification();
                    clearForm();
                }
            } else {
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Khách chưa đưa đủ tiền!");
                panel.showNotification();
            }
        }
    }//GEN-LAST:event_btn_thanhtoanActionPerformed

    private void txt_tienkhachduaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_tienkhachduaCaretUpdate
        Double tongTien = null;
        Double tienKhachDua = null;
        try {
            tongTien = Double.parseDouble(txt_phaitra.getText());
            tienKhachDua = Double.parseDouble(txt_tienkhachdua.getText());
            Double tienThua = tienKhachDua - tongTien;
            txt_tienthua.setText(tienThua.toString());
        } catch (Exception e) {
            txt_tienthua.setText("-" + tongTien);
        }
    }//GEN-LAST:event_txt_tienkhachduaCaretUpdate

    private void tb_giohangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_giohangMouseClicked
        Integer soLuong;
        int rowGH = tb_giohang.getSelectedRow();
        int rowHD = tb_hoadon.getSelectedRow();
        HoaDon hd = iHoaDonService.getObj((String) tb_hoadon.getValueAt(rowHD, 0));
        System.out.println(hd.getTrangThai());
        if (hd.getTrangThai() == 1) {
            tb_giohang.clearSelection();
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Hóa đơn đã được thanh toán ");
            panel.showNotification();
        } else {
            HoaDonChiTiet hdct = iHoaDonCTService.findByMa(txt_mahd.getText()).get(rowGH);
            ChiTietDep ctd = iChiTietDepService.getObj(hdct.getCtdep().getId());
            String inputSL = helper.input(this, "Cập nhật lại số lượng", "Nhập số lượng");
            try {
                soLuong = Integer.parseInt(inputSL);
                if (ctd.getSoLuong() == 0) {
                    if (soLuong > hdct.getSoLuong()) {
                        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Quá số lượng cho phép! ");
                        panel.showNotification();
                        return;
                    }
                } else if (soLuong > ctd.getSoLuong()) {
                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Quá số lượng cho phép ! ");
                    panel.showNotification();
                    return;
                }
            } catch (Exception e) {
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Vui lòng nhập lại!");
                panel.showNotification();
                return;
            }
            
            if (soLuong == 0) {
                if (helper.confirm(this, "Xác nhận xóa " + hdct.getCtdep().getDep().getTen() + " khỏi giỏ hàng ?")) {
                    ctd.setSoLuong(ctd.getSoLuong() + hdct.getSoLuong());
                    iHoaDonCTService.delete(hdct);
                    iChiTietDepService.save(ctd);
                    loadGioHang(txt_mahd.getText());
                    loadSP(iChiTietDepService.findByTT(0, txt_sp_timkiem.getText(), "DESC"));
                    tongTien();
                    txt_tienkhachdua.setText("");
                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Xóa thành công ! ");
                    panel.showNotification();
                }
            } else if (soLuong < 0) {
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Vui lòng nhập lại !");
                panel.showNotification();
            } else {
                ctd.setSoLuong(ctd.getSoLuong() + hdct.getSoLuong() - soLuong);
                iChiTietDepService.save(ctd);
                hdct.setSoLuong(soLuong);
                iHoaDonCTService.save(hdct);
                loadGioHang(hd.getMa());
                loadSP(iChiTietDepService.findByTT(0, txt_sp_timkiem.getText(), "DESC"));
                tongTien();
                txt_tienkhachdua.setText("");
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Cập nhật thành công! ");
                panel.showNotification();
            }
        }
    }//GEN-LAST:event_tb_giohangMouseClicked

    private void btn_themkmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themkmActionPerformed
        HoaDon hd = iHoaDonService.getObj(txt_mahd.getText());
        FrmKhuyenMai fkm = new FrmKhuyenMai(this, true);
        fkm.setVisible(true);
        khuyenMai = fkm.getKM();
        if (khuyenMai == null) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Không lấy được khuyến mãi !");
            panel.showNotification();
        } else {
            if (tb_giohang.getRowCount() == 0) {
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Hãy thêm gì đó vào giỏ hàng!");
                panel.showNotification();
            } else {
                if (hd.getTrangThai() == 0) {
                    if (khuyenMai.getSoLuong() > 0) {
                        txt_giamgia.setText("0");
                        chk_tichluy.setSelected(false);
                        txt_makm.setText(khuyenMai.getMa());
                        txt_tenkm.setText(khuyenMai.getTen());
                        Double giamGia = Double.parseDouble(txt_giamgia.getText());
                        if (giamGia == null) {
                            giamGia = 0.0;
                        }
                        giamGia = giamGia + Double.parseDouble(txt_tongtien.getText()) / 100 * khuyenMai.getPhantramgiam();
                        Double phaiTra = Double.parseDouble(txt_tongtien.getText()) - giamGia;
                        txt_giamgia.setText(giamGia.toString());
                        txt_phaitra.setText(phaiTra.toString());
                    } else {
                        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Đã hết khuyến mại!");
                        panel.showNotification();
                        return;
                    }
                } else {
                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Hóa đơn đã được thanh toán!");
                    panel.showNotification();
                }
            }
        }
    }//GEN-LAST:event_btn_themkmActionPerformed

    private void tb_sanphamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanphamMousePressed
        addSpToGH();
    }//GEN-LAST:event_tb_sanphamMousePressed

    private void bnt_gh_xoatatcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_gh_xoatatcaActionPerformed
        int rowHD = tb_hoadon.getSelectedRow();
        if (rowHD == -1) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Vui lòng chọn hóa đơn!");
            panel.showNotification();
        } else {
            HoaDon hd = iHoaDonService.getObj(txt_mahd.getText());
            List<HoaDonChiTiet> listHDCT = iHoaDonCTService.findByMa(hd.getMa());
            if (hd.getTrangThai() == 0) {
                if (helper.confirm(this, "Xác nhận xóa toàn bộ giỏ hàng ?")) {
                    if (listHDCT.size() == 0) {
                        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Giỏ hàng trống!");
                        panel.showNotification();
                    } else {
                        for (HoaDonChiTiet x : listHDCT) {
                            ChiTietDep ctd = iChiTietDepService.getObj(x.getCtdep().getId());
                            ctd.setSoLuong(ctd.getSoLuong() + x.getSoLuong());
                            iChiTietDepService.save(ctd);
                            iHoaDonCTService.delete(x);
                        }
                        loadSP(iChiTietDepService.findByTT(0, txt_sp_timkiem.getText(), "DESC"));
                        loadGioHang(hd.getMa());
                        txt_tongtien.setText("0");
                        txt_giamgia.setText("0");
                        txt_phaitra.setText("0");
                        chk_tichluy.setSelected(false);
                        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Xóa thành công!");
                        panel.showNotification();
                    }
                }
            } else {
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Hóa đơn đã được thanh toán!");
                panel.showNotification();
            }
        }
    }//GEN-LAST:event_bnt_gh_xoatatcaActionPerformed

    private void lbl_removekmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_removekmMouseClicked
        if (khuyenMai != null) {
            khuyenMai = null;
            chk_tichluy.setSelected(false);
            txt_giamgia.setText("0");
            txt_phaitra.setText(txt_tongtien.getText());
            txt_makm.setText("");
            txt_tenkm.setText("");
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Đã xóa khuyến mại!");
            panel.showNotification();
        } else {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Bạn chưa chọn khuyến mại!");
            panel.showNotification();
        }
    }//GEN-LAST:event_lbl_removekmMouseClicked

    private void tb_hoadonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_hoadonMousePressed
        int row = tb_hoadon.getSelectedRow();
        HoaDon hd = iHoaDonService.getObj((String) tb_hoadon.getValueAt(row, 0));
        khachHang = hd.getKhachHang();
        txt_mahd.setText(hd.getMa());
        if (khachHang == null) {
            lbl_diemtichluy.setText("Khách hàng lẻ đang có 0 điểm tích lũy");
            txt_makh.setText("Khách hàng mua lẻ");
            txt_tenkh.setText("Khách hàng mua lẻ");
        } else {
            lbl_diemtichluy.setText(khachHang.getMa() + " đang có " + khachHang.getDiemTichLuy() + " điểm tích lũy");
            txt_makh.setText(khachHang.getMa());
            txt_tenkh.setText(khachHang.getTen());
        }
        if (hd.getTrangThai() == 1) {
            try {
                Double tongTien = Double.parseDouble(txt_tongtien.getText());
                Double giamGia = tongTien / 100 * hd.getKhuyenMai().getPhantramgiam();
                System.out.println(hd.getKhuyenMai().getPhantramgiam());
                txt_giamgia.setText(String.valueOf(giamGia + hd.getDiemTichLuy() * 1000));
                txt_phaitra.setText(String.valueOf(tongTien - giamGia));
            } catch (Exception e) {
            }
        }
        loadGioHang(hd.getMa());
        tongTien();
    }//GEN-LAST:event_tb_hoadonMousePressed

    private void cb_loc_soLuongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_loc_soLuongItemStateChanged
        if (cb_loc_soLuong.getSelectedIndex() == 1) {
            loadSP(iChiTietDepService.findByTT(0, txt_sp_timkiem.getText(), "ASC"));
        } else {
            loadSP(iChiTietDepService.findByTT(0, txt_sp_timkiem.getText(), "DESC"));
        }
    }//GEN-LAST:event_cb_loc_soLuongItemStateChanged
    
    public static void main(String args[]) {
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
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private swing.Button bnt_gh_xoatatca;
    private swing.Button btn_gh_xoa;
    private swing.Button btn_khLe;
    private swing.Button btn_return;
    private swing.Button btn_taohd;
    private swing.ButtonLG btn_thanhtoan;
    private swing.Button btn_themKH;
    private swing.Button btn_themkm;
    private swing.Combobox cb_loc_soLuong;
    private swing.JCheckBoxCustom chk_tichluy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_diemtichluy;
    private javax.swing.JLabel lbl_removekm;
    private javax.swing.JPanel pn_main;
    private javax.swing.JPanel pn_webcam;
    private swing.TableScrollButton tableScrollButton1;
    private swing.TableScrollButton tableScrollButton2;
    private swing.TableScrollButton tableScrollButton3;
    private javax.swing.JTable tb_giohang;
    private javax.swing.JTable tb_hoadon;
    private javax.swing.JTable tb_sanpham;
    private swing.TextField txt_giamgia;
    private swing.TextField txt_mahd;
    private swing.TextField txt_makh;
    private swing.TextField txt_makm;
    private swing.TextField txt_phaitra;
    private swing.TextField txt_sp_timkiem;
    private swing.TextField txt_tenkh;
    private swing.TextField txt_tenkm;
    private swing.TextField txt_tienkhachdua;
    private swing.TextField txt_tienthua;
    private swing.TextField txt_tongtien;
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
                Thread.sleep(1000);
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
                    String maSP = result.getText().replace("MWCSTORES", "");
                    for (int i = 0; i < tb_sanpham.getRowCount(); i++) {
                        if (tb_sanpham.getValueAt(i, 1).equals(maSP)) {
                            tb_sanpham.setRowSelectionInterval(i, i);
                            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.INFO, NotificationMess.Location.TOP_CENTER, "Đã tìm thấy" + maSP);
                            panel.showNotification();
                            addSpToGH();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                try {
                    HoaDon hd = iHoaDonService.getObj(txt_mahd.getText());
                    String maKhuyenMai = result.getText().replace("MWCSTORES", "");
                    List<KhuyenMai> listKM = iKhuyenMaiService.getAll();
                    for (int i = 0; i < listKM.size(); i++) {
                        if (listKM.get(i).getMa().equals(maKhuyenMai)) {
                            khuyenMai = iKhuyenMaiService.getObj(maKhuyenMai);
                            Date currentDate = new Date();
                            Date date1 = null;
                            Date date2 = null;
                            try {
                                String ketThuc = sdf.format(khuyenMai.getNgayKetThuc());
                                String hienTai = sdf.format(currentDate);
                                date1 = sdf.parse(ketThuc);
                                date2 = sdf.parse(hienTai);
                                long getDiff = date1.getTime() - date2.getTime();
                                if (getDiff < 0) {
                                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Mã khuyến mại đã hết hạn !");
                                    panel.showNotification();
                                    break;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (khuyenMai.getSoLuong() == 0) {
                                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Đã hết mã khuyến mại !");
                                panel.showNotification();
                                break;
                            } else {
                                if (txt_makh.getText().isEmpty()) {
                                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Bạn chưa tạo/chọn hóa đơn ! ");
                                    panel.showNotification();
                                } else if (tb_giohang.getRowCount() == 0) {
                                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Hãy thêm gì đó vào giỏ hàng!");
                                    panel.showNotification();
                                } else {
                                    if (hd.getTrangThai() == 0) {
                                        txt_giamgia.setText("0");
                                        chk_tichluy.setSelected(false);
                                        if (helper.confirm(this, "Đã tìm thấy " + khuyenMai.getMa() + " giảm " + khuyenMai.getPhantramgiam() + "%. Xác nhận sử dụng ?")) {
                                            txt_makm.setText(khuyenMai.getMa());
                                            txt_tenkm.setText(khuyenMai.getTen());
                                            Double giamGia = Double.parseDouble(txt_giamgia.getText());
                                            if (giamGia == null) {
                                                giamGia = 0.0;
                                            }
                                            giamGia = giamGia + Double.parseDouble(txt_tongtien.getText()) / 100 * khuyenMai.getPhantramgiam();
                                            Double phaiTra = Double.parseDouble(txt_tongtien.getText()) - giamGia;
                                            txt_giamgia.setText(giamGia.toString());
                                            txt_phaitra.setText(phaiTra.toString());
                                        }
                                    } else {
                                        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Hóa đơn đã được thanh toán!");
                                        panel.showNotification();
                                    }
                                }
                            }
                        }
                    }
                    System.out.println(maKhuyenMai);
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
