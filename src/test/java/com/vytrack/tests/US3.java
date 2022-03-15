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
    @DataProvider(name = "usernames")
    public Object[][] usernames(){
        return new Object[][]{
                {"user1"},{"user2"},{"user3"},{"user4"},{"user5"},{"user6"},
                {"storemanager55"},{"storemanager56"},{"storemanager57"},{"storemanager58"},
                {"salesmanager260"},{"salesmanager261"},{"salesmanager262"},
                {"salesmanager263"},{"salesmanager264"},{"salesmanager265"},{"salesmanager266"}

        };
    }
    @Test (dataProvider = "usernames" )
    public void click_the_webelement(String username){
        VytrackUtils.login(username, ConfigurationReader.getProperty("password"));

        BrowserUtils.sleep(2);
        //locate and click "Learn how to use this space" webElement:
        Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']")).click();

        BrowserUtils.sleep(2);
        // check if text "How To Use Pinbar" is displayed
        WebElement pinBar = Driver.getDriver().findElement(By.xpath("//h3[.='How To Use Pinbar']"));
        Assert.assertTrue(pinBar.isDisplayed());

        // check if
        WebElement secondText = Driver.getDriver().findElement(By.xpath("//p[1]"));
        Assert.assertTrue(secondText.isDisplayed());

    }
    @Test (dataProvider = "usernames" )
    public void locate_the_image(String username){
        VytrackUtils.login(username, ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(2);

        //locate and click "Learn how to use this space" webElement:
        Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']")).click();

        BrowserUtils.sleep(2);

        //check if you can see the image
        WebElement image = Driver.getDriver().findElement(By.xpath("//img[@src='/bundles/oronavigation/images/pinbar-location.jpg']"));
        Assert.assertTrue(image.isDisplayed());

    }


}
