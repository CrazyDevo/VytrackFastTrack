package com.cydeo.tests;


import com.cydeo.pages.CalendarEventsPage;
import com.cydeo.pages.CreateCalendarEventsPage;
import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {
    /*
    open chrome browser "https://qa3.vytrack.com/user/login"
    login as driver
    go to activities ->Calendar Events
    click on Crete calender events
    verify that repeat everyday is checked
    verify that repeat every week is not checked

     */

    @Test
    public void test1() {
        new LoginPage().loginAsDriver();
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();
        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected(),"verify is seleccted");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify that weekday is not selected");


    }

    /*
    open chrome browser
    login as driver
    go to activities ->Calendar Events
    click on Crete calender events
    click repeat checkbox
    verify that repet options are Daily Weekly,Monthly,Yearly in this order


     */


    @Test
    public void test2() {
        new LoginPage().loginAsDriver();
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();
        Select select = createCalendarEventsPage.repeatOptionsList();
        List<WebElement> options = select.getOptions();
      List<String> expected= Arrays.asList("Daily","Weekly","Monthly","Yearly");
      /*List <String > actual=new ArrayList<>();

        for (WebElement element : options) {
            actual.add(element.getText());
        }
        */

        Assert.assertEquals(BrowserUtils.getElementsText(options),expected,"verify elements");

      // Assert.assertEquals(actual,expected,"verify the elements in order");

    }
}
