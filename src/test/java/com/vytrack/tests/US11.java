package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US11 extends TestBase {
    @Override
    @BeforeMethod
    public void setUp() {
        super.setUp();
        VytrackUtils.loginAsDriver();
        BrowserUtils.sleep(1);
        SupToSub.goToPage("Fleet","Vehicle Odometer");
    }



     @Test
        public  void driver_vehicleOdometer_defaultPage_test() {

            WebElement defaultPageNumber = Driver.getDriver().findElement(By.xpath("//input[@value='1']"));
            String actualValue = defaultPageNumber.getAttribute("value");
            String expectedValue = "1";
            Assert.assertEquals(actualValue, expectedValue);
        }

        @Test
        public void driver_view_perPage(){

        WebElement viewesPerpage = Driver.getDriver().findElement(By.xpath("//button[@class='btn dropdown-toggle ']"));
             String actualViewsPerPage= viewesPerpage.getText();
             String expectedViewsPerPage= "25";
             Assert.assertEquals(actualViewsPerPage,expectedViewsPerPage);

    }


}
