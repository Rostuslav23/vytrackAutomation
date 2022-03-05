package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class US7 extends TestBase {
    //testing checkboxes for only store manager, as truck manager and sales manager checkboxes have bugs

    @Test
    public void store_manager_view_unchecked_checkboxes(){
        //login to the page as a Store Manager
        VytrackUtils.loginAsStoreManger();
        BrowserUtils.sleep(5);
        Driver.getDriver().findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']"));
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
