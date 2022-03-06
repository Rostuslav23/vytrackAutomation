package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class US8{
    WebDriver driver;
    @Test
    public void test1() throws InterruptedException {
        VytrackUtils.loginAsDriver();
        BrowserUtils.sleep(10);
        Actions actions = new Actions(Driver.getDriver());


        WebElement activitebutton = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[3]"));
        activitebutton.click();

        WebElement Calenderbutton = driver.findElement(By.xpath("//span[.='Calendar Events']"));
        Calenderbutton.click();
        WebElement calender= driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        calender.click();

        driver.findElement(By.xpath("//label[@for=\"recurrence-repeat-view593\"]")).click();

        WebElement repeat = driver.findElement(By.xpath("//input[@class='recurrence-subview-control__number error']"));
        repeat.clear();


    }
}
