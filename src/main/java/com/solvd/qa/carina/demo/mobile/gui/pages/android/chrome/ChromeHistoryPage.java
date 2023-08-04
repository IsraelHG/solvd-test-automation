package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeHistoryPageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ClearBrowsingDataPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChromeHistoryPageBase.class)
public class ChromeHistoryPage extends ChromeHistoryPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.android.chrome:id/action_bar']/android.widget.TextView")
    private ExtendedWebElement titlePage;

    @FindBy(id = "com.android.chrome:id/clear_browsing_data_button")
    private ExtendedWebElement clearHistoryBtn;

    @FindBy(id = "com.android.chrome:id/empty_view")
    private ExtendedWebElement emptyPageIndicator;

    public ChromeHistoryPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(titlePage);
    }

    @Override
    public ClearBrowsingDataPageBase clearHistory() {
        clearHistoryBtn.click();
        return initPage(getDriver(), ClearBrowsingDataPageBase.class);
    }

    @Override
    public boolean isHistoryCleared() {
        return (!clearHistoryBtn.isElementPresent() && emptyPageIndicator.isElementPresent());
    }
}
