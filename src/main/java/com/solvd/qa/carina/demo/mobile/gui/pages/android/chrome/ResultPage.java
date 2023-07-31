package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome;

import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.header.HeaderMenu;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ResultPageBase.class)
public class ResultPage extends ResultPageBase {

    @FindBy(xpath = "//android.view.View[@content-desc]")
    private ExtendedWebElement searchResults;

    @FindBy(id = "com.android.chrome:id/toolbar")
    private HeaderMenu header;

    public ResultPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchResults);
    }

    @Override
    public HeaderMenu getHeader() {
        return header;
    }
}
