package views;

import java.io.File;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.ChiTietDep;
import models.HoaDonChiTiet;
import services.IChiTietDepService;
import services.IHoaDonCTService;
import services.impl.ChiTietDepService;
import services.impl.HoaDonCTService;
import swing.Table;
import ui.ModelCard;
import ui.NotificationMess;
import utilities.ExportSP;
import utilities.Helper;

public class FrmThongKe extends javax.swing.JPanel {

    private IChiTietDepService iChiTietDepService = new ChiTietDepService();
    private IHoaDonCTService iHoaDonCTService = new HoaDonCTService();
    private Helper helper = new Helper();

    private DefaultTableModel defaultTableModel;
    private int soLuong = 0;

    public FrmThongKe() {
        initComponents();
        setOpaque(false);
        Table.apply(jScrollPane1, Table.TableType.DEFAULT);
        Table.apply(jScrollPane2, Table.TableType.DEFAULT);
        List<HoaDonChiTiet> listHDCT = iHoaDonCTService.getDoanhThu(1, new Date());
//        Double doanhThuNgay = 0.0;
//        try {
//            for (HoaDonChiTiet x : listHDCT) {
//                if (x.getHoaDon().getKhuyenMai() == null) {
//                    doanhThuNgay += x.getDonGia().doubleValue() * x.getSoLuong()  - x.getHoaDon().getDiemTichLuy() * 1000;
//                } else {
//                    doanhThuNgay += x.getDonGia().doubleValue() * x.getSoLuong()  - x.getHoaDon().getDiemTichLuy() * 1000 - (x.getDonGia().doubleValue() * x.getSoLuong()) / 100 * x.getHoaDon().getKhuyenMai().getPhantramgiam();
//                }
//            }
//        } catch (Exception e) {
//        }
//        doanhthungay.setData(new ModelCard("Doanh thu ngày", doanhThuNgay, null));
        spsaphethang.setData(new ModelCard("Sản phẩm đang kinh doanh", iChiTietDepService.findByTT(0, "").size(), new ImageIcon(getClass().getResource("/icons/unpacking.png"))));
        spngungkd.setData(new ModelCard("Sản phẩm sắp hết hàng", 0, new ImageIcon(getClass().getResource("/icons/box.png"))));
        spdangkd.setData(new ModelCard("Sản phẩm ngừng kinh doanh", iChiTietDepService.findByTT(1, "").size(), new ImageIcon(getClass().getResource("/icons/stop.png"))));
        loadData(iChiTietDepService.topSPBanChay(0, 5), tb_top5sp);
    }

    private void loadData(List<ChiTietDep> list, JTable table) {
        defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.setRowCount(0);
        for (ChiTietDep x : list) {
            defaultTableModel.addRow(new Object[]{
                x.getDep().getTen(), x.getLoaiDep().getTen(), x.getSize().getKichCo(), x.getSoLuong(), x.getGiaBan(), x.getMoTa(), x.getSoLuongBanRa()
            });
        }
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        spdangkd = new swing.Card();
        spsaphethang = new swing.Card();
        spngungkd = new swing.Card();
        jPanel1 = new javax.swing.JPanel();
        btn_exportTop5 = new swing.Button();
        jLabel2 = new javax.swing.JLabel();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_top5sp = new javax.swing.JTable();
        btn_xembieudotop5 = new swing.Button();
        jPanel2 = new javax.swing.JPanel();
        tableScrollButton2 = new swing.TableScrollButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_spsaphethang = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txt_soluong = new javax.swing.JTextField();
        btn_exportSapHetHang = new swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Thống kê / Sản phẩm");

        spdangkd.setBackground(new java.awt.Color(10, 30, 214));
        spdangkd.setColorGradient(new java.awt.Color(72, 111, 252));

        spsaphethang.setBackground(new java.awt.Color(194, 85, 1));
        spsaphethang.setColorGradient(new java.awt.Color(255, 212, 99));

        spngungkd.setColorGradient(new java.awt.Color(211, 28, 215));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btn_exportTop5.setBackground(new java.awt.Color(0, 102, 0));
        btn_exportTop5.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportTop5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel.png"))); // NOI18N
        btn_exportTop5.setText("Export Excel");
        btn_exportTop5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportTop5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.blue);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Top 5 sản phẩm bán chạy nhất");

