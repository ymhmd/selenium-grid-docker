package org.example.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;

public class SampleTestSuite {

    private WebDriver driver;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browser) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
        } else {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void navigateToGithub() {
        driver.get("https://github.com/");
    }

    @Test
    public void navigateToGoogle() {
        driver.get("https://www.google.com/");
    }
}
