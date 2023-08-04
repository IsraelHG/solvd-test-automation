package com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome;

import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.menus.OptionMenuBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ChromeBookmarkMobileListPageBase extends AbstractPage {
    protected ChromeBookmarkMobileListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract OptionMenuBase getOptionMenu();

    public abstract boolean isBookmarksCleared();
}
