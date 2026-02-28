package com.mobiletest.tests;

import com.mobiletest.base.BaseTest;
import com.mobiletest.pages.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * BasicCalculatorTests covers fundamental arithmetic operations.
 * Contains 6 independent test cases for basic calculator functionality.
 *
 * @author Member1
 */
public class BasicCalculatorTests extends BaseTest {

    private CalculatorPage calculatorPage;

    @BeforeMethod
    public void initPage() {
        calculatorPage = new CalculatorPage(driver);
        // Ensure we start with a clean state
        try {
            calculatorPage.tapClear();
        } catch (Exception e) {
            // Clear button may not be visible if calculator is already clear
        }
    }

    /**
     * TC-01: Verify simple addition of two integers.
     * Input: 25 + 75
     * Expected: 100
     */
    @Test(priority = 1, description = "Verify addition of two positive integers")
    public void testAddition() {
        String result = calculatorPage.performAddition("25", "75");
        Assert.assertEquals(result, "100", "Addition result should be 100");
    }

    /**
     * TC-02: Verify simple subtraction of two integers.
     * Input: 90 - 35
     * Expected: 55
     */
    @Test(priority = 2, description = "Verify subtraction of two positive integers")
    public void testSubtraction() {
        String result = calculatorPage.performSubtraction("90", "35");
        Assert.assertEquals(result, "55", "Subtraction result should be 55");
    }

    /**
     * TC-03: Verify multiplication of two integers.
     * Input: 12 × 8
     * Expected: 96
     */
    @Test(priority = 3, description = "Verify multiplication of two positive integers")
    public void testMultiplication() {
        String result = calculatorPage.performMultiplication("12", "8");
        Assert.assertEquals(result, "96", "Multiplication result should be 96");
    }

    /**
     * TC-04: Verify division of two integers.
     * Input: 144 ÷ 12
     * Expected: 12
     */
    @Test(priority = 4, description = "Verify division of two positive integers")
    public void testDivision() {
        String result = calculatorPage.performDivision("144", "12");
        Assert.assertEquals(result, "12", "Division result should be 12");
    }

    /**
     * TC-05: Verify decimal number addition.
     * Input: 3.5 + 2.7
     * Expected: 6.2
     */
    @Test(priority = 5, description = "Verify addition with decimal numbers")
    public void testDecimalAddition() {
        String result = calculatorPage.performAddition("3.5", "2.7");
        Assert.assertEquals(result, "6.2", "Decimal addition result should be 6.2");
    }

    /**
     * TC-06: Verify that the calculator page loads successfully.
     * Checks that essential buttons are visible.
     */
    @Test(priority = 6, description = "Verify calculator main screen loads correctly")
    public void testCalculatorPageLoads() {
        Assert.assertTrue(calculatorPage.isPageLoaded(),
                "Calculator page should be loaded with all key elements visible");
    }
}
