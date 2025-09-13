package Assignments.Day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandle {

    //Go to https://claruswaysda.github.io/
    //Click on Window Handle
    //Click on 'Open Index Page'
    //Verify the link 'https://claruswaysda.github.io/index.html'

    WebDriver driver;
    String url = "https://claruswaysda.github.io/";
    String expectedUrl ="https://claruswaysda.github.io/index.html";

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void windowHandleTesting(){
        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.linkText("Window Handle")).click();

        Set<String> allwindows = driver.getWindowHandles();
        for (String handle : allwindows){
            if ((!handle.equals(mainWindow))){
                driver.switchTo().window(handle);
            }
        }

        driver.findElement(By.partialLinkText("Open Index Page")).click();

        allwindows = driver.getWindowHandles();
        for (String handle : allwindows){
            //Skip both main and the first handler
            if ((!handle.equals(mainWindow) && !driver.getWindowHandle().equals(handle))){
                driver.switchTo().window(handle);
            }
        }

        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }
}
