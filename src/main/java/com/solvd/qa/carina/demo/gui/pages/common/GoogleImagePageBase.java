package com.solvd.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GoogleImagePageBase extends AbstractPage {
    protected GoogleImagePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String readImageDescription();
}
