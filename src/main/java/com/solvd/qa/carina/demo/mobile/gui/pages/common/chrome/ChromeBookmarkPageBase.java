package com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ChromeBookmarkPageBase extends AbstractPage {
    protected ChromeBookmarkPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ChromeBookmarkMobileListPageBase openBookmarkMobilePage();
}
