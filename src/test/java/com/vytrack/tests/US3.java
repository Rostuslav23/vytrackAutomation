package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US3 extends TestBase {
//    @DataProvider(name = "StoreManagersLogin")
//    public Object[][] storeManager(){
//        return new Object[][]{
//                {"storemanager55"},{"storemanager56"},{"storemanager57"},{"storemanager58"}
//        };
//    }
    @Test //(dataProvider = "StoreManagersLogin" )
    public void click_the_webelement(){
        VytrackUtils.login(ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("password"));

        BrowserUtils.sleep(10);
        //locate and click "Learn how to use this space" webElement:
        Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']")).click();

        BrowserUtils.sleep(10);
        // check if text "How To Use Pinbar" is displayed
        WebElement pinBar = Driver.getDriver().findElement(By.xpath("//h3[.='How To Use Pinbar']"));
        Assert.assertTrue(pinBar.isDisplayed());

        // check if
        WebElement secondText = Driver.getDriver().findElement(By.xpath("//p[1]"));
        Assert.assertTrue(secondText.isDisplayed());

    }@Test //(dataProvider = "StoreManagersLogin" )
    public void locate_the_image(){
        VytrackUtils.login(ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(10);

        //locate and click "Learn how to use this space" webElement:
        Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']")).click();

        BrowserUtils.sleep(10);

        //check if you can see the image
        WebElement image = Driver.getDriver().findElement(By.xpath("//img[@src='/bundles/oronavigation/images/pinbar-location.jpg']"));
        Assert.assertTrue(image.isDisplayed());

    }


}
