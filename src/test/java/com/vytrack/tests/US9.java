package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US9 extends TestBase{

    @DataProvider(name = "TruckDriverLogin")
    public Object[][] truckDriver(){
        return new Object[][]{
                {"user1"},{"user2"},{"user3"},{"user4"},{"user5"},{"user6"}
        };
    }
    @Test(dataProvider = "TruckDriverLogin")
    public void truck_driver_see_error_messages(String trucksUsers){

        VytrackUtils.login(trucksUsers,ConfigurationReader.getProperty("password"));
        VytrackUtils.waitTillLoaderMaskDisappear();
   SupToSub.goToPage("Activities","Calendar Events");
        //click to "Activities"
       // Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[3]")).click();
        //click on the "Calendar Event"
       // Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']")).click();

        //Create calendar event
        WebElement calender = Driver.getDriver().findElement(By.xpath("(//a[@href=\"/calendar/event/create\"])[3]"));
       VytrackUtils.waitTillLoaderMaskDisappear();
        //click on the calendar button
        calender.click();
       VytrackUtils.waitTillLoaderMaskDisappear();

        //clicks on repeats checkboxes
        Driver.getDriver().findElement(By.xpath("//input[contains(@id,'recurrence-repeat-view')]")).click();

        //locating "Repeat Every" input,and make it clear
        WebElement repeat = Driver.getDriver().findElement(By.xpath("//input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']"));// THE value cannot be more than 99
        repeat.clear();

        //  repeat.sendKeys("0");
        String expectedTextMin = "The value have not to be less than 1.";
        String actualTextMin = "";

        for (int i = -10; i < 1; i++) {
            repeat.sendKeys(String.valueOf(i));
            actualTextMin = Driver.getDriver().findElement(By.xpath("(//span[.='The value have not to be less than 1.'])[2]")).getText();
            Assert.assertEquals(actualTextMin, expectedTextMin, "Minimum Number didnt pass!");
            repeat.clear();
        }
        String actualTextMax = "";
        String expectedTexMax = ("The value have not to be more than 99.");

        for (int i = 110; i > 100; i--) {
            repeat.sendKeys(String.valueOf(i));
            actualTextMax = Driver.getDriver().findElement(By.xpath("(//span[.='The value have not to be more than 99.'])[2]")).getText();

            Assert.assertEquals(actualTextMax, expectedTexMax, "Maximum Number didnt pass!");
            repeat.clear();

        }
//            Assert.assertEquals(actualTextMin,expectedTextMin);
//            repeat.clear();
//            repeat.sendKeys("100");
//          Assert.assertEquals(actualTextMax,expectedTexMax);
    }
    }

