package org.example.tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.example.helpers.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.net.URL;

@Listeners(ExtentReportManager.class)
public class ExtentReportSampleTestSuite {

    private static ExtentTest test;
    private static ExtentReports report;
    private static WebDriver driver;

    @BeforeClass
    public static void setupExtentReports(ITestContext context) {
        report = new ExtentReports("./ExtentReportResults.html");
        test = report.startTest("ExtentDemo");
        context.setAttribute("test", test);
    }

    @AfterClass
    public static void tearDownExtentReports() {
        report.endTest(test);
        report.flush();
    }

    @BeforeTest
    public void setUp(ITestContext context) throws Exception {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        context.setAttribute("driver", driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"Navigate to github", "https://github.com"},
                {"Navigate to youtube", "https://www.youtube.com/"}
        };
    }


    @Test(dataProvider = "data-provider")
    public void navigationTestScenario(String testName, String url, ITestContext context) {
        context.setAttribute("testName", testName);
        driver.navigate().to(url);
    }

    @Test
    public void testToFail(ITestContext context) {
        context.setAttribute("testName", "Should fail");
        driver.navigate().to("https://www.youtube.com/");
        Assert.assertEquals(1, 2);
    }
}
