package com.auto.pages;

import com.auto.core.WebActionUtils;
import org.openqa.selenium.WebDriver;

public class landingPage extends WebActionUtils {
    WebDriver driver;
    static String pageName = landingPage.class.getSimpleName();

    public landingPage(WebDriver driver) {
        super(driver, pageName);
        this.driver = driver;
    }

    //function is for navigate to "amazon.com"
    public void navigateToWebsite(String url) throws Exception {
        launchUrl(url);
        Thread.sleep(2000);
    }



}
