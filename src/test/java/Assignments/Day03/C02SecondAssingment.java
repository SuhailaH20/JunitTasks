package Assignments.Day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02SecondAssingment {
    String url = "https://testpages.herokuapp.com/styled/index.html";
    WebDriver driver;
String numValue = "20";
    // TODO: Navigate to test pages
    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

// TODO: Click on "Locators - Find By Playground Test Page"
// TODO: Print current URL
// TODO: Navigate back
// TODO: Print URL after going back
    @Test
    public void navi(){
        WebElement locatorsLink = driver.findElement(By.linkText("Locators - Find By Playground Test Page"));
        locatorsLink.click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("After getting back"+driver.getCurrentUrl());

        // TODO: Click on "WebDriver Example Page"
        WebElement webdriverExampleLink = driver.findElement(By.linkText("WebDriver Example Page"));
        webdriverExampleLink.click();

        // TODO: Print current URL
        System.out.println(driver.getCurrentUrl());

        // TODO: Enter value 20 in number input
        WebElement numberInput = driver.findElement(By.id("numentry"));
        numberInput.sendKeys(numValue);
        WebElement submitButton = driver.findElement(By.id("submit-to-server"));
        submitButton.click();

// TODO: Verify 'two, zero' message appears
        WebElement message = driver.findElement(By.id("message"));
        String text = message.getText();
        System.out.println("Message displayed: " + text);
        Assertions.assertTrue(text.contains("two, zero"), "Expected message to contain 'two, zero'");


    }

}