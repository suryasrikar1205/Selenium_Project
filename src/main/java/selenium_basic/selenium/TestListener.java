package selenium_basic.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    private ExtentSparkReporter reporter;
    private ExtentReports extent;
    private ThreadLocal<ExtentTest> test = new ThreadLocal<>(); // ThreadLocal for parallel execution

    @Override
    public void onStart(ITestContext context) {
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Surya");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test.set(extent.createTest(result.getMethod().getMethodName())); // Initialize the test
        test.get().info("Test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail("Test failed: " + result.getThrowable());

        // Capture Screenshot
        Object testInstance = result.getInstance();
        if (testInstance instanceof BaseClass) {
            WebDriver driver = ((BaseClass) testInstance).driver;
            String screenshotPath = getScreenshot(driver, result.getMethod().getMethodName());

            // Ensure the screenshot exists before adding it to the report
            if (screenshotPath != null) {
                test.get().addScreenCaptureFromPath(screenshotPath);
            } else {
                test.get().fail("Screenshot not found");
            }
        } else {
            test.get().fail("Unable to capture screenshot, WebDriver instance not found");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    private String getScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotDir = System.getProperty("user.dir") + File.separator + "screenshots";
        String screenshotPath = screenshotDir + File.separator + testName + "_" + timestamp + ".png";

        new File(screenshotDir).mkdirs(); // Ensure directory exists

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(screenshotPath));
            return screenshotPath;
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
            return null;
        }
    }
}
