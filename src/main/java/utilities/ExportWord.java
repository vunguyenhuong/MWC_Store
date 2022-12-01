package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import models.HoaDon;
import models.HoaDonChiTiet;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import services.IHoaDonCTService;
import services.IHoaDonService;
import services.impl.HoaDonCTService;
import services.impl.HoaDonService;
import swing.TextField;

/**
 *
 * @author homna
 */
public class ExportWord {

    public static IHoaDonService hoaDonService = new HoaDonService();

    public void ExportToWord(HoaDon hd, Double giamGia, Double khachDua, Double traKhach) {
        DecimalFormat df = new DecimalFormat("###,###,###");
        // Create Blank document
        IHoaDonCTService hoadonctservice = new HoaDonCTService();
        XWPFDocument document = new XWPFDocument();
        String maHd = hd.getMa();
        String soLuongSp;
        String tenSp;
        String giaBan;
        double tongTien = 0;
        for (HoaDonChiTiet hoaDonChiTiet : hoadonctservice.findByMa(maHd)) {
            tongTien += (Double.parseDouble(String.valueOf(hoaDonChiTiet.getSoLuong())) * Double.valueOf(String.valueOf(hoaDonChiTiet.getDonGia())));
        }
//        double TongTien = Double.parseDouble(soTienPhaiTra1) + (Double.parseDouble(tongTien) / 100 * Double.parseDouble(khuyenMai)) + (Double.parseDouble(diemTichLuy)*1000) ;
        // Create new Paragraph
        // tiêu đề
        XWPFParagraph ParagraphTitle = document.createParagraph();
        ParagraphTitle.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun runLogo = ParagraphTitle.createRun();
        runLogo.setFontSize(36);
        runLogo.setBold(true);
        runLogo.setFontFamily("Sitka Small");
        runLogo.setText("MWC STORE");
        runLogo.addBreak();

        XWPFRun Unicode1 = ParagraphTitle.createRun();
        Unicode1.setFontFamily("Wingdings");
        Unicode1.setText("");
        XWPFRun runDiaChi = ParagraphTitle.createRun();
        runDiaChi.setFontSize(12);
        runDiaChi.setFontFamily("sansserif");
        runDiaChi.setText("phố Trịnh Văn Bô, phường Phương Canh, quận Nam Từ Liêm, TP.Hà Nội");
        runDiaChi.addBreak();

        XWPFRun Unicode2 = ParagraphTitle.createRun();
        Unicode2.setFontFamily("Wingdings");
        Unicode2.setText("");
        XWPFRun runEmail = ParagraphTitle.createRun();
        runEmail.setFontSize(12);
        runEmail.setFontFamily("sansserif");
        runEmail.setText("E-mail: reset.mwcstore@gmail.com");
        runEmail.addBreak();

        XWPFRun Unicode3 = ParagraphTitle.createRun();
        Unicode3.setFontFamily("Wingdings");
        Unicode3.setText("");
        XWPFRun runTel = ParagraphTitle.createRun();
        runTel.setFontSize(12);
        runTel.setFontFamily("sansserif");
        runTel.setText("Tel: 0348 079 278");
        runTel.addBreak();
        runTel.addBreak();

        XWPFRun runTile = ParagraphTitle.createRun();
        runTile.setFontSize(26);
        runTile.setBold(true);
        runTile.setFontFamily("Sitka Text Semibold");
        runTile.setText("PHIẾU THANH TOÁN");

        // thoi gian
        XWPFParagraph ParagraphLeft = document.createParagraph();
        ParagraphLeft.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun runNgay = ParagraphLeft.createRun();
        runNgay.setFontSize(14);
        runNgay.setFontFamily("Times New Roman");
        String ngayTao = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss").format(new Date());
        runNgay.setText("Ngày mua:     ");
        runNgay.setText(ngayTao);
        runNgay.addTab();
        runNgay.addTab();
        String tenNhanVien = hd.getNguoiDungTT().getTen();
        runNgay.setText("       Thu ngân:  ");
        runNgay.setText(tenNhanVien);
        runNgay.addBreak();

        runNgay.setText("Khách hàng:  ");
        String tenKh = hd.getKhachHang() == null ? "Khách lẻ" : hd.getKhachHang().getTen();
        runNgay.setText(tenKh);
        runNgay.addTab();
        runNgay.addTab();
        runNgay.addTab();
        runNgay.addTab();
        runNgay.addTab();
        runNgay.setText("Mã HĐ:     " + maHd);
        runNgay.addBreak();

        XWPFRun colum = ParagraphLeft.createRun();
        colum.setBold(true);
        colum.setFontFamily("Calibri");
        colum.setFontSize(20);
        colum.addTab();
        colum.setText("Tên SP");
        colum.addTab();
        colum.addTab();
        colum.addTab();
        colum.setText("SL");
        colum.addTab();
        colum.addTab();
        colum.setText("Đ.Giá");
        colum.addTab();
        colum.addTab();
        colum.setText("T.Tiền");
        colum.addBreak();
        XWPFRun ke1 = ParagraphLeft.createRun();
        ke1.setFontSize(20);
        ke1.setText("_____________________________________________");
        ke1.addBreak();
        XWPFRun sp = ParagraphLeft.createRun();
        sp.setFontFamily("Calibri");
        sp.setFontSize(15);
        for (HoaDonChiTiet x : hoadonctservice.findByMa(maHd)) {
            tenSp = x.getCtdep().getDep().getTen();
            soLuongSp = String.valueOf(x.getSoLuong());
            giaBan = String.valueOf(x.getDonGia());
            sp.setText(tenSp);
            sp.addTab();
            sp.addTab();
            sp.addTab();
            sp.setText(soLuongSp);
            sp.addTab();
            sp.addTab();
            sp.setText(giaBan);
            sp.addTab();
            sp.addTab();
            sp.addTab();
            Double gia = Double.parseDouble(soLuongSp) * Double.parseDouble(giaBan);
            sp.setText(String.valueOf(df.format(gia)));
            sp.addBreak();
        }
        XWPFRun ke = ParagraphLeft.createRun();
        ke.setFontSize(15);
        ke.setText("____________________________________________________________");
        ke.addBreak();
        ke.setText("Tổng tiền:");
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.setText(String.valueOf(df.format(tongTien)));
        ke.addBreak();
        ke.setText("Giảm giá:");
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.addTab();
        ke.setText(String.valueOf(df.format(giamGia)));
        ke.addBreak();
        XWPFRun thanhtoan = ParagraphLeft.createRun();
        thanhtoan.setFontSize(20);
        thanhtoan.setFontFamily("Mongolian Baiti");
        thanhtoan.setBold(true);
        thanhtoan.setText("Tiền thanh toán:");
        thanhtoan.addTab();
        thanhtoan.addTab();
        thanhtoan.addTab();
        thanhtoan.addTab();
        thanhtoan.addTab();
        thanhtoan.addTab();
        thanhtoan.addTab();
        Double thanhTien = tongTien - giamGia;
        thanhtoan.setText(String.valueOf(df.format(thanhTien)));
        XWPFRun cuoitrang = ParagraphLeft.createRun();
        cuoitrang.setFontSize(15);
        cuoitrang.addBreak();
        cuoitrang.setText("Khách đưa:");
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.setText(String.valueOf(df.format(khachDua)));
        cuoitrang.addBreak();
        cuoitrang.setText("Trả khách:");
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.addTab();
        cuoitrang.setText(String.valueOf(df.format(traKhach)));

        XWPFParagraph ParagraphCamOn = document.createParagraph();
        ParagraphCamOn.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun Camon = ParagraphCamOn.createRun();
        Camon.setFontFamily("Cambria");
        Camon.setFontSize(20);
        Camon.addBreak();
        Camon.setText("Cảm ơn Quý khách. Hẹn gặp lại !");
        // Write the Document in file system
        // xuất file ra word
        try {
            FileOutputStream out = new FileOutputStream(new File("ExportHoaDon/HoaDon" + maHd + ".docx"));
            document.write(out);
            out.close();
            document.close();
            System.out.println("thành công");
        } catch (FileNotFoundException ex) {
            System.out.println("trung ten File dang mo");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Lỗi bình thường nhưng nhân 2");
            ex.printStackTrace();
        }

    }
}
