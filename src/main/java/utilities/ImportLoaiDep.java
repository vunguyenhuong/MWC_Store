/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import models.KhachHang;
import models.LoaiDep;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static utilities.ImportKH.COLUMN_DIACHI;
import static utilities.ImportKH.COLUMN_DIEMTICHLUY;
import static utilities.ImportKH.COLUMN_MA;
import static utilities.ImportKH.COLUMN_SDT;
import static utilities.ImportKH.COLUMN_TEN;
import static utilities.ImportKH.COLUMN_TONGDIEMTICHLUY;

/**
 *
 * @author KimChi
 */
public class ImportLoaiDep {
    public static final int COLUMN_MA = 0;
    public static final int COLUMN_TEN = 1;
    public static final int COLUMN_NGAYTHEM = 2;
    public static final int COLUMN_NGAYSUACUOI = 3;
    public static final int COLUMN_TRANGTHAI = 4;
    
     private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case _NONE:
            case BLANK:
            case ERROR:
                break;
            default:
                break;
        }
        return cellValue;
    }


    public static List<LoaiDep> readExcel(String excelFilePath) throws IOException {
        List<LoaiDep> list = new ArrayList<>();
        Date date = new Date();
        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));

        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);

        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);

        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                // Ignore header
                continue;
            }

            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            // Read cells and set value for book object
            LoaiDep d = new LoaiDep();
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
                // Set value for book object
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case COLUMN_MA:
                        d.setMa((String) getCellValue(cell));
                        break;
                    case COLUMN_TEN:
                        d.setTen((String) getCellValue(cell));
                        break;
                    case COLUMN_NGAYTHEM:
                        d.setNgayThem(date);
                        break;
                    case COLUMN_NGAYSUACUOI:
                        d.setNgaySuaCuoi(date);
                        break;
                    case COLUMN_TRANGTHAI:
                        d.setTrangThai(new BigDecimal((double) cellValue).intValue());
                        break;
                    

                    default:
                        break;
                }

            }
            list.add(d);
        }
        workbook.close();
        inputStream.close();

        return list;

    }
}
