package selenium_basic.selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {
    WebDriver driver;
    
    @FindBy(id = "inputUsername")
    WebElement userName;
    
    @FindBy(name = "inputPassword")
    WebElement password;
    
    @FindBy(className = "signInBtn")
    WebElement login;
    
    // Constructor
    public ReusableMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }
    
    public  void loginApplication(String email, String password) {
        this.userName.sendKeys(new CharSequence[]{email});
        this.password.sendKeys(new CharSequence[]{password});
     }
    
    
    public WebElement waitForElement(int num,By ele) {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(num));
    	return  wait.until(ExpectedConditions.visibilityOfElementLocated(ele));

    }
    
    public void clickSignIn() {
        WebElement login = waitForElement(10, By.className("signInBtn"));
        login.click();
    }
    
}
