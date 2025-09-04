package Assignments.Day01;
/* Assignment 2*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TitleVerify {
    public static void main(String[] args) {

        //Invoke FireFox Driver
        WebDriver driver = new FirefoxDriver();

        // Go to Youtube
        driver.navigate().to("https://www.youtube.com/");

        //verfiy the page title contains the word video
        String pageTitle = driver.getTitle();
        if (pageTitle.contains("video")){
            System.out.println("the Title contains the word video");
        }
        else {
            System.out.println("the Title does not contains the word video");
        }

        //close the driver
        driver.quit();


    }
}
