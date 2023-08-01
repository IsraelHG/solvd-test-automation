package com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome;

import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.header.HeaderMenuBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ChromeHomePageBase extends AbstractPage {
    protected ChromeHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HeaderMenuBase getHeader();

    public abstract ResultPageBase search(String text);
}
