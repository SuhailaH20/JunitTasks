package Assignments.Day01;
/*Assignment */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowCommands2 {
    public static void main(String[] args) throws InterruptedException {


        //Open google
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");

        //Maximize the window
        driver.manage().window().maximize();

        //Print the position and size
        System.out.println(driver.manage().window().getSize());
        System.out.println(driver.manage().window().getPosition());
        Thread.sleep(1000);
        //Minimize the page
        driver.manage().window().minimize();
        Thread.sleep(1000);
        //Wait 5 s in the icon state and maximize the page
        Thread.sleep(5000);
        driver.manage().window().maximize();

        //Print the Position and dimension of the page
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getPosition().getX());
        System.out.println(driver.manage().window().getPosition().getY());

        System.out.println(driver.manage().window().getSize());



        //make the page fullscreen
        driver.manage().window().fullscreen();
        Thread.sleep(1000);

        //close the browser
        driver.quit();

    }
}
