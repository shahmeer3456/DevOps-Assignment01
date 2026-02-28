package com.mobiletest.config;

/**
 * Configuration class holding all app and device constants.
 * Centralizes configuration to avoid hardcoded values in tests.
 */
public class AppConfig {

    // Appium Server
    public static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";

    // Device Capabilities
    public static final String PLATFORM_NAME = "Android";
    public static final String DEVICE_NAME = "emulator-5554";
    public static final String AUTOMATION_NAME = "UiAutomator2";

    // App Under Test - Android Calculator
    public static final String APP_PACKAGE = "com.google.android.calculator";
    public static final String APP_ACTIVITY = "com.android.calculator2.Calculator";

    // Timeouts (in seconds)
    public static final int IMPLICIT_WAIT = 10;
    public static final int EXPLICIT_WAIT = 15;
    public static final int COMMAND_TIMEOUT = 60;

    // Private constructor to prevent instantiation
    private AppConfig() {
        throw new UnsupportedOperationException("Configuration class - do not instantiate");
    }
}
