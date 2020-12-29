package org.example.helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ExtentReportScreenshot {

    public String captureScreenshot(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File desFile = new File("./screenshots/" + System.currentTimeMillis() + ".png");
        FileUtils.copyFile(scrFile, desFile);
        return desFile.getPath();
    }
}
