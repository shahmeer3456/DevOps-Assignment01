package com.mobiletest.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * CalculatorPage encapsulates interactions with the main calculator screen.
 * Implements POM by keeping locators and actions in one place.
 */
public class CalculatorPage extends BasePage {

    // ======================== DIGIT BUTTONS ========================

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_0")
    private WebElement digit0;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_1")
    private WebElement digit1;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
    private WebElement digit2;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_3")
    private WebElement digit3;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_4")
    private WebElement digit4;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_5")
    private WebElement digit5;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_6")
    private WebElement digit6;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_7")
    private WebElement digit7;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_8")
    private WebElement digit8;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_9")
    private WebElement digit9;

    // ======================== OPERATOR BUTTONS ========================

    @AndroidFindBy(id = "com.google.android.calculator:id/op_add")
    private WebElement addButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_sub")
    private WebElement subtractButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_mul")
    private WebElement multiplyButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_div")
    private WebElement divideButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/eq")
    private WebElement equalsButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/dec_point")
    private WebElement decimalButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/clr")
    private WebElement clearButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/del")
    private WebElement deleteButton;

    // ======================== RESULT / FORMULA ========================

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    private WebElement resultField;

    @AndroidFindBy(id = "com.google.android.calculator:id/formula")
    private WebElement formulaField;

    public CalculatorPage(AndroidDriver driver) {
        super(driver);
    }

    // ======================== DIGIT ACTIONS ========================

    /**
     * Taps a digit button based on integer value.
     *
     * @param digit the digit (0-9) to tap
     */
    public void tapDigit(int digit) {
        WebElement[] digits = {digit0, digit1, digit2, digit3, digit4,
                digit5, digit6, digit7, digit8, digit9};
        if (digit >= 0 && digit <= 9) {
            digits[digit].click();
        } else {
            throw new IllegalArgumentException("Digit must be between 0 and 9");
        }
    }

    /**
     * Types a multi-digit number by tapping each digit sequentially.
     *
     * @param number the number to enter
     */
    public void enterNumber(String number) {
        for (char c : number.toCharArray()) {
            if (c == '.') {
                decimalButton.click();
            } else {
                tapDigit(Character.getNumericValue(c));
            }
        }
    }

    // ======================== OPERATOR ACTIONS ========================

    public void tapAdd() {
        addButton.click();
    }

    public void tapSubtract() {
        subtractButton.click();
    }

    public void tapMultiply() {
        multiplyButton.click();
    }

    public void tapDivide() {
        divideButton.click();
    }

    public void tapEquals() {
        equalsButton.click();
    }

    public void tapDecimal() {
        decimalButton.click();
    }

    public void tapClear() {
        clearButton.click();
    }

    public void tapDelete() {
        deleteButton.click();
    }

    // ======================== RESULT ACTIONS ========================

    /**
     * Gets the final computed result displayed on screen.
     *
     * @return the result text
     */
    public String getResult() {
        return resultField.getText().trim();
    }

    /**
     * Gets the formula/expression currently displayed.
     *
     * @return the formula text
     */
    public String getFormula() {
        return formulaField.getText().trim();
    }

    // ======================== COMPOSITE OPERATIONS ========================

    /**
     * Performs addition of two numbers and returns the result.
     */
    public String performAddition(String num1, String num2) {
        enterNumber(num1);
        tapAdd();
        enterNumber(num2);
        tapEquals();
        return getResult();
    }

    /**
     * Performs subtraction of two numbers and returns the result.
     */
    public String performSubtraction(String num1, String num2) {
        enterNumber(num1);
        tapSubtract();
        enterNumber(num2);
        tapEquals();
        return getResult();
    }

    /**
     * Performs multiplication of two numbers and returns the result.
     */
    public String performMultiplication(String num1, String num2) {
        enterNumber(num1);
        tapMultiply();
        enterNumber(num2);
        tapEquals();
        return getResult();
    }

    /**
     * Performs division of two numbers and returns the result.
     */
    public String performDivision(String num1, String num2) {
        enterNumber(num1);
        tapDivide();
        enterNumber(num2);
        tapEquals();
        return getResult();
    }

    @Override
    public boolean isPageLoaded() {
        try {
            return digit0.isDisplayed() && equalsButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
