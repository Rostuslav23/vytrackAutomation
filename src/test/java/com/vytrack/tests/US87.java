package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US87 extends TestBase{

    WebDriver driver;



    @Test
    public void login() throws InterruptedException {

       driver=Driver.getDriver();

       driver.get("https://app.vytrack.com/user/login");

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(ConfigurationReader.getProperty("driver_username"));

        driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(ConfigurationReader.getProperty("password"));

        driver.findElement(By.xpath("//button[@id='_submit']")).click();


       driver.findElement(By.xpath("(//span[@class='title title-level-1'])[3]")).click();


        driver.findElement(By.xpath("//span[.='Calendar Events']")).click();

        WebElement calender = driver.findElement(By.xpath("(//a[@href=\"/calendar/event/create\"])[3]"));
        Thread.sleep(2000);

        calender.click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='recurrence-repeat-view1031']")).click();


        WebElement repeat = driver.findElement(By.xpath("//input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']"));// THE value cannot be more than 99
        repeat.clear();
        //  repeat.sendKeys("0");
        String expectedTextMin = "The value have not to be less than 1.";
        String actualTextMin = "";

        for (int i = -10; i < 1; i++) {
            repeat.sendKeys(String.valueOf(i));
            actualTextMin = driver.findElement(By.xpath("(//span[.='The value have not to be less than 1.'])[2]")).getText();
            Assert.assertEquals(actualTextMin, expectedTextMin, "Minimum Number didnt pass!");
            repeat.clear();
        }
        String actualTextMax = "";
        String expectedTexMax = ("The value have not to be more than 99.");

        for (int i = 110; i > 100; i--) {
            repeat.sendKeys(String.valueOf(i));
            actualTextMax = driver.findElement(By.xpath("(//span[.='The value have not to be more than 99.'])[2]")).getText();


            Assert.assertEquals(actualTextMax, expectedTexMax, "Maximum Number didnt pass!");
            repeat.clear();

        }
//
//            Assert.assertEquals(actualTextMin,expectedTextMin);
//
//            repeat.clear();
//            repeat.sendKeys("100");
//
//
//
//
//
//
//          Assert.assertEquals(actualTextMax,expectedTexMax);


    }
}
