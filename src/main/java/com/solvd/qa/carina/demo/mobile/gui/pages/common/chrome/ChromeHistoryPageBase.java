package com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ChromeHistoryPageBase extends AbstractPage {
    protected ChromeHistoryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ClearBrowsingDataPageBase clearHistory();
}
