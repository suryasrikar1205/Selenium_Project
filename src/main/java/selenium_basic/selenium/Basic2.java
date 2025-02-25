package selenium_basic.selenium;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)

public class Basic2 extends TestListener {
	
	@Test(groups = {"smoke","regression"})

	public  void testAllThings() {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	//	driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
		
	
		ReusableMethods reusable = new ReusableMethods(driver);
		reusable.loginApplication("suryasrikar", "Srikar@123");
		
		reusable.clickSignIn();

		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		driver.findElement(By.linkText("Forgot your password?")).click();


		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");

		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		System.out.println(driver.findElement(By.cssSelector("form p")).getText());

		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

		//Thread.sleep(1000);

		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

		driver.findElement(By.id("chkboxOne")).click();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		//driver.manage().


		//driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

	}
	@Test(groups = {"regression","sanity"})

	public void testMiscenllnous() {
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
	// Closes the current window
	// Closes the all windows
	driver.quit();
	}

}
