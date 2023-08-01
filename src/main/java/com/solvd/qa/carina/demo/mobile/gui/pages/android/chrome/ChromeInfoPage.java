package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeInfoPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ChromeInfoPage extends ChromeInfoPageBase {

    @FindBy(id = "com.android.chrome:id/page_info_truncated_url")
    private ExtendedWebElement pageInfo;

    public ChromeInfoPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(pageInfo);
    }

    @Override
    public String checkInfo() {
        return pageInfo.getText();
    }

}
