package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeBookmarkMobileListPageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeBookmarkPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChromeBookmarkPageBase.class)
public class ChromeBookmarkPage extends ChromeBookmarkPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.android.chrome:id/action_bar']/android.widget.TextView")
    private ExtendedWebElement titlePage;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id]/android.widget.FrameLayout[3]")
    private ExtendedWebElement mobileBookmarksPage;

    public ChromeBookmarkPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(titlePage);
    }

    @Override
    public ChromeBookmarkMobileListPageBase openBookmarkMobilePage() {
        mobileBookmarksPage.click();
        return initPage(getDriver(), ChromeBookmarkMobileListPageBase.class);
    }


}
