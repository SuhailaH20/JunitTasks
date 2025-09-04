package Assignments.Day01;
/* Assignment 1*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidatePageTitle {
    //create main method
    public static void main(String[] args) {

        // Create chrome Driver
        WebDriver driver = new ChromeDriver();

        //open google home page
        driver.navigate().to("https://www.google.com");

        //get title on page
        String PageTitle=driver.getTitle();
        System.out.println("Page Title: "+PageTitle);

        //Get Cureent URL on page
        String pageURL = driver.getCurrentUrl();
        System.out.println("Page URL: "+pageURL);

        //Close / Quit the browser
        driver.close();
        driver.quit();

    }
}
