package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome;

import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.menus.ChromeTabsMenu;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeTabsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChromeTabsPageBase.class)
public class ChromeTabsPage extends ChromeTabsPageBase {

    @FindBy(id = "com.android.chrome:id/new_tab_view")
    private ExtendedWebElement newTabBtn;

    @FindBy(id = "com.android.chrome:id/app_menu_list")
    private ChromeTabsMenu menu;

    @FindBy(id = "com.android.chrome:id/menu_button")
    private ExtendedWebElement menuBtn;

    public ChromeTabsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return newTabBtn.isElementPresent();
    }

    public ChromeTabsMenu getMenu() {
        menuBtn.click();
        return this.menu;
    }

    @Override
    public ChromeHomePage createNewTab() {
        return getMenu().openNewTab();
    }

//    @Override
//    public ChromeHomePageBase closeAllTabs() {
//        menuBtn.click();
//        ChromeTabsPage temp = getMenu().closeAllTabs();
//        newTabBtn.click();
//        return initPage(getDriver(), ChromeHomePageBase.class);
//    }
}
