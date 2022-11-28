package views;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.MauSac;
import services.IMauSacService;
import services.impl.MauSacService;
import swing.Table;
import ui.EventPagination;
import ui.NotificationMess;
import ui.Page;
import ui.PaginationItemRenderStyle1;
import utilities.Helper;

/**
 *
 * @author dell
 */
public class FrmMauSac extends javax.swing.JPanel {

    private IMauSacService iMauSacService;
    private DefaultTableModel dtm;
    private Helper helper;
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    private Page pg = new Page();
    Integer limit = 2;
    Integer totalData = 0;

    /**
     * Creates new form FrmSizeOK
     */
    public FrmMauSac() {
        initComponents();
        iMauSacService = new MauSacService();
        helper = new Helper();
        pagination(txt_search.getText());
        pagination1.setPagegination(1, pg.getTotalPage());
        pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());
        Table.apply(jScrollPane1, Table.TableType.MULTI_LINE);
    }

    public void pagination(String ten) {
        totalData = iMauSacService.findByName(ten).size();
        int totalPage = (int) Math.ceil(totalData.doubleValue() / limit);
        pg.setTotalPage(totalPage);
        pagination1.setPagegination(1, pg.getTotalPage());
        loadToTable(iMauSacService.pagination(1, limit, ten));
        clear();
        pagination1.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                loadToTable(iMauSacService.pagination(page, limit, ten));
            }
        });
    }

    public void clear() {
        txt_Ma.setText("");
        txt_Ten.setText("");
        rd_DangKinhDoanh.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txt_Ma = new swing.TextField();
        rd_DangKinhDoanh = new swing.RadioButtonCustom();
        rd_NgungKinhDoanh = new swing.RadioButtonCustom();
        btn_update = new swing.Button();
        btn_add = new swing.Button();
        txt_search = new swing.TextField();
        txt_Ten = new swing.TextField();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pagination1 = new swing.Pagination();

        setBackground(new java.awt.Color(255, 255, 255));

        txt_Ma.setEditable(false);
        txt_Ma.setToolTipText("");
        txt_Ma.setLabelText("Mã :");

        buttonGroup1.add(rd_DangKinhDoanh);
        rd_DangKinhDoanh.setSelected(true);
        rd_DangKinhDoanh.setText("Đang kinh doanh");

        buttonGroup1.add(rd_NgungKinhDoanh);
        rd_NgungKinhDoanh.setText("Ngừng kinh doanh");

        btn_update.setText("Cập nhật");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        txt_search.setLabelText("Search");
        txt_search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_searchCaretUpdate(evt);
            }
        });

        txt_Ten.setToolTipText("");
        txt_Ten.setLabelText("Tên :");
        txt_Ten.setName(""); // NOI18N

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Ngày thêm", "Ngày sửa cuối", "Trạng thái"
            }
        ));
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("MÀU SẮC");

        jPanel1.setBackground(new java.awt.Color(153, 51, 255));

        pagination1.setBackground(new java.awt.Color(153, 51, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_search, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rd_NgungKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_DangKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rd_DangKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rd_NgungKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        int row = tblBang.getSelectedRow();
        if (row == -1) {
            NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.WARNING, NotificationMess.Location.TOP_CENTER, "Chọn 1 dòng màu sắc để cập nhật");
            panel.showNotification();
            return;
        }
        MauSac m = iMauSacService.getObj(tblBang.getValueAt(row, 0).toString());
        if (checkNull()) {
            return;
        }
        m.setTen(txt_Ten.getText());
        m.setNgaySuaCuoi(new Date());
        if (rd_DangKinhDoanh.isSelected()) {
            m.setTrangThai(0);
        } else {
            m.setTrangThai(1);
        }
        iMauSacService.save(m);
        pagination(txt_search.getText());
        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Cập nhật thành công!");
        panel.showNotification();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        MauSac m = new MauSac();
        if (checkNull()) {
            return;
        }
        String result;
        for (int i = 0; i < iMauSacService.getAll().size() + 1; i++) {
            result = "MS" + i;
            if (iMauSacService.getObj(result) == null) {
                m.setMa(result);
                break;
            } else {
                continue;
            }
        }

        m.setTen(txt_Ten.getText());
        m.setNgayThem(new Date());
        m.setNgaySuaCuoi(new Date());
        if (rd_DangKinhDoanh.isSelected()) {
            m.setTrangThai(0);
        } else {
            m.setTrangThai(1);
        }
        iMauSacService.save(m);
        pagination(txt_search.getText());
        NotificationMess panel = new NotificationMess(new FrmHome(), NotificationMess.Type.SUCCESS, NotificationMess.Location.TOP_CENTER, "Thêm thành công!");
        panel.showNotification();


    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_searchCaretUpdate
        // TODO add your handling code here:
        pagination(txt_search.getText());
    }//GEN-LAST:event_txt_searchCaretUpdate

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        // TODO add your handling code here:
        int row = tblBang.getSelectedRow();
        MauSac m = iMauSacService.getObj((String) tblBang.getValueAt(row, 0));
        txt_Ma.setText(m.getMa());
        txt_Ten.setText(m.getTen());
        rd_DangKinhDoanh.setSelected(m.getTrangThai() == 0);
        rd_NgungKinhDoanh.setSelected(m.getTrangThai() == 1);
    }//GEN-LAST:event_tblBangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_add;
    private swing.Button btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.Pagination pagination1;
    private swing.RadioButtonCustom rd_DangKinhDoanh;
    private swing.RadioButtonCustom rd_NgungKinhDoanh;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tblBang;
    private swing.TextField txt_Ma;
    private swing.TextField txt_Ten;
    private swing.TextField txt_search;
    // End of variables declaration//GEN-END:variables
    private void loadToTable(List<MauSac> list) {
        dtm = (DefaultTableModel) tblBang.getModel();
        dtm.setRowCount(0);
        for (MauSac x : list) {
            dtm.addRow(new Object[]{
                x.getMa(),
                x.getTen(),
                format.format(x.getNgayThem()),
                format.format(x.getNgaySuaCuoi()),
                x.getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh"
            });
        }
    }

    private boolean checkNull() {
        if (helper.checkNull(txt_Ten, "Tên")
                || helper.checkRegex(txt_Ten, "(\\S+ )*\\S+", "Tên không hợp lệ!")) {
            return true;
        }
        return false;

    }
}
