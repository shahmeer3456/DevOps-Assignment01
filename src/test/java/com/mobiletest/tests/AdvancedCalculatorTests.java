package com.mobiletest.tests;

import com.mobiletest.base.BaseTest;
import com.mobiletest.pages.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * AdvancedCalculatorTests covers edge cases and complex operations.
 * Contains 6 independent test cases for advanced calculator scenarios.
 *
 * @author Member2
 */
public class AdvancedCalculatorTests extends BaseTest {

    private CalculatorPage calculatorPage;

    @BeforeMethod
    public void initPage() {
        calculatorPage = new CalculatorPage(driver);
        try {
            calculatorPage.tapClear();
        } catch (Exception e) {
            // Calculator may already be in clean state
        }
    }

    /**
     * TC-07: Verify multiplication with zero returns zero.
     * Input: 999 × 0
     * Expected: 0
     */
    @Test(priority = 1, description = "Verify multiplication by zero returns zero")
    public void testMultiplicationByZero() {
        String result = calculatorPage.performMultiplication("999", "0");
        Assert.assertEquals(result, "0", "Multiplying by zero should return 0");
    }

    /**
     * TC-08: Verify subtraction resulting in a negative number.
     * Input: 10 - 25
     * Expected: -15
     */
    @Test(priority = 2, description = "Verify subtraction yielding negative result")
    public void testNegativeResult() {
        String result = calculatorPage.performSubtraction("10", "25");
        Assert.assertEquals(result, "−15", "Subtraction result should be -15");
    }

    /**
     * TC-09: Verify large number addition.
     * Input: 999999 + 1
     * Expected: 1000000
     */
    @Test(priority = 3, description = "Verify addition with large numbers")
    public void testLargeNumberAddition() {
        String result = calculatorPage.performAddition("999999", "1");
        Assert.assertEquals(result, "1000000", "Large number addition should be correct");
    }

    /**
     * TC-10: Verify clear button resets the calculator.
     * Enter a number, press clear, formula should be empty.
     */
    @Test(priority = 4, description = "Verify clear button resets calculator state")
    public void testClearFunction() {
        calculatorPage.enterNumber("12345");
        calculatorPage.tapClear();

        // After clearing, try entering a new calculation
        String result = calculatorPage.performAddition("1", "1");
        Assert.assertEquals(result, "2",
                "After clear, new calculation should work correctly");
    }

    /**
     * TC-11: Verify delete button removes last digit.
     * Enter 123, press delete, remaining should be 12.
     */
    @Test(priority = 5, description = "Verify delete button removes last entered digit")
    public void testDeleteLastDigit() {
        calculatorPage.enterNumber("123");
        calculatorPage.tapDelete();
        // Now formula should show 12
        calculatorPage.tapAdd();
        calculatorPage.enterNumber("8");
        calculatorPage.tapEquals();

        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "20",
                "After deleting last digit of 123 (→12), 12+8 should be 20");
    }

    /**
     * TC-12: Verify chained operations.
     * Input: 5 + 3 × 2 (calculator evaluates left-to-right or with BODMAS)
     * Tests that sequential operations produce a result.
     */
    @Test(priority = 6, description = "Verify chained arithmetic operations")
    public void testChainedOperations() {
        calculatorPage.enterNumber("5");
        calculatorPage.tapAdd();
        calculatorPage.enterNumber("3");
        calculatorPage.tapMultiply();
        calculatorPage.enterNumber("2");
        calculatorPage.tapEquals();

        String result = calculatorPage.getResult();
        // Google Calculator follows BODMAS: 5 + (3×2) = 11
        Assert.assertEquals(result, "11",
                "Chained operation 5+3×2 should follow order of operations");
    }
}
