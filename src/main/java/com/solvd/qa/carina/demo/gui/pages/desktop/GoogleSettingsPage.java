package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.pages.common.GoogleSettingsPageBase;
import com.solvd.qa.carina.demo.gui.pages.desktop.enums.Languages;
import com.solvd.qa.carina.demo.gui.pages.desktop.enums.Regions;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GoogleSettingsPage extends GoogleSettingsPageBase {

    @FindBy(xpath = "//li[@class='mitem'and@id='langSecLink']")
    ExtendedWebElement languageTab;

    @FindBy(xpath = "//div/div/a[@class='jfk-link' and @id='langanchormore']")
    ExtendedWebElement languageShowMoreBtn;

    @FindBy(xpath = "//div/div/a[@class='jfk-link' and @id='regionanchormore']")
    ExtendedWebElement regionShowMoreBtn;

    @FindBy(xpath = "//div/div[@style]/div[@id='%s']/div[@class='jfk-radiobutton']/span[@class='jfk-radiobutton-radio']")
    ExtendedWebElement languageRadioBtn;

    @FindBy(xpath = "//div[@id]/div[@role='radio' and @data-value='%s']/span[@class='jfk-radiobutton-radio']")
    ExtendedWebElement regionRadioBtn;

    @FindBy(xpath = "//div[@id='form-buttons']/div[@role='button'][1]")
    ExtendedWebElement saveBtn;

    public GoogleSettingsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleSettingsPage(WebDriver driver, String path) {
        super(driver);
        setPageURL(path);
    }

    @Override
    public void selectRegion(Regions region) {
        // last radio button before having to click the "show more" button
        if (region.getId().compareTo("BJ") > 0) {
            regionShowMoreBtn.scrollTo();
            regionShowMoreBtn.click();
        }
        regionRadioBtn.format(region.getId()).scrollTo();
        regionRadioBtn.click();
        saveBtn.click();

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
    public void selectLanguage(Languages language) {
        languageTab.click();
        languageShowMoreBtn.click();

        languageRadioBtn.format(language.getId()).scrollTo();
        languageRadioBtn.click();
        saveBtn.click();

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
