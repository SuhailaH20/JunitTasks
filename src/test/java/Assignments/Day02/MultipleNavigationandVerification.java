package Assignments.Day02;

/*
Task 4: Multiple Navigation and Verification
Setup:
Launch Chrome and maximize in @BeforeEach.
Test 1:
Navigate Google → YouTube → LinkedIn.
Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
Test 2:
Navigate back twice and assert the URL of Google.
Navigate forward twice and assert URL of LinkedIn.
Teardown:
Use @AfterEach to quit the browser.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultipleNavigationandVerification {
    WebDriver driver;

    //Navigate Google → YouTube → LinkedIn.
    //Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
    @Test
    void Test1() {
        driver.navigate().to("https://www.google.com/");
        String googleTitle=driver.getTitle();
        assertTrue(googleTitle.contains("Google"),"it should has Google!!");

        driver.navigate().to("https://www.youtube.com/");
        String youtubeTitle=driver.getTitle();
        assertTrue(youtubeTitle.contains("YouTube"),"it should has YouTube!!");

        driver.navigate().to("https://www.LinkedIn.com/");
        String linkedinTitle=driver.getTitle();
        assertTrue(linkedinTitle.contains("LinkedIn"),"it should has LinkedIn!!");
    }

    //Navigate back twice and assert the URL of Google.
    //Navigate forward twice and assert URL of LinkedIn.
    @Test
    void Test2() {
        driver.navigate().to("https://www.google.com/");
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().to("https://www.linkedin.com/");

        driver.navigate().back();
        driver.navigate().back();
        String googleURL = "https://www.google.com/";
        assertEquals(googleURL,driver.getCurrentUrl());

        driver.navigate().forward();
        driver.navigate().forward();
        String linkedinURL ="https://www.linkedin.com/";
        assertEquals(linkedinURL,driver.getCurrentUrl());
    }

    @BeforeEach
    void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void afterEach(){
        driver.quit();
    }
}
