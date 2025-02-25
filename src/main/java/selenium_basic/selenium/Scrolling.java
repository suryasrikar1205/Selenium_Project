package selenium_basic.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
/**
 * Hello world!
 *
 */
@Listeners(TestListener.class)

public class Scrolling extends TestListener
{
	@Test(groups = {"regreesion","sanity"})
    public static void testcrolld()
    {
    // Creating driver object
    	// Invoking the browser
    	// Firefox we have to use geko driver,Edge driver,Chrome driver
    	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SRIRAM\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("www.xnxx.com");
    	JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll Down
        js.executeScript("window.scrollBy(0,500);");  // Scroll down by 500 pixels
        Thread.sleep(2000);

        // Scroll Up
        js.executeScript("window.scrollBy(0,-500);");  // Scroll up by 500 pixels
        Thread.sleep(2000);

        // Scroll Right
        js.executeScript("window.scrollBy(500,0);");  // Scroll right by 500 pixels
        Thread.sleep(2000);

        // Scroll Left
        js.executeScript("window.scrollBy(-500,0);");  // Scroll left by 500 pixels
        Thread.sleep(2000);

        // Scroll to the Bottom of the Page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);

        // Scroll to the Top of the Page
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(2000);    	

    	// Closes the current window
    	driver.close();
    	// Closes the all windows
    	driver.quit();
    }
}
