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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US92 extends TestBase {


    @DataProvider(name = "SalesManager")
    public Object[][] truckDriver() {
        return new Object[][]{
                {"storemanager55" }, {"storemanager56" }, {"storemanager57" }, {"storemanager58" }
        };

    }
@Test(dataProvider = "SalesManager")
    public void store_manager_shouldSeeCheckBoxes(String salesManagerUsername){
        //login to the page as a Store Manager

   VytrackUtils.login(salesManagerUsername,ConfigurationReader.getProperty("password"));



     //locating "marketing" tab
    Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[6]")).click();
     // locating "Campaigns" tab
    Driver.getDriver().findElement(By.xpath("//span[.='Campaigns']")).click();

    BrowserUtils.sleep(3);
   // locating Grid Settings and click it
    Driver.getDriver().findElement(By.xpath("//a[@title='Grid Settings']")).click();

 // locating all checkBoxes
    List<WebElement> allCheckBoxes= Driver.getDriver().findElements(By.xpath("//input[contains (@id,'column-c')]"));
    //locating if the checkBoxes are selected
    allCheckBoxes.forEach(p->Assert.assertTrue(p.isSelected()));

    BrowserUtils.sleep(2);

    //Uncheck all checkBoxes and verify all is unselected

    for (WebElement each: allCheckBoxes){

        each.click();
        Assert.assertTrue(each.isSelected());

        for (int i = 0; i < allCheckBoxes.size()-1; i++) {
            allCheckBoxes.get(i).click();
            Assert.assertTrue(!(allCheckBoxes.get(i).isSelected()));

        }
    }

//input[@id='column-c95']





    }
}
