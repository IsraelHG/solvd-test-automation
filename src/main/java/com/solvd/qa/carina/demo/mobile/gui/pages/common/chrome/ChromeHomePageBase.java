package com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ChromeHomePageBase extends AbstractPage {
    protected ChromeHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ResultPageBase search(String text);

    public abstract ChromeTabsPageBase openNewTabPage();
}
