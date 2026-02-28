package com.mobiletest.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

/**
 * BasePage provides common functionality shared across all page objects.
 * All page classes extend this to reduce code duplication (OOP - Inheritance).
 */
public abstract class BasePage {

    protected AndroidDriver driver;

    /**
     * Constructor initializes the page elements using Appium's PageFactory.
     *
     * @param driver the AndroidDriver instance
     */
    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    /**
     * Checks if the page is currently displayed.
     *
     * @return true if the identifying element is visible
     */
    public abstract boolean isPageLoaded();
}
