package views;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.ChatLieu;
import models.ChiTietDep;
import models.Dep;
import models.LoaiDep;
import models.MauSac;
import models.NhaSX;
import models.Size;
import services.IChatLieuService;
import services.IChiTietDepService;
import services.IDepService;
import services.ILoaiDepService;
import services.IMauSacService;
import services.INhaSXService;
import services.ISizeService;
import services.impl.ChatLieuService;
import services.impl.ChiTietDepService;
import services.impl.DepService;
import services.impl.LoaiDepService;
import services.impl.MauSacService;
import services.impl.NhaSXService;
import services.impl.SizeService;
import swing.Table;
import ui.EventPagination;
import ui.NotificationMess;
import ui.Page;
import ui.PaginationItemRenderStyle1;
import utilities.ExportSP;
import utilities.Helper;
import utilities.ImageUltil;
import utilities.ImportSP;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class FrmChiTietDep extends javax.swing.JPanel {

    private Helper helper = new Helper();
    private ImageUltil imageUltil = new ImageUltil();
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    private DefaultTableModel defaultTableModel;
    private IChiTietDepService iChiTietDepService;

    private DefaultComboBoxModel<Dep> comboDep = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<LoaiDep> comboLoaiDep = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<ChatLieu> comboChatLieu = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<MauSac> comboMauSac = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<Size> comboSize = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<NhaSX> comboNSX = new DefaultComboBoxModel<>();

    private IDepService iDepService = new DepService();
    private ILoaiDepService iLoaiDepService = new LoaiDepService();
    private IMauSacService iMauSacService = new MauSacService();
    private IChatLieuService iChatLieuService = new ChatLieuService();
    private INhaSXService iNhaSXService = new NhaSXService();
    private ISizeService iSizeService = new SizeService();
    private Page pg = new Page();

    private int checkSearchCT = 0;

    Integer limit = 5;
    Integer totalData = 0;

    public FrmChiTietDep() {
        initComponents();
        iChiTietDepService = new ChiTietDepService();
        Table.apply(jScrollPane1, Table.TableType.MULTI_LINE);
        addCbChatLieu();
        addCbDep();
        addCbLoaiDep();
        addCbMauSac();
        addCbNhaSX();
        addCbSize();
        pagination();
        pagination1.setPagegination(1, pg.getTotalPage());
        pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());
    }

    public void pagination() {
        loadData(iChiTietDepService.pagination(pg.getCurrent(), limit));
        totalData = iChiTietDepService.getAll().size();
        int totalPage = (int) Math.ceil(totalData.doubleValue() / limit);
        pg.setTotalPage(totalPage);
        pagination1.setPagegination(pg.getCurrent(), pg.getTotalPage());
        pagination1.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                loadData(iChiTietDepService.pagination(page, limit));
                pg.setCurrent(page);
                pagination1.setPagegination(pg.getCurrent(), pg.getTotalPage());
            }
        });
    }

    private void loadData(List<ChiTietDep> list) {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_table.getModel();
        defaultTableModel.setRowCount(0);
        for (ChiTietDep x : list) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getDep().getTen(), x.getLoaiDep().getTen(), x.getMauSac().getTen(), x.getChatLieu().getTen(), x.getNhaSX().getTen(), x.getSize().getKichCo(), x.getMoTa(), x.getSoLuong(), x.getGiaNhap(), x.getGiaBan(), helper.formatDate(x.getNgayThem()), helper.formatDate(x.getNgaySuaCuoi()), x.getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh"
            });
        }
    }

    private void addCbDep() {
        cb_dep.setModel((DefaultComboBoxModel) comboDep);
        cb_dep.removeAllItems();
        for (Dep x : iChiTietDepService.getAllDep()) {
            if (x.getTrangThai() == 1) {
                comboDep.removeElement(x);
            } else {
                comboDep.addElement(x);
            }
        }
    }

    private void addCbLoaiDep() {
        cb_loaidep.setModel((DefaultComboBoxModel) comboLoaiDep);
        cb_loaidep.removeAllItems();
        for (LoaiDep x : iChiTietDepService.getAllLoaiDep()) {
            if (x.getTrangThai() == 1) {
                comboLoaiDep.removeElement(x);
            } else {
                comboLoaiDep.addElement(x);
            }
        }
    }

    private void addCbChatLieu() {
        cb_chatlieu.setModel((DefaultComboBoxModel) comboChatLieu);
        cb_chatlieu.removeAllItems();
        for (ChatLieu x : iChiTietDepService.getAllChatLieu()) {
            if (x.getTrangThai() == 1) {
                comboChatLieu.removeElement(x);
            } else {
                comboChatLieu.addElement(x);
            }
        }
    }

    private void addCbMauSac() {
        cb_mausac.setModel((DefaultComboBoxModel) comboMauSac);
        cb_mausac.removeAllItems();
        for (MauSac x : iChiTietDepService.getAllMauSac()) {
            if (x.getTrangThai() == 1) {
                comboMauSac.removeElement(x);
            } else {
                comboMauSac.addElement(x);
            }
        }
    }

    private void addCbSize() {
        cb_size.setModel((DefaultComboBoxModel) comboSize);
        cb_size.removeAllItems();
        for (Size x : iChiTietDepService.getAllSize()) {
            if (x.getTrangThai() == 1) {
                comboSize.removeElement(x);
            } else {
                comboSize.addElement(x);
            }
        }
    }

    private void addCbNhaSX() {
        cb_nsx.setModel((DefaultComboBoxModel) comboNSX);
        cb_nsx.removeAllItems();
        for (NhaSX x : iChiTietDepService.getAllNSX()) {
            if (x.getTrangThai() == 1) {
                comboNSX.removeElement(x);
            } else {
                comboNSX.addElement(x);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lbl_image = new javax.swing.JLabel();
        rd_ct_ngungkd = new swing.RadioButtonCustom();
        cb_loaidep = new swing.Combobox();
        rd_ct_dangkd = new swing.RadioButtonCustom();
        btn_importExcel = new swing.Button();
        jLabel2 = new javax.swing.JLabel();
        btn_ctd_capnhat = new swing.Button();
        cb_mausac = new swing.Combobox();
        txt_timkiem = new swing.TextField();
        txt_giaban = new swing.TextField();
        btn_ctd_them = new swing.Button();
        cb_chatlieu = new swing.Combobox();
        cb_size = new swing.Combobox();
        txt_gianhap = new swing.TextField();
        btn_ctd_xoa = new swing.Button();
        cb_nsx = new swing.Combobox();
        cb_dep = new swing.Combobox();
        txt_mota = new swing.TextField();
        btn_exportExcel = new swing.Button();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_table = new javax.swing.JTable();
        sp_SoLuong = new swing.Spinner();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pagination1 = new swing.Pagination();

        setBackground(new java.awt.Color(255, 255, 255));

        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setText(" ");

        buttonGroup1.add(rd_ct_ngungkd);
        rd_ct_ngungkd.setText("Ngừng kinh doanh");
        rd_ct_ngungkd.setFocusPainted(false);

        cb_loaidep.setFocusable(false);
        cb_loaidep.setLabeText("Loại dép");
        cb_loaidep.setLineColor(new java.awt.Color(102, 102, 102));
        cb_loaidep.setRequestFocusEnabled(false);

        buttonGroup1.add(rd_ct_dangkd);
        rd_ct_dangkd.setSelected(true);
        rd_ct_dangkd.setText("Đang kinh doanh");
        rd_ct_dangkd.setFocusPainted(false);

        btn_importExcel.setBackground(new java.awt.Color(0, 102, 0));
        btn_importExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_importExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel.png"))); // NOI18N
        btn_importExcel.setText("Import Excel");
        btn_importExcel.setFocusPainted(false);
        btn_importExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_importExcelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("THÔNG TIN SẢN PHẨM");

        btn_ctd_capnhat.setBackground(new java.awt.Color(153, 153, 153));
        btn_ctd_capnhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_ctd_capnhat.setText("Cập nhật");
        btn_ctd_capnhat.setFocusPainted(false);
        btn_ctd_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctd_capnhatActionPerformed(evt);
            }
        });

        cb_mausac.setFocusable(false);
        cb_mausac.setLabeText("Màu sắc");
        cb_mausac.setLineColor(new java.awt.Color(102, 102, 102));
        cb_mausac.setRequestFocusEnabled(false);

        txt_timkiem.setLabelText("Tìm kiếm");
        txt_timkiem.setLineColor(new java.awt.Color(102, 102, 102));
        txt_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkiemCaretUpdate(evt);
            }
        });

        txt_giaban.setLabelText("Giá bán");
        txt_giaban.setLineColor(new java.awt.Color(102, 102, 102));

        btn_ctd_them.setBackground(new java.awt.Color(153, 153, 153));
        btn_ctd_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_ctd_them.setText("Thêm");
        btn_ctd_them.setFocusPainted(false);
        btn_ctd_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctd_themActionPerformed(evt);
            }
        });

        cb_chatlieu.setFocusable(false);
        cb_chatlieu.setLabeText("Chất liệu");
        cb_chatlieu.setLineColor(new java.awt.Color(102, 102, 102));
        cb_chatlieu.setRequestFocusEnabled(false);

        cb_size.setFocusable(false);
        cb_size.setLabeText("Size");
        cb_size.setLineColor(new java.awt.Color(102, 102, 102));
        cb_size.setRequestFocusEnabled(false);

        txt_gianhap.setLabelText("Giá nhập");
        txt_gianhap.setLineColor(new java.awt.Color(102, 102, 102));

        btn_ctd_xoa.setBackground(new java.awt.Color(153, 153, 153));
        btn_ctd_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_ctd_xoa.setText("Xóa");
        btn_ctd_xoa.setFocusPainted(false);
        btn_ctd_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctd_xoaActionPerformed(evt);
            }
        });

        cb_nsx.setFocusable(false);
        cb_nsx.setLabeText("Nhà sản xuất");
        cb_nsx.setLineColor(new java.awt.Color(102, 102, 102));
        cb_nsx.setRequestFocusEnabled(false);

        cb_dep.setFocusable(false);
        cb_dep.setLabeText("Dép");
        cb_dep.setLineColor(new java.awt.Color(102, 102, 102));
        cb_dep.setRequestFocusEnabled(false);

        txt_mota.setLabelText("Mô tả");
        txt_mota.setLineColor(new java.awt.Color(102, 102, 102));

        btn_exportExcel.setBackground(new java.awt.Color(0, 102, 0));
        btn_exportExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel.png"))); // NOI18N
        btn_exportExcel.setText("Export Excel");
        btn_exportExcel.setFocusPainted(false);
        btn_exportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportExcelActionPerformed(evt);
            }
        });

        tb_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên", "Loại", "Màu sắc", "Chất liệu", "NSX", "Size", "Mô tả", "Số lượng", "Giá nhập", "Giá bán", "Ngày thêm", "Ngày Sửa Cuối", "Trạng thái"
            }
        ));
        tb_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tb_table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tb_table.setSelectionBackground(new java.awt.Color(153, 153, 255));
        tb_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_table);
        if (tb_table.getColumnModel().getColumnCount() > 0) {
            tb_table.getColumnModel().getColumn(0).setPreferredWidth(30);
            tb_table.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Số lượng :");

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        pagination1.setBackground(new java.awt.Color(0, 0, 255));
        pagination1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(404, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_gianhap, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(txt_mota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(sp_SoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_giaban, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                                    .addComponent(jLabel1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rd_ct_ngungkd, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(rd_ct_dangkd, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_dep, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(cb_chatlieu, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_loaidep, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_size, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_timkiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btn_ctd_them, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ctd_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ctd_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_importExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_exportExcel, btn_importExcel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(cb_chatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cb_dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cb_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cb_loaidep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rd_ct_dangkd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sp_SoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_gianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_ct_ngungkd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ctd_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ctd_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ctd_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_importExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cb_chatlieu, cb_dep, cb_loaidep, cb_mausac, cb_nsx, cb_size});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {rd_ct_dangkd, txt_giaban, txt_gianhap, txt_mota});

    }// </editor-fold>//GEN-END:initComponents

    private void btn_importExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_importExcelActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".xlsx", "xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Import Excel");
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileOpen = fileChooser.getSelectedFile();
            try {
                List<ChiTietDep> list = ImportSP.readExcel(fileOpen.getAbsolutePath());

                if (helper.confirm(this, "Xác nhận thêm " + list.size() + " sản phẩm ?")) {
                    for (ChiTietDep x : list) {
                        ChiTietDep ctd = iChiTietDepService.getObjByProperties(x.getDep().getId(), x.getLoaiDep().getId(), x.getMauSac().getId(), x.getChatLieu().getId(), x.getNhaSX().getId(), x.getSize().getId());
                        if (ctd != null) {
                            ctd.setSoLuong(ctd.getSoLuong() + x.getSoLuong());
                            iChiTietDepService.save(ctd);
                            continue;
                        } else {
                            iChiTietDepService.save(x);
                        }

                    }
                    pagination();
                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Import File Excel thành công");
                    panel.showNotification();
                }
            } catch (Exception e) {
                e.printStackTrace();
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Import File Excel thất bại");
                panel.showNotification();
            }
            System.out.println("Save as file: " + fileOpen.getAbsolutePath());
        }
    }//GEN-LAST:event_btn_importExcelActionPerformed

    private void btn_ctd_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctd_capnhatActionPerformed
        int row = tb_table.getSelectedRow();
        if (row == -1) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Vui lòng chọn dòng sản phẩm cần cập nhật");
            panel.showNotification();
        } else {
            ChiTietDep ctd;
            if (checkSearchCT == 0) {
                ctd = iChiTietDepService.pagination(pg.getCurrent(), limit).get(row);
            } else {
                ctd = iChiTietDepService.findByName(txt_timkiem.getText()).get(row);
            }
            ctd.setDep((Dep) comboDep.getSelectedItem());
            ctd.setLoaiDep((LoaiDep) comboLoaiDep.getSelectedItem());
            ctd.setMauSac((MauSac) comboMauSac.getSelectedItem());
            ctd.setChatLieu((ChatLieu) comboChatLieu.getSelectedItem());
            ctd.setNhaSX((NhaSX) comboNSX.getSelectedItem());
            ctd.setSize((Size) comboSize.getSelectedItem());
            ctd.setMoTa(txt_mota.getText());
            ctd.setSoLuong((int) sp_SoLuong.getValue());
            ctd.setGiaNhap(helper.convertToDecimal(txt_gianhap, "Error!"));
            ctd.setGiaBan(helper.convertToDecimal(txt_giaban, "Error!"));
            ctd.setNgaySuaCuoi(new Date());
            if (rd_ct_dangkd.isSelected()) {
                ctd.setTrangThai(0);
            } else {
                ctd.setTrangThai(1);
            }
            iChiTietDepService.save(ctd);
            pagination();
            checkSearchCT = 0;
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Cập nhật thành công");
            panel.showNotification();
        }
    }//GEN-LAST:event_btn_ctd_capnhatActionPerformed

    private void txt_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkiemCaretUpdate
        loadData(iChiTietDepService.findByName(txt_timkiem.getText()));
        if (iChiTietDepService.findByName(txt_timkiem.getText()).size() == iChiTietDepService.getAll().size()) {
            checkSearchCT = 0;
        } else {
            checkSearchCT = 1;
        }

    }//GEN-LAST:event_txt_timkiemCaretUpdate

    private void btn_ctd_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctd_themActionPerformed
        Dep dep = (Dep) comboDep.getSelectedItem();
        ChatLieu chatLieu = (ChatLieu) comboChatLieu.getSelectedItem();
        MauSac mauSac = (MauSac) comboMauSac.getSelectedItem();
        Size size = (Size) comboSize.getSelectedItem();
        LoaiDep loaiDep = (LoaiDep) comboLoaiDep.getSelectedItem();
        NhaSX nhaSX = (NhaSX) comboNSX.getSelectedItem();
        if (iChiTietDepService.getObjByProperties(dep.getId(), loaiDep.getId(), mauSac.getId(), chatLieu.getId(), nhaSX.getId(), size.getId()) == null) {
            ChiTietDep ctd = new ChiTietDep();
            ctd.setDep((Dep) comboDep.getSelectedItem());
            ctd.setLoaiDep((LoaiDep) comboLoaiDep.getSelectedItem());
            ctd.setMauSac((MauSac) comboMauSac.getSelectedItem());
            ctd.setChatLieu((ChatLieu) comboChatLieu.getSelectedItem());
            ctd.setNhaSX((NhaSX) comboNSX.getSelectedItem());
            ctd.setSize((Size) comboSize.getSelectedItem());
            ctd.setMoTa(txt_mota.getText());
            int soluong = (int) sp_SoLuong.getValue();
            if (soluong < 0) {
                helper.alert(this, "Số lượng không hợp lệ");
                return;
            }           
            ctd.setSoLuong(soluong);
            ctd.setGiaNhap(helper.convertToDecimal(txt_gianhap, "Error!"));
            ctd.setGiaBan(helper.convertToDecimal(txt_giaban, "Error!"));
            ctd.setNgayThem(new Date());
            ctd.setNgaySuaCuoi(new Date());
            if (rd_ct_dangkd.isSelected()) {
                ctd.setTrangThai(0);
            } else {
                ctd.setTrangThai(1);
            }
            iChiTietDepService.save(ctd);
            pagination();
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Thêm thành công");
            panel.showNotification();
        } else {
            ChiTietDep ctd = iChiTietDepService.getObjByProperties(dep.getId(), loaiDep.getId(), mauSac.getId(), chatLieu.getId(), nhaSX.getId(), size.getId());
            int soLuong = (int) sp_SoLuong.getValue();
            ctd.setSoLuong(ctd.getSoLuong() + soLuong);
            ctd.setNgaySuaCuoi(new Date());
            iChiTietDepService.save(ctd);
            pagination();
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.INFO, NotificationMess.Location.TOP_CENTER, "Sản phẩm đã tồn tại, cập nhật thêm số lượng");
            panel.showNotification();
        }
    }//GEN-LAST:event_btn_ctd_themActionPerformed

    private void btn_ctd_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctd_xoaActionPerformed
        int row = tb_table.getSelectedRow();
        if (row == -1) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Vui lòng chọn dòng sản phẩm để xóa !");
            panel.showNotification();
        } else {
            ChiTietDep ctd;
            if (checkSearchCT == 0) {
                ctd = iChiTietDepService.pagination(pg.getCurrent(), limit).get(row);
            } else {
                ctd = iChiTietDepService.findByName(txt_timkiem.getText()).get(row);
            }
            if (helper.confirm(this, "Xác nhận xóa")) {
                iChiTietDepService.delete(ctd);
                List<ChiTietDep> c = iChiTietDepService.pagination(pg.getCurrent(), limit);
                int r = c.size();
                if (r == 0) {
                    pagination();
                    pagination1.setPagegination(pg.getCurrent(), (pg.getTotalPage()) + 1);
                } else {
                    pagination();
                }
                checkSearchCT = 0;
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Xóa thành công");
                panel.showNotification();
            }
        }
    }//GEN-LAST:event_btn_ctd_xoaActionPerformed

    private void btn_exportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportExcelActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".xlsx", "xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Export Excel");
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                if (helper.confirm(this, "File Path: " + fileToSave.getAbsolutePath() + filter.getDescription() + ". Xác nhận xuất file ?")) {
                    ExportSP.writeExcel(iChiTietDepService.getAll(), fileToSave.getAbsolutePath() + filter.getDescription());
                    NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Xuất File Excel thành công");
                    panel.showNotification();
                }
            } catch (Exception e) {
                e.printStackTrace();
                NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.ERROR, NotificationMess.Location.TOP_CENTER, "Xuất File Excel thất bại");
                panel.showNotification();
            }
            System.out.println("Save as file: " + fileToSave.getAbsolutePath() + filter.getDescription());
        }
    }//GEN-LAST:event_btn_exportExcelActionPerformed

    private void tb_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_tableMousePressed
        // TODO add your handling code here:
        int row = tb_table.getSelectedRow();
        ChiTietDep ctd = iChiTietDepService.pagination(pg.getCurrent(), limit).get(row);
        comboDep.setSelectedItem(ctd.getDep());
        comboLoaiDep.setSelectedItem(ctd.getLoaiDep());
        comboChatLieu.setSelectedItem(ctd.getChatLieu());
        comboSize.setSelectedItem(ctd.getSize());
        comboNSX.setSelectedItem(ctd.getNhaSX());
        comboMauSac.setSelectedItem(ctd.getMauSac());
        txt_mota.setText(ctd.getMoTa());
        txt_gianhap.setText(ctd.getGiaNhap().toString());
        txt_giaban.setText(ctd.getGiaBan().toString());
        sp_SoLuong.setValue(ctd.getSoLuong());
        if (ctd.getTrangThai() == 0) {
            rd_ct_dangkd.setSelected(true);
        } else {
            rd_ct_ngungkd.setSelected(true);
        }
        lbl_image.setIcon(imageUltil.resizeIcon(new ImageIcon("images/products/" + ctd.getDep().getHinhAnh()), lbl_image.getWidth(), lbl_image.getHeight()));
        System.out.println(ctd.getDep().getHinhAnh());
    }//GEN-LAST:event_tb_tableMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_ctd_capnhat;
    private swing.Button btn_ctd_them;
    private swing.Button btn_ctd_xoa;
    private swing.Button btn_exportExcel;
    private swing.Button btn_importExcel;
    private javax.swing.ButtonGroup buttonGroup1;
    private swing.Combobox cb_chatlieu;
    private swing.Combobox cb_dep;
    private swing.Combobox cb_loaidep;
    private swing.Combobox cb_mausac;
    private swing.Combobox cb_nsx;
    private swing.Combobox cb_size;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_image;
    private swing.Pagination pagination1;
    private swing.RadioButtonCustom rd_ct_dangkd;
    private swing.RadioButtonCustom rd_ct_ngungkd;
    private swing.Spinner sp_SoLuong;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tb_table;
    private swing.TextField txt_giaban;
    private swing.TextField txt_gianhap;
    private swing.TextField txt_mota;
    private swing.TextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
