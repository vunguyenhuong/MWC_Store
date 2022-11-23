package views;

import java.util.Date;
import java.util.List;
import models.HoaDonChiTiet;
import services.IChiTietDepService;
import services.IHoaDonCTService;
import services.impl.ChiTietDepService;
import services.impl.HoaDonCTService;
import swing.Table;
import ui.ModelCard;

public class FrmThongKe extends javax.swing.JPanel {

    private IChiTietDepService iChiTietDepService = new ChiTietDepService();
    private IHoaDonCTService iHoaDonCTService = new HoaDonCTService();

    public FrmThongKe() {
        initComponents();
        setOpaque(false);
        Table.apply(jScrollPane1, Table.TableType.DEFAULT);
        List<HoaDonChiTiet> listHDCT = iHoaDonCTService.getDoanhThu(1, new Date());
        Double doanhThuNgay = 0.0;
        try {
            for (HoaDonChiTiet x : listHDCT) {
                if (x.getHoaDon().getKhuyenMai() == null) {
                    doanhThuNgay += x.getDonGia().doubleValue() * x.getSoLuong()  - x.getHoaDon().getDiemTichLuy() * 1000;
                } else {
                    doanhThuNgay += x.getDonGia().doubleValue() * x.getSoLuong()  - x.getHoaDon().getDiemTichLuy() * 1000 - (x.getDonGia().doubleValue() * x.getSoLuong()) / 100 * x.getHoaDon().getKhuyenMai().getPhantramgiam();
                }
            }
        } catch (Exception e) {
        }
        doanhthungay.setData(new ModelCard("Doanh thu ngày", doanhThuNgay, null));
        spsaphethang.setData(new ModelCard("Sản phẩm đang kinh doanh", iChiTietDepService.findByTT(0, "").size(), null));
        spngungkd.setData(new ModelCard("Sản phẩm sắp hết hàng", iChiTietDepService.findSLSPLess(5).size(), null));
        spdangkd.setData(new ModelCard("Sản phẩm ngừng kinh doanh", iChiTietDepService.findByTT(1, "").size(), null));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        doanhthungay = new swing.Card();
        jLabel1 = new javax.swing.JLabel();
        spdangkd = new swing.Card();
        spsaphethang = new swing.Card();
        spngungkd = new swing.Card();
        jPanel1 = new javax.swing.JPanel();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        doanhthungay.setColorGradient(new java.awt.Color(211, 28, 215));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Thống kê / Sản phẩm");

        spdangkd.setBackground(new java.awt.Color(10, 30, 214));
        spdangkd.setColorGradient(new java.awt.Color(72, 111, 252));

        spsaphethang.setBackground(new java.awt.Color(194, 85, 1));
        spsaphethang.setColorGradient(new java.awt.Color(255, 212, 99));

        spngungkd.setBackground(new java.awt.Color(60, 195, 0));
        spngungkd.setColorGradient(new java.awt.Color(0, 255, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(doanhthungay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(spdangkd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(spsaphethang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(spngungkd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doanhthungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spdangkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spsaphethang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spngungkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Card doanhthungay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private swing.Card spdangkd;
    private swing.Card spngungkd;
    private swing.Card spsaphethang;
    private swing.TableScrollButton tableScrollButton1;
    // End of variables declaration//GEN-END:variables
}
