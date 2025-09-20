package Assignments.Day09_1609;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WebTableIntegration {


        public static void main(String[] args) {
            // Lists to hold column data
            List<String> names = new ArrayList<>();
            List<Integer> ages = new ArrayList<>();
            List<String> countries = new ArrayList<>();

            try {
                // Load Excel file from resources folder
                FileInputStream inputStream = new FileInputStream(Path.of(".","resources","Task01.xlsx").toString());
                if (inputStream == null) {
                    throw new RuntimeException("File not found in resources!");
                }

                Workbook workbook = new XSSFWorkbook(inputStream);
                Sheet sheet = workbook.getSheetAt(0);

                // Skip the header row (row 0)
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) continue;

                    // Name (String)
                    Cell nameCell = row.getCell(0);
                    names.add(nameCell.getStringCellValue());

                    // Age (Numeric)
                    Cell ageCell = row.getCell(1);
                    ages.add((int) ageCell.getNumericCellValue());

                    // Country (String)
                    Cell countryCell = row.getCell(2);
                    countries.add(countryCell.getStringCellValue());
                }

                workbook.close();

                // Print to verify
                System.out.println("Names: " + names);
                System.out.println("Ages: " + ages);
                System.out.println("Countries: " + countries);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

