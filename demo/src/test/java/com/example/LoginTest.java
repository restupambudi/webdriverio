package com.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class LoginTest {

    private AppiumDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void testApp() throws Exception {
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

    @Test
    public void validCredentials() {
        if (driver == null) {
            System.err.println("Driver is null");
            return;
        }

        // Your test logic here
        WebElement loginMenu = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.view.View[@content-desc=\"Login\"]")
        ));
        loginMenu.click();

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.EditText[@content-desc=\"input-email\"]")
        ));
        emailField.sendKeys("restupambudi21195@proton.me");

        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.EditText[@content-desc=\"input-password\"]")
        ));
        passwordField.sendKeys("12345678");

        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("button-LOGIN")
        ));
        loginButton.click();

        boolean isMessagePresent;
        try {
            WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.id("android:id/message")
            ));
            isMessagePresent = messageElement.isDisplayed();
        } catch (Exception e) {
            isMessagePresent = false;
        }
    }

    // @AfterEach
    // public void tearDown() {
    // if (driver != null) {
    // driver.quit();
    // }
    // }

}
