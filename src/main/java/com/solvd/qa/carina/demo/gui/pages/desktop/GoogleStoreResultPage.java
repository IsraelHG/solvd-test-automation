package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.pages.common.GoogleStoreResultPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleStoreResultPage extends GoogleStoreResultPageBase {

    // Locating the element that contains the products information
    @FindBy(xpath = "//main[@tabindex]/div[@class]/section[@class]/div[@class]")
    ExtendedWebElement productsInfo;

    // Locating the store home button
    @FindBy(xpath = "//div[@data-test='header-glogo']/a[@aria-label]")
    ExtendedWebElement storeHomeButton;

    /**
     * Constructor of the GoogleStoreResultPage class.
     *
     * @param driver The WebDriver instance to use for interacting with the browser.
     */
    protected GoogleStoreResultPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Custom ExpectedCondition to check if the specified text is present in the given ExtendedWebElement.
     *
     * @param element The ExtendedWebElement to check for the presence of the specified text.
     * @param text    The text to check for in the ExtendedWebElement.
     * @return True if the ExtendedWebElement contains the specified text, false otherwise.
     */
    private ExpectedCondition<Boolean> textToBePresentInExtendedElement(ExtendedWebElement element, final String text) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return element.getText().contains(text);
            }
        };
    }

    /**
     * Get the product specification based on the specified text.
     *
     * @param spec The text representing the product specification to search for.
     * @return The product specification text if found, an empty string otherwise.
     */
    public String getProductSpec(String spec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(textToBePresentInExtendedElement(productsInfo, spec));

        if (productsInfo.getText().contains(spec)) {
            int startIndex = productsInfo.getText().indexOf(spec);
            int endIndex = startIndex + spec.length();
            return productsInfo.getText().substring(startIndex, endIndex).trim();
        }
        return "";
    }

    /**
     * Navigate to the Google Store homepage by clicking the store home button.
     *
     * @return An instance of GoogleStorePage representing the Google Store homepage.
     */
    public GoogleStorePage goHome() {
        storeHomeButton.hover();
        storeHomeButton.click();
        return new GoogleStorePage(driver);
    }

}
