package insession.day03;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T03RadioButtonSelection {
    //    Task: Navigate to "https://demoqa.com/radio-button"
    WebDriver driver;
    String url = "https://demoqa.com/radio-button";

    @BeforeEach
    void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(2000); // wait for page to load
    }

    @AfterEach
    void cleanup() {
            driver.quit();
    }

    //        Attempts to select each radio button (Yes, Impressive, No)
    //        Prints whether each option is enabled/disabled
    //        For enabled options, select them and verify selection
    //        Print confirmation message for each successful selection
    @Test
    void testRadioButtonSelection() throws InterruptedException {
        // Radio buttons IDs or labels
        String[] options = {"yes", "impressive", "no"};

        for (String option : options) {
            // The input element is hidden, click the label instead
            WebElement label = driver.findElement(By.cssSelector("label[for='" + option + "Radio']"));
            WebElement radio = driver.findElement(By.id(option + "Radio"));

            System.out.println("Option '" + option + "' enabled = " + radio.isEnabled());

            if (radio.isEnabled()) {
                label.click(); // click label to select
                Thread.sleep(1000); // wait a bit for selection
                if (radio.isSelected()) {
                    System.out.println(" selected '" + option + "'");
                } else {
                    System.out.println("Failed to select '" + option + "'");
                }
            } else {
                System.out.println("Option '" + option + "' is disabled and cannot be selected.");
            }

            System.out.println("****************suhaila's***************");
        }
    }
}