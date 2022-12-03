/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import models.KhachHang;
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
public class ExportKH {
    public static final int COLUMN_MA = 0;
    public static final int COLUMN_TEN = 1;
    public static final int COLUMN_SDT = 2;
    public static final int COLUMN_DIACHI = 3;
    public static final int COLUMN_DIEMTICHLUY = 4;
    public static final int COLUMN_TONGDIEMTICHLUY = 5;
    
    public static void writeExcel(List<KhachHang> list, String excelFilePath) throws IOException {
        Workbook workbook = getWorkbook(excelFilePath);
        Sheet sheet = workbook.createSheet("Khách hàng ");
        int rowIndex = 0;
        writeHeader(sheet, rowIndex);
        rowIndex++;

        for (KhachHang x : list) {
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
        cell.setCellValue("Mã KH");

        cell = row.createCell(COLUMN_TEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tên KH");

        cell = row.createCell(COLUMN_SDT);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số điện thoại");

        cell = row.createCell(COLUMN_DIACHI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Địa chỉ");

        cell = row.createCell(COLUMN_DIEMTICHLUY);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Điểm tích lũy");

        cell = row.createCell(COLUMN_TONGDIEMTICHLUY);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tổng điểm tích lũy");


    }

    private static void writeBook(KhachHang k, Row row) {

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Cell cell = row.createCell(COLUMN_MA);
        cell.setCellValue(k.getMa());

        cell = row.createCell(COLUMN_TEN);
        cell.setCellValue(k.getTen());

        cell = row.createCell(COLUMN_SDT);
        cell.setCellValue(k.getSoDt());

        cell = row.createCell(COLUMN_DIACHI);
        cell.setCellValue(k.getDiaChi());

        cell = row.createCell(COLUMN_DIEMTICHLUY);
        cell.setCellValue(k.getDiemTichLuy());

        cell = row.createCell(COLUMN_TONGDIEMTICHLUY);
        cell.setCellValue(k.getTongDiemTichLuy());

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
