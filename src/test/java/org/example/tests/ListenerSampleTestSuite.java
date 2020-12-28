package org.example.tests;

import org.example.helpers.EventCapture;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class ListenerSampleTestSuite {

    private EventFiringWebDriver eventHandler;

    @BeforeTest
    public void setUp() throws Exception {
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        eventHandler = new EventFiringWebDriver(driver);
        EventCapture eventCapture = new EventCapture();
        eventHandler.register(eventCapture);
    }

    @AfterTest
    public void tearDown() {
        eventHandler.quit();
    }

    @Test
    public void navigateToGithub() {
        eventHandler.navigate().to("https://github.com/");
    }
}
