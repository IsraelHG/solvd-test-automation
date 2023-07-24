package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.components.footer.menu.GoogleSettingMenu;
import com.solvd.qa.carina.demo.gui.pages.common.GoogleHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = GoogleHomePageBase.class)
public class GoogleHomePage extends GoogleHomePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleHomePage.class);

    @FindBy(xpath = "//g-menu[@role='menu']")
    private GoogleSettingMenu menu;

    @FindBy(xpath = "//div/textarea[@title='Search']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//div[@jsname]/center/input[@value='Google Search']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div/a[@aria-label='Search for Images (opens a new tab)']")
    private ExtendedWebElement topImageButton;

    @FindBy(xpath = "//a[@href='https://store.google.com/US?utm_source=hp_header&utm_medium=google_ooo&utm_campaign=GS100042&hl=en-US']")
    private ExtendedWebElement topStoreButton;

    @FindBy(xpath = "//g-popup/div[@role='button']")
    private ExtendedWebElement bottomSettingsButton;

    @FindBy(xpath = "//div[@role='link']")
    private ExtendedWebElement darkThemeButton;

    @FindBy(xpath = "//body/div[@data-hveid='1']/div[5]/div[1]")
    private ExtendedWebElement regionAfghanistan;


    public GoogleHomePage(WebDriver driver) {
        super(driver);
        setPageURL("");
    }

    public GoogleHomePage(WebDriver driver, String path) {
        super(driver);
        setPageURL(path);
    }

    @Override
    public GoogleSettingMenu openMenu() {
        bottomSettingsButton.hover();
        bottomSettingsButton.click();
        return menu;
    }

    @Override
    public void performSearch(String input) {
        searchBar.type(input);
        searchButton.click();
    }

    @Override
    public GoogleStorePage clickStoreButton() {
        topStoreButton.hover();
        topStoreButton.click();
        return new GoogleStorePage(driver);
    }

    public GoogleImagePage clickImageButton() {
        topImageButton.hover();
        topImageButton.click();
        return new GoogleImagePage(driver);
    }

    @Override
    public GoogleHomePage changeTheme() {
        bottomSettingsButton.click();
        darkThemeButton.click();
        return new GoogleHomePage(driver, "?pccc=1");
    }

    public String getRegion() {
        return regionAfghanistan.getText();
    }

    public String getLanguage() {
        return bottomSettingsButton.getText();
    }
}
