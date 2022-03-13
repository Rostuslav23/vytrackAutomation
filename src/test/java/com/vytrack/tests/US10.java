package com.vytrack.tests;

import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;
import com.vytrack.pages.CalendarEventPage;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US10 {
    CalendarEventPage calendarEventPage;

    @BeforeMethod
    private void driverSetup(){
        calendarEventPage = new CalendarEventPage();
    }


@Test
    public void _test()  {
    Actions actions = new Actions(Driver.getDriver());
    Faker faker =new Faker();

    WebDriverWait wait =new WebDriverWait(Driver.getDriver(),10);

 // As user (Truck driver, Store manager, Sales manager) go to the main page of the website: https://qa1.vytrack.com/
    VytrackUtils.loginAsDriver();

 // On the main menu panel navigate to"Activities" module
    wait.until(ExpectedConditions.visibilityOf(calendarEventPage.activitiesTab));       // BrowserUtils.sleep(1);
    actions.click().moveToElement(calendarEventPage.activitiesTab).perform();           // calendarEventPage.activitiesTab.click();

// and select "Calendar Events" tab
    calendarEventPage.calendarEventsTab.click();

// On the Calendar Events page click "Create Calendar Event" button
    calendarEventPage.createBtn.click();


// Type in text into the Description input box
    String inputText = faker.lorem().fixedString(200);
    Driver.getDriver().switchTo().frame(calendarEventPage.frame);
    calendarEventPage.descriptionInbox.sendKeys(inputText);


//Verify entered text is displayed in the Description input box

    Assert.assertEquals(calendarEventPage.textMessage.getText(),inputText);
    Driver.getDriver().switchTo().defaultContent();

    Driver.closeDriver();
}


}
