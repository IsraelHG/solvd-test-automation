package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.menus;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeHomePageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ChromeTabsMenuBase extends AbstractUIObject {
    protected ChromeTabsMenuBase(WebDriver driver) {
        super(driver);
    }

    protected ChromeTabsMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ChromeHomePageBase openNewTab();

    // TODO: Create page for incognito

    // TODO:

    // TODO: Create page(maybe) for select tabs.

    // TODO: Create page for settings
}
