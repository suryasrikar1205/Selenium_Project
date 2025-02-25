package selenium_basic.selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.cucumber.java.After;
/**
 * Hello world!
 *
 */

@Listeners(TestListener.class)

public class Iframes extends TestListener
{
	@Test(groups = {"smoke","regression"})
    public void iframess() throws IOException
    {
    // Creating driver object
    	// Invoking the browser
    	// Firefox we have to use geko driver,Edge driver,Chrome driver
    	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SRIRAM\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://jqueryui.com/droppable/");
    	driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class= 'demo-frame']")));
    	//driver.switchTo()
    	driver.findElement(By.id("draggable")).click();
    	Actions a = new Actions(driver);
    	a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
    	driver.switchTo().defaultContent();
    	
    	// Getting counts for the normal and footer pages // Limiting webdriver scrope
    	WebElement footDriver = driver.findElement(By.id("sdbvhds"));
    	footDriver.findElements(By.tagName("a")).size();
    	 File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	       File dest = new File("C:\\Documents\\Screenshot.png");
	       FileUtils.copyFile(src, dest);
	       System.out.println("Screenshot saved successfully.");
    	// Closes the current window
    	// Closes the all windows
    	driver.quit();
    }
	
}
