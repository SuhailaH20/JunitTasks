package Assignments.Day01;

/* Assignment 3*/

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WndowCommands {
    public static void main(String[] args) throws InterruptedException {

        //Go to Amazon
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");

        //Print the position and Size
        Point windowPosition = driver.manage().window().getPosition();
        Dimension windowSize = driver.manage().window().getSize();
        System.out.println("Postion: "+windowPosition);
        System.out.println("Size: "+windowSize);

        //Adjust the size and Position
        Point newPosition=(new Point(300,400));
        driver.manage().window().setPosition(newPosition);
        Thread.sleep(1000);
        Dimension newSize=new Dimension(900,700);
        driver.manage().window().setSize(newSize);
        Thread.sleep(1000);

        //Test that the page is in the position and size
        Point actualPosition=driver.manage().window().getPosition();
        Dimension actualSize=driver.manage().window().getSize();

        if (actualSize.equals(newSize)  && actualPosition.equals(newPosition)){
            System.out.println("size and position changed sucessfuly!!!");
        }
        else {
            System.out.println("size and position changed failed...");
        }

        System.out.println("New size: "+newSize);
        System.out.println("New Position: "+newPosition);
        System.out.println("actual Position: "+ driver.manage().window().getPosition());
        System.out.println("actual Size: "+driver.manage().window().getSize());



        //Close the Window
        driver.quit();

    }
}
