package com.solvd.qa.carina.demo;

import java.util.List;

import com.solvd.qa.carina.demo.gui.pages.common.*;
import com.solvd.qa.carina.demo.gui.pages.desktop.GoogleHomePage;
import com.solvd.qa.carina.demo.gui.pages.desktop.HomePage;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.solvd.qa.carina.demo.gui.components.ModelItem;
import com.solvd.qa.carina.demo.gui.components.NewsItem;
import com.solvd.qa.carina.demo.gui.components.compare.ModelSpecs;
import com.solvd.qa.carina.demo.gui.components.compare.ModelSpecs.SpecType;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

public class WebGoogleTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testGooglePage() {
        GoogleHomePage googleHomePage = new GoogleHomePage(new EdgeDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Home page is not opened");

        googleHomePage.performSearch("How to feed my cat");
        //googleHomePage.feelingLuckySearch();
    }
}
