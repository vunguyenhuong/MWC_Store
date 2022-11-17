package utilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class ExportPDFUltil {

    public static void main(String[] args) {
        // tạo một document
        Document document = new Document();
        PdfPTable t = new PdfPTable(4);
        LineSeparator sep = new LineSeparator();
        Phrase phrase = new Phrase();
        sep.setOffset(5);

        // font size
        Font fontSize_18 = FontFactory.getFont(FontFactory.TIMES, 18f);

        Paragraph paragraph1 = new Paragraph("MWC STORE", fontSize_18);
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        phrase.add(sep);

        try {
            // khởi tạo một PdfWriter truyền vào document và FileOutputStream
            PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));

            // mở file để thực hiện viết
            document.open();
//            // thêm nội dung sử dụng add function
////            document.add(new Paragraph("A Hello World PDF document."));
              document.add(paragraph1);
//              document.add(sep);
//            // đóng file
            t.setSpacingBefore(25);
            t.setSpacingAfter(25);

            PdfPCell c1 = new PdfPCell(new Phrase("Tên sản phẩm"));
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Số lượng"));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Đơn giá"));
            t.addCell(c3);
            PdfPCell c4 = new PdfPCell(new Phrase("Thành tiền"));
            t.addCell(c4);

            t.addCell("Sandard");
            t.addCell("2");
            t.addCell("2500");
            t.addCell("5000");

            document.add(t);
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
