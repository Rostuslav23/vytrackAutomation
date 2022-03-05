package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.VytrackUtils;
import org.testng.annotations.Test;

public class US7 extends TestBase {
    //testing checkboxes for only store manager, as truck manager and sales manager checkboxes have bugs

    @Test
    public void as_store_manager(){
        VytrackUtils.loginAsStoreManger();
    }


}
