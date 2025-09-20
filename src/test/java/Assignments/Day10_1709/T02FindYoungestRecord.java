package Assignments.Day10_1709;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase2;

import java.util.List;

public class T02FindYoungestRecord  extends TestBase2 {
//
//Go to https://claruswaysda.github.io/addRecordWebTable.html
//Add 10 records using Faker.
//Find the name of the youngest record.
//

    @Test
    void findyongest() {
        // Go to https://claruswaysda.github.io/addRecordWebTable.html
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");


        for (int i = 0; i < 10; i++) {
            actionHelper.sendKeys(By.id("nameInput"), Faker.instance().name().firstName());
            actionHelper.sendKeys(By.id("ageInput"), (Faker.instance().number().numberBetween(18, 50) + ""));
            Select select = new Select(actionHelper.findElement(By.id("countrySelect")));
            int idx = Faker.instance().number().numberBetween(1, 5);
            select.selectByIndex(idx);
            actionHelper.click(By.xpath("//button[@onclick=\"addRecord()\"]"));


        }

        List<WebElement> tableRows = driver.findElements(By.xpath("//table[1]//tbody//tr"));

        String youngestName = "";
        int youngestAge = Integer.MAX_VALUE;

        for (WebElement row : tableRows) {
            List<WebElement> cells = row.findElements(By.xpath("//table[1]//tbody//tr//td"));
            if (cells.size() >= 2) {
                String name = cells.get(0).getText();
                int age = Integer.parseInt(cells.get(1).getText());

                if (age < youngestAge) {
                    youngestAge = age;
                    youngestName = name;
                }
            }
        }

        System.out.println("Youngest person: " + youngestName + " (Age: " + youngestAge + ")");
        assert !youngestName.isEmpty() : "No youngest person found";




    }
}