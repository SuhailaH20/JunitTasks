package Assignments;

/*
Task 3: Browser Size and Position
Setup:
Open Chrome in @BeforeEach.
Test 1:
Navigate to https://www.bbc.com.
Set browser size to 800x600 and assert the window size.
Test 2:
Move the window to position (100, 100) and assert its position.
Teardown:
Close the browser.
 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowserSizeandPosition {

    static WebDriver driver;

    @Test
    void Test1() {
        driver.navigate().to("https://www.bbc.com");
        Dimension newSize = new Dimension(800,600);
        driver.manage().window().setSize(newSize);
        assertEquals(newSize, driver.manage().window().getSize());

    }

    @Test
    void Test2() {
        Point newPosition = new Point(100,100);
        driver.manage().window().setPosition(newPosition);
        assertEquals(newPosition,driver.manage().window().getPosition());
    }

    @BeforeEach
    void beforeEach(){
        driver=new ChromeDriver();
    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }
}
