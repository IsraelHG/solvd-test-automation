package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.gui.pages.desktop.*;
import com.solvd.qa.carina.demo.gui.pages.desktop.enums.Languages;
import com.solvd.qa.carina.demo.gui.pages.desktop.enums.Regions;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.XlsDataSourceParameters;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebGoogleTest implements IAbstractTest, IAbstractDataProvider {

    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "IsraelHG")
    @XlsDataSourceParameters(path = "data_source/googleSearches.xlsx", sheet = "companies", dsUid = "TUID", dsArgs = "companyName")
    public void testGoogleSearch(String search) {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Home page is not opened");

        googleHomePage.performSearch(search);
        SearchResultPage searchResultPage = new SearchResultPage(getDriver(), search);

        Assert.assertTrue(searchResultPage.isPageOpened(), "Search result page did not load.");
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

    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "IsraelHG")
    @XlsDataSourceParameters(path = "data_source/productSearches.xlsx", sheet = "products", dsUid = "TUID", dsArgs = "productOne, productTwo, productOnePrice, productTwoPrice")
    public void testGoogleProductSpecs(String productOne, String productTwo, String productOnePrice, String productTwoPrice) {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Home page is not opened");

        GoogleStorePage googleStorePage = googleHomePage.clickStoreButton();
        Assert.assertTrue(googleStorePage.isPageOpened(), "Google Store page is not opened");

        GoogleStoreResultPage googleStoreResultPage = googleStorePage.searchProduct(productOne);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(googleStoreResultPage.getProductSpec(productOne), productOne, "Phone name is not correct");
        softAssert.assertEquals(googleStoreResultPage.getProductSpec(productOnePrice), productOnePrice, "Phone price is not correct");
        googleStorePage = googleStoreResultPage.goHome();

        googleStorePage.refresh(1);
        googleStorePage.searchProduct(productTwo);
        softAssert.assertEquals(googleStoreResultPage.getProductSpec(productTwo), productTwo, "Phone name is not correct");
        softAssert.assertEquals(googleStoreResultPage.getProductSpec(productTwoPrice), productTwoPrice, "Phone price is not correct");
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

        GoogleSettingsPage googleSettingsPage = googleHomePage.openMenu().openSearchSettingsPage();
        Assert.assertTrue(googleSettingsPage.isPageOpened(), "Google Settings page is not opened.");

        // Change the region of your choice
        Regions region = Regions.DENMARK;
        googleSettingsPage.selectRegion(region);
        Assert.assertEquals(googleHomePage.getRegion(), "Denmark", "Region was not changed correctly.");
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

        Languages language = Languages.RUSSIAN;
        googleSettingsPage.selectLanguage(language);
        Assert.assertTrue(googleHomePage.isLanguageChanged());
    }
}
