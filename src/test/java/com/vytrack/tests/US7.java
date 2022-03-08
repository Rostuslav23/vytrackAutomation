package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;

public class US7 extends TestBase {
    //testing checkboxes for only store manager, as truck manager and sales manager checkboxes have bugs
    @DataProvider(name = "StoreManagersLogin")
    public Object[][] storeManager(){
        return new Object[][]{
                {"storemanager55"},{"storemanager56"},{"storemanager57"},{"storemanager58"}
        };
    }
    @Test(dataProvider = "StoreManagersLogin", priority = 1)
    public void store_manager_view_unchecked_checkboxes(String storeManagerUsername){
        VytrackUtils.login(storeManagerUsername,ConfigurationReader.getProperty("password"));
        // Using Action class to hover over
        Actions actions = new Actions(Driver.getDriver());
        //locating "FLeet" button and going on it
        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        BrowserUtils.sleep(2);
        //locating "Vehicle" button, going on it, and click
        WebElement vehiclesBtn = Driver.getDriver().findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']/span"));
        actions.moveToElement(fleetBtn).pause(1000).moveToElement(vehiclesBtn).pause(1000).click(vehiclesBtn).build().perform();

        //finding all checkboxes
        List<WebElement> allCheckBoxes = Driver.getDriver().findElements(By.xpath("//input[@data-role='select-row-cell']"));
        //verify all of them are unchecked by using !isSelected() method
        allCheckBoxes.forEach(p-> Assert.assertTrue(!(p.isSelected())));

    }
    @Test(dataProvider = "StoreManagersLogin",priority = 2)
    public void store_managers_click_first_checkbox_to_check_all_the_cars(String storeManagerUsername){
        VytrackUtils.login(storeManagerUsername,ConfigurationReader.getProperty("password"));
        // Using Action class to hover over
        Actions actions = new Actions(Driver.getDriver());
        //locating "FLeet" button and going on it
        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        BrowserUtils.sleep(2);
        //locating "Vehicle" button, going on it, and click
        WebElement vehiclesBtn = Driver.getDriver().findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']/span"));
        actions.moveToElement(fleetBtn).pause(1000).moveToElement(vehiclesBtn).pause(1000).click(vehiclesBtn).build().perform();

        List<WebElement> allCheckBoxes = Driver.getDriver().findElements(By.xpath("//input[@data-role='select-row-cell']"));
        Driver.getDriver().findElement(By.xpath("(//div[@class='btn-group dropdown']//input)[1]")).click();
        BrowserUtils.sleep(2);
        allCheckBoxes.forEach(p-> Assert.assertTrue((p.isSelected())));
    }
    @Test(dataProvider = "StoreManagersLogin",priority = 3)
    public void store_managers_check_any_cars_checkbox(String storeManagerUsername){
        VytrackUtils.login(storeManagerUsername,ConfigurationReader.getProperty("password"));
        // Using Action class to hover over
        Actions actions = new Actions(Driver.getDriver());
        //locating "FLeet" button and going on it
        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        BrowserUtils.sleep(2);
        //locating "Vehicle" button, going on it, and click
        WebElement vehiclesBtn = Driver.getDriver().findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']/span"));
        actions.moveToElement(fleetBtn).pause(2000).moveToElement(vehiclesBtn).pause(1000).click(vehiclesBtn).build().perform();

        //finding all checkboxes
        List<WebElement> allCheckBoxes = Driver.getDriver().findElements(By.xpath("//input[@data-role='select-row-cell']"));
        //making sure all checkboxes are NOT selected
        allCheckBoxes.forEach(p-> Assert.assertTrue(!(p.isSelected())));
        //clicking each check box then make sure it is selected
        for (WebElement eachCheckBox : allCheckBoxes) {
            eachCheckBox.click();
            Assert.assertTrue(eachCheckBox.isSelected());
        }

    }
}

