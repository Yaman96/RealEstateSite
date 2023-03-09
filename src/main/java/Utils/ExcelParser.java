package Utils;

import model.Property;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelParser {

//    public static ArrayList<Property> parseExcel(File excelFile) throws IOException {
//        ArrayList<Property> properties = new ArrayList<>();
//        try(FileInputStream inputStream = new FileInputStream(excelFile);
//            XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
//            Sheet sheet = workbook.getSheetAt(0);
//            boolean isFirstRow = true;
//
//            for (Row currentRow : sheet) {
//
//                if (isFirstRow) {
//
//                }
//            }
//        }
//
//    }
}
