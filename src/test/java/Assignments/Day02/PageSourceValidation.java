package Assignments.Day02;

/*
Task 2: Page Source Validation
Setup:
Use @BeforeEach to open Chrome and maximize.
Test 1:
Navigate to https://www.selenium.dev.
Verify that the page source contains the word "WebDriver".
Test 2:
Navigate to https://www.python.org.
Assert the page source contains "Python".
Teardown:
Close the browser with @AfterEach.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageSourceValidation {
    WebDriver driver;

    @Test
    void Test1() {
        driver.navigate().to("https://www.selenium.dev.");
        String selePageSource = driver.getPageSource();

        System.out.println(selePageSource.contains("WebDriver") ? "it has" : "it has not");
    }

    @Test
    void Test2() {
        driver.navigate().to("https://www.python.org");
        String pyPageSource = driver.getPageSource();
        assertTrue(pyPageSource.contains("Python"), "page should has the word puthon!!");
    }

    @BeforeEach
    void beforeEach(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void afterEach(){
        driver.quit();
    }
}
