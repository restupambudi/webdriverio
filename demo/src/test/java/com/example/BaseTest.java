package com.example;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
    protected static AppiumDriver driver;
    protected static WebDriverWait wait;

    public static void setup() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("app", "C:\\webdriverio\\app\\android.wdio.native.app.v1.0.8.apk");
        caps.setCapability("appPackage", "com.wdiodemoapp");
        caps.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
        caps.setCapability("automationName", "UiAutomator2");

        try {
            URL url = new URI("http://127.0.0.1:4723/").toURL();
            driver = new AndroidDriver(url, caps); // Use AndroidDriver or IOSDriver
            System.out.println("Appium driver initialized: " + driver);
        } catch (MalformedURLException | URISyntaxException e) {
            // TODO Auto-generated catch block
            System.err.println("Failed to initialize Appium driver: " + e.getMessage());
            e.printStackTrace();
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // public static void teardown() {
    //     if (driver != null) {
    //         driver.quit();
    //     }
    // }

}
