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

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repositories.ChatLieuRepository;
import repositories.ChiTietDepRepository;
import repositories.DepRepository;
import repositories.LoaiDepRepository;
import repositories.MauSacRepository;
import repositories.NhaSXRepository;
import repositories.SizeRepository;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class ImportSP {

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

    private static ChiTietDepRepository repo = new ChiTietDepRepository();
    private static DepRepository depRepo = new DepRepository();
    private static LoaiDepRepository loaiDepRepo = new LoaiDepRepository();
    private static ChatLieuRepository chatLieuRepo = new ChatLieuRepository();
    private static MauSacRepository mauSacRepo = new MauSacRepository();
    private static SizeRepository sizeRepo = new SizeRepository();
    private static NhaSXRepository nsxRepo = new NhaSXRepository();

//    public static void main(String[] args) throws IOException {
//        final String excelFilePath = "D:\\Book1.xlsx";
//        final List<ChiTietDep> books = readExcel(excelFilePath);
//        for (ChiTietDep x : books) {
//            System.out.println(x);
//        }
//    }

    public static List<ChiTietDep> readExcel(String excelFilePath)throws IOException{
        Date date = new Date();
        List<ChiTietDep> list = new ArrayList<>();

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
            ChiTietDep ctd = new ChiTietDep();
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
                    case COLUMN_TEN:
                        ctd.setDep(depRepo.getObjById(new BigDecimal((double) cellValue).intValue()));
                        break;
                    case COLUMN_LOAI:
                        ctd.setLoaiDep(loaiDepRepo.getObjectById(new BigDecimal((double) cellValue).intValue()));
                        break;
                    case COLUMN_MAU:
                        ctd.setMauSac(mauSacRepo.getObjectById(new BigDecimal((double) cellValue).intValue()));
                        break;
                    case COLUMN_CHATLIEU:
                        ctd.setChatLieu(chatLieuRepo.getObjById(new BigDecimal((double) cellValue).intValue()));
                        break;
                    case COLUMN_NSX:
                        ctd.setNhaSX(nsxRepo.getObjById(new BigDecimal((double) cellValue).intValue()));
                        break;
                    case COLUMN_SIZE:
                        ctd.setSize(sizeRepo.getObjById(new BigDecimal((double) cellValue).intValue()));
                        break;
                    case COLUMN_MOTA:
                        ctd.setMoTa((String) getCellValue(cell));
                        break;
                    case COLUMN_SOLUONG:
                        ctd.setSoLuong(new BigDecimal((double) cellValue).intValue());
                        break;
                    case COLUMN_GIANHAP:
                        ctd.setGiaNhap(BigDecimal.valueOf((double) cellValue));
                        break;
                    case COLUMN_GIABAN:
                        ctd.setGiaBan(BigDecimal.valueOf((double) cellValue));
                        break;
                    case COLUMN_NGAYTHEM:
                        ctd.setNgayThem(date);
                        break;
                    case COLUMN_NGAYSUA:
                        ctd.setNgaySuaCuoi(date);
                        break;
                    case COLUMN_TRANGTHAI:
                        ctd.setTrangThai(new BigDecimal((double) cellValue).intValue());
                        break;
                    default:
                        break;
                }

            }
            list.add(ctd);
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
