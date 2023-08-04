package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.XlsDataSourceParameters;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileChromeTest implements IAbstractTest, IMobileUtils, IAbstractDataProvider {
    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "IsraelHG")
    @XlsDataSourceParameters(path = "data_source/mobileGoogleSearches.xlsx", sheet = "companies", dsUid = "TUID", dsArgs = "companyName")
    public void testChromeSearch(String search) {
        ChromeHomePageBase homePage = initPage(getDriver(), ChromeHomePageBase.class);
        homePage.skipIntroMenu();
        Assert.assertTrue(homePage.isPageOpened(), "Google Chrome application did not open properly.");

        ResultPageBase resultPage = homePage.search(search + "asdf");
        Assert.assertTrue(resultPage.isPageOpened(), "Result page did not load up properly.");
    }

    @Test()
    @MethodOwner(owner = "IsraelHG")
    public void testChromeTabs() {
        ChromeHomePageBase homePage = initPage(getDriver(), ChromeHomePageBase.class);
        homePage.skipIntroMenu();
        Assert.assertTrue(homePage.isPageOpened(), "Google Chrome application did not open properly.");

        ChromeTabsPageBase tabsPage = homePage.getHeader().openNewTabPage();
        Assert.assertTrue(tabsPage.isPageOpened(), "Google tabs page did not open properly.");

        homePage = tabsPage.getMenu().openNewTab();
        Assert.assertTrue(homePage.isPageOpened(), "New Google Chrome home page (after creating new tab) did not open properly.");
    }

    @Test()
    @MethodOwner(owner = "IsraelHG")
    public void testPageInfo() {
        ChromeHomePageBase homePage = initPage(getDriver(), ChromeHomePageBase.class);
        homePage.skipIntroMenu();
        Assert.assertTrue(homePage.isPageOpened(), "Google Chrome application did not open properly.");

        ChromeInfoPageBase chromeInfoPage = homePage.getHeader().openMenu().openPageInfo();
        Assert.assertTrue(chromeInfoPage.isPageOpened());
        Assert.assertEquals(chromeInfoPage.checkInfo(), "chrome-native://newtab", "Chrome info page is not correct.");
    }

    @Test()
    @MethodOwner(owner = "IsraelHG")
    public void testClearHistory() {
        ChromeHomePageBase homePage = initPage(getDriver(), ChromeHomePageBase.class);
        homePage.skipIntroMenu();
        Assert.assertTrue(homePage.isPageOpened(), "Google Chrome application did not open properly.");

        String search = "solvd inc.";
        ResultPageBase resultPage = homePage.search(search);
        Assert.assertTrue(resultPage.isPageOpened(), "Google Chrome application did not open properly.");
        homePage = resultPage.getHeader().goHome();

        ChromeHistoryPageBase historyPage = homePage.getHeader().openMenu().openHistoryPage();
        Assert.assertTrue(historyPage.isPageOpened(), "Google history page did not open properly.");

        ClearBrowsingDataPageBase clearBrowsingPage = historyPage.clearHistory();
        Assert.assertTrue(clearBrowsingPage.isPageOpened(), "Clear browsing page did not open properly.");

        historyPage = clearBrowsingPage.clearData();
        Assert.assertTrue(historyPage.isPageOpened(), "Google history page did not open properly.");
        Assert.assertTrue(historyPage.isHistoryCleared(), "There is still some history to be cleared.");
    }

    @Test()
    @MethodOwner(owner = "IsraelHG")
    public void testBookmarkFeature() {
        ChromeHomePageBase homePage = initPage(getDriver(), ChromeHomePageBase.class);
        homePage.skipIntroMenu();
        Assert.assertTrue(homePage.isPageOpened(), "Google Chrome application did not open properly.");

        String search = "solvd. inc";
        ResultPageBase resultPage = homePage.search(search);
        Assert.assertTrue(resultPage.isPageOpened(), "Result page did not load properly.");
        resultPage.getHeader().openMenu().addBookmark();

        ChromeBookmarkPageBase bookmarkPage = resultPage.getHeader().openMenu().openBookmarkPage();
        Assert.assertTrue(bookmarkPage.isPageOpened(), "Bookmarks page did not load properly.");

        ChromeBookmarkMobileListPageBase bookmarkMobileList = bookmarkPage.openBookmarkMobilePage();
        bookmarkMobileList.getOptionMenu().deleteBookmark();
        Assert.assertTrue(bookmarkMobileList.isPageOpened(), "Mobile bookmark page is not loaded.");
        Assert.assertTrue(bookmarkMobileList.isBookmarksCleared(), "Bookmarks are not cleared.");

    }
}
