package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.menus;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeBookmarkPageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeHistoryPageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeInfoPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ChromeMenuBase extends AbstractUIObject {

    protected ChromeMenuBase(WebDriver driver) {
        super(driver);
    }

    protected ChromeMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void addBookmark();

    public abstract ChromeInfoPageBase openPageInfo();

    public abstract ChromeHistoryPageBase openHistoryPage();

    public abstract ChromeBookmarkPageBase openBookmarkPage();
}
