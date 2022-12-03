/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import models.NguoiDung;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author KimChi
 */
public class ExportNV {
    
    public static final int COLUMN_MA = 0;
    public static final int COLUMN_TEN = 1;
    public static final int COLUMN_EMAIL = 2;
    public static final int COLUMN_SDT = 3;
    public static final int COLUMN_DIACHI = 4;
    public static final int COLUMN_GIOITINH = 5;
    public static final int COLUMN_MATKHAU = 6;
    public static final int COLUMN_TRANGTHAI = 7;
    public static final int COLUMN_HINHANH = 8;
    public static final int COLUMN_CV = 9;
    
    public static void writeExcel(List<NguoiDung> list, String excelFilePath) throws IOException {
        Workbook workbook = getWorkbook(excelFilePath);
        Sheet sheet = workbook.createSheet("Khách hàng ");
        int rowIndex = 0;
        writeHeader(sheet, rowIndex);
        rowIndex++;

        for (NguoiDung x : list) {
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

        CellStyle cellStyle = createStyleHeader(sheet);

        Row row = sheet.createRow(rowIndex);

        Cell cell = row.createCell(COLUMN_MA);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Mã người dùng");

        cell = row.createCell(COLUMN_TEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tên người dùng");
        
        cell = row.createCell(COLUMN_EMAIL);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Email");
        
        cell = row.createCell(COLUMN_SDT);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số điện thoại");
        
        
        cell = row.createCell(COLUMN_DIACHI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Địa chỉ");

        cell = row.createCell(COLUMN_GIOITINH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Giới tính");
        
        cell = row.createCell(COLUMN_MATKHAU);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Mật khẩu");
        
        cell = row.createCell(COLUMN_TRANGTHAI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Trạng thái");
        
        cell = row.createCell(COLUMN_HINHANH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Hình ảnh");
        
        cell = row.createCell(COLUMN_CV);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Chức vụ");

    }

    private static void writeBook(NguoiDung n, Row row) {

        
        Cell cell = row.createCell(COLUMN_MA);
        cell.setCellValue(n.getMa());

        cell = row.createCell(COLUMN_TEN);
        cell.setCellValue(n.getTen());
        
        cell = row.createCell(COLUMN_EMAIL);
        cell.setCellValue(n.getEmail());
        
        cell = row.createCell(COLUMN_SDT);
        cell.setCellValue(n.getSdt());

        cell = row.createCell(COLUMN_DIACHI);
        cell.setCellValue(n.getDiaChi());

        cell = row.createCell(COLUMN_GIOITINH);
       if (n.getGioiTinh() == 0) {
            cell.setCellValue("Nam");
        } else {
            cell.setCellValue("Nữ");
        }

        cell = row.createCell(COLUMN_MATKHAU);
        cell.setCellValue(n.getMatKhau());
        
        cell = row.createCell(COLUMN_TRANGTHAI);
         if (n.getGioiTinh() == 0) {
            cell.setCellValue("Đang làm");
        } else {
            cell.setCellValue("Đã nghỉ");
        }
         
        cell = row.createCell(COLUMN_HINHANH);
        cell.setCellValue(n.getHinhAnh()); 
        
        cell = row.createCell(COLUMN_CV);
        cell.setCellValue(n.getChucVu().getTen());

    }

    // Create CellStyle for header
    private static CellStyle createStyleHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
//        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 13); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
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


