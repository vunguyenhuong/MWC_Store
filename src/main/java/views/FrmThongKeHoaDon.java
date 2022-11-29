package views;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import models.HoaDon;
import models.HoaDonChiTiet;
import services.IHoaDonCTService;
import services.IHoaDonService;
import services.impl.HoaDonCTService;
import services.impl.HoaDonService;
import swing.ModelPieChart;
import swing.PieChart;
import ui.ModelCard;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class FrmThongKeHoaDon extends javax.swing.JPanel {

    private IHoaDonService iHoaDonService = new HoaDonService();
    private IHoaDonCTService iHoaDonCTService = new HoaDonCTService();
    private DefaultComboBoxModel comboNgay;
    private DefaultComboBoxModel comboThang;
    private DefaultComboBoxModel comboNam;
    private Calendar calendar = Calendar.getInstance();

    public FrmThongKeHoaDon() {
        initComponents();
        chuatt.setData(new ModelCard("Chưa thanh toán", iHoaDonService.getByTT(0).size(), null));
        datt.setData(new ModelCard("Đã thanh toán", iHoaDonService.getByTT(1).size(), null));
        addYear();
        chartDoanhThu();
        lbl_tenbieudo.setText("BIỂU ĐỒ CƠ CẤU DOANH THU NĂM " + calendar.get(Calendar.YEAR));
        comboNam = (DefaultComboBoxModel) cb_nam.getModel();
        comboThang = (DefaultComboBoxModel) cb_thang.getModel();
        comboNgay = (DefaultComboBoxModel) cb_ngay.getModel();
        comboNgay.setSelectedItem(calendar.get(Calendar.DATE));
        comboThang.setSelectedItem(calendar.get(Calendar.MONTH) + 1);
        comboNam.setSelectedItem(calendar.get(Calendar.YEAR));
    }

    private void addYear() {
        comboNam = (DefaultComboBoxModel) cb_nam.getModel();
        comboNam.removeAllElements();
        for (int i = 0; i <= 11; i++) {
            comboNam.addElement(calendar.get(Calendar.YEAR) - 6 + i);
        }
    }

    private void chartDoanhThu() {
        BigDecimal bd = null;
        pieChart1.clearData();
        pieChart1.setChartType(PieChart.PeiChartType.DEFAULT);
        for (int i = 1; i <= 12; i++) {
            bd = iHoaDonService.doanhThuTheoThang(i, Integer.parseInt(comboNam.getSelectedItem().toString()));
            pieChart1.addData(new ModelPieChart("Tháng " + i, bd == null ? 0 : bd.doubleValue(), new Color(23 + i * 10, 126 + i * 5, 238 - i * 3)));
        }
    }

    private void showDoanhThu() {
        Integer ngay = Integer.parseInt(cb_ngay.getSelectedItem().toString());
        Integer thang = Integer.parseInt(cb_thang.getSelectedItem().toString());
        Integer nam = Integer.parseInt(cb_nam.getSelectedItem().toString());
        String date = ngay + "/" + thang + "/" + nam;
        BigDecimal doanhthuNgay = iHoaDonService.doanhThuTheoNgay(ngay, thang, nam);
        BigDecimal doanhThuThang = iHoaDonService.doanhThuTheoThang(thang, nam);
        Double doanhThuNam = 0.0;
        BigDecimal doanhThu12Thang = null;
        doanhthungay.setData(new ModelCard("Doanh thu ngày " + date, doanhthuNgay == null ? 0 : doanhthuNgay.doubleValue(), null));
        doanhthuthang.setData(new ModelCard("Doanh thu tháng " + thang + "/" + nam, doanhThuThang == null ? 0 : doanhThuThang.doubleValue(), null));
        for (int i = 1; i <= 12; i++) {
            doanhThu12Thang = iHoaDonService.doanhThuTheoThang(i, Integer.parseInt(comboNam.getSelectedItem().toString()));
            doanhThuNam += doanhThu12Thang == null ? 0 : doanhThu12Thang.doubleValue();
            doanhthunam.setData(new ModelCard("Doanh thu năm " + nam, doanhThuNam == null ? 0 : doanhThuNam.doubleValue(), null));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        doanhthunam = new swing.Card();
        doanhthungay = new swing.Card();
        jLabel1 = new javax.swing.JLabel();
        chuatt = new swing.Card();
        datt = new swing.Card();
        pieChart1 = new swing.PieChart();
        cb_nam = new swing.Combobox();
        lbl_tenbieudo = new javax.swing.JLabel();
        cb_thang = new swing.Combobox();
        cb_ngay = new swing.Combobox();
        doanhthuthang = new swing.Card();

        setBackground(new java.awt.Color(255, 255, 255));

        doanhthunam.setBackground(new java.awt.Color(60, 195, 0));
        doanhthunam.setColorGradient(new java.awt.Color(0, 255, 51));

        doanhthungay.setColorGradient(new java.awt.Color(211, 28, 215));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Thống kê / Hóa đơn");

        chuatt.setBackground(new java.awt.Color(10, 30, 214));
        chuatt.setColorGradient(new java.awt.Color(72, 111, 252));

        datt.setBackground(new java.awt.Color(194, 85, 1));
        datt.setColorGradient(new java.awt.Color(255, 212, 99));

        cb_nam.setLabeText("Năm");
        cb_nam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_namItemStateChanged(evt);
            }
        });

        lbl_tenbieudo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_tenbieudo.setForeground(java.awt.Color.red);
        lbl_tenbieudo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tenbieudo.setText("BIỂU ĐỒ CƠ CẤU DOANH THU NĂM ");
        lbl_tenbieudo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_tenbieudoMouseClicked(evt);
            }
        });

        cb_thang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cb_thang.setLabeText("Tháng");
        cb_thang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_thangItemStateChanged(evt);
            }
        });

        cb_ngay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cb_ngay.setLabeText("Ngày");
        cb_ngay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_ngayItemStateChanged(evt);
            }
        });

        doanhthuthang.setBackground(new java.awt.Color(60, 195, 0));
        doanhthuthang.setColorGradient(new java.awt.Color(0, 255, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(423, 423, 423))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_tenbieudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chuatt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doanhthungay, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doanhthuthang, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doanhthunam, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(32, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_nam, cb_ngay, cb_thang});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doanhthuthang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doanhthunam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chuatt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doanhthungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_tenbieudo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cb_nam, cb_ngay, cb_thang});

    }// </editor-fold>//GEN-END:initComponents

    private void cb_namItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_namItemStateChanged
        chartDoanhThu();
        lbl_tenbieudo.setText("BIỂU ĐỒ CƠ CẤU DOANH THU NĂM " + comboNam.getSelectedItem());
        for (int i = 1; i <= 31; i++) {
            System.out.print(i + ",");
        }
        showDoanhThu();
    }//GEN-LAST:event_cb_namItemStateChanged

    private void cb_ngayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_ngayItemStateChanged
        showDoanhThu();
    }//GEN-LAST:event_cb_ngayItemStateChanged

    private void cb_thangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_thangItemStateChanged
        showDoanhThu();
    }//GEN-LAST:event_cb_thangItemStateChanged

    private void lbl_tenbieudoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_tenbieudoMouseClicked

    }//GEN-LAST:event_lbl_tenbieudoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Combobox cb_nam;
    private swing.Combobox cb_ngay;
    private swing.Combobox cb_thang;
    private swing.Card chuatt;
    private swing.Card datt;
    private swing.Card doanhthunam;
    private swing.Card doanhthungay;
    private swing.Card doanhthuthang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_tenbieudo;
    private swing.PieChart pieChart1;
    // End of variables declaration//GEN-END:variables
}
