package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.pages.common.GoogleStorePageBase;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GoogleStorePage extends GoogleStorePageBase {

    @FindBy(xpath = "//div[@data-test='header-search']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//i[@role='button'][1]")
    ExtendedWebElement confirmSearchButton;

    @FindBy(xpath = "//input[@placeholder='Search Google Store']")
    ExtendedWebElement searchBar;

    public GoogleStorePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("google_store.url"));
    }

    public GoogleStoreResultPage searchProduct(String product) {
        searchButton.click();
        searchBar.click();
        searchBar.type(product);
        confirmSearchButton.hover();
        confirmSearchButton.click();
        return new GoogleStoreResultPage(driver);
    }
}
