package selenium_basic.selenium;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Endtoend2 extends TestListener{
	
	@Test
	public  void endtoend() throws InterruptedException {
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    	
    	// Radio buttons
    	List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
    	System.out.println("Number of checkboxes on the page: " + radioButtons.size());
    	driver.findElement(By.xpath("//input[@value='radio2']")).click();
    	Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
    	Assert.assertFalse(driver.findElement(By.xpath("//input[@value='radio3']")).isSelected());
    	Assert.assertFalse(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());

    	driver.findElement(By.id("autocomplete")).sendKeys("indi");
    	
    	
    	driver.close();
    	
    	
	}

}
