package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.pages.common.GoogleSettingsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GoogleSettingsPage extends GoogleSettingsPageBase {

    @FindBy(xpath = "//li[@class='mitem'and@id='langSecLink']")
    ExtendedWebElement languageTab;

    @FindBy(xpath = "//div[@id='langtit']/div[@class='jfk-radiobutton']/span[@class='jfk-radiobutton-radio']")
    ExtendedWebElement italianButton;

    @FindBy(xpath = "//div[@data-value='AF']")
    ExtendedWebElement afghanistanButton;

    @FindBy(xpath = "//div[@id='form-buttons']/div[@role='button'][1]")
    ExtendedWebElement saveButton;

    public GoogleSettingsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleSettingsPage(WebDriver driver, String path) {
        super(driver);
        setPageURL(path);
    }

    @Override
    public void selectRegion() {
        afghanistanButton.scrollTo();
        afghanistanButton.click();
        saveButton.click();

        // Get the current window handle (parent window)
        String parentWindowHandle = getDriver().getWindowHandle();

        // Switch to the new window (alert window) if it opens
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                getDriver().switchTo().window(windowHandle);

                // Handle the alert (dismiss it in this case)
                getDriver().switchTo().alert().dismiss();

                // Switch back to the parent window
                getDriver().switchTo().window(parentWindowHandle);
                break;
            }
        }
    }

    @Override
    public void selectLanguage() {
        languageTab.click();
        italianButton.scrollTo();
        italianButton.click();
        saveButton.click();

        // Get the current window handle (parent window)
        String parentWindowHandle = getDriver().getWindowHandle();

        // Switch to the new window (alert window) if it opens
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                getDriver().switchTo().window(windowHandle);

                // Handle the alert (dismiss it in this case)
                getDriver().switchTo().alert().dismiss();

                // Switch back to the parent window
                getDriver().switchTo().window(parentWindowHandle);
                break;
            }
        }
    }
}
