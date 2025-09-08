package insession.day03;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



/*
 Task: Go to "https://the-internet.herokuapp.com/checkboxes"
.   Write a method that:

 Checks the current state of both checkboxes
 Ensures both checkboxes are selected (click only if not already selected)
 Verify both checkboxes are checked after the operations
 Print the status of each checkbox to console */

public class T02CheckboxInteraction {


        WebDriver driver;
        String url = "https://the-internet.herokuapp.com/checkboxes";

        @BeforeEach
        void setup() throws InterruptedException {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            Thread.sleep(2000); // wait for page to load
        }

        @AfterEach
        void cleanup() {
            if (driver != null) {
                driver.quit();
            }
        }

        @Test
        void testCheckboxSelection() throws InterruptedException {
            // Locate checkboxes
            WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
            WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

            // Print current state
            System.out.println("Checkbox 1 initially selected: " + checkbox1.isSelected());
            System.out.println("Checkbox 2 initially selected: " + checkbox2.isSelected());

            // Select checkboxes only if not already selected
            if (!checkbox1.isSelected()) {
                checkbox1.click();
                Thread.sleep(500);
            }
            if (!checkbox2.isSelected()) {
                checkbox2.click();
                Thread.sleep(500);
            }

            // Verify both checkboxes are selected
            System.out.println("Checkbox 1 selected after operation: " + checkbox1.isSelected());
            System.out.println("Checkbox 2 selected after operation: " + checkbox2.isSelected());

            Assertions.assertTrue(checkbox1.isSelected(), "Checkbox 1 should be selected");
            Assertions.assertTrue(checkbox2.isSelected(), "Checkbox 2 should be selected");
        }



}