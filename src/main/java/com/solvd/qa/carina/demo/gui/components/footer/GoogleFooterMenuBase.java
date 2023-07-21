package com.solvd.qa.carina.demo.gui.components.footer;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class GoogleFooterMenuBase extends AbstractUIObject {
    protected GoogleFooterMenuBase(WebDriver driver) {
        super(driver);
    }

    protected GoogleFooterMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
