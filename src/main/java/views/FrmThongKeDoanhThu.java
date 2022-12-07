package views;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import services.IHoaDonCTService;
import services.IHoaDonService;
import services.impl.HoaDonCTService;
import services.impl.HoaDonService;
import swing.ModelChart;
import swing.ModelPieChart;
import swing.PieChart;
import swing.Table;
import ui.ModelCard;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class FrmThongKeDoanhThu extends javax.swing.JPanel {

    private IHoaDonService iHoaDonService = new HoaDonService();
    private IHoaDonCTService iHoaDonCTService = new HoaDonCTService();
    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel comboNgay;
    private DefaultComboBoxModel comboThang;
    private DefaultComboBoxModel comboNam;
    private Calendar calendar = Calendar.getInstance();
    Random obj = new Random();

    public FrmThongKeDoanhThu() {
        initComponents();
        chuatt.setData(new ModelCard("HD chưa thanh toán", iHoaDonService.getByTT(0).size(), new ImageIcon(getClass().getResource("/icons/bill.png"))));
        datt.setData(new ModelCard("HD đã thanh toán", iHoaDonService.getByTT(1).size(), new ImageIcon(getClass().getResource("/icons/paidbill.png"))));
        addYear();
        comboNam = (DefaultComboBoxModel) cb_nam.getModel();
        comboThang = (DefaultComboBoxModel) cb_thang.getModel();
        comboNgay = (DefaultComboBoxModel) cb_ngay.getModel();
        comboNgay.setSelectedItem(calendar.get(Calendar.DATE));
        comboThang.setSelectedItem(calendar.get(Calendar.MONTH) + 1);
        comboNam.setSelectedItem(calendar.get(Calendar.YEAR));
        Table.apply(jScrollPane1, Table.TableType.DEFAULT);
        loadDoanhThu();
        curveLineChart1.setTitle("Chi tiết doanh thu theo năm");
        curveLineChart1.addLegend(String.valueOf(calendar.get(Calendar.YEAR) - 2), Color.decode("#0099F7"), Color.decode("#F11712"));
        curveLineChart1.addLegend(String.valueOf(calendar.get(Calendar.YEAR) - 1), Color.decode("#e65c00"), Color.decode("#F9D423"));
        curveLineChart1.addLegend(String.valueOf(calendar.get(Calendar.YEAR)), Color.decode("#7b4397"), Color.decode("#dc2430"));
        chartDoanhThu();
        curveLineChart1.start();
    }

    private void addYear() {
        comboNam = (DefaultComboBoxModel) cb_nam.getModel();
        comboNam.removeAllElements();
        for (int i = 0; i <= 11; i++) {
            comboNam.addElement(calendar.get(Calendar.YEAR) - 6 + i);
        }
    }

    private void chartDoanhThu() {
        BigDecimal year = null;
        BigDecimal currentYear = null;
        BigDecimal currentYear1 = null;
        curveLineChart1.clear();
        for (int i = 1; i <= 12; i++) {
            year = iHoaDonService.doanhThuTheoThang(i, calendar.get(Calendar.YEAR));
            currentYear = iHoaDonService.doanhThuTheoThang(i, calendar.get(Calendar.YEAR) - 1);
            currentYear1 = iHoaDonService.doanhThuTheoThang(i, calendar.get(Calendar.YEAR) - 2);
            curveLineChart1.addData(new ModelChart("T " + i, new double[]{currentYear1 == null ? 0.0 : currentYear1.doubleValue(), currentYear == null ? 0.0 : currentYear.doubleValue(), year == null ? 0.0 : year.doubleValue()}));
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
        doanhthungay.setData(new ModelCard("Doanh thu ngày " + date, doanhthuNgay == null ? 0 : doanhthuNgay.doubleValue(), new ImageIcon(getClass().getResource("/icons/day.png"))));
        doanhthuthang.setData(new ModelCard("Doanh thu tháng " + thang + "/" + nam, doanhThuThang == null ? 0 : doanhThuThang.doubleValue(), new ImageIcon(getClass().getResource("/icons/month.png"))));
        for (int i = 1; i <= 12; i++) {
            doanhThu12Thang = iHoaDonService.doanhThuTheoThang(i, Integer.parseInt(comboNam.getSelectedItem().toString()));
            doanhThuNam += doanhThu12Thang == null ? 0 : doanhThu12Thang.doubleValue();
            doanhthunam.setData(new ModelCard("Doanh thu năm " + nam, doanhThuNam == null ? 0 : doanhThuNam.doubleValue(), new ImageIcon(getClass().getResource("/icons/year.png"))));
        }
    }

    private void loadDoanhThu() {
        BigDecimal doanhThu12Thang = null;
        defaultTableModel = (DefaultTableModel) tb_chitietdoanhthu.getModel();
        defaultTableModel.setRowCount(0);
        for (int i = 1; i <= 12; i++) {
            defaultTableModel.addRow(new Object[]{
                "Tháng " + i, doanhThu12Thang = iHoaDonService.doanhThuTheoThang(i, Integer.parseInt(comboNam.getSelectedItem().toString()))
            });
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
        cb_nam = new swing.Combobox();
        cb_thang = new swing.Combobox();
        cb_ngay = new swing.Combobox();
        doanhthuthang = new swing.Card();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_chitietdoanhthu = new javax.swing.JTable();
        lbl_chitietdoanhthu = new javax.swing.JLabel();
        button1 = new swing.Button();
        jPanel1 = new javax.swing.JPanel();
        panelShadow1 = new swing.PanelShadow();
        curveLineChart1 = new swing.CurveLineChart();

        setBackground(new java.awt.Color(255, 255, 255));

        doanhthunam.setBackground(new java.awt.Color(153, 0, 255));
        doanhthunam.setColorGradient(new java.awt.Color(0, 0, 153));

        doanhthungay.setColorGradient(new java.awt.Color(211, 28, 215));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Thống kê / Doanh thu");

        chuatt.setBackground(new java.awt.Color(10, 30, 214));
        chuatt.setColorGradient(new java.awt.Color(0, 153, 255));

        datt.setBackground(new java.awt.Color(194, 85, 1));
        datt.setColorGradient(new java.awt.Color(255, 212, 99));

        cb_nam.setLabeText("Năm");
        cb_nam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_namItemStateChanged(evt);
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

        doanhthuthang.setBackground(new java.awt.Color(0, 102, 51));
        doanhthuthang.setColorGradient(new java.awt.Color(0, 255, 51));

        tb_chitietdoanhthu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tháng", "Doanh thu"
            }
        ));
        jScrollPane1.setViewportView(tb_chitietdoanhthu);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lbl_chitietdoanhthu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_chitietdoanhthu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_chitietdoanhthu.setText("Chi tiết doanh thu năm 2022");

        button1.setBackground(new java.awt.Color(0, 102, 102));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Biểu đồ cột");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelShadow1.setBackground(new java.awt.Color(34, 59, 69));
        panelShadow1.setColorGradient(new java.awt.Color(17, 38, 47));

        curveLineChart1.setForeground(new java.awt.Color(237, 237, 237));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(curveLineChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(curveLineChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(chuatt, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datt, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doanhthungay, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(doanhthuthang, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doanhthunam, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addComponent(lbl_chitietdoanhthu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {button1, cb_nam, cb_ngay, cb_thang});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doanhthunam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(doanhthuthang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_chitietdoanhthu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chuatt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doanhthungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {button1, cb_nam, cb_ngay, cb_thang});

    }// </editor-fold>//GEN-END:initComponents

    private void cb_namItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_namItemStateChanged
        showDoanhThu();
        loadDoanhThu();
        lbl_chitietdoanhthu.setText("Doanh thu từng tháng năm " + cb_nam.getSelectedItem());
    }//GEN-LAST:event_cb_namItemStateChanged

    private void cb_ngayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_ngayItemStateChanged
        showDoanhThu();
    }//GEN-LAST:event_cb_ngayItemStateChanged

    private void cb_thangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_thangItemStateChanged
        showDoanhThu();
    }//GEN-LAST:event_cb_thangItemStateChanged

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        new ChartDoanhThu1(Integer.parseInt(cb_nam.getSelectedItem().toString())).setVisible(true);
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button button1;
    private swing.Combobox cb_nam;
    private swing.Combobox cb_ngay;
    private swing.Combobox cb_thang;
    private swing.Card chuatt;
    private swing.CurveLineChart curveLineChart1;
    private swing.Card datt;
    private swing.Card doanhthunam;
    private swing.Card doanhthungay;
    private swing.Card doanhthuthang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_chitietdoanhthu;
    private swing.PanelShadow panelShadow1;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tb_chitietdoanhthu;
    // End of variables declaration//GEN-END:variables
}
