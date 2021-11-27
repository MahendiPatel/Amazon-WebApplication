package com.auto.tests;



import com.auto.browsers.DriverManager;
import com.auto.configs.ConfigLoader;
import com.auto.configs.EnvironmentConfiguration;
import com.auto.core.Hooks;
import com.auto.core.LocateBy;
import com.auto.core.WebActionUtils;
import com.auto.dataprovider.DataProviderUtils;
import com.auto.dataprovider.ITestDataProvider;
import com.auto.pages.landingPage;
import com.auto.pages.searchPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class practiceTest {

    public EnvironmentConfiguration configs;
    public WebActionUtils actions;
    public WebDriver driver;
    public LocateBy locateBy;
    public DriverManager driverManager;
    //static String url="https://www.amazon.com/";

    @BeforeSuite
    public void beforeAnythingElse() throws Exception {
        ConfigLoader configLoader = new ConfigLoader();
        configs = configLoader.loadProperties();
        configLoader.validateEnvironmentConfigurations(configs);
    }


    @BeforeMethod
    public void setUpTestConfigs() throws Exception {
        driverManager = new DriverManager();
        driver = driverManager.launchBrowser(configs);

    }

    @Test(dataProviderClass = DataProviderUtils.class, dataProvider = "jsonDataProvider")
   @ITestDataProvider(value = "executeTest=url,productName,price")
    public void executeTest(String url,String productName, String price) throws Exception {
        landingPage LandingPage = new landingPage(driver);
        LandingPage.navigateToWebsite(url);

        searchPage SearchPage = new searchPage(driver);

        SearchPage.searchForProduct();

        SearchPage.scroll2Times();
        SearchPage.selectProdAndCheckPrice(productName,price);
    }

    @AfterMethod
    public void tearDownEverything() throws Exception {
       driverManager.closeAllBrowsers();
    }
}
