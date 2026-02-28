# Appium Mobile Test Automation Framework

## Project Overview

This project is a **mobile test automation framework** built using **Java**, **Appium**, and **TestNG** for automating tests on the **Android Calculator** application. It follows the **Page Object Model (POM)** design pattern and uses **Maven** for dependency management. The project includes a **CI/CD pipeline** configured with **GitHub Actions**.

## Tools and Technologies

| Tool/Technology | Purpose                          |
|-----------------|----------------------------------|
| Java 11         | Programming language             |
| Appium 9.x      | Mobile automation framework      |
| TestNG 7.x      | Test execution and assertions    |
| Maven           | Build and dependency management  |
| GitHub Actions  | Continuous Integration pipeline  |
| Git             | Version control                  |
| Android SDK     | Android platform tools           |
| UiAutomator2    | Appium driver for Android        |

## Project Structure

```
├── .github/
│   └── workflows/
│       └── ci.yml                          # GitHub Actions CI pipeline
├── src/
│   ├── main/java/com/mobiletest/
│   │   ├── config/
│   │   │   └── AppConfig.java              # App & device configuration
│   │   ├── pages/
│   │   │   ├── BasePage.java               # Base page (common logic)
│   │   │   ├── CalculatorPage.java         # Main calculator screen POM
│   │   │   ├── AdvancedCalculatorPage.java # Scientific mode POM
│   │   │   └── HistoryPage.java            # History screen POM
│   │   └── utils/
│   │       ├── TestUtils.java              # Screenshot & helper utilities
│   │       └── WaitHelper.java             # Explicit wait utilities
│   └── test/java/com/mobiletest/
│       ├── base/
│       │   └── BaseTest.java               # Shared setup/teardown
│       └── tests/
│           ├── BasicCalculatorTests.java   # TC-01 to TC-06
│           └── AdvancedCalculatorTests.java# TC-07 to TC-12
├── testng.xml                              # TestNG suite configuration
├── pom.xml                                 # Maven project file
├── .gitignore                              # Git ignore rules
└── README.md                               # This file
```

## Setup Instructions

### Prerequisites

1. **Java JDK 11+** installed ([Download](https://adoptium.net/))
2. **Maven 3.8+** installed ([Download](https://maven.apache.org/download.cgi))
3. **Node.js 18+** installed ([Download](https://nodejs.org/))
4. **Android SDK** with platform tools
5. **Android Emulator** or a real device connected via ADB
6. **Appium Server** installed globally

### Installation Steps

```bash
# 1. Clone the repository
git clone https://github.com/YOUR_USERNAME/appium-mobile-automation.git
cd appium-mobile-automation

# 2. Install Appium server
npm install -g appium

# 3. Install UiAutomator2 driver
appium driver install uiautomator2

# 4. Start Android emulator (or connect a real device)
emulator -avd Pixel_6_API_33

# 5. Install Maven dependencies
mvn clean install -DskipTests
```

### Configuration

Update device settings in `src/main/java/com/mobiletest/config/AppConfig.java`:

```java
public static final String DEVICE_NAME = "emulator-5554";     // Your device name
public static final String APP_PACKAGE = "com.google.android.calculator";
public static final String APP_ACTIVITY = "com.android.calculator2.Calculator";
```

## How to Run Tests Locally

```bash
# 1. Start Appium server (in a separate terminal)
appium

# 2. Ensure emulator/device is running
adb devices

# 3. Run all tests
mvn clean test

# 4. Run specific test class
mvn test -Dtest=BasicCalculatorTests

# 5. Run with specific TestNG XML
mvn test -DsuiteXmlFile=testng.xml
```

### Test Reports

After execution, reports are available at:
- **TestNG Reports**: `target/surefire-reports/index.html`
- **Screenshots**: `screenshots/` directory

## Test Cases

| ID    | Test Case                        | Description                                |
|-------|----------------------------------|--------------------------------------------|
| TC-01 | testAddition                     | Verify addition of two positive integers   |
| TC-02 | testSubtraction                  | Verify subtraction of two positive integers|
| TC-03 | testMultiplication               | Verify multiplication of two integers      |
| TC-04 | testDivision                     | Verify division of two integers            |
| TC-05 | testDecimalAddition              | Verify addition with decimal numbers       |
| TC-06 | testCalculatorPageLoads          | Verify calculator screen loads correctly   |
| TC-07 | testMultiplicationByZero         | Verify multiplication by zero returns 0    |
| TC-08 | testNegativeResult               | Verify subtraction yielding negative result|
| TC-09 | testLargeNumberAddition          | Verify addition with large numbers         |
| TC-10 | testClearFunction                | Verify clear button resets calculator      |
| TC-11 | testDeleteLastDigit              | Verify delete removes last entered digit   |
| TC-12 | testChainedOperations            | Verify chained arithmetic operations       |

## CI Workflow Explanation

The project uses **GitHub Actions** for Continuous Integration. The pipeline is defined in `.github/workflows/ci.yml`.

### Pipeline Triggers
- **Push to `main`** branch
- **Pull Requests** targeting `main`

### Pipeline Steps
1. **Checkout** – Clones the repository
2. **Setup JDK 11** – Configures Java environment
3. **Setup Node.js** – Required for Appium
4. **Install Appium** – Installs Appium server globally
5. **Install UiAutomator2** – Installs the Android driver
6. **Maven Build** – Compiles the project and downloads dependencies
7. **Run Tests** – Executes the TestNG test suite
8. **Upload Reports** – Stores test reports as build artifacts

## Git Workflow

### Branching Strategy

```
main (protected)
 ├── develop
 │    ├── feature/framework-setup
 │    ├── feature/page-objects
 │    ├── feature/basic-tests
 │    ├── feature/advanced-tests
 │    ├── feature/ci-pipeline
 │    └── feature/documentation
 └── hotfix/* (for urgent fixes)
```

### Branch Protection Rules
- **No direct commits** to `main`
- All changes go through **Pull Requests**
- Pull requests require **at least 1 review**
- Each feature is developed in a **separate branch**
- **Meaningful commit messages** following conventional format

### Commit Message Format
```
feat: add basic calculator test cases
fix: correct element locator for result field
docs: update README with setup instructions
chore: configure CI pipeline
refactor: extract common wait logic to WaitHelper
```

## Team Members

| Member   | Responsibilities                                          |
|----------|-----------------------------------------------------------|
| Member 1 | Framework setup, Page Objects, Basic Tests (TC-01–TC-06)  |
| Member 2 | Advanced Tests (TC-07–TC-12), CI Pipeline, Documentation  |

## License

This project is for academic purposes only.
