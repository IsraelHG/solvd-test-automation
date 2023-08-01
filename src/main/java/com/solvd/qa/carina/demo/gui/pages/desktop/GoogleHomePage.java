package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.components.footer.menu.GoogleSettingMenu;
import com.solvd.qa.carina.demo.gui.pages.common.GoogleHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = GoogleHomePageBase.class)
public class GoogleHomePage extends GoogleHomePageBase {

    @FindBy(xpath = "//g-menu[@role='menu']")
    private GoogleSettingMenu menu;

    @FindBy(xpath = "//div/textarea[@title='Search']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//div[@jsname]/center/input[@value='Google Search']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div/a[@aria-label='Search for Images (opens a new tab)']")
    private ExtendedWebElement topImageButton;

    @FindBy(xpath = "//body[@jsmodel]/div/div/a[@class][2]")
    private ExtendedWebElement topStoreButton;

    @FindBy(xpath = "//g-popup/div[@role='button']")
    private ExtendedWebElement bottomSettingsButton;

    @FindBy(xpath = "//div[@role='link']")
    private ExtendedWebElement darkThemeButton;

    @FindBy(xpath = "//body/div[@data-hveid='1']/div[5]/div[1]")
    private ExtendedWebElement regionLabel;

    private String prev = "";


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
        topStoreButton.click();
        return new GoogleStorePage(driver);
    }

    public GoogleImagePage clickImageButton() {
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
        return regionLabel.getText();
    }

    public boolean isLanguageChanged() {
        if (!prev.equals(bottomSettingsButton.getText())) {
            prev = bottomSettingsButton.getText();
            return true;
        }
        return false;
    }
}
