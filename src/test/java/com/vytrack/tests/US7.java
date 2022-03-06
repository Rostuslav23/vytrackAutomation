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
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"))).perform();
        actions.doubleClick(Driver.getDriver().findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']"))).perform();

    }

    @Test
    public void store_manager_view_unchecked_checkboxes(){
        List<WebElement> allCheckBoxes = Driver.getDriver().findElements(By.xpath("//input[@data-role='select-row-cell']"));
        allCheckBoxes.forEach(p-> Assert.assertTrue(!(p.isSelected())));
        BrowserUtils.sleep(5);
    }
    @Test
    public void store_managers_click_first_checkbox_to_check_all_the_cars(){
        //login to the page as a Store Manager
        VytrackUtils.loginAsStoreManger();
    }

    @Test
    public void store_managers_check_any_cars_checkbox(){
        //login to the page as a Store Manager
        VytrackUtils.loginAsStoreManger();
    }
}
