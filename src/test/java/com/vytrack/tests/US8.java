package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US8 extends TestBase {

    @DataProvider(name = "TruckDriverLogin")
    public Object[][] truckDriver(){
        return new Object[][]{
                {"user1"},{"user2"},{"user3"},{"user4"},{"user5"},{"user6"}
        };
    }
    @Test(dataProvider = "TruckDriverLogin")
    public void truck_driver_see_error_messages(String trucksUsers) {
        VytrackUtils.login(trucksUsers, ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(5);
        //click to "Activities"
        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[3]")).click();
        //click on the "Calendar Event"
        Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']")).click();
        BrowserUtils.sleep(2);
        //Create calendar event
        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        //click on the calendar button
        BrowserUtils.sleep(2);

        //clicks on repeats checkboxes
        Driver.getDriver().findElement(By.xpath("//input[contains(@id,'recurrence-repeat-view')]")).click();

        //locating "Repeat Every" input,and make it clear

        WebElement repeat = Driver.getDriver().findElement(By.xpath("//input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']"));// THE value cannot be more than 99
        System.out.println("repeat.getAttribute() = " + repeat.getAttribute("value"));

        String expectedValue = "1";

        String actualValue = repeat.getAttribute("value");

        Assert.assertEquals(actualValue, expectedValue);


        repeat.clear();

        String ExpectedError = "This value should not be blank.";


        String actualErrror = Driver.getDriver().findElement(By.xpath("(//span[.='This value should not be blank.'])[3]")).getText();

        Assert.assertEquals(ExpectedError, actualErrror);



    }
}




