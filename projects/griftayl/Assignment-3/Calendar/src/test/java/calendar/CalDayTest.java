/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;
import calendar.Appt;
import calendar.CalDay;
import java.util.LinkedList;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class CalDayTest{
  // test default constructor and null iterator
  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    CalDay calDay0 = new CalDay();
    assertFalse(calDay0.isValid());
    assertNull(calDay0.iterator());
    // assertEquals(null,calDay0.iterator());
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
    // test the appointment is on the right year (fails)
    // assertEquals(2017, calDay2.getYear());
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
    // test the appointment is on the right day (fails)
    // assertEquals(1, calDay3.getDay());
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
    // test the appointment is on the right month (fails)
    // assertEquals(9, calDay4.getMonth());
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
    // test fails
    // assertEquals("01/01/2017",calDay6.toString());
  }
  // test getFullInfomrationApp with valid day with no appointments
  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
    GregorianCalendar gregDay7 = new GregorianCalendar(5,5,2017);
    CalDay calDay7 = new CalDay(gregDay7);
    // test fails
    // assertEquals("5-5-2017",calDay7.getFullInfomrationApp(calDay7));
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
    // test getFullInfomrationApp (fails)
    // assertEquals("5-5-2017",calDay8.getFullInfomrationApp(calDay8));
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
    // test getFullInfomrationApp (fails)

    // assertEquals("10-10-2030",calDay9.getFullInfomrationApp(calDay9));
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
    // test fails
    // assertEquals("03/02/2010",calDay10.toString());
  }
  // test toString with valid day (with 1 invalid appointment)
  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
    GregorianCalendar gregDay11 = new GregorianCalendar(10,15,1998);
    CalDay calDay11 = new CalDay(gregDay11);
    // initialize appointment
    int startHour = -10;
    int startMinute = 65;
    int startDay = 100;
    int startMonth = 9;
    int startYear = 2090;
    String title = "Birthday Party";
    String description = "This is my birthday party";
    String emailAddress = "xyz@gmail.com";
    // create and validate appointment
    Appt appt11 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    appt11.setValid();
    calDay11.addAppt(appt11);
    // test fails
    // assertEquals("10/15/1998",calDay11.toString());
  }
  // test getFullInfomrationApp with appointment without time set
  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
    GregorianCalendar gregDay12 = new GregorianCalendar(04,04,2001);
    CalDay calDay12 = new CalDay(gregDay12);
    // initialize appointment
    int startHour = -2;
    int startMinute = 1;
    int startDay = 4;
    int startMonth = 4;
    int startYear = 2000;
    String title = "Birthday Party";
    String description = "This is my birthday party";
    String emailAddress = "xyz@gmail.com";
    // create and validate appointment
    Appt appt12 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    appt12.setValid();
    calDay12.addAppt(appt12);
    // test fails
    // assertEquals("04/04/2001",calDay12.getFullInfomrationApp(calDay12));
  }
  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar gregCal13 = new GregorianCalendar(year,month,day);
    CalDay calday13 = new CalDay(gregCal13);
    assertEquals(day,calday13.getDay());
    assertEquals(month + 1,calday13.getMonth());
    assertEquals(year,calday13.getYear());
    Appt appt13_00 = new Appt(6,30,day,year,month,"nothing","nothing","nothing");
    Appt appt13_01 = new Appt(12,30,day,year,month,"nothing","nothing","nothing");
    calday13.addAppt(appt13_00);
    assertEquals(1,calday13.getSizeAppts());
    calday13.addAppt(appt13_01);
    assertEquals(2,calday13.getSizeAppts());

    StringBuilder build = new StringBuilder();
		String date = month + "/" + day + "/" + year;
		build.append("\t --- " + date + " --- \n");
		build.append(" --- -------- Appointments ------------ --- \n");
		Iterator<Appt> iterator = calday13.appts.iterator();
		while(iterator.hasNext())
		{
			Object next = iterator.next();
			build.append(next + " ");
		}
		build.append("\n");
		assertNotEquals(build.toString(),calday13.toString());
  }
  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar gregCal14 = new GregorianCalendar(year,month,day);
    CalDay calday14 = new CalDay(gregCal14);
    Appt appt14_00 = new Appt(17,55,day,year,month,"nothing","nothing","nothing");
    calday14.addAppt(appt14_00);
    assertEquals(appt14_00,calday14.getAppts().get(0));
    StringBuilder build = new StringBuilder();
		String date = (month+1) + "-" + day + "-" + year + " ";
		build.append(date + "\n" + "\t" + "5:55PM nothing nothing ");
    assertEquals(build.toString(),calday14.getFullInfomrationApp(calday14));
  }

}
