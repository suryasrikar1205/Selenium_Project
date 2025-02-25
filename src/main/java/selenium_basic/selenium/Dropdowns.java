package selenium_basic.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)

public class Dropdowns extends TestListener {

	@Test(groups = {"smoke","regression"})
	public static void testDropDowns() throws IOException {
		
		WebDriver driver = new ChromeDriver();
    	
    	WebElement currecydrowdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
    	driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
    	currecydrowdown.click();

		Select dropdown = new Select(currecydrowdown);
		dropdown.selectByIndex(3);
		WebElement aer = dropdown.getFirstSelectedOption();
		System.out.println(aer);
		currecydrowdown.click();
		dropdown.selectByVisibleText("INR");
	   WebElement ind = dropdown.getFirstSelectedOption();
		System.out.println(ind);
		currecydrowdown.click();
	   dropdown.selectByVisibleText("AED");
	   WebElement aed = dropdown.getFirstSelectedOption();
		System.out.println(aed);

		
		  File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	       File dest = new File("C:\\Documents\\Screenshot.png");
	       FileUtils.copyFile(src, dest);
	       System.out.println("Screenshot saved successfully.");


		
	}

}
