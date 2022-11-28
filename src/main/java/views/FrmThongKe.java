package views;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.ChiTietDep;
import models.Dep;
import models.HoaDonChiTiet;
import services.IChiTietDepService;
import services.IHoaDonCTService;
import services.impl.ChiTietDepService;
import services.impl.HoaDonCTService;
import swing.ModelPieChart;
import swing.PieChart;
import swing.Table;
import ui.ModelCard;

public class FrmThongKe extends javax.swing.JPanel {

    private IChiTietDepService iChiTietDepService = new ChiTietDepService();
    private IHoaDonCTService iHoaDonCTService = new HoaDonCTService();

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
        spsaphethang.setData(new ModelCard("Sản phẩm đang kinh doanh", iChiTietDepService.findByTT(0, "").size(), null));
        spngungkd.setData(new ModelCard("Sản phẩm sắp hết hàng", 0, null));
        spdangkd.setData(new ModelCard("Sản phẩm ngừng kinh doanh", iChiTietDepService.findByTT(1, "").size(), null));
        pieChart1.setChartType(PieChart.PeiChartType.DEFAULT);
        List<ChiTietDep> listCTD = iChiTietDepService.topSPBanChay(0, 5);
        try {
            for (int i = 0; i < listCTD.size(); i++) {
                Dep dep = listCTD.get(i).getDep();
                pieChart1.addData(new ModelPieChart(dep.getTen(), listCTD.get(i).getSoLuongBanRa(), new Color(23 + i * 50, 126 - i * 30, 238 - i * 20)));
            }
        } catch (Exception e) {
        }

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
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_top5sp = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tableScrollButton2 = new swing.TableScrollButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_spsaphethang = new javax.swing.JTable();
        txt_soluong = new javax.swing.JTextField();
        pieChart1 = new swing.PieChart();
        jLabel4 = new javax.swing.JLabel();
        btn_exportTop5 = new swing.Button();
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

        tb_top5sp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên dép", "Loại dép", "Size", "Số lượng tồn", "Giá bán", "Mô tả", "Số lượng bán ra"
            }
        ));
        jScrollPane1.setViewportView(tb_top5sp);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.blue);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Top 5 sản phẩm bán chạy nhất");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.red);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Danh sách sản phẩm sắp hết hàng");

        tb_spsaphethang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên dép", "Loại dép", "Size", "Số lượng tồn", "Giá bán", "Mô tả", "Số lượng bán ra"
            }
        ));
        jScrollPane2.setViewportView(tb_spsaphethang);

        tableScrollButton2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        txt_soluong.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_soluongCaretUpdate(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.magenta);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Biểu đồ Top 5 sản phẩm");

        btn_exportTop5.setBackground(new java.awt.Color(0, 102, 0));
        btn_exportTop5.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportTop5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel.png"))); // NOI18N
        btn_exportTop5.setText("Export Excel");

        btn_exportSapHetHang.setBackground(new java.awt.Color(0, 102, 0));
        btn_exportSapHetHang.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportSapHetHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel.png"))); // NOI18N
        btn_exportSapHetHang.setText("Export Excel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spdangkd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spsaphethang, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spngungkd, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(btn_exportTop5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_exportSapHetHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tableScrollButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_exportTop5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_exportSapHetHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableScrollButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_soluongCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_soluongCaretUpdate
        try {
            soLuong = Integer.parseInt(txt_soluong.getText());
        } catch (Exception e) {

        }
        List<ChiTietDep> list = iChiTietDepService.findSLSPLess(soLuong);
        loadData(list, tb_spsaphethang);
    }//GEN-LAST:event_txt_soluongCaretUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_exportSapHetHang;
    private swing.Button btn_exportTop5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private swing.PieChart pieChart1;
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
