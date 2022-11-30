package views;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import services.IHoaDonCTService;
import services.IHoaDonService;
import services.impl.HoaDonCTService;
import services.impl.HoaDonService;
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
        chartDoanhThu();
        lbl_tenbieudo.setText("BIỂU ĐỒ CƠ CẤU DOANH THU NĂM " + calendar.get(Calendar.YEAR));
        comboNam = (DefaultComboBoxModel) cb_nam.getModel();
        comboThang = (DefaultComboBoxModel) cb_thang.getModel();
        comboNgay = (DefaultComboBoxModel) cb_ngay.getModel();
        comboNgay.setSelectedItem(calendar.get(Calendar.DATE));
        comboThang.setSelectedItem(calendar.get(Calendar.MONTH) + 1);
        comboNam.setSelectedItem(calendar.get(Calendar.YEAR));
        Table.apply(jScrollPane1, Table.TableType.DEFAULT);
        loadDoanhThu();
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
            int rand_num = obj.nextInt(0xffffff + 1);
            String colorCode = String.format("#%06x", rand_num);
            bd = iHoaDonService.doanhThuTheoThang(i, Integer.parseInt(comboNam.getSelectedItem().toString()));
            pieChart1.addData(new ModelPieChart("Tháng " + i, bd == null ? 0 : bd.doubleValue(), Color.decode(colorCode)));
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
    
    private void loadDoanhThu(){
        BigDecimal doanhThu12Thang = null;
        defaultTableModel = (DefaultTableModel) tb_chitietdoanhthu.getModel(); 
        defaultTableModel.setRowCount(0);
        for (int i = 1; i <= 12; i++) {
            defaultTableModel.addRow(new Object[]{
                "Tháng "+i,doanhThu12Thang = iHoaDonService.doanhThuTheoThang(i, Integer.parseInt(comboNam.getSelectedItem().toString()))
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
        pieChart1 = new swing.PieChart();
        cb_nam = new swing.Combobox();
        lbl_tenbieudo = new javax.swing.JLabel();
        cb_thang = new swing.Combobox();
        cb_ngay = new swing.Combobox();
        doanhthuthang = new swing.Card();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_chitietdoanhthu = new javax.swing.JTable();
        lbl_chitietdoanhthu = new javax.swing.JLabel();

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
                            .addComponent(lbl_tenbieudo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(chuatt, javax.swing.GroupLayout.PREFERRED_SIZE, 129, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doanhthungay, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(doanhthuthang, javax.swing.GroupLayout.PREFERRED_SIZE, 183, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doanhthunam, javax.swing.GroupLayout.PREFERRED_SIZE, 184, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cb_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbl_chitietdoanhthu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_nam, cb_ngay, cb_thang});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doanhthunam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chuatt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doanhthungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(doanhthuthang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_tenbieudo))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_chitietdoanhthu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
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
        loadDoanhThu();
        lbl_chitietdoanhthu.setText("Chi tiết doanh thu năm "+cb_nam.getSelectedItem());
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_chitietdoanhthu;
    private javax.swing.JLabel lbl_tenbieudo;
    private swing.PieChart pieChart1;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tb_chitietdoanhthu;
    // End of variables declaration//GEN-END:variables
}
