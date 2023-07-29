package com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CloseAllTabsPageBase extends AbstractPage {
    protected CloseAllTabsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ChromeTabsPageBase confirm();

    public abstract ChromeTabsPageBase cancel();
}
