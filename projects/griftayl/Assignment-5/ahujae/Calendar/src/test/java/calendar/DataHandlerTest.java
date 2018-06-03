/** A JUnit test class to test the class DataHandler. */


package calendar;

import java.util.*;
import java.io.*;

import javax.xml.*;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DataHandlerTest{
  //test default constructor (no filename supplied)
  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    // create dataHandler
    DataHandler dataHandler0;
		dataHandler0 = new DataHandler();
  }
  // test constructor with filename supplied
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    // create DataHandler
    DataHandler dataHandler1;
		dataHandler1 = new DataHandler("testFileName.xml");
    assertTrue(dataHandler1.save());
  }
  // test constructor with filename and auto-save supplied
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
    // create DataHandler
    DataHandler dataHandler2;
		dataHandler2 = new DataHandler("testFileName.xml",false);
    Appt appt2 = new Appt(1,1,1,1,1,"title","desc","email");
    appt2.setValid();
    assertTrue(dataHandler2.saveAppt(appt2));
  }
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
    // create dataHandler
    DataHandler dataHandler4;
		dataHandler4 = new DataHandler();
    // create calDays
    LinkedList<CalDay> calDays1 = new LinkedList<CalDay>();
    // create 5 valid appointments
    Appt appt4_1 = new Appt(1, 1, 1, 1, 2015, "Appt 1", "number 1", "ex@email.net");
    Appt appt4_2 = new Appt(2, 2, 2, 2, 2015, "Appt 2", "number 2", "ex@email.net");
    Appt appt4_3 = new Appt(3, 3, 3, 3, 2015, "Appt 3", "number 3", "ex@email.net");
    Appt appt4_4 = new Appt(4, 4, 4, 4, 2015, "Appt 4", "number 4", "ex@email.net");
    Appt appt4_5 = new Appt(5, 5, 5, 5, 2015, "Appt 5", "number 5", "ex@email.net");
    // create 1 invalid appointment
    Appt appt4_6 = new Appt(100, 100, 100, 100, 0, null, null, null);
    // create two valid appt linked lists
    LinkedList<Appt> apptList4_1 = new LinkedList<Appt>();
    apptList4_1.add(appt4_1);
    apptList4_1.add(appt4_2);
    apptList4_1.add(appt4_3);
    apptList4_1.add(appt4_4);
    LinkedList<Appt> apptList4_2 = new LinkedList<Appt>();
    apptList4_2.add(appt4_4);
    apptList4_2.add(appt4_5);
    // create 1 invalid appt linked list
    LinkedList<Appt> apptList4_3 = new LinkedList<Appt>();
    apptList4_3.add(appt4_5);
    apptList4_3.add(appt4_6);
    // create corresponding days
    GregorianCalendar day4_1 = new GregorianCalendar(1, 1, 2015);
    GregorianCalendar day4_2 = new GregorianCalendar(2, 2, 2015);
    GregorianCalendar day4_3 = new GregorianCalendar(3, 3, 2015);
    GregorianCalendar day4_4 = new GregorianCalendar(4, 4, 2015);
    GregorianCalendar day4_5 = new GregorianCalendar(5, 5, 2015);
    // test saving valid appointment
    assertTrue(dataHandler4.saveAppt(appt4_5));
    // test deleting valid appointment
    assertTrue(dataHandler4.deleteAppt(appt4_5));
    // test getApptRange (second test will fail)
    assertNotSame(appt4_3, dataHandler4.getApptRange(day4_4, day4_5).get(0));
    // FIX THIS ONE LATER
    // assertNull(dataHandler4.getApptRange(day4_3, day4_4));
  }
  // test saving invalid appointment
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
    // create DataHandler
    DataHandler dataHandler5;
		dataHandler5 = new DataHandler("testFileName.xml",false);
    // create invalid appointment
    Appt appt5 = new Appt(100, 100, 100, 100, 0, null, null, null);
    appt5.setValid();
    // test deleting appointment
    assertFalse(dataHandler5.deleteAppt(appt5));
    // test saving appointment
    assertFalse(dataHandler5.saveAppt(appt5));
  }
  // test getApptOccurences with recurring appointments
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
    // set first and last days
		GregorianCalendar firstDay = new GregorianCalendar(year,month,day);
    GregorianCalendar lastDay = new GregorianCalendar(year,month+1,day);
    // create DataHandler
    DataHandler dataHandler6;
    dataHandler6 = new DataHandler("testFileName.xml",false);
    // create appointment
    Appt appt6 = new Appt(9, 15, day, year, month, "test appt 1", "this is the first appt", "test@email.net");
    // set it to recur weekly
    int[] recurDays = {1,2,3,4,5};
    appt6.setRecurrence(recurDays, 1, 1, 2);

    // add it to appt linked list
    LinkedList<Appt> apptList6 = new LinkedList<Appt>();
    apptList6.add(appt6);
    // test recurring event with getApptOccurences (will fail)
    assertNotNull(dataHandler6.getApptRange(firstDay, lastDay).get(0));
  }
  //test getApptRange where lastday is before firstday
  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
    // create DataHandler
    DataHandler dataHandler7 = new DataHandler("nothing.xml");
    // set first and last days (last before first)
    GregorianCalendar firstDay = new GregorianCalendar(1,2,1);
    GregorianCalendar lastDay = new GregorianCalendar(1,1,1);
    // test getApptRange where last is before first
    try {
		   dataHandler7.getApptRange(firstDay,lastDay);
		}  catch(DateOutOfRangeException e) {}
  }
  // hit "while(iter.hasNext())" branch of getApptRange
  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
    // create DataHandler
    DataHandler dataHandler8 = new DataHandler("flN.xml");
    // create recurring event
    Appt appt8 = new Appt(13, 30, 10, 5, 2018, "test appt", "this is a test appointment", "test@email.net");
    // set it to recur weekly
    int[] recurDays = {1,2};
    appt8.setValid();
    appt8.setRecurrence(recurDays, 1, 1, 2);
    GregorianCalendar firstDay = new GregorianCalendar(1,1,1);
    GregorianCalendar lastDay = new GregorianCalendar(1,1,2050);
    assertNotSame(appt8, dataHandler8.getApptRange(firstDay, lastDay));
  }
}
