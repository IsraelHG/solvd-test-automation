package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome;

import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.header.HeaderMenu;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeHomePageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChromeHomePageBase.class)
public class ChromeHomePage extends ChromeHomePageBase {

    @FindBy(id = "com.android.chrome:id/negative_button")
    private ExtendedWebElement skipBtn;

    @FindBy(id = "com.android.chrome:id/search_box_text")
    private ExtendedWebElement searchBar;

    @FindBy(id = "com.android.chrome:id/line_1")
    private ExtendedWebElement resultOne;

    @FindBy(id = "com.android.chrome:id/toolbar")
    private HeaderMenu header;

    public ChromeHomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchBar);
        skipBtn.clickIfPresent();
    }

    @Override
    public HeaderMenu getHeader() {
        return header;
    }

    @Override
    public ResultPageBase search(String text) {
        searchBar.type(text);
        resultOne.click();
        return initPage(getDriver(), ResultPageBase.class);
    }
}