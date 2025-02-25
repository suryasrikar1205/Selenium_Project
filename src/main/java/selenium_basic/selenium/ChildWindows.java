package selenium_basic.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

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

public class ChildWindows extends TestListener
{
	@Test(groups = {"sanity"})
    public static void testiFrames()
    {
    // Creating driver object
    	// Invoking the browser
    	// Firefox we have to use geko driver,Edge driver,Chrome driver
    	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SRIRAM\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
    	driver.findElement(By.cssSelector(".blinkingText")).click();
        Set	<String> windows = driver.getWindowHandles();
    	Iterator <String> it = windows.iterator();
    	String parentid = it.next();
    	String childid = it.next();
    	driver.switchTo().window(childid);
    	String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[1];
    	driver.switchTo().window(parentid);
    	driver.findElement(By.id("username")).sendKeys(email);
 
    	
    	// Closes the current window
    	driver.close();
    	// Closes the all windows
    	driver.quit();
    }
}
