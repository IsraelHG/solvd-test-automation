package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome;

import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.menus.OptionMenu;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeBookmarkMobileListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChromeBookmarkMobileListPageBase.class)
public class ChromeBookmarkMobileListPage extends ChromeBookmarkMobileListPageBase {

    @FindBy(id = "com.android.chrome:id/selectable_list_recycler_view")
    private ExtendedWebElement bookmarks;

    @FindBy(id = "com.android.chrome:id/more")
    private ExtendedWebElement optionMenuBtn;

    @FindBy(id = "com.android.chrome:id/app_menu_list")
    private ExtendedWebElement optionMenu;

    @FindBy(id = "com.android.chrome:id/content")
    private ExtendedWebElement listOfBookmarks;

    public ChromeBookmarkMobileListPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(bookmarks);
    }

    @Override
    public OptionMenu getOptionMenu() {
        optionMenuBtn.click();
        return new OptionMenu(driver);
    }

    @Override
    public boolean isBookmarksCleared() {
        return !listOfBookmarks.isElementPresent();
    }
}
