package com.solvd.qa.carina.demo.gui.pages.common;


import com.solvd.qa.carina.demo.gui.pages.desktop.enums.Languages;
import com.solvd.qa.carina.demo.gui.pages.desktop.enums.Regions;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GoogleSettingsPageBase extends AbstractPage {
    protected GoogleSettingsPageBase(WebDriver driver) {
        super(driver);
    }

    protected GoogleSettingsPageBase(WebDriver driver, String path) {
        super(driver);
    }

    public abstract void selectRegion(Regions region);

    public abstract void selectLanguage(Languages region);
}
