package selenium_basic.selenium;

import java.io.File;
import java.lang.reflect.Proxy;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

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

public class Miscellnous extends TestListener
{
	@Test(groups = {"regreesion","sanity"})
    public static void miscellnous()
    {
    // Creating driver object
    	// Invoking the browser
    	// Firefox we have to use geko driver,Edge driver,Chrome driver
    	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SRIRAM\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	// Maximinze and deleting cookies
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().deleteCookieNamed("asdf");
    
    	driver.get("https://expired.badssl.com/");
    	ChromeOptions options = new ChromeOptions();
    	options.setAcceptInsecureCerts(true);
    	options.addEncodedExtensions("File path");
    	options.setExperimentalOption("Exclucdeswitcheds", Arrays.asList("disable popup blocking"));
    	
//    	String proxy = new Proxy();
//        proxy.setHttpProxy("myhttpProxy:3335")
//        options.setCapability(proxy, "dwcjd");
    	System.out.println(driver.getTitle());
//    	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//    	fileUtils.copyfile(src,new file(C://Documents));
    	
    	
    	WebElement uploadElement = driver.findElement(By.id("file-upload"));
    	uploadElement.sendKeys("/path/to/your/file.txt");

    	WebElement uploadElement = driver.findElement(By.id("file-upload"));
    	uploadElement.sendKeys("/path/to/your/file.txt");

    	
    	
    	System.out.println("test passses");
 
    	
    	// Closes the current window
    	driver.close();
    	// Closes the all windows
    	driver.quit();
    }
}
