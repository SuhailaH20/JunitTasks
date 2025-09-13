package Assignments.Day06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drawing {
    //Go to https://claruswaysda.github.io/Draw.html
    //Draw a triangle
    //Reset

    WebDriver driver;
    String url = "https://claruswaysda.github.io/Draw.html";

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void drawingTesting(){
        WebElement canvas = driver.findElement(By.id("myCanvas"));
        Actions actions = new Actions(driver);

        actions.clickAndHold(canvas).moveByOffset(200,0).perform();
        actions.moveByOffset(-100,200).perform();
        actions.moveByOffset(-100,-200).perform();
        actions.release().perform();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("resetButton")).click();
    }
}
