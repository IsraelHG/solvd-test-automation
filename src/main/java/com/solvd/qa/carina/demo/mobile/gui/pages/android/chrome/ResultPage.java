package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ResultPageBase.class)
public class ResultPage extends ResultPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//android.view.View[@content-desc]")
    private ExtendedWebElement searchResults;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return searchResults.isElementPresent();
    }
}
