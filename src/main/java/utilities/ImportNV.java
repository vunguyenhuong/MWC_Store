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
import models.ChiTietDep;
import models.NguoiDung;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repositories.ChucVuRepository;
import static utilities.ImportSP.COLUMN_CHATLIEU;
import static utilities.ImportSP.COLUMN_GIABAN;
import static utilities.ImportSP.COLUMN_GIANHAP;
import static utilities.ImportSP.COLUMN_LOAI;
import static utilities.ImportSP.COLUMN_MAU;
import static utilities.ImportSP.COLUMN_MOTA;
import static utilities.ImportSP.COLUMN_NGAYSUA;
import static utilities.ImportSP.COLUMN_NGAYTHEM;
import static utilities.ImportSP.COLUMN_NSX;
import static utilities.ImportSP.COLUMN_SIZE;
import static utilities.ImportSP.COLUMN_SOLUONG;
import static utilities.ImportSP.COLUMN_TEN;
import static utilities.ImportSP.COLUMN_TRANGTHAI;

/**
 *
 * @author KimChi
 */
public class ImportNV {

    public static final int COLUMN_CV = 0;
    public static final int COLUMN_MA = 1;
    public static final int COLUMN_TEN = 2;
    public static final int COLUMN_EMAIL = 3;
    public static final int COLUMN_SDT = 4;
    public static final int COLUMN_DIACHI = 5;
    public static final int COLUMN_GIOITINH = 6;
    public static final int COLUMN_MATKHAU = 7;
    public static final int COLUMN_TRANGTHAI = 8;
    public static final int COLUMN_HINHANH = 9;

    private static ChucVuRepository repo = new ChucVuRepository();

    public static List<NguoiDung> readExcel(String excelFilePath) throws IOException {

        List<NguoiDung> list = new ArrayList<>();

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
            NguoiDung n = new NguoiDung();
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
                    case COLUMN_CV:
                        n.setChucVu(repo.getObjById(new BigDecimal((double) cellValue).intValue()));
                        break;
                    case COLUMN_MA:
                        n.setMa((String) getCellValue(cell));
                        break;
                    case COLUMN_TEN:
                        n.setTen((String) getCellValue(cell));
                        break;
                    case COLUMN_EMAIL:
                        n.setEmail((String) getCellValue(cell));
                        break;
                    case COLUMN_SDT:
                        n.setSdt((String) getCellValue(cell));
                        break;

                    case COLUMN_DIACHI:
                        n.setDiaChi((String) getCellValue(cell));
                        break;
                    case COLUMN_GIOITINH:
                        n.setGioiTinh(new BigDecimal((double) cellValue).intValue());
                        break;
                    case COLUMN_MATKHAU:
                        n.setMatKhau((String) getCellValue(cell));
                        break;
                    case COLUMN_TRANGTHAI:
                        n.setTrangThai(new BigDecimal((double) cellValue).intValue());
                        break;
                    case COLUMN_HINHANH:
                        n.setHinhAnh((String) getCellValue(cell));
                        break;

                    default:
                        break;
                }

            }
            list.add(n);
        }

        workbook.close();
        inputStream.close();

        return list;
    }

    // Get Workbook
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

    // Get cell value
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
}
