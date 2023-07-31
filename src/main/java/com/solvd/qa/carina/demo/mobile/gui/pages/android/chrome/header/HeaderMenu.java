package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.header;

import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.ChromeHomePage;
import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.ChromeTabsPage;
import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.menus.ChromeMenu;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeHomePageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeTabsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends HeaderMenuBase {

    @FindBy(id = "com.android.chrome:id/home_button")
    private ExtendedWebElement homeBtn;

    @FindBy(id = "com.android.chrome:id/tab_switcher_button")
    private ExtendedWebElement tabsBtn;

    @FindBy(id = "com.android.chrome:id/menu_button")
    private ExtendedWebElement menuBtn;

    @FindBy(id = "com.android.chrome:id/app_menu_list")
    private ChromeMenu menu;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public ChromeMenu openMenu() {
        menuBtn.click();
        return new ChromeMenu(driver);
    }

    @Override
    public ChromeHomePageBase goHome() {
        homeBtn.click();
        return new ChromeHomePage(driver);
    }

    @Override
    public ChromeTabsPageBase openNewTabPage() {
        tabsBtn.click();
        return new ChromeTabsPage(driver);
    }
}