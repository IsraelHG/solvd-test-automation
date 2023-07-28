package com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome;

import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.menus.ChromeTabsMenu;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ChromeTabsPageBase extends AbstractPage {
    protected ChromeTabsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ChromeTabsMenu getMenu();

    public abstract ChromeHomePageBase createNewTab();

    //public abstract ChromeHomePageBase closeAllTabs();
}
