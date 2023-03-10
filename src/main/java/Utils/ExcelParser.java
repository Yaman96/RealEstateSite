package Utils;

import Services.PropertyService;
import model.Property;
import model.PropertyType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.PropertyRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Component
public class ExcelParser {

    @Autowired
    private static PropertyService propertyService;

    @Autowired
    public ExcelParser() {
    }

    public static ArrayList<Property> parseExcel(File excelFile) throws IOException {
        ArrayList<Property> properties = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(excelFile);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);

            if (!checkExcelFileColumnOrder(workbook)) {
                System.out.println("Check columns. Order must be \"id\",\"type\",\"price\",\"city\",\"district\",\"neighborhood\"");
                return properties;
            }
            boolean isFirstRow = true;

            for (Row row : sheet) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                Property property = new Property();
                Iterator<Cell> cellIterator = row.iterator();

                property.setId((int)cellIterator.next().getNumericCellValue());
                property.setType(PropertyType.valueOf(cellIterator.next().getStringCellValue().toUpperCase()));
                property.setPrice((int)cellIterator.next().getNumericCellValue());
                property.setCity(cellIterator.next().getStringCellValue());
                property.setDistrict(cellIterator.next().getStringCellValue());
                property.setNeighborhood(cellIterator.next().getStringCellValue());

                properties.add(property);
            }

            System.out.println(checkExcelFileColumnOrder(workbook));
        }
        return properties;
    }

    private static boolean checkExcelFileColumnOrder(XSSFWorkbook workbook) {
        String[] expectedColumnNames = new String[] {"id","type","price","city","district","neighborhood"};
        String[] currentColumnNamesArray = new String[6];
        List<String> currentColumnNames = new ArrayList<>();

        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);

        for (Cell cell : row) {
            if (cell.getStringCellValue().isEmpty()) break;
            currentColumnNames.add(cell.getStringCellValue());
        }


        return Arrays.equals(expectedColumnNames,currentColumnNames.toArray(currentColumnNamesArray));
    }

    public static void addPropertiesFromExcel(File file) {

    }
}