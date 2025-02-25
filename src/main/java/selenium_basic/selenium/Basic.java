package selenium_basic.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)

public class Basic extends TestListener {
	@Test(groups = {"smoke","sanity","regression"})

    public static void Basicc(){
        // Set up WebDriver
       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\SRIRAM\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Open website
        driver.get("https://rahulshettyacademy.com/");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Click on Login
        driver.findElement(By.xpath("(//a[normalize-space()='Login'])[1]")).click();
       // Thread.sleep(40000);

        // Click login button if necessary (Check if this step is needed)
        driver.findElement(By.xpath("(//div[contains(@class, 'login-btn')])[1]")).click();

        // Fill in the form


        driver.findElement(By.id("email")).sendKeys("suryasrikar");

        // Check marketing emails checkbox
        WebElement checkbox = driver.findElement(By.id("allowMarketingEmails"));
      //  js.executeScript("arguments[0].click();", checkbox);

        // Close the browser
        driver.quit();
    }
}
