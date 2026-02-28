package com.mobiletest.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class providing helper methods for test execution.
 * Includes screenshot capture and common wait operations.
 */
public class TestUtils {

    private static final Logger logger = LoggerFactory.getLogger(TestUtils.class);
    private static final String SCREENSHOT_DIR = "screenshots";

    private TestUtils() {
        throw new UnsupportedOperationException("Utility class - do not instantiate");
    }

    /**
     * Captures a screenshot and saves it with a timestamped filename.
     *
     * @param driver   the AndroidDriver instance
     * @param testName name of the test for the filename
     * @return the path to the saved screenshot
     */
    public static String captureScreenshot(AndroidDriver driver, String testName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = testName + "_" + timestamp + ".png";

            Path destDir = Paths.get(SCREENSHOT_DIR);
            Files.createDirectories(destDir);

            Path destPath = destDir.resolve(fileName);
            Files.copy(srcFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);

            logger.info("Screenshot saved: {}", destPath);
            return destPath.toString();
        } catch (IOException e) {
            logger.error("Failed to capture screenshot: {}", e.getMessage());
            return null;
        }
    }

    /**
     * Pauses execution for specified milliseconds.
     * Use sparingly - prefer explicit waits.
     *
     * @param millis time to wait in milliseconds
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warn("Sleep interrupted: {}", e.getMessage());
        }
    }
}
