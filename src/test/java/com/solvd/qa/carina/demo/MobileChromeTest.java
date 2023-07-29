package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeHomePageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ChromeTabsPageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.chrome.ResultPageBase;
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
        Assert.assertTrue(homePage.isPageOpened(), "Google Chrome application did not open properly.");

        ResultPageBase resultPage = homePage.search(search);
        Assert.assertTrue(resultPage.isPageOpened(), "Result page did not load up properly.");
    }

    @Test()
    @MethodOwner(owner = "IsraelHG")
    public void testChromeTabs() {
        ChromeHomePageBase homePage = initPage(getDriver(), ChromeHomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Google Chrome application did not open properly.");

        ChromeTabsPageBase tabsPage = homePage.openNewTabPage();
        Assert.assertTrue(tabsPage.isPageOpened(), "Google tabs page did not open properly.");

        homePage = tabsPage.getMenu().openNewTab();
        Assert.assertTrue(homePage.isPageOpened(), "New Google Chrome home page (after creating new tab) did not open properly.");
    }

    
}
