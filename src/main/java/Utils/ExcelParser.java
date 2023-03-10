package Utils;

import model.Property;
import model.PropertyType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelParser {

    public static ArrayList<Property> parseExcel(File excelFile) throws IOException {
        ArrayList<Property> properties = new ArrayList<>();
        try(FileInputStream inputStream = new FileInputStream(excelFile);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            boolean isFirstRow = true;

            main: for (Row currentRow : sheet) {
                Property currentProperty = new Property();
                List<String> fields = new ArrayList<>();
                ArrayList<String> columnNames = new ArrayList<>();

                if (isFirstRow) {
                    for (Cell currentCell1 : currentRow) {
                        columnNames.add(currentCell1.);
                        isFirstRow = false;
                        continue main;
                    }
                }

                for (Cell currentCell2 : currentRow) {
                    fields.add(currentCell2.getStringCellValue());
                }

                if (!checkColumnNamesAndOrder(columnNames)) {
                    System.out.println("check not passed");
                    break;
                }

                currentProperty.setExternalID(Long.parseLong(fields.get(0)));
                currentProperty.setType(PropertyType.valueOf(fields.get(1).toUpperCase()));
                currentProperty.setPrice(Integer.parseInt(fields.get(2)));
                currentProperty.setCity(fields.get(3));
                currentProperty.setDistrict(fields.get(4));
                currentProperty.setNeighborhood(fields.get(5));

                properties.add(currentProperty);
            }
        }
        return properties;
    }

    private static boolean checkColumnNamesAndOrder(List<String> columnNames) {
        String[] currentNames = new String[6];
        columnNames.toArray(currentNames);
        System.out.println(Arrays.toString(currentNames));
        String[] expectedNamesAndOrder = new String[] {"id", "type", "price", "city", "district", "neighborhood"};
        return Arrays.equals(currentNames, expectedNamesAndOrder);
    }
}
