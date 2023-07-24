package com.solvd.qa.carina.demo.gui.components.footer.menu;

import com.solvd.qa.carina.demo.gui.pages.desktop.GoogleSettingsPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GoogleSettingMenu extends GoogleSettingMenuBase {

    @FindBy(xpath = "//g-menu-item[1]")
    private ExtendedWebElement searchSettingLink;

    public GoogleSettingMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public GoogleSettingsPage openSearchSettingsPage() {
        searchSettingLink.hover();
        searchSettingLink.click();
        return new GoogleSettingsPage(driver, "preferences?hl=en&fg=1");
    }
}
