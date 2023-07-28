package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.menus;

import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.ChromeHomePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChromeTabsMenuBase.class)
public class ChromeTabsMenu extends ChromeTabsMenuBase {

    @FindBy(id = "com.android.chrome:id/new_tab_menu_id")
    private ExtendedWebElement newTabBtn;

    @FindBy(id = "com.android.chrome:id/title")
    private ExtendedWebElement incognitoBtn;

    @FindBy(id = "com.android.chrome:id/close_all_tabs_menu_id")
    private ExtendedWebElement closeAllTabsBtn;

    @FindBy(id = "com.android.chrome:id/menu_select_tabs")
    private ExtendedWebElement selectTabsBtn;

    @FindBy(id = "com.android.chrome:id/preferences_id")
    private ExtendedWebElement settingsBtn;

    public ChromeTabsMenu(WebDriver driver) {
        super(driver);
    }

    public ChromeTabsMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public ChromeHomePage openNewTab() {
        newTabBtn.click();
        return new ChromeHomePage(driver);
    }
}
