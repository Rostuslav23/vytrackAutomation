package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WebTableUtils {

    /**
     * this method is using for finding vehicle model table headers
     *
     * @return List<String> titles
     */

    public static List<String> getHeadersFromVehicleModelTable() {
        List<WebElement> headerElements = Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']//th//span[1]"));
        List<String> headerTitles = new ArrayList<>();
        headerElements.forEach(k -> headerTitles.add(k.getText()));
        return headerTitles;
    }
}
