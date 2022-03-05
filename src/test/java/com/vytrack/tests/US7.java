package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.VytrackUtils;
import org.testng.annotations.Test;

public class US7 extends TestBase {
    //testing module for sales manager

    @Test
    public void as_sales_manager(){
        VytrackUtils.loginAsSalesManager();
    }

    @Test
    public void as_store_manager(){
        VytrackUtils.loginAsStoreManger();
    }

    @Test
    public void as_driver(){
        VytrackUtils.loginAsDriver();
    }
}
