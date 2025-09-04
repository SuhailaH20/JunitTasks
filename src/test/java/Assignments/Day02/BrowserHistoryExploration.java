package Assignments.Day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BrowserHistoryExploration {
    /*
    Task 1: Browser History Exploration
    Setup:
    Use @BeforeEach to launch Chrome and maximize.
    Test 1:
    Navigate to https://www.wikipedia.org.
    Navigate to https://www.google.com.
    Navigate back and forward multiple times, asserting the correct title at each step.
    Test 2:
    Use driver.navigate().refresh() on Google and assert the title still contains "Google".
    Teardown:
    Use @AfterEach to close the browser.
    */
    WebDriver driver;

    // Test 1:
    //    Navigate to https://www.wikipedia.org.
    //    Navigate to https://www.google.com.
    //    Navigate back and forward multiple times, asserting the correct title at each step.

    @Test
    void navigationTest(){
        driver.navigate().to("https://www.wikipedia.org");
        String wikiTitle = driver.getTitle();
        System.out.println("Wikipedia title: " + wikiTitle);

        driver.navigate().to("https://www.google.com");
        String googleTitle = driver.getTitle();
        System.out.println("Google title: " + googleTitle);

        driver.navigate().back();// go back ti wiki
        assertEquals(wikiTitle, driver.getTitle(), "Back navigation failed");

        driver.navigate().forward();// go to google
        assertEquals(googleTitle, driver.getTitle(), "Forward navigation failed");


    }

    //    Test 2:
    //    Use driver.navigate().refresh() on Google and assert the title still contains "Google".
    @Test
    void googleTitle(){
        driver.navigate().to("https://www.google.com");
        driver.navigate().refresh();
        String refreshedTitle = driver.getTitle();
        assertTrue(refreshedTitle.contains("Google"));


    }


//  Use @BeforeEach to launch Chrome and maximize.
    @BeforeEach
    void beforEach(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void afterEach(){
        driver.quit();
    }
}
