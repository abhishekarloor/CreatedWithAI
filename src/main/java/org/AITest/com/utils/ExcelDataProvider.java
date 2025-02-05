package org.AITest.com.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataProvider {

    private static final String FILE_PATH = "src/test/resources/testdata/TestData.xlsx"; // Path to Excel file
    private static final String SHEET_NAME = "Login"; // Your sheet name

    @DataProvider(name = "ExcelData")
    public static Object[][] getTestData(Method method) throws IOException {
        String testCaseName = method.getName();  // Get the method name to filter test data dynamically
        return fetchDataForTestCase(FILE_PATH, SHEET_NAME, testCaseName);
    }

    private static Object[][] fetchDataForTestCase(String filePath, String sheetName, String testCaseName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        List<Object[]> dataList = new ArrayList<>();

        Iterator<Row> iterator = sheet.iterator();
        Row headerRow = iterator.next(); // First row is the header

        while (iterator.hasNext()) {
            Row row = iterator.next();
            Cell testCaseCell = row.getCell(0);

            if (testCaseCell.getStringCellValue().equalsIgnoreCase(testCaseName)) {
                int colCount = row.getLastCellNum();
                Object[] rowData = new Object[colCount - 1]; // Exclude first column (TestCase name)

                for (int i = 1; i < colCount; i++) { // Start from column index 1
                    rowData[i - 1] = getCellValue(row.getCell(i));
                }
                dataList.add(rowData);
            }
        }
        workbook.close();
        return dataList.toArray(new Object[0][]);
    }

    private static Object getCellValue(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue();
            case NUMERIC: return cell.getNumericCellValue();
            case BOOLEAN: return cell.getBooleanCellValue();
            default: return "";
        }
    }
}
