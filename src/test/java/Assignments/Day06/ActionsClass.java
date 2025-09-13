package Assignments.Day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class ActionsClass {

    //Go to https://claruswaysda.github.io/submit-button.html
    //Click on submit
    //Verify link contains 'actionsClickDrag'
    //Drag 'Drag me' to 'Drop here'
    //Right-click on 'Right-click' me
    //Double-click on 'Double-click me'
    //Hover on 'Hover over me'
    //Verify all actions' success messages.

    WebDriver driver;
    String url = "https://claruswaysda.github.io/submit-button.html";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void ActionsClassTesting() {
        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.id("submitButton")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles){
            if (!window.equals(mainWindow)){
                driver.switchTo().window(window);
            }
        }

        Assertions.assertTrue(driver.getCurrentUrl().contains("actionsClickDrag"));

        /// //////////////////////////////////////////////////////////////////////

        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.id("drag1"));
        WebElement drop = driver.findElement(By.id("drop1"));
        actions.dragAndDrop(drag, drop).perform();
        System.out.println(driver.findElement(By.id("dragSuccessMessage")).getText());

        /// //////////////////////////////////////////////////////////////////

        WebElement rightClickButton = driver.findElement(By.id("showSuccessButton"));
        actions.contextClick(rightClickButton).perform();
        System.out.println(driver.findElement(By.id("rightClickSuccessMessage")).getText());

        /// //////////////////////////////////////////////////////////////////

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickButton"));
        actions.doubleClick(doubleClickButton).perform();
        System.out.println(driver.findElement(By.id("doubleClickSuccessMessage")).getText());

        /// //////////////////////////////////////////////////////////////////

        WebElement hoverButton = driver.findElement(By.id("hoverButton"));
        actions.moveToElement(hoverButton).perform();
        System.out.println(driver.findElement(By.id("hoverSuccessMessage")).getText());


        Assertions.assertEquals("You have successfully dropped!", driver.findElement(By.id("dragSuccessMessage")).getText());
        Assertions.assertEquals("You have done a right click", driver.findElement(By.id("rightClickSuccessMessage")).getText());
        Assertions.assertEquals("You have done a double click", driver.findElement(By.id("doubleClickSuccessMessage")).getText());
        Assertions.assertEquals("You hovered over the element", driver.findElement(By.id("hoverSuccessMessage")).getText());


    }

}
