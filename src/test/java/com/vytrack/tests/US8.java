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
        BrowserUtils.sleep(10);


        BrowserUtils.sleep(10);
        WebElement activitebutton = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[3]"));
        activitebutton.click();
        BrowserUtils.sleep(10);

        WebElement Calenderbutton = driver.findElement(By.xpath("//span[.='Calendar Events']"));
        Calenderbutton.click();
        WebElement calender= driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        calender.click();
        BrowserUtils.sleep(10);
        driver.findElement(By.xpath("//*[@id=\"oro_calendar_event_form-uid-6227e795664b4\"]/div[2]/div[2]/div/div[1]/div[2]/div/fieldset/div[2]/div[2]/div[1]/div[1]/label")).click();
        BrowserUtils.sleep(10);
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
