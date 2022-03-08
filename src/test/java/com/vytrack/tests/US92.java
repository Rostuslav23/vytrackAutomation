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
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class US92 extends TestBase {


    WebDriver driver;


@Test
    public void store_manager_view_unchecked_checkboxes(){
        //login to the page as a Store Manager

    driver=Driver.getDriver();
    driver.get("https://app.vytrack.com/user/login");

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(ConfigurationReader.getProperty("store_manager_username"));

    driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(ConfigurationReader.getProperty("password"));

    driver.findElement(By.xpath("//button[@id='_submit']")).click();




    driver.findElement(By.xpath("(//span[@class='title title-level-1'])[6]")).click();

    driver.findElement(By.xpath("//span[.='Campaigns']")).click();

    BrowserUtils.sleep(3);

    driver.findElement(By.xpath("//a[@title='Grid Settings']")).click();

    driver.findElement(By.xpath("//input[@id='column-c95']")).click();

    driver.findElement(By.xpath("//input[@id='column-c96']")).click();

    driver.findElement(By.xpath("//input[@id='column-c97']")).click();

    driver.findElement(By.xpath("//input[@id='column-c98']")).click();

    driver.findElement(By.xpath("//input[@id='column-c99']")).click();

//input[@id='column-c95']





    }
}
