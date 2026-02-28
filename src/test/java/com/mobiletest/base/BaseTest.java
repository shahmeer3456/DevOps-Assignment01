package com.mobiletest.base;

import com.mobiletest.config.AppConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * BaseTest class provides shared setup and teardown logic for all tests.
 * Every test class extends this to get a fresh driver session.
 */
public class BaseTest {

    protected AndroidDriver driver;

    /**
     * Sets up the Appium driver before each test method.
     * Configures device capabilities and connects to the Appium server.
     */
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(AppConfig.PLATFORM_NAME);
        options.setDeviceName(AppConfig.DEVICE_NAME);
        options.setAutomationName(AppConfig.AUTOMATION_NAME);
        options.setAppPackage(AppConfig.APP_PACKAGE);
        options.setAppActivity(AppConfig.APP_ACTIVITY);
        options.setNoReset(true);
        options.setNewCommandTimeout(Duration.ofSeconds(AppConfig.COMMAND_TIMEOUT));

        driver = new AndroidDriver(new URL(AppConfig.APPIUM_SERVER_URL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(AppConfig.IMPLICIT_WAIT));
    }

    /**
     * Tears down the driver after each test method.
     * Ensures resources are properly released.
     */
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
