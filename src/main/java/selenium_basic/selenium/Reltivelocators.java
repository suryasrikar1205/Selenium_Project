package selenium_basic.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Listeners;
/**
 * Hello world!
 *
 */
@Listeners(TestListener.class)

public class Reltivelocators extends TestListener
{
    public static void main( String[] args )
    {
    // Creating driver object
    	// Invoking the browser
    	// Firefox we have to use geko driver,Edge driver,Chrome driver
    	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SRIRAM\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	Actions a = new Actions(driver);
    	a.
    	
		driver.manage().window().fullscreen();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		

		// Locate the "Name" label
//		WebElement nameLabel = driver.findElement(By.xpath("//label[text()='Name']"));
//
//		// Find the input box below the "Name" label
//		WebElement nameInput = driver.findElement(RelativeLocator.with(By.tagName("input")).below(nameLabel));

    	
    	// Closes the current window
    	driver.close();
    	// Closes the all windows
    	driver.quit();
    }
}
