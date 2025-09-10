package Assignments.Day04;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ass2 {

    WebDriver driver;
    String url = "https://demoqa.com/select-menu";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testMultiSelectDropdown() throws InterruptedException {
        // Locate the multi-select dropdown by ID
        WebElement multiSelectElement = driver.findElement(By.id("cars"));
        Select multiSelect = new Select(multiSelectElement);

        // Verify it is a multi-select element
        Assertions.assertTrue(multiSelect.isMultiple(), "Dropdown should support multiple selections");
        System.out.println("Verified: Multi-select dropdown is working good.");

        // Select 'Opel' using index (index 2)
        multiSelect.selectByIndex(2);
        Thread.sleep(1000);
        System.out.println("Selected Opel by index");

        // Deselect 'Opel' using index
        multiSelect.deselectByIndex(2);
        Thread.sleep(1000);
        System.out.println("Deselected Opel by index");

        // Select 'Saab' using value
        multiSelect.selectByValue("saab");
        Thread.sleep(1000);
        System.out.println("Selected Saab by value");

        // Deselect 'Saab' using value
        multiSelect.deselectByValue("saab");
        Thread.sleep(1000);
        System.out.println("Deselected Saab by value");

        // Select multiple, then deselect all
        multiSelect.selectByVisibleText("Volvo");
        multiSelect.selectByVisibleText("Audi");
        Thread.sleep(1000);
        System.out.println("Selected Volvo and Audi");

        // Deselect all
        multiSelect.deselectAll();
        System.out.println("All options deselected successfully!!!!");
    }
}
