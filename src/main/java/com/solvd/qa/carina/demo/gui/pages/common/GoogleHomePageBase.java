package com.solvd.qa.carina.demo.gui.pages.common;

import com.solvd.qa.carina.demo.gui.components.footer.GoogleFooterMenuBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GoogleHomePageBase extends AbstractPage {

    protected GoogleHomePageBase(WebDriver driver) {
        super(driver);
    }

    //public abstract GoogleFooterMenuBase getFooterMenu();
    public abstract void performSearch(String input);

    public abstract void feelingLuckySearch();

    @Override
    public void open() {
        super.open();
    }
}
