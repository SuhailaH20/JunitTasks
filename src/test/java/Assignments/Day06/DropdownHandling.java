package Assignments.Day06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropdownHandling {
    //Go to https://claruswaysda.github.io/Dropdowns.html
    //In 1. Traditional Dropdown select 'Ford'
    //In 2. Multi-Select Dropdown select 'Mercedes'
    //In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
    //In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
    //In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'

    static WebDriver driver;
    static String url = "https://claruswaysda.github.io/Dropdowns.html";

    @BeforeAll
    static public void setUp(){
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void menu1(){
        WebElement Dmenu = driver.findElement(By.id("carSelect"));
        Select select = new Select(Dmenu);
        select.selectByVisibleText("Ford");

    }

    @Test
    public void menu2(){
        WebElement Dmenu = driver.findElement(By.id("multiCarSelect"));
        Select select = new Select(Dmenu);
        select.selectByVisibleText("Mercedes");

    }

    @Test
    public void menu3(){
        driver.findElement(By.id("customDropdown")).click();
        driver.findElement(By.xpath("//div[@id='customList']//div[text()='BMW']")).click();

    }

    @Test
    public void menu4(){
        driver.findElement(By.id("staticInput")).sendKeys("Tes");
        driver.findElement(By.xpath("//div[@id='staticSuggestions']//div[text()='Tesla Model 3']")).click();

    }

    @Test
    public void menu5(){
        driver.findElement(By.id("dynamicInput")).sendKeys("Toyota");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement toyota = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@id='dynamicSuggestions']//div[text()='Toyota']")
                )
        );
        toyota.click();

    }

}
