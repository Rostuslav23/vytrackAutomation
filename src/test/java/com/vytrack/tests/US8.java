package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US8{





    WebDriver driver;
    @Test
    public void test1() throws InterruptedException {
        VytrackUtils.loginAsDriver();




        WebElement activitebutton = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[3]"));
        BrowserUtils.sleep(10);
        activitebutton.click();


        WebElement Calenderbutton = driver.findElement(By.xpath("//span[.='Calendar Events']"));
        BrowserUtils.sleep(10);
        Calenderbutton.click();
        WebElement calender= driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        BrowserUtils.sleep(10);
        calender.click();

        driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]")).click();

        Select select=new Select(driver.findElement(By.xpath("//input[@name=\"temp-validation-name-1579\"]")));

        String actual=select.getFirstSelectedOption().getText();
        String expected="1";

        Assert.assertEquals(actual,expected);


        WebElement repeat = driver.findElement(By.xpath("//input[@class='recurrence-subview-control__number error']"));
        repeat.clear();

        String actualdropdown=repeat.getText();
        String expecteddropdown="This value should not be blank.";

        Assert.assertEquals(actualdropdown,expecteddropdown);


    }
}
