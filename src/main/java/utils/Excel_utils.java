package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Excel_utils {

    public static Object get_cell_value(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue();
            case NUMERIC: return cell.getNumericCellValue();
            case BOOLEAN: return cell.getBooleanCellValue();
            case FORMULA: return cell.getCellFormula();
            default: return "";
        }
    }

    public static Object[][] load_excel(String route, String Sheet_name) throws IOException {
        try (FileInputStream file = new FileInputStream(route); XSSFWorkbook workbook = new XSSFWorkbook(file)) {
            XSSFSheet sheet = workbook.getSheet(Sheet_name);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet does not exist: " + Sheet_name);
            }

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getLastCellNum(); // Asume que la primera fila tiene todos los headers

            List<Object[]> dataList = new ArrayList<>();

            for (int i = 1; i < rows; i++) { // Empieza en 1 para saltar el header
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Object[] rowData = new Object[cols];
                boolean hasData = false;

                for (int j = 0; j < cols; j++) {
                    Object value = get_cell_value(row.getCell(j));
                    rowData[j] = value;
                    if (value != null && !value.toString().trim().isEmpty()) {
                        hasData = true;
                    }
                }
                if (hasData) {
                    dataList.add(rowData);
                }
            }

            Object[][] arr = new Object[dataList.size()][cols];
            dataList.toArray(arr);
            return arr;
        }
    }
}