        tb_top5sp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên dép", "Loại dép", "Size", "Số lượng tồn", "Giá bán hiện tại", "Mô tả", "Số lượng bán ra"
            }
        ));
        jScrollPane1.setViewportView(tb_top5sp);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btn_xembieudotop5.setBackground(new java.awt.Color(204, 0, 0));
        btn_xembieudotop5.setForeground(new java.awt.Color(255, 255, 255));
        btn_xembieudotop5.setText("Xem biểu đồ");
        btn_xembieudotop5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xembieudotop5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24)
                        .addComponent(btn_xembieudotop5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_exportTop5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_exportTop5, btn_xembieudotop5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_exportTop5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btn_xembieudotop5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_exportTop5, btn_xembieudotop5});

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tb_spsaphethang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên dép", "Loại dép", "Size", "Số lượng tồn", "Giá bán hiện tại", "Mô tả", "Số lượng bán ra"
            }
        ));
        jScrollPane2.setViewportView(tb_spsaphethang);

        tableScrollButton2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.red);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Danh sách sản phẩm sắp hết hàng");

        txt_soluong.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_soluongCaretUpdate(evt);
            }
        });

        btn_exportSapHetHang.setBackground(new java.awt.Color(0, 102, 0));
        btn_exportSapHetHang.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportSapHetHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel.png"))); // NOI18N
        btn_exportSapHetHang.setText("Export Excel");
        btn_exportSapHetHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportSapHetHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_exportSapHetHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_exportSapHetHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spdangkd, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spsaphethang, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spngungkd, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spdangkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spsaphethang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spngungkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_soluongCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_soluongCaretUpdate
        try {
            soLuong = Integer.parseInt(txt_soluong.getText());
        } catch (Exception e) {

        }
        List<ChiTietDep> list = iChiTietDepService.findSLSPLess(soLuong);
        spngungkd.setData(new ModelCard("Sản phẩm sắp hết hàng", list.size(), new ImageIcon(getClass().getResource("/icons/box.png"))));
        loadData(list, tb_spsaphethang);
    }//GEN-LAST:event_txt_soluongCaretUpdate

    private void btn_xembieudotop5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xembieudotop5ActionPerformed
        Chart chart = new Chart(null, true);
        chart.setVisible(true);
    }//GEN-LAST:event_btn_xembieudotop5ActionPerformed

    private void btn_exportTop5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportTop5ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".xlsx", "xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Export Excel");
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                if (helper.confirm(this, "File Path: " + fileToSave.getAbsolutePath() + filter.getDescription() + ". Xác nhận xuất file ?")) {
                    ExportSP.writeExcel(iChiTietDepService.topSPBanChay(0, 5), fileToSave.getAbsolutePath() + filter.getDescription());
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
    }//GEN-LAST:event_btn_exportTop5ActionPerformed

    private void btn_exportSapHetHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportSapHetHangActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".xlsx", "xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Export Excel");
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                if (helper.confirm(this, "File Path: " + fileToSave.getAbsolutePath() + filter.getDescription() + ". Xác nhận xuất file ?")) {
                    ExportSP.writeExcel(iChiTietDepService.findSLSPLess(soLuong), fileToSave.getAbsolutePath() + filter.getDescription());
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
    }//GEN-LAST:event_btn_exportSapHetHangActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_exportSapHetHang;
    private swing.Button btn_exportTop5;
    private swing.Button btn_xembieudotop5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private swing.Card spdangkd;
    private swing.Card spngungkd;
    private swing.Card spsaphethang;
    private swing.TableScrollButton tableScrollButton1;
    private swing.TableScrollButton tableScrollButton2;
    private javax.swing.JTable tb_spsaphethang;
    private javax.swing.JTable tb_top5sp;
    private javax.swing.JTextField txt_soluong;
    // End of variables declaration//GEN-END:variables
}
