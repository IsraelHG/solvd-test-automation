package com.solvd.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GoogleStorePageBase extends AbstractPage {
    protected GoogleStorePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract GoogleStoreResultPageBase searchProduct(String product);
}
