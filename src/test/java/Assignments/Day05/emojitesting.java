package Assignments.Day05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class emojitesting {

    //Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    //1. Maximize the website
    //2. Click on the second emoji
    //3. Click on all second emoji items
    //4. Return to the parent iframe
    //5. Fill out the form and press the apply button

    WebDriver driver;
    String url ="https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/";

    @BeforeEach
    public void setUp(){
        driver=new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();

    }

    @Test
    public void aemojiClicking(){
        //since the emojis are inside the iframe tag i should switch to it first
        WebElement iframe = driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(iframe);

        //or
        //        driver.switchTo().frame(1);


        //find the 2nd emoji then click it
        WebElement secondEmoji=driver.findElement(By.xpath("(//a[@class='mdl-tabs__tab'])[1]"));
        secondEmoji.click();

        // Click all emojis in the second category
        List<WebElement> secondCategoryEmojis = driver.findElements(By.xpath("//div[@id='nature']//img"));
        for (WebElement emoji : secondCategoryEmojis) {
            emoji.click();
        }

        //Return to parent
        driver.switchTo().defaultContent();
    }

    @Test
    public void fillTheForm(){
        WebElement textField = driver.findElement(By.id("text"));
        WebElement objectsField = driver.findElement(By.id("objects"));
        WebElement submitButton = driver.findElement(By.id("send"));

        textField.sendKeys("Tester SH");
        objectsField.sendKeys("heart");
        submitButton.click();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
