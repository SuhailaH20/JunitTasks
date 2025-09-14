package Assignments.Day07_1409;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class RobotClasswithNavigationFormSubmission {

    //
    //* Open a demo login page (e.g. https://the-internet.herokuapp.com/login).
    //* Click into the username field.
    //* Type the username using sendKeys.
    //* Use the Robot class to:
    //* Press Tab → go to password field.
    //* Type the password using sendKeys.
    //* Press Enter → submit the form.
    //* Verify login success or error message.
    //
    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/login";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void robotLoginTest() throws AWTException, InterruptedException {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("suhaila");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        WebElement password = driver.switchTo().activeElement();
        password.sendKeys("SuperSecretPassword!");

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement flashMessage = driver.findElement(By.id("flash"));
        Assertions.assertTrue(flashMessage.getText().contains("You logged into a secure area!"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
