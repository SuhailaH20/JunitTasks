package Assignments.Day05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class frametesting {

    //Go to URL: http://demo.guru99.com/test/guru99home/
    //1. Find the number of iframes on the page
    //2. Switch to the third iframe (JMeter Made Easy)
    //3. Click the link (https://www.guru99.com/live-selenium-project.html)
    //4. Exit the iframe and return to the main page

    WebDriver driver;
    String url = "http://demo.guru99.com/test/guru99home/";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void frameTesting(){
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println("The number of frames is: "+frames.size());

        WebElement iframe = driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(iframe);

        WebElement link = driver.findElement(By.xpath("/html/body/a"));
        link.click();

        driver.switchTo().defaultContent();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
