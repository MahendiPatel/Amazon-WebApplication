package com.auto.pages;
import org.junit.Assert;
import org.openqa.selenium.*;
import com.auto.core.WebActionUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;


public class searchPage extends WebActionUtils {
    WebDriver driver;

    static String pageName = searchPage.class.getSimpleName();

    public searchPage(WebDriver driver) {
        super(driver, pageName);
        this.driver = driver;
    }

    //this function will search for searchBox and click on it.
    public void navigateToSearchBox() throws Exception {
        clickOn("searchBox");
        Thread.sleep(2000);
    }

    //this function will call the navigateToSearchBox() and type "keyboard" into searchBox.
    public void searchForProduct() throws Exception {
        navigateToSearchBox();
        typeInto("searchBox","keyboard");
        clickOn("searchBtn");
        Thread.sleep(2000);
    }

    //this function will press PAGE_DOWN keys 2 time to scroll for 2 times.
    public void scroll2Times() throws Exception {
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
    }

    //this function will locate a product "prod" -> click on the product and fetch the name of product.
    //assert that the fetched name is same as the name provided to the TestData.
    //it also fetched the price from that page and assert that it will also match with provided TestData.
    public void selectProdAndCheckPrice(String productName,String price) throws Exception
    {
        WebElement prod = driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/61VLSqFG6DL._AC_UY218_.jpg']"));
        prod.click();
        WebElement actualTitle= driver.findElement(By.xpath("//span[@id='productTitle']"));
        Assert.assertEquals(actualTitle.getText(),productName);
        System.out.println("You have selected the correct product:");
        WebElement actualPrice= driver.findElement(By.xpath("//*[@id=\"corePrice_desktop\"]/div/table/tbody/tr[2]/td[2]/span[1]/span[2]"));
        Assert.assertEquals(actualPrice.getText(),price);
        System.out.println("Price is matched with expected price:"+actualPrice.getText());
    }


}
