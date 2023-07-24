package com.solvd.qa.carina.demo.gui.components.footer;

import com.solvd.qa.carina.demo.gui.pages.common.GoogleSettingsPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class GoogleSettingMenuBase extends AbstractUIObject {

    protected GoogleSettingMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract GoogleSettingsPageBase openSearchSettingsPage();

    //Add some other setting button methods if needed...
}
