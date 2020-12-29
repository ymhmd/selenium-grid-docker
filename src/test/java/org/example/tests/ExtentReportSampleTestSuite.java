package org.example.tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.URL;

public class ExtentReportSampleTestSuite {

    static ExtentTest test;
    static ExtentReports report;
    WebDriver driver;

    @BeforeClass
    public static void setupExtentReports() {
        report = new ExtentReports("./ExtentReportResults.html");
        test = report.startTest("ExtentDemo");
    }

    @AfterClass
    public static void tearDownExtentReports() {
        report.endTest(test);
        report.flush();
    }

    @BeforeTest
    public void setUp() throws Exception {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void navigateToGithub() {
        String url = "https://github.com";
        driver.navigate().to(url);
        test.log(LogStatus.PASS,"Navigated to the URL: " + url);
    }
}
