package com.solvd.qa.carina.demo.gui.pages.desktop;

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

    @FindBy(xpath = "//div/textarea[@title='Search']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//div[@jsname]/center/input[@value='Google Search']")
    private ExtendedWebElement googleSearchButton;

    @FindBy(xpath = "//div[not(@jsname)]/center/input[@aria-label=\"I'm Feeling Lucky\"]")
    private ExtendedWebElement googleImFeelingLuckyButton;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.google.com/");
    }

    @Override
    public void performSearch(String input) {
        searchBar.type(input);
        googleSearchButton.pause(1);
        googleSearchButton.click();
    }

    @Override
    public void feelingLuckySearch() {
        googleImFeelingLuckyButton.hover();
        googleImFeelingLuckyButton.pause(2);
        googleImFeelingLuckyButton.click();
    }

//    @Override
//    public GoogleFooterMenuBase getFooterMenu() {
//        return null;
//    }
}
