package Assignments.Day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {
    //Go to https://claruswaysda.github.io/dragAndDrop.html
    //Drag the items in their right places
    //Assert the success message
    WebDriver driver;
    String url = "https://claruswaysda.github.io/dragAndDrop.html";

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void DragandDropTesting(){
        Actions actions = new Actions(driver);

        WebElement drag1 = driver.findElement(By.id("piece1"));
        WebElement drag2 = driver.findElement(By.id("piece2"));
        WebElement drag3 = driver.findElement(By.id("piece3"));
        /// /////////
        WebElement drop1 = driver.findElement(By.id("slot1"));
        WebElement drop2 = driver.findElement(By.id("slot2"));
        WebElement drop3 = driver.findElement(By.id("slot3"));

        actions.dragAndDrop(drag1,drop1).perform();
        actions.dragAndDrop(drag2,drop2).perform();
        actions.dragAndDrop(drag3,drop3).perform();

        Assertions.assertEquals("Congratulations!",driver.findElement(By.id("celebrate")).getText());


    }
}
