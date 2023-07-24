package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.pages.common.GoogleStoreResultPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GoogleStoreResultPage extends GoogleStoreResultPageBase {

    @FindBy(xpath = "//div/h2[@aria-label]")
    ExtendedWebElement productName;

    @FindBy(xpath = "//div[@aria-label]/span[@aria-hidden]")
    ExtendedWebElement productPrice;

    @FindBy(xpath = "//div[@data-test='header-glogo']/a[@aria-label]")
    ExtendedWebElement storeHomeButton;

    protected GoogleStoreResultPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return this.productName.getText();
    }

    public String getPrice() {
        return this.productPrice.getText();
    }

    public GoogleStorePage goHome() {
        storeHomeButton.hover();
        storeHomeButton.click();
        return new GoogleStorePage(driver);
    }

}
