package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.gui.pages.desktop.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.asserts.SoftAssert;

public class WebGoogleTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebGoogleTest.class);

    @DataProvider(name = "companiesSearch")
    public Object[][] provideCompanySearch() {
        return new Object[][]{
                {"amazon", "https://www.amazon.com/"},
                {"ebay", "https://www.ebay.com/"},
                {"apple", "https://www.apple.com/"},
                {"samsung", "https://www.samsung.com/us/"}
        };
    }

    @Test(dataProvider = "companiesSearch")
    @MethodOwner(owner = "IsraelHG")
    public void testGoogleSearch(String search, String link) {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Home page is not opened");

        googleHomePage.performSearch(search);
        SearchResultPage searchResultPage = new SearchResultPage(getDriver(), search);
        Assert.assertTrue(searchResultPage.isPageOpened(), "Search result page did not load.");

        String actualLink = searchResultPage.getCompanyLinkURL(search);

        Assert.assertEquals(actualLink, link, "Link URL does not match for company: " + search);
        Assert.assertTrue(searchResultPage.validateSearchResultsContainWord(search), "Word " + search + " is not present in all search results.");
    }

    @Test()
    @MethodOwner(owner = "IsraelHG")
    public void testGoogleImagePage() {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Home page is not opened");

        GoogleImagePage googleImagePage = googleHomePage.clickImageButton();
        Assert.assertTrue(googleImagePage.isPageOpened(), "Google Image page is not opened");
        Assert.assertEquals(googleImagePage.readImageDescription(), "Google Images", "Could not locate the Google image icon");
    }

    @Test()
    @MethodOwner(owner = "IsraelHG")
    public void testGoogleProductSpecs() {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Home page is not opened");

        GoogleStorePage googleStorePage = googleHomePage.clickStoreButton();
        Assert.assertTrue(googleStorePage.isPageOpened(), "Google Store page is not opened");

        String product1 = "pixel 7 pro";
        GoogleStoreResultPage googleStoreResultPage = googleStorePage.searchProduct(product1);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(googleStoreResultPage.getProductName(), "Pixel 7 Pro", "Phone name is not correct");
        softAssert.assertEquals(googleStoreResultPage.getPrice(), "From $899", "Phone price is not correct");
        googleStorePage = googleStoreResultPage.goHome();

        String product2 = "pixel 7a";
        googleStorePage.refresh(1);
        googleStorePage.searchProduct(product2);
        softAssert.assertEquals(googleStoreResultPage.getProductName(), "Pixel 7a", "Phone name is not correct");
        softAssert.assertEquals(googleStoreResultPage.getPrice(), "From $499", "Phone price is not correct");
        softAssert.assertAll();

    }

    @Test()
    @MethodOwner(owner = "IsraelHG")
    public void testGoogleRegionSettings() {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Home page is not opened.");

        googleHomePage = googleHomePage.changeTheme();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Home page is not opened.");

        String region = "Afghanistan";
        GoogleSettingsPage googleSettingsPage = googleHomePage.openMenu().openSearchSettingsPage();
        Assert.assertTrue(googleSettingsPage.isPageOpened(), "Google Settings page is not opened.");

        googleSettingsPage.selectRegion();
        Assert.assertEquals(googleHomePage.getRegion(), region);
    }

    @Test()
    public void testGoogleLanguageSettings() {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Home page is not opened.");

        googleHomePage = googleHomePage.changeTheme();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Home page is not opened.");

        GoogleSettingsPage googleSettingsPage = googleHomePage.openMenu().openSearchSettingsPage();
        Assert.assertTrue(googleSettingsPage.isPageOpened(), "Google Settings page is not opened.");

        googleSettingsPage.selectLanguage();
        Assert.assertEquals(googleHomePage.getLanguage(), "Impostazioni");
    }
}
