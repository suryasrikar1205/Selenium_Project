package selenium_basic.selenium;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)

public class Endtoend extends TestListener{
	
	@Test(groups = {"regreesion","sanity"})
	public  void testEndtoend() throws InterruptedException {
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
    	// radio buttons
    	List<WebElement> radiobuttons = driver.findElements(By.xpath("//div[@type='radio']"));
    	System.out.println("Number of checkboxes on the page: " + radiobuttons.size());
    	
    	// Selecting destinations
    	driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
    	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
    	driver.findElement(By.xpath("//a[@value='DEL']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
    	
    	// Calender
    //	ctl00$mainContent$view_date1
    	driver.findElement(By.id("ctl00_mainContent_view_date1"));
    	
    	// Validating disabed calender
    	if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5"))
    	{
    	System.out.println("its disabled");
    	Assert.assertTrue(true);
    	}
    	else
    	{
    	Assert.assertTrue(false);
    	}
    	
    	
    	// Selecting adults and childs
    	driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
    	// hrefIncAdt
    	int i = 1;
    	while(i<5) {
    		driver.findElement(By.id("hrefIncAdt"));
    		i++;
    	}
    	int j = 1;
    	while(j<5) {
    		driver.findElement(By.id("hrefIncChd"));
    		j++;
    	}
    	driver.findElement(By.id("btnclosepaxoption")).click();
    	
    	
    	// selecting currency
    	WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
    	Select dropDown = new Select(currency);
    	dropDown.selectByValue("ASD");
    	
    	// Checkboxes
    	List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
    	System.out.println("Number of checkboxes on the page: " + checkboxes.size());
    	
    	driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();    	
    	driver.close();
    	
	}

}
