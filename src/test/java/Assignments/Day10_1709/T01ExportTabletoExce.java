package Assignments.Day10_1709;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class T01ExportTabletoExce extends TestBase {


 /*
 Go to https://claruswaysda.github.io/webTable.html
 Write the entire Table 1 to a new Excel sheet.
 */
    @Test
    void takeandwrite() throws IOException {

        driver.get("https://claruswaysda.github.io/webTable.html");

        List<WebElement> allRows = driver.findElements(By.xpath("//table[1]//tr"));//take all rows and get siz
        int numOfRows = allRows.size();
        int numOfColumns = driver.findElements(By.xpath("//table[1]//tr[1]//th")).size();//get size of colume

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Expor Table");


        Row headerRow = sheet.createRow(0);
        List<WebElement> headerCells = driver.findElements(By.xpath("//table[1]//tr[1]//th"));
        for (int j = 0; j < headerCells.size(); j++) {
            Cell cell = headerRow.createCell(j);
            cell.setCellValue(headerCells.get(j).getText());


            }

        for (int i = 1; i < numOfRows; i++) { //  1 to skip header
            Row excelRow = sheet.createRow(i);

            for (int j = 1; j <= numOfColumns; j++) {
                try {
                    String data = driver.findElement(By.xpath("//table[1]//tr[" + i + "]//td[" + j + "]")).getText();
                    Cell cell = excelRow.createCell(j - 1);
                    cell.setCellValue(data);

                    System.out.print(data + " || ");
                } catch (Exception e) {
                    System.out.print("N/A || ");
                }
            }

        }

        FileOutputStream fos = new FileOutputStream(Path.of(System.getProperty("user.dir"),"resources", "Student Greds.xlsx").toString());
        workbook.write(fos);
        fos.close();
        workbook.close();

        }

}