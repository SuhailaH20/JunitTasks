package Assignments.Day04;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ass1 {

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
    void testOldStyleSelectMenu() throws InterruptedException {
        // Locate the old style select menu by ID
        WebElement oldStyleMenu = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(oldStyleMenu);

        // Print all options
        List<WebElement> options = select.getOptions();
        System.out.println("options:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        // Select 'Purple' using index
        select.selectByIndex(4);
        Thread.sleep(1000);

        // Select 'Magenta' using visible text
        select.selectByVisibleText("Magenta");
        Thread.sleep(1000);

        // Select an option using value
        select.selectByValue("6");
        Thread.sleep(1000);

        // Print final selected option
        System.out.println("Final selected option: " + select.getFirstSelectedOption().getText());
    }
}
