package selenium_basic.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
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

public class Calender extends TestListener
{
	@Test(groups = {"smoke"})

    public static void caledenrr() 
    {
    // Creating driver object
    	// Invoking the browser
    	// Firefox we have to use geko driver,Edge driver,Chrome driver
    	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SRIRAM\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("www.ggogle.com");
    	
    	
    	 
    	
    	
    	
    	
    	
    	
    			


    	
    	// Closes the current window
    	driver.close();
    	// Closes the all windows
    	driver.quit();
    }
}
