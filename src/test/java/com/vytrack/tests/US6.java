package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

//  AC #1: users should see “view, edit, delete” when they hover the mouse to the three d
/// #1: users should see “view, edit, delete” when they hover the mouse to the three dots “...”.

public class US6 extends TestBase {

    @DataProvider(name = "TruckDriverLogin")
    public Object[][] truckDriver(){
        return new Object[][]{
                {"user1"},{"user2"},{"user3"},{"user4"},{"user5"},{"user6"}
        };
    }

        @Test (dataProvider = "TruckDriverLogin")
    public void verifing_user_on_homepage(String truckDrivers){

            VytrackUtils.login(truckDrivers, ConfigurationReader.getProperty("password"));
            String actual_result = Driver.getDriver().getTitle();
            String expected_result = "Dashboard";
        }


    @Test (dataProvider = "TruckDriverLogin")
    public void verifing_user_on_vehicels_page (String truckDrivers)  {

        VytrackUtils.login(truckDrivers, ConfigurationReader.getProperty("password"));
        VytrackUtils.waitTillLoaderMaskDisappear();

        //Locate Fleet
        //Locate Vehicles
        SupToSub.goToPage("Fleet","Vehicles");

        String actualResult = Driver.getDriver().getTitle();
        Assert.assertTrue(actualResult.contains("Car"));
    }

    @Test (dataProvider = "TruckDriverLogin")
    public void user_is_able_to_see_3_icons(String truckDrivers){

        VytrackUtils.login(truckDrivers, ConfigurationReader.getProperty("password"));

        VytrackUtils.waitTillLoaderMaskDisappear();

        SupToSub.goToPage("Fleet","Vehicles");

        WebElement three_dots = Driver.getDriver().findElement(By.xpath("//tr[1]//div[@class='more-bar-holder']/div"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(three_dots).perform();

        List<WebElement> icons_3 = Driver.getDriver().findElements(By.xpath("//li[@class='launcher-item']"));

        //
        icons_3.forEach(p-> Assert.assertTrue(p.isDisplayed()));

    }
}
