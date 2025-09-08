package insession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C05JunitTests02 {
   static WebDriver driver;


    // Go to google homepage
// Do the following tasks by creating 3 different test methods.
// Print "Tests are starting to run" before each test() method
// Print "Tests have finished running" after each test() method
// Test if the title is the same when the page window is maximize and minimize
// Test if the title does not contain "Video" when the page window is fullscreen
// Test if the URL contains "google"



    // Test if the title is the same when the page window is maximize and minimize
    @Test
    void titleInSizes(){

    }

    // Test if the title does not contain "Video" when the page window is fullscreen
    @Test
    void test2(){

    }

    // Test if the URL contains "google"
    @Test
    void url(){

    }

    @BeforeEach
    void beforeEach(){
        driver = new ChromeDriver();
        System.out.println("Tests are starting to run");

    }

    @AfterEach
    void afterEach(){
        System.out.println("Tests have finished running");
    }

    @BeforeAll
    public static void beforeAll(){
        driver.navigate().to("https://google.com/");
    }
}
