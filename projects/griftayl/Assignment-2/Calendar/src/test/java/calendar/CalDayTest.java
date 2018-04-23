/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.LinkedList;
import java.util.GregorianCalendar;

public class CalDayTest{
  // test default constructor
  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    CalDay calDay0 = new CalDay();
    assertFalse(calDay0.isValid());
  }
  // test constructor given 1 argument
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    GregorianCalendar gregDay1 = new GregorianCalendar(1,1,2017);
    CalDay calDay1 = new CalDay(gregDay1);
    assertTrue(calDay1.isValid());
  }
  // test addAppt, getSizeAppts, and getYear
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
    // initialize day
    GregorianCalendar gregDay2 = new GregorianCalendar(1,1,2017);
    CalDay calDay2 = new CalDay(gregDay2);
    // initialize appointment
    int startHour = 15;
    int startMinute = 30;
    int startDay = 14;
    int startMonth = 9;
    int startYear = 2018;
    String title = "Birthday Party";
    String description = "This is my birthday party";
    String emailAddress = "xyz@gmail.com";
    Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    // add the appointment to the day
    calDay2.addAppt(appt2);
    // test number of appointments (should be 1)
    assertEquals(1, calDay2.getSizeAppts());
    // test the appointment is on the right year
    assertEquals(2018, calDay2.getYear());
  }
  // test getDay
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
    // initialize day
    GregorianCalendar gregDay3 = new GregorianCalendar(1,1,2017);
    CalDay calDay3 = new CalDay(gregDay3);
    // initialize appointment
    int startHour = 15;
    int startMinute = 30;
    int startDay = 14;
    int startMonth = 9;
    int startYear = 2018;
    String title = "Birthday Party";
    String description = "This is my birthday party";
    String emailAddress = "xyz@gmail.com";
    Appt appt3 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    // add the appointment to the day
    calDay3.addAppt(appt3);
    // test the appointment is on the right day
    assertEquals(14, calDay3.getDay());
  }
  // test getMonth
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
    // initialize day
    GregorianCalendar gregDay4 = new GregorianCalendar(1,1,2017);
    CalDay calDay4 = new CalDay(gregDay4);
    // initialize appointment
    int startHour = 15;
    int startMinute = 30;
    int startDay = 14;
    int startMonth = 9;
    int startYear = 2018;
    String title = "Birthday Party";
    String description = "This is my birthday party";
    String emailAddress = "xyz@gmail.com";
    Appt appt4 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    // add the appointment to the day
    calDay4.addAppt(appt4);
    // test the appointment is on the right month
    assertEquals(9, calDay4.getMonth());
  }
  // test toString with invalid day
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
    CalDay calDay5 = new CalDay();
    assertEquals("",calDay5.toString());
  }
  // test toString with valid day
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
    GregorianCalendar gregDay6 = new GregorianCalendar(1,1,2017);
    CalDay calDay6 = new CalDay(gregDay6);
    assertEquals("01/01/2017",calDay6.toString());
  }
  // test getFullInfomrationApp with valid day with no appointments
  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
    GregorianCalendar gregDay7 = new GregorianCalendar(5,5,2017);
    CalDay calDay7 = new CalDay(gregDay7);
    assertEquals("5-5-2017",calDay7.getFullInfomrationApp(calDay7));
  }
  // test getFullInfomrationApp with valid day (one appointment)
  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
    // create day
    GregorianCalendar gregDay8 = new GregorianCalendar(5,5,2017);
    CalDay calDay8 = new CalDay(gregDay8);
    // initialize appointment
    int startHour = 15;
    int startMinute = 30;
    int startDay = 14;
    int startMonth = 9;
    int startYear = 2018;
    String title = "Birthday Party";
    String description = "This is my birthday party";
    String emailAddress = "xyz@gmail.com";
    Appt appt8 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    // add the appointment to the day
    calDay8.addAppt(appt8);
    // test getFullInfomrationApp
    assertEquals("5-5-2017",calDay8.getFullInfomrationApp(calDay8));
  }
  // test getFullInfomrationApp with valid day (three appointments)
  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
    // create day
    GregorianCalendar gregDay9 = new GregorianCalendar(10,10,2030);
    CalDay calDay9 = new CalDay(gregDay9);
    // initialize appointments
    int startHour = 15;
    int startMinute = 30;
    int startDay = 14;
    int startMonth = 9;
    int startYear = 2018;
    String title = "Birthday Party";
    String description = "This is my birthday party";
    String emailAddress = "xyz@gmail.com";
    // create and validate appointments
    Appt appt9 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt9_2 = new Appt(startHour - 10, startMinute + 25, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt9_3 = new Appt(0, startMinute - 29, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt9_4 = new Appt(-10, -1, startDay, startMonth, startYear, title, description, emailAddress);
    appt9.setValid();
    appt9_2.setValid();
    appt9_3.setValid();
    appt9_4.setValid();
    // add appointments to the day
    calDay9.addAppt(appt9);
    calDay9.addAppt(appt9_2);
    calDay9.addAppt(appt9_3);
    calDay9.addAppt(appt9_4);
    // test getFullInfomrationApp
    assertEquals("10-10-2030",calDay9.getFullInfomrationApp(calDay9));
  }
  // test toString with valid day (1 appointment)
  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
    GregorianCalendar gregDay10 = new GregorianCalendar(3,2,2010);
    CalDay calDay10 = new CalDay(gregDay10);
    // initialize appointments
    int startHour = 15;
    int startMinute = 30;
    int startDay = 14;
    int startMonth = 9;
    int startYear = 2018;
    String title = "Birthday Party";
    String description = "This is my birthday party";
    String emailAddress = "xyz@gmail.com";
    // create and validate appointments
    Appt appt10 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    appt10.setValid();
    calDay10.addAppt(appt10);
    assertEquals("03/02/2010",calDay10.toString());
  }
  // test toString with valid day (with 1 invalid appointment)
  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
    GregorianCalendar gregDay11 = new GregorianCalendar(10,15,1998);
    CalDay calDay11 = new CalDay(gregDay11);
    // initialize appointments
    int startHour = -10;
    int startMinute = 65;
    int startDay = 100;
    int startMonth = 9;
    int startYear = 2090;
    String title = "Birthday Party";
    String description = "This is my birthday party";
    String emailAddress = "xyz@gmail.com";
    // create and validate appointments
    Appt appt11 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    appt11.setValid();
    calDay11.addAppt(appt11);
    assertEquals("10/15/1998",calDay11.toString());
  }

}
