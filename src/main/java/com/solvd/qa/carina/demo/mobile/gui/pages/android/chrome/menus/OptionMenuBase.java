package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.menus;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class OptionMenuBase extends AbstractUIObject {
    protected OptionMenuBase(WebDriver driver) {
        super(driver);
    }

    protected OptionMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    
    public abstract void deleteBookmark();
}
