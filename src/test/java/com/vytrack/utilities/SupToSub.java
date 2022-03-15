package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SupToSub {
    public static void goToPage(String superTab,String subTab){
        String TabElementLocator = "//span[normalize-space()='"+superTab+"' and contains(@class, 'title title-level-1')]";

        WebElement TabElement = Driver.getDriver().findElement(By.xpath(TabElementLocator));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(TabElement).perform();

        String subModuleLocator = "//span[normalize-space()='"+subTab+"' and contains(@class, 'title title-level-2')]";
        WebElement vehiclesModelElement = Driver.getDriver().findElement(By.xpath(subModuleLocator));
        //we are using for waiting until loader mask disappearing
        VytrackUtils.waitTillLoaderMaskDisappear();
        vehiclesModelElement.click();
        VytrackUtils.waitTillLoaderMaskDisappear();
    }

}
