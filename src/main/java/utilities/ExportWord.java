/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.HoaDon;
import models.HoaDonChiTiet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import services.IHoaDonCTService;
import services.IHoaDonService;
import services.impl.HoaDonCTService;
import services.impl.HoaDonService;

/**
 *
 * @author homna
 */
public class ExportWord {

    public static IHoaDonService hoaDonService = new HoaDonService();

    public static void main(String[] args) {
        ExportToWord(hoaDonService.getObj("HD12"));
    }

    public static void ExportToWord(HoaDon hd) {
        // Create Blank document
        IHoaDonCTService hoadonctservice = new HoaDonCTService();
        XWPFDocument document = new XWPFDocument();
        
        String maHd = hd.getMa();
        String soLuongSp;
        String tenSp;
        String giaBan;
        String tenNhanVien = hd.getNguoiDung().getTen();
        String ngayTao = hd.getNgayTao().toString();
        String ngayThanhToan = hd.getNgayThanhToan() == null ? "Hoá đơn chưa thanh toán" : hd.getNgayThanhToan().toString();
//        String soTienPhaiTra = hd.getTongTien() == null ? "0" : hd.getTongTien().toString();
        String tenKh = hd.getKhachHang() == null ? "Khách hàng lẻ" : hd.getKhachHang().getTen();
        String diaChi = hd.getKhachHang() == null ? "" : hd.getKhachHang().getDiaChi();
        String sodt = hd.getKhachHang() == null ? "" : hd.getKhachHang().getSoDt();
        String khuyenMai = hd.getKhuyenMai() == null ? "0" : hd.getKhuyenMai().getPhantramgiam().toString();
        String tenKhuyenMai = hd.getKhuyenMai() == null ? "" : hd.getKhuyenMai().getTen();
        String diemTichLuy = String.valueOf(hd.getDiemTichLuy());
        String trangThai = "Chua thanh toan";
        double tongTien = 0;
        for (HoaDonChiTiet hoaDonChiTiet : hoadonctservice.findByMa(maHd)) {
            tongTien += (Double.parseDouble(String.valueOf(hoaDonChiTiet.getSoLuong())) * Double.valueOf(String.valueOf(hoaDonChiTiet.getDonGia())));
        }
//        double TongTien = Double.parseDouble(soTienPhaiTra1) + (Double.parseDouble(tongTien) / 100 * Double.parseDouble(khuyenMai)) + (Double.parseDouble(diemTichLuy)*1000) ;
        if (hd.getTrangThai() == 1) {
            trangThai = "da thanh toan";
        }
        if (hd.getTrangThai() == 2) {
            trangThai = "da huy";
        }
        double giamGia = (tongTien / 100 * Double.parseDouble(khuyenMai)) + (Double.parseDouble(diemTichLuy)*1000);
        double soTienPhaiTra = tongTien - giamGia;
        

        // Create new Paragraph
        
        // tiêu đề
        XWPFParagraph ParagraphTitle = document.createParagraph();
        XWPFRun runTitle = ParagraphTitle.createRun();
        XWPFRun runTitleContent = ParagraphTitle.createRun();
        XWPFRun runTitleContentTop = ParagraphTitle.createRun();
        
        ParagraphTitle.setAlignment(ParagraphAlignment.CENTER);
        
        runTitle.setText("MWC STORE");
        runTitle.addBreak();
        runTitle.setFontSize(40);
        runTitle.setBold(true);
        runTitle.setFontFamily("Courier");
        
        runTitleContent.setFontSize(18);
        runTitleContent.addBreak();
        runTitleContent.setText("Địa chỉ: Xuân Phương, Nam Từ Liêm, Hà Nội");
        runTitleContent.addBreak();
        runTitleContent.setText("Hotline: 0348 079 278");
        
        runTitleContentTop.addBreak();
        runTitleContentTop.addBreak();
        runTitleContentTop.setText("HOÁ ĐƠN BÁN HÀNG");
        runTitleContentTop.setFontSize(40);
        runTitleContentTop.setBold(true);
        runTitleContentTop.setFontFamily("Courier");
        runTitleContentTop.addBreak();

        // nội dung
        XWPFParagraph Paragraph = document.createParagraph();
        XWPFRun run = Paragraph.createRun();

        run.setFontSize(15);
        run.addBreak();
        run.setText("Ngày tạo: " + ngayTao);
        
        run.addBreak();
        run.setText("Ngày thanh toán: " + ngayThanhToan);
        
        run.addBreak();
        run.setText("Trang thai hoa don: " + trangThai);
        
        run.addBreak();
        run.setText("Nhân viên thanh toán: " + tenNhanVien);

        run.addBreak();
        run.addBreak();
        run.setText("Khách hàng: " + tenKh);
        
        run.addBreak();
        run.addBreak();
        run.setText("Địa chỉ: " + diaChi);

        run.addBreak();
        run.addBreak();
        run.setText("Số điện thoại: " + sodt);

        for (HoaDonChiTiet hoaDonChiTiet : hoadonctservice.findByMa(maHd)) {
            tenSp = hoaDonChiTiet.getCtdep().getDep().getTen();
            soLuongSp = String.valueOf(hoaDonChiTiet.getSoLuong());
            giaBan = String.valueOf(hoaDonChiTiet.getDonGia());
            run.addBreak();
            run.addBreak();
            run.setText("tên sản phẩm: " + tenSp);

            run.addBreak();
            run.addTab();
            run.setText(" " + soLuongSp + " X " + giaBan + " = " + Double.parseDouble(soLuongSp)*Double.parseDouble(giaBan));
        }
        
        run.addBreak();
        run.addBreak();
        run.addBreak();
        run.setText("Tổng tiền: " + tongTien);
        
        run.addBreak();
        run.addBreak();
        run.setText("Giảm Giá: " + giamGia);
        
        run.addBreak();
        run.addBreak();
        run.setText("Số tiền phải trả: " + soTienPhaiTra);

        // Write the Document in file system
        // xuất file ra word
        try {
            FileOutputStream out = new FileOutputStream(new File("HoaDon" + maHd + ".docx"));
            document.write(out);
            out.close();
            document.close();
            System.out.println("thành công");
        } catch (FileNotFoundException ex) {
            System.out.println("Lỗi bình thường");
        } catch (IOException ex) {
            System.out.println("Lỗi bình thường nhưng nhân 2");
        }

    }
}
