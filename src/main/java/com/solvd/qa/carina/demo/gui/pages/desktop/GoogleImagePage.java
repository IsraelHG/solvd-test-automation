package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.pages.common.GoogleImagePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GoogleImagePage extends GoogleImagePageBase {

    @FindBy(xpath = "//img[@alt='Google Images']")
    private ExtendedWebElement googleImage;

    public GoogleImagePage(WebDriver driver) {
        super(driver);
        setPageURL("imghp?hl=en&ogbl");
    }

    @Override
    public String readImageDescription() {
        return googleImage.getAttribute("alt");
    }
}
