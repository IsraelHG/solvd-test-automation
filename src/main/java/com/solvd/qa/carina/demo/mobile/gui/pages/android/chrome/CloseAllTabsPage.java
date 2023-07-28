package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeTabsPageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.CloseAllTabsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CloseAllTabsPage extends CloseAllTabsPageBase {

    @FindBy(id = "com.android.chrome:id/positive_button")
    private ExtendedWebElement confirmBtn;

    @FindBy(id = "com.android.chrome:id/negative_button")
    private ExtendedWebElement cancelBtn;

    protected CloseAllTabsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ChromeTabsPageBase confirm() {
        confirmBtn.click();
        return initPage(getDriver(), ChromeTabsPageBase.class);
    }

    @Override
    public ChromeTabsPageBase cancel() {
        cancelBtn.click();
        return initPage(getDriver(), ChromeTabsPageBase.class);
    }
}
