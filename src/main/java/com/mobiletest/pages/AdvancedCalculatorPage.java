package com.mobiletest.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * AdvancedCalculatorPage represents the scientific/advanced mode of the calculator.
 * Accessed by rotating the device or tapping an expand button.
 */
public class AdvancedCalculatorPage extends BasePage {

    @AndroidFindBy(id = "com.google.android.calculator:id/op_pct")
    private WebElement percentButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/toggle_inv")
    private WebElement inverseToggle;

    @AndroidFindBy(id = "com.google.android.calculator:id/fun_sin")
    private WebElement sinButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/fun_cos")
    private WebElement cosButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/fun_tan")
    private WebElement tanButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/fun_ln")
    private WebElement lnButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/fun_log")
    private WebElement logButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_sqrt")
    private WebElement sqrtButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_pow")
    private WebElement powerButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_fact")
    private WebElement factorialButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/const_pi")
    private WebElement piButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/const_e")
    private WebElement eulerButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/lparen")
    private WebElement leftParenButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/rparen")
    private WebElement rightParenButton;

    public AdvancedCalculatorPage(AndroidDriver driver) {
        super(driver);
    }

    public void tapPercent() {
        percentButton.click();
    }

    public void tapSin() {
        sinButton.click();
    }

    public void tapCos() {
        cosButton.click();
    }

    public void tapTan() {
        tanButton.click();
    }

    public void tapLn() {
        lnButton.click();
    }

    public void tapLog() {
        logButton.click();
    }

    public void tapSqrt() {
        sqrtButton.click();
    }

    public void tapPower() {
        powerButton.click();
    }

    public void tapFactorial() {
        factorialButton.click();
    }

    public void tapPi() {
        piButton.click();
    }

    public void tapEuler() {
        eulerButton.click();
    }

    public void tapLeftParen() {
        leftParenButton.click();
    }

    public void tapRightParen() {
        rightParenButton.click();
    }

    public void tapInverseToggle() {
        inverseToggle.click();
    }

    @Override
    public boolean isPageLoaded() {
        try {
            return sinButton.isDisplayed() && cosButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
