package utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import models.ChiTietDep;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class ExportSP {
    public static final int COLUMN_TEN = 0;
    public static final int COLUMN_LOAI = 1;
    public static final int COLUMN_MAU = 2;
    public static final int COLUMN_CHATLIEU = 3;
    public static final int COLUMN_NSX = 4;
    public static final int COLUMN_SIZE = 5;
    public static final int COLUMN_MOTA = 6;
    public static final int COLUMN_SOLUONG = 7;
    public static final int COLUMN_GIANHAP = 8;
    public static final int COLUMN_GIABAN = 9;
    public static final int COLUMN_NGAYTHEM = 10;
    public static final int COLUMN_NGAYSUA = 11;
    public static final int COLUMN_TRANGTHAI = 12;
    
    public static void writeExcel(List<ChiTietDep> list, String excelFilePath) throws IOException {
        Workbook workbook = getWorkbook(excelFilePath);
        Sheet sheet = workbook.createSheet("Chi tiết dép");
        int rowIndex = 0;
        writeHeader(sheet, rowIndex);
        rowIndex++;
        
        for (ChiTietDep x : list) {
            Row row = sheet.createRow(rowIndex);
            writeBook(x, row);
            rowIndex++;
        }

        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }
    
    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    // Write header with format
    private static void writeHeader(Sheet sheet, int rowIndex) {
        Row row = sheet.createRow(rowIndex);

        Cell cell = row.createCell(COLUMN_TEN);
        cell.setCellValue("Tên dép");

        cell = row.createCell(COLUMN_LOAI);
        cell.setCellValue("Loại dép");

        cell = row.createCell(COLUMN_MAU);
        cell.setCellValue("Màu sắc");

        cell = row.createCell(COLUMN_CHATLIEU);
        cell.setCellValue("Chất liệu");
        
        cell = row.createCell(COLUMN_NSX);
        cell.setCellValue("Nhà SX");
        
        cell = row.createCell(COLUMN_SIZE);
        cell.setCellValue("Size");
        
        cell = row.createCell(COLUMN_MOTA);
        cell.setCellValue("Mô tả");
        
        cell = row.createCell(COLUMN_SOLUONG);
        cell.setCellValue("Số lượng");
        
        cell = row.createCell(COLUMN_GIANHAP);
        cell.setCellValue("Giá nhập");
        
        cell = row.createCell(COLUMN_GIABAN);
        cell.setCellValue("Giá bán");
        
        cell = row.createCell(COLUMN_NGAYTHEM);
        cell.setCellValue("Ngày thêm");
        
        cell = row.createCell(COLUMN_NGAYSUA);
        cell.setCellValue("Ngày sửa");
        
        cell = row.createCell(COLUMN_TRANGTHAI);
        cell.setCellValue("Trạng thái");
        
    }

    private static void writeBook(ChiTietDep c, Row row) {

        Cell cell = row.createCell(COLUMN_TEN);
        cell.setCellValue(c.getDep().getTen());

        cell = row.createCell(COLUMN_LOAI);
        cell.setCellValue(c.getLoaiDep().getTen());

        cell = row.createCell(COLUMN_MAU);
        cell.setCellValue(c.getMauSac().getTen());

        cell = row.createCell(COLUMN_CHATLIEU);
        cell.setCellValue(c.getChatLieu().getTen());
        
        cell = row.createCell(COLUMN_NSX);
        cell.setCellValue(c.getNhaSX().getTen());
        
        cell = row.createCell(COLUMN_SIZE);
        cell.setCellValue(c.getSize().getKichCo());
        
        cell = row.createCell(COLUMN_MOTA);
        cell.setCellValue(c.getMoTa());
        
        cell = row.createCell(COLUMN_SOLUONG);
        cell.setCellValue(c.getSoLuong());
        
        cell = row.createCell(COLUMN_GIANHAP);
        cell.setCellValue(c.getGiaNhap().toString());
        
        cell = row.createCell(COLUMN_GIABAN);
        cell.setCellValue(c.getGiaBan().toString());
        
        cell = row.createCell(COLUMN_NGAYTHEM);
        cell.setCellValue(c.getNgayThem().toString());
        
        cell = row.createCell(COLUMN_NGAYSUA);
        cell.setCellValue(c.getNgaySuaCuoi().toString());
        
        cell = row.createCell(COLUMN_TRANGTHAI);
        if(c.getTrangThai()==0){
            cell.setCellValue("Đang kinh doanh");
        }else{
            cell.setCellValue("Ngừng kinh doanh");
        }
    }

    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try ( OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }
}
