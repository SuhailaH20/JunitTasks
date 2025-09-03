import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class C05JunitTests01 {
static WebDriver  driver;
    // Go to YouTube homepage
// Do the following tasks by creating 4 different test methods. 
//*- Print "Test is running" before each test() method
//*- Print "Test finished" after each test() method
// Test if the currentURL contains "youtube" 
// Test if the title does not contain "Video". 
// Test if the URL contains "youtube". 
// Test if the sourcePage contains "youtube".


    @Test
    void urlTest01() {
        System.out.println("hh");
        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.contains("youtube"));
    }

    @Test
    void urlTest02() {
    }

    @Test
    void titleTest() {
    }

    @Test
    void pageSourceTest01() {
        System.out.println("hh878");

    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Test is runing");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Test finished");
    }

    @BeforeAll
    public static void beforeAl(){
        driver.navigate().to("https://youtube.com");
    }
}
