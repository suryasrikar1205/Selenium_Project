package selenium_basic.selenium;


import java.time.Duration;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)


public class Synchronazation extends TestListener {
	
	@Test
	public  void endtoend() throws InterruptedException {
    	WebDriver driver = new ChromeDriver();
    	
    	// Implicit wait
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
    	// Explicit wait
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("someId")));
    	//Elementtobeclickable,Presence of element located,TexttobepresentInelementlocated(By.locator,"Text"),alertIspresent()
        element.click();
    	 
        // Fluent wait
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
        	    .withTimeout(Duration.ofSeconds(20)) // Maximum wait time
        	    .pollingEvery(Duration.ofSeconds(2)) // Polling interval
        	    .ignoring(NoSuchElementException.class); // Ignore specific exceptions

		WebElement elementt = fluentWait.until(driver -> driver.findElement(By.id("someId")));
		elementt.click();
    	
	}

}
