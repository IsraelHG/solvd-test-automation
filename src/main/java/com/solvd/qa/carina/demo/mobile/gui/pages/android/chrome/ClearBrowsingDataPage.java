package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeHistoryPageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ClearBrowsingDataPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ClearBrowsingDataPageBase.class)
public class ClearBrowsingDataPage extends ClearBrowsingDataPageBase {

    @FindBy(id = "com.android.chrome:id/clear_button")
    private ExtendedWebElement clearDataBtn;

    public ClearBrowsingDataPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(clearDataBtn);
    }

    @Override
    public ChromeHistoryPageBase clearData() {
        clearDataBtn.click();
        return initPage(getDriver(), ChromeHistoryPageBase.class);
    }
}
