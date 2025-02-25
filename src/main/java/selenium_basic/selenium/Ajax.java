package selenium_basic.selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

public class Ajax extends TestListener
{
	@Test(groups = {"smoke","regression"})
    public void ajax() 
    {
		ChromeOptions options = new ChromeOptions();

        // Add arguments to customize Chrome behavior
        options.addArguments("--start-maximized");  // Start browser maximized
        options.addArguments("--headless");  // Run Chrome in headless mode (no UI)
        options.addArguments("--disable-notifications");  // Disable browser notifications
        options.addArguments("--incognito");  // Open Chrome in Incognito mode
    // Creating driver object
    	// Invoking the browser
    	// Firefox we have to use geko driver,Edge driver,Chrome driver
    	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SRIRAM\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().fullscreen();
    	driver.get("https://www.amazon.com/");
    	Actions a = new Actions(driver);
    	a.moveToElement(driver.findElement(By.xpath("//a[@id = 'nav-link-accountList'])"))).build().perform();
    	// a.moveToElement(driver.findElement(By.id("cdcw"))).click().keyDown(keys, SHIFT).sendKeys("abcd")	
    	// Closes the current window
    	driver.close();
    	// Closes the all windows
    	driver.quit();
    }
	
	public void screenshot(WebDriver driver) {
	    try {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File dest = new File("C:\\Documents\\Screenshot.png");
	        FileUtils.copyFile(src, dest);
	        System.out.println("Screenshot saved successfully.");
	    } catch (IOException e) {
	        System.out.println("Failed to save screenshot: " + e.getMessage());
	    }
	}

}
