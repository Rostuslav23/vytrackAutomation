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

public class US8{
    @DataProvider(name = "TruckDriverLogin")
    public Object[][] truckDriver(){
        return new Object[][]{
                {"user1"},{"user2"},{"user3"},{"user4"},{"user5"},{"user6"}
        };
    }




    @Test(dataProvider ="TruckDriverLogin")
    public void test1(String truckUsers)  {
        VytrackUtils.login(truckUsers, ConfigurationReader.getProperty("password"));





         Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[3]")).click();
        BrowserUtils.sleep(5);



       Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']")).click();
        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.xpath("//input[contains(@id,'recurrence-repeat-view')]")).click();

        WebElement valuee = Driver.getDriver().findElement(By.xpath("/input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']"));

String actual=valuee.getAttribute("value");
        System.out.println(actual);
        String expected="1";

        Assert.assertEquals(actual,expected);


        WebElement repeat = Driver.getDriver().findElement(By.xpath("//input[@class='recurrence-subview-control__number error']"));
        repeat.clear();

        String actualdropdown=repeat.getText();
        String expecteddropdown="This value should not be blank.";

        Assert.assertEquals(actualdropdown,expecteddropdown);


    }
}



