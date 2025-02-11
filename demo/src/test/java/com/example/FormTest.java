package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumBy;

public class FormTest extends BaseTest {
    @BeforeEach
    public void init() throws Exception {
        setup();
    }

    @Test
    public void scenario1() {
        if (driver == null) {
            System.err.println("Driver is null");
            return;
        }

        // Your test logic here
        WebElement formMenu = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("Forms")));
        formMenu.click();

        WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("text-input")));
        inputField.sendKeys("forms1@99.co");

        WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.TextView[@text='\uF140']")));
        dropdown.click();

        WebElement dropdownOption = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(
                        "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='webdriver.io is awesome']")));
        dropdownOption.click();

        WebElement activeButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.view.ViewGroup[@content-desc=\"button-Active\"]/android.view.ViewGroup")));
        // Verify if the button is enabled
        boolean isEnabled = activeButton.isEnabled();
    }

    @Test
    public void scenario2() {
        if (driver == null) {
            System.err.println("Driver is null");
            return;
        }

        // Your test logic here
        WebElement formMenu = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("Forms")));
        formMenu.click();

        WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("text-input")));
        inputField.sendKeys("Form2@99.co");

        WebElement switchButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("switch")));
        switchButton.click();

        WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.TextView[@text='\uF140']")));
        dropdown.click();

        WebElement dropdownOption = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(
                        "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"This app is awesome\"]")));
        dropdownOption.click();

        WebElement activeButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.view.ViewGroup[@content-desc=\"button-Active\"]/android.view.ViewGroup")));
        // Verify if the button is enabled
        boolean isEnabled = activeButton.isEnabled();
    }

    @Test
    public void scenario3() {
        if (driver == null) {
            System.err.println("Driver is null");
            return;
        }

        // Your test logic here
        WebElement formMenu = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("Forms")));
        formMenu.click();

        WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("text-input")));
        inputField.sendKeys("f0rm3@99.co");

        WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.TextView[@text='\uF140']")));
        dropdown.click();

        WebElement dropdownOption = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(
                        "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"This app is awesome\"]")));
        dropdownOption.click();

        WebElement inactiveButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.view.ViewGroup[@content-desc=\"button-Inactive\"]/android.view.ViewGroup")));
        // Verify if the button is enabled
        boolean isEnabled = inactiveButton.isEnabled();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
