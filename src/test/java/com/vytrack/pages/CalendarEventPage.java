package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventPage {

    public CalendarEventPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='title title-level-1'][normalize-space()='Activities']")
    public WebElement activitiesTab;

    @FindBy(xpath = "//a[@href='/calendar/event']/span[text()='Calendar Events']")
    public WebElement calendarEventsTab;

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    public WebElement createBtn;

    @FindBy(xpath = "//div[@id='mceu_24']//iframe")
    public WebElement frame;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement descriptionInbox;

    @FindBy(xpath = "//body[@id='tinymce']//p")
    public WebElement textMessage;

}
