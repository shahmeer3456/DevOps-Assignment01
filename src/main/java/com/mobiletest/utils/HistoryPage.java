package com.mobiletest.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * HistoryPage encapsulates interactions with the calculator's history screen.
 * The history screen shows previously computed expressions.
 */
public class HistoryPage extends BasePage {

    @AndroidFindBy(id = "com.google.android.calculator:id/history_menu_item")
    private WebElement historyMenuButton;

    @AndroidFindBy(accessibility = "History")
    private WebElement historyTab;

    @AndroidFindBy(id = "com.google.android.calculator:id/history_recycler_view")
    private WebElement historyList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No history']")
    private WebElement noHistoryMessage;

    @AndroidFindBy(id = "com.google.android.calculator:id/clear_history")
    private WebElement clearHistoryButton;

    public HistoryPage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Opens the history screen by tapping the history button/tab.
     */
    public void openHistory() {
        try {
            // Drag down on the result area to reveal history
            historyTab.click();
        } catch (Exception e) {
            historyMenuButton.click();
        }
    }

    /**
     * Checks if history list is displayed with previous calculations.
     *
     * @return true if history entries are visible
     */
    public boolean isHistoryDisplayed() {
        try {
            return historyList.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the "No history" message is shown.
     *
     * @return true if no history message appears
     */
    public boolean isHistoryEmpty() {
        try {
            return noHistoryMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Clears all calculation history.
     */
    public void clearHistory() {
        clearHistoryButton.click();
    }

    @Override
    public boolean isPageLoaded() {
        try {
            return historyList.isDisplayed() || noHistoryMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
