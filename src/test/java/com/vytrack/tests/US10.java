package com.vytrack.tests;

import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;
import com.vytrack.pages.CalendarEventPage;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US10 {
    CalendarEventPage calendarEventPage;
    Actions actions;
    Faker faker;
    WebDriverWait wait;

    @BeforeMethod
    private void driverSetup() {
        calendarEventPage = new CalendarEventPage();
        actions = new Actions(Driver.getDriver());
        faker = new Faker();
        wait = new WebDriverWait(Driver.getDriver(), 10);
    }

    @AfterMethod
    private void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void calendar_event_creation_typeIn_test() {

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
        String inputText = faker.letterify("?????? ????????? ????? ??????");
        Driver.getDriver().switchTo().frame(calendarEventPage.frame);
        calendarEventPage.descriptionInbox.sendKeys(inputText);

//Verify entered text is displayed in the Description input box

        Assert.assertEquals(calendarEventPage.textMessage.getText(), inputText);

        Driver.getDriver().switchTo().defaultContent();

    }

    @Test
    public void calendar_event_creation_copyPaste_test() {
        VytrackUtils.loginAsSalesManager();
        wait.until(ExpectedConditions.visibilityOf(calendarEventPage.activitiesTab));       // BrowserUtils.sleep(1);
        actions.click().moveToElement(calendarEventPage.activitiesTab).perform();
        calendarEventPage.calendarEventsTab.click();
        calendarEventPage.createBtn.click();
        String inputText = faker.letterify("?????? ????????? ????? ??????");
        Driver.getDriver().switchTo().frame(calendarEventPage.frame);
        calendarEventPage.descriptionInbox.sendKeys(inputText);

//Pass the copied test from the clipboard (by copy-pasting it) into the Description input box
        calendarEventPage.descriptionInbox.sendKeys(Keys.CONTROL,"A");
        calendarEventPage.descriptionInbox.sendKeys(Keys.CONTROL, "X");
        calendarEventPage.descriptionInbox.sendKeys(Keys.CONTROL, "V");

//Verify entered text is displayed in the Description input box

        Assert.assertEquals(calendarEventPage.textMessage.getText(), inputText);

        Driver.getDriver().switchTo().defaultContent();

    }
}
