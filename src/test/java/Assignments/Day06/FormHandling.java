package Assignments.Day06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormHandling {
    //Go to https://claruswaysda.github.io/form.html
    //Create a method to flash the elements you are working on and use it.
    //Register a user
    //Login
    //Celebrate the login!

    static WebDriver driver;
    static String url = "https://claruswaysda.github.io/form.html";

    @BeforeAll
    static public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public void flashElment(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String orignalColor = element.getCssValue("backgroundColor");
        js.executeScript("arguments[0].style.background = 'Green'",element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        js.executeScript("arguments[0].style.background = '"+orignalColor+"'",element);

    }

    @Test
    public void testFormHandling() {
        WebElement snn = driver.findElement(By.id("ssn"));
        flashElment(snn);
        snn.sendKeys("1234567890");
        /// ////

        WebElement firstName = driver.findElement(By.id("first-name"));
        flashElment(firstName);
        firstName.sendKeys("Suhaylah");
        /// ////

        WebElement lastName = driver.findElement(By.id("last-name"));
        flashElment(lastName);
        lastName.sendKeys("Hawsawi");
        /// ////

        WebElement address = driver.findElement(By.id("address"));
        flashElment(address);
        address.sendKeys("Saudi");
        /// ////

        WebElement phone = driver.findElement(By.id("phone"));
        flashElment(phone);
        phone.sendKeys("1234567890");
        /// ////

        WebElement username = driver.findElement(By.id("username"));
        flashElment(username);
        username.sendKeys("suhaila01");
        /// ////

        WebElement email = driver.findElement(By.id("email"));
        flashElment(email);
        email.sendKeys("suh@test.com");
        /// ////

        WebElement password = driver.findElement(By.id("password"));
        flashElment(password);
        password.sendKeys("S1234567890");
        /// ////

        WebElement confirmPassword = driver.findElement(By.id("confirm-password"));
        flashElment(confirmPassword);
        confirmPassword.sendKeys("S1234567890");
        /// ////

        driver.findElement(By.className("button")).click();

        driver.findElement(By.className("login-button")).click();

    }

    @Test
    public void Login(){

        WebElement username = driver.findElement(By.id("username"));
        flashElment(username);
        username.sendKeys("suhaila01");

        WebElement password = driver.findElement(By.id("password"));
        flashElment(password);
        password.sendKeys("S1234567890");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.id("clickMeButton")).click();

    }
}
