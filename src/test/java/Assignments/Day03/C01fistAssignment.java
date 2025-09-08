package Assignments.Day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01fistAssignment {

    // Navigate to: https://opensource-demo.orangehrmlive.com/
     WebDriver driver = new ChromeDriver();
     String url = "https://opensource-demo.orangehrmlive.com/";

    @BeforeEach
    public void setup() throws InterruptedException {
        driver.navigate().to(url);
        Thread.sleep(5000);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

    // TODO: Locate username using absolute XPath
    String absoluteUsernameXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input";

    // TODO: Locate username using relative XPath
    String relativeUsernameXPath = "//input[@name='username']";

    // TODO: Locate password using both methods
    String absolutePasswordXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input";
    String relativePasswordXPath = "//input[@name='password']";

    // TODO: Locate login button using both methods
    String absoluteLoginButtonXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button";
    String relativeLoginButtonXPath = "//button[@type='submit']";

    // TODO: Test both approaches work
   @Test
    void relativeXpathTest() throws InterruptedException {
       Thread.sleep(10000);
        WebElement username = driver.findElement(By.xpath(relativeUsernameXPath));
        WebElement password = driver.findElement(By.xpath(relativePasswordXPath));
        WebElement loginButton = driver.findElement(By.xpath(relativeLoginButtonXPath));

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginButton.click();
    }
    @Test
    void absoltuXpathTest() throws InterruptedException {
        Thread.sleep(12000);
        WebElement username = driver.findElement(By.xpath(absoluteUsernameXPath));
        WebElement password = driver.findElement(By.xpath(absolutePasswordXPath));
        WebElement loginButton = driver.findElement(By.xpath(absoluteLoginButtonXPath));

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginButton.click();
    }
}
