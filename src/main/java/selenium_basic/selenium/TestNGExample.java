package selenium_basic.selenium;
import org.testng.annotations.*;

public class TestNGExample {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite - Setup Selenium Grid");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class - Launch Browser");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method - Login");
    }

    @Test
    public void test1() {
        System.out.println("Executing Test 1");
    }

    @Test
    public void test2() {
        System.out.println("Executing Test 2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method - Logout");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class - Close Browser");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite - Generate Report");
    }
}
