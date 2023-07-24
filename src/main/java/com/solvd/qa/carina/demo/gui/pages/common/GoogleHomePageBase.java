package com.solvd.qa.carina.demo.gui.pages.common;

import com.solvd.qa.carina.demo.gui.components.footer.menu.GoogleSettingMenuBase;
import com.solvd.qa.carina.demo.gui.pages.desktop.GoogleHomePage;
import com.solvd.qa.carina.demo.gui.pages.desktop.GoogleImagePage;
import com.solvd.qa.carina.demo.gui.pages.desktop.GoogleStorePage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GoogleHomePageBase extends AbstractPage {

    protected GoogleHomePageBase(WebDriver driver) {
        super(driver);
    }

    protected GoogleHomePageBase(WebDriver driver, String path) {
        super(driver);
    }

    public abstract GoogleSettingMenuBase openMenu();

    public abstract void performSearch(String input);

    public abstract GoogleStorePage clickStoreButton();

    public abstract GoogleImagePage clickImageButton();

    public abstract GoogleHomePage changeTheme();

}
