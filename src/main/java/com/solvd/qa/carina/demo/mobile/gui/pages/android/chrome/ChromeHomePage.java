package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeHomePageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeTabsPageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChromeHomePageBase.class)
public class ChromeHomePage extends ChromeHomePageBase {

    @FindBy(id = "com.android.chrome:id/negative_button")
    ExtendedWebElement skipBtn;

    @FindBy(id = "com.android.chrome:id/search_box_text")
    private ExtendedWebElement searchBar;

    @FindBy(id = "com.android.chrome:id/line_1")
    private ExtendedWebElement resultOne;

    @FindBy(id = "com.android.chrome:id/tab_switcher_button")
    private ExtendedWebElement newTabBtn;

    public ChromeHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        skipBtn.clickIfPresent();
        return searchBar.isElementPresent(2);
    }

    public ResultPageBase search(String text) {
        searchBar.type(text);
        resultOne.click();
        return initPage(getDriver(), ResultPageBase.class);
    }

    @Override
    public ChromeTabsPageBase openNewTabPage() {
        newTabBtn.click();
        return initPage(getDriver(), ChromeTabsPageBase.class);
    }
}
