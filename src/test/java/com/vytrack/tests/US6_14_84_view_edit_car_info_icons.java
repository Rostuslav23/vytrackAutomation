package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US6_14_84_view_edit_car_info_icons  extends TestBase {

    // We are login as a Driver
    @Test
    public void login_and_view_fleet_vehicles_asDriver()  {

            VytrackUtils.loginAsDriver();

            BrowserUtils.sleep(2);
            Actions actions = new Actions(Driver.getDriver());


            //Locate Fleet
            WebElement fleet_module = Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div[2]/header/div[2]/ul/li[1]/a/span"));
            actions.moveToElement(fleet_module).perform();

            BrowserUtils.sleep(2);

            //Locate Vehicles
            WebElement vehicles_module = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span"));
            vehicles_module.click();

            BrowserUtils.sleep(2);


            //Locate "..." dots
            //2. Hover over to "..."
            WebElement threedots = Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[20]/div/div/a"));
            actions.moveToElement(threedots).perform();

            BrowserUtils.sleep(5);

            //Locate 3 oprions such as: eye_button edit_button trash_button
            WebElement eye_button = Driver.getDriver().findElement(By.xpath("/html/body/ul/li/ul/li[1]/a"));
            WebElement edit_button = Driver.getDriver().findElement(By.xpath("/html/body/ul/li/ul/li[2]/a/i"));
            WebElement trash_button = Driver.getDriver().findElement(By.xpath("/html/body/ul/li/ul/li[3]/a/i"));

            Assert.assertTrue(eye_button.isDisplayed());
            Assert.assertTrue(edit_button.isDisplayed());
            Assert.assertTrue(trash_button.isDisplayed());

        BrowserUtils.sleep(2);

        }

    // We are login as a Sales Manager
    @Test
    public void login_and_view_fleet_vehicles_asSaleManager (){

        VytrackUtils.loginAsSalesManager();

        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());


        //Locate Fleet
        WebElement fleet_module = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        actions.moveToElement(fleet_module).perform();

        BrowserUtils.sleep(2);

        //Locate Vehicles
        WebElement vehicles_module = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span"));
        vehicles_module.click();

        BrowserUtils.sleep(2);


        //Locate "..." dots
        //2. Hover over to "..."
        WebElement threedots = Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[20]/div/div/a"));
        actions.moveToElement(threedots).perform();

        BrowserUtils.sleep(5);

        //Locate 3 oprions such as: eye_button edit_button trash_button
        WebElement eye_button = Driver.getDriver().findElement(By.xpath("/html/body/ul/li/ul/li[1]/a"));
        WebElement edit_button = Driver.getDriver().findElement(By.xpath("/html/body/ul/li/ul/li[2]/a/i"));
        WebElement trash_button = Driver.getDriver().findElement(By.xpath("/html/body/ul/li/ul/li[3]/a/i"));

        Assert.assertTrue(eye_button.isDisplayed());
        Assert.assertTrue(edit_button.isDisplayed());
        Assert.assertTrue(trash_button.isDisplayed());

        BrowserUtils.sleep(2);

    }

    // We are login as a Store Manager
    @Test
    public void login_and_view_fleet_vehicles_asStoreManager ()  {
        VytrackUtils.loginAsStoreManger();

        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());


        //Locate Fleet
        WebElement fleet_module = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        actions.moveToElement(fleet_module).perform();

        BrowserUtils.sleep(2);

        //Locate Vehicles
        WebElement vehicles_module = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span"));
        vehicles_module.click();

        BrowserUtils.sleep(2);


        //Locate "..." dots
        //2. Hover over to "..."
        WebElement threedots = Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[21]/div/div/a"));
        actions.moveToElement(threedots).perform();

        BrowserUtils.sleep(5);

        //Locate 3 oprions such as: eye_button edit_button trash_button
        WebElement eye_button = Driver.getDriver().findElement(By.xpath("/html/body/ul/li/ul/li[1]/a"));
        WebElement edit_button = Driver.getDriver().findElement(By.xpath("/html/body/ul/li/ul/li[2]/a/i"));
        WebElement trash_button = Driver.getDriver().findElement(By.xpath("/html/body/ul/li/ul/li[3]/a/i"));

        Assert.assertTrue(eye_button.isDisplayed());
        Assert.assertTrue(edit_button.isDisplayed());
        Assert.assertTrue(trash_button.isDisplayed());
    }
    }
//  AC #1: users should see “view, edit, delete” when they hover the mouse to the three d
/// #1: users should see “view, edit, delete” when they hover the mouse to the three dots “...”.