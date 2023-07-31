package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.menus;

import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.ChromeBookmarkPage;
import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.ChromeHistoryPage;
import com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.ChromeInfoPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ChromeMenu extends ChromeMenuBase {

    @FindBy(id = "com.android.chrome:id/button_two")
    private ExtendedWebElement addBookmarkBtn;

    @FindBy(id = "com.android.chrome:id/button_four")
    private ExtendedWebElement infoBtn;

    @FindBy(id = "com.android.chrome:id/open_history_menu_id")
    private ExtendedWebElement historyBtn;

    @FindBy(id = "com.android.chrome:id/all_bookmarks_menu_id")
    private ExtendedWebElement bookmarkPageBtn;

    public ChromeMenu(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(infoBtn);
    }

    public ChromeMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void addBookmark() {
        addBookmarkBtn.click();
    }

    @Override
    public ChromeInfoPage openPageInfo() {
        infoBtn.click();
        return new ChromeInfoPage(driver);
    }

    @Override
    public ChromeHistoryPage openHistoryPage() {
        historyBtn.click();
        return new ChromeHistoryPage(driver);
    }

    @Override
    public ChromeBookmarkPage openBookmarkPage() {
        bookmarkPageBtn.click();
        return new ChromeBookmarkPage(driver);
    }
}
