package selenium_basic.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AppTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));
	}
	
	@After
	public void teardown() {
		driver.quit();
		driver.close();
	}
	
	@Test
	public void testIframes() {
		driver.findElement(By.linkText("Nested Frames")).click();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());
	}
	
	@Test
	public void testAddRemove()
	{
		driver.findElement(By.cssSelector("a[href='/add_remove_elements/']")).click();

		
		//<a href="/add_remove_elements/" xpath="1">Add/Remove Elements</a>
		   WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
	        addButton.click();
	        
	        // Validate that the delete button appears
	        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
	        Assert.assertTrue(deleteButtons.size() > 0, "Delete button should be displayed after adding.");

	        // Click "Delete" button
	        deleteButtons.get(0).click();

	        // Validate that the delete button disappears
	        deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
	        Assert.assertTrue(deleteButtons.isEmpty()); 
	}
	
	@Test
	public void testBasicAuthAlert() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		//Maximize the window
		driver.manage().window().maximize();
		
		
		//Enter the URL with Auth Key username / password : admin / admin
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");	
		Thread.sleep(1000);
		//Close the Browser
		driver.quit();
	}

}
