package org.example.helpers;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ExtentReportManager implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestContext context = result.getTestContext();
        ExtentTest extentTest = (ExtentTest) context.getAttribute("test");
        String testName = (String) context.getAttribute("testName");
        extentTest.log(LogStatus.PASS, testName);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        ExtentTest extentTest = (ExtentTest) context.getAttribute("test");
        String testName = (String) context.getAttribute("testName");
        ExtentReportScreenshot extentReportScreenshot = new ExtentReportScreenshot();
        try {
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(extentReportScreenshot.captureScreenshot(driver)) + testName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
