package com.mobiletest.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.time.Duration;

/**
 * WaitHelper provides explicit wait utilities for reliable element interactions.
 * Avoids flaky tests caused by timing issues.
 */
public class WaitHelper {

    private final WebDriverWait wait;
    private final AndroidDriver driver;

    public WaitHelper(AndroidDriver driver, int timeoutSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }

    /**
     * Waits until the element is visible on screen.
     *
     * @param element the WebElement to wait for
     * @return the visible element
     */
    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits until the element is clickable.
     *
     * @param element the WebElement to wait for
     * @return the clickable element
     */
    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for an element located by the given By locator to be visible.
     *
     * @param locator the By locator
     * @return the visible element
     */
    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Waits for element text to match expected value.
     *
     * @param element      the WebElement
     * @param expectedText the expected text
     * @return true if text matches within timeout
     */
    public boolean waitForText(WebElement element, String expectedText) {
        return wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }
}
