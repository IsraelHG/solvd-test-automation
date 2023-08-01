package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.header;

import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.menus.ChromeMenuBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeHomePageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeTabsPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderMenuBase extends AbstractUIObject {
    protected HeaderMenuBase(WebDriver driver) {
        super(driver);
    }

    protected HeaderMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ChromeMenuBase openMenu();

    public abstract ChromeHomePageBase goHome();

    public abstract ChromeTabsPageBase openNewTabPage();

}
