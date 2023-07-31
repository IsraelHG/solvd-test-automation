package com.solvd.qa.carina.demo.mobile.gui.pages.android.chrome.menus;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OptionMenu extends OptionMenuBase {

    @FindBy(xpath = "//android.widget.ListView[@resource-id='com.android.chrome:id/app_menu_list']/android.widget.LinearLayout[4]")
    private ExtendedWebElement deleteBtn;

    public OptionMenu(WebDriver driver) {
        super(driver);
    }

    public OptionMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void deleteBookmark() {
        deleteBtn.click();
    }
}
