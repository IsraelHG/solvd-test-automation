package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.pages.common.SearchResultPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SearchResultPage extends SearchResultPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchResultPage.class);

    @FindBy(xpath = "//div[@id='search']/div/div/div")
    private List<ExtendedWebElement> searchResults;

    public SearchResultPage(WebDriver driver, String search) {
        super(driver);
        setPageURL("search?q=" + search);
    }

    public boolean validateSearchResultsContainWord(String word) {
        for (ExtendedWebElement result : searchResults) {
            if (!result.getText().toLowerCase().contains(word.toLowerCase())) {
                LOGGER.error("Word '{}' is not present in the search result: {}", word, result.getText());
                return false;
            }
        }
        return true;
    }

}
