package Assignments.Day07_1409;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JavaScriptEvents {

    WebDriver driver;
    Actions actions;
    String url ="https://testpages.herokuapp.com/styled/events/javascript-events.html";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void JavaScriptEventsTesting() {
        // Get all the buttons except the reset one
        List<WebElement> buttons = driver.findElements(By.cssSelector("button.styled-click-button, button.styled-click-button-triggered"));

        for (WebElement button : buttons) {
            String id = button.getAttribute("id");
            if (id.equals("reset-challenge")) continue; // skip reset button

            switch (id) {
                case "onclick":
                    button.click();
                    break;
                case "oncontextmenu":
                    actions.contextClick(button).perform();
                    break;
                case "ondoubleclick":
                    actions.doubleClick(button).perform();
                    break;
                case "onmouseover":
                    actions.moveToElement(button).perform();
                    break;
                case "onmouseleave":
                    actions.moveToElement(button).perform();
                    WebElement other = driver.findElement(By.id("onclick"));
                    actions.moveToElement(other).perform();
                    break;
                case "onmousedown":
                    actions.clickAndHold(button).release().perform();
                    break;
                case "onkeydown":
                case "onkeyup":
                case "onkeypress":
                    button.click();
                    button.sendKeys(Keys.SPACE);
                    break;
                case "onblur":
                case "onfocus":
                    button.click();
                    driver.findElement(By.id("onclick")).click();
                    break;
                default:
                    button.click();
            }

            // Verify the status text
            WebElement status = driver.findElement(By.id(id + "status"));
            assertEquals("Event Triggered", status.getText(), id + " event not triggered!");
        }
    }
}
