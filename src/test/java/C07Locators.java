import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07Locators {
    static WebDriver driver;
    static String url = "https://linkedin.com/login";
static String testEmail = "tester@example.com";
static String testpassword = "Soioa1212";
    @BeforeAll
    public static void setUp() {
// TODO: Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //we will wait for every element to load up to 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
// TODO: Navigate to LinkedIn
        driver.navigate().to(url);
    }

    @AfterAll
    public static void tearDown() {
// TODO: Close driver
     //   driver.quit();
    }

    @Test
    public void testLoginElements() {
// TODO: Locate email field using By.id
        By emailFieldById = By.id("username");
// TODO: Locate password field using By.name
        By passWordFieldByName = By.name("session_password");
// TODO: Locate sign-in button using By.xpath
        By signInByXpath = By.xpath("//button[@type='submit']");
// TODO: Enter test credentials
        driver.findElement(emailFieldById).sendKeys(testEmail);
        driver.findElement(passWordFieldByName).sendKeys(testpassword);
// TODO: Verify elements are displayed
        Assertions.assertTrue( driver.findElement(emailFieldById).isDisplayed());
        Assertions.assertTrue( driver.findElement(passWordFieldByName).isDisplayed());
        Assertions.assertTrue( driver.findElement(signInByXpath).isDisplayed());


        driver.findElement(signInByXpath).click();
    }

}
