package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US4 extends TestBase {

    @DataProvider (name= "storeManagersLogin")
    public Object[][] StoreManagerUsername(){
        return new Object[][]{
                {"storemanager55"}, {"storemanager258"}
        };
    }
    @DataProvider(name= "salesManagersLogin")
    public Object[][] SalesManagersUsername(){
        return new Object[][]{
                {"salesmanager260"},{"salesmanager265"}

        };
    }
    @DataProvider(name= "DriverLogin")
    public Object[][] driverUsername(){
        return new Object[][]{
                {"user1"},{"user6"}
        };
    }


    @Test(dataProvider = "storeManagersLogin")
    public void store_manager_view_vehicle_contracts(String storeManagerUsername){
        VytrackUtils.login(storeManagerUsername,ConfigurationReader.getProperty("password"));
        SupToSub.goToPage("Fleet","Vehicle Contracts");
        WebElement vehicleContracts = Driver.getDriver().findElement(By.xpath("//*[@id='container']"));
        Assert.assertTrue(vehicleContracts.isDisplayed());
    }

    @Test(dataProvider = "salesManagersLogin")
    public void sales_manager_view_vehicle_contracts(String salesManagerUsername){
        VytrackUtils.login(salesManagerUsername,ConfigurationReader.getProperty("password"));
        SupToSub.goToPage("Fleet","Vehicle Contracts");
        WebElement vehicleContracts = Driver.getDriver().findElement(By.xpath("//*[@id='container']"));
        Assert.assertTrue(vehicleContracts.isDisplayed());


    }

    @Test(dataProvider = "DriverLogin")
    public void driver_view_vehicle_contracts(String driverUsername){
        VytrackUtils.login(driverUsername,ConfigurationReader.getProperty("password"));
        SupToSub.goToPage("Fleet","Vehicle Contracts");
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//*[@id=\"flash-messages\"]"));
        Assert.assertTrue(errorMessage.isDisplayed());


    }
}
