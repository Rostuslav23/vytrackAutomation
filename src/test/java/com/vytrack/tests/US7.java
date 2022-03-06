package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class US7 extends TestBase {
    //testing checkboxes for only store manager, as truck manager and sales manager checkboxes have bugs

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        VytrackUtils.loginAsStoreManger();
    }
//
//        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]")));
//        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']"))).perform();
//        actions.click().build().perform();
//        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]")));
    @Test(priority = 1)
    public void store_manager_view_unchecked_checkboxes(){
        // Using Action class to hover over
        Actions actions = new Actions(Driver.getDriver());
        //locating "FLeet" button and going on it
        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        BrowserUtils.sleep(2);
        actions.moveToElement(fleetBtn).build().perform();
        BrowserUtils.sleep(2);
        //locating "Vehicle" button, going on it, and click
        WebElement vehiclesBtn = Driver.getDriver().findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']/span"));
        actions.moveToElement(vehiclesBtn).build().perform();
        BrowserUtils.sleep(2);
        vehiclesBtn.click();
        //finding all checkboxes
        List<WebElement> allCheckBoxes = Driver.getDriver().findElements(By.xpath("//input[@data-role='select-row-cell']"));
        //verify all of them are unchecked by using !isSelected() method
        allCheckBoxes.forEach(p-> Assert.assertTrue(!(p.isSelected())));

    }
    @Test(priority = 2)
    public void store_managers_click_first_checkbox_to_check_all_the_cars(){
        // Using Action class to hover over
        Actions actions = new Actions(Driver.getDriver());
        //locating "FLeet" button and going on it
        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        BrowserUtils.sleep(2);
        actions.moveToElement(fleetBtn).build().perform();
        BrowserUtils.sleep(2);
        //locating "Vehicle" button, going on it, and click
        WebElement vehiclesBtn = Driver.getDriver().findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']/span"));
        actions.moveToElement(vehiclesBtn).build().perform();
        BrowserUtils.sleep(2);
        vehiclesBtn.click();

        List<WebElement> allCheckBoxes = Driver.getDriver().findElements(By.xpath("//input[@data-role='select-row-cell']"));
        Driver.getDriver().findElement(By.xpath("(//div[@class='btn-group dropdown']//input)[1]")).click();
        BrowserUtils.sleep(2);
        allCheckBoxes.forEach(p-> Assert.assertTrue((p.isSelected())));
    }

    @Test(priority = 3)
    public void store_managers_check_any_cars_checkbox(){
        // Using Action class to hover over
        Actions actions = new Actions(Driver.getDriver());
        //locating "FLeet" button and going on it
        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        BrowserUtils.sleep(2);
        actions.moveToElement(fleetBtn).build().perform();
        BrowserUtils.sleep(2);
        //locating "Vehicle" button, going on it, and click
        WebElement vehiclesBtn = Driver.getDriver().findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']/span"));
        actions.moveToElement(vehiclesBtn).build().perform();
        BrowserUtils.sleep(2);
        vehiclesBtn.click();

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

