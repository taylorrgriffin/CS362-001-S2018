/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;

public class ApptTest  {
  // test full constructor and get methods
  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      // initliaze test attributes
      int startHour = 15;
      int startMinute = 30;
      int startDay = 14;
      int startMonth = 9;
      int startYear = 2018;
      String title = "Birthday Party";
      String description = "This is my birthday party";
      String emailAddress = "xyz@gmail.com";
      // create appointment with attributes
      Appt appt0 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
      // test get methods
      assertEquals(30, appt0.getStartMinute());
      assertEquals(14, appt0.getStartDay());
      assertEquals(9, appt0.getStartMonth());
      assertEquals(2018, appt0.getStartYear());
      assertEquals("This is my birthday party", appt0.getDescription());
      assertEquals("xyz@gmail.com", appt0.getEmailAddress());
      assertTrue(appt0.getValid());
      /*
      These last two tests will fail because of a bug I introduced from assignment-1
      */
      assertEquals(15, appt0.getStartHour());
      assertEquals("Birthday Party", appt0.getTitle());
  }
  // test alt constructor and set methods
  @Test(timeout = 4000)
  public void test01()  throws Throwable {
    // initliaze test attributes
    int startDay = 14;
    int startMonth = 9;
    int startYear = 2018;
    String title = null;
    String description = null;
    String emailAddress = null;
    // create appointment with attributes
    Appt appt1 = new Appt(startDay, startMonth, startYear, title, description, emailAddress);
    // test alt constructor worked properly
    assertEquals(14, appt1.getStartDay());
    assertEquals(9, appt1.getStartMonth());
    assertEquals(2018, appt1.getStartYear());
    // use set methods
    appt1.setStartHour(10);
    appt1.setStartMinute(15);
    appt1.setStartDay(20);
    appt1.setStartMonth(5);
    appt1.setStartYear(2019);
    appt1.setTitle("Test Title");
    appt1.setDescription("Test Description");
    appt1.setXmlElement(null);
    appt1.setValid();
    // test set methods
    assertNull(appt1.getXmlElement());
    assertTrue(appt1.getValid());
    assertEquals(15, appt1.getStartMinute());
    assertEquals(20, appt1.getStartDay());
    assertEquals(5, appt1.getStartMonth());
    assertEquals(2019, appt1.getStartYear());
    assertEquals("Test Description", appt1.getDescription());
    /*
    These last two tests will fail because of a bug I introduced from assignment-1
    */
    assertEquals("Test Title", appt1.getTitle());
    assertEquals(10, appt1.getStartHour());
  }
  // test isOn and recurrence methods
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
    // initliaze test attributes
    int[] recurDays = {2,3,4};
    int startHour = 12;
    int startMinute = 0;
    int startDay = 1;
    int startMonth = 1;
    int startYear = 2020;
    String title = null;
    String description = null;
    String emailAddress = null;
    // create appointment with attributes
    Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    // create second appointment to hit first branch of setRecurDays
    Appt appt2_2 = new Appt(startHour + 1, startMinute + 1, startDay + 1, startMonth, startYear, title, description, emailAddress);
    // set recurrence
    appt2.setRecurrence(recurDays,Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
    appt2_2.setRecurrence(null,Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
    // test isRecurring and getRecur Methods
    assertTrue(appt2.isRecurring());
    assertEquals(recurDays, appt2.getRecurDays());
    assertEquals(Appt.RECUR_BY_WEEKLY, appt2.getRecurBy());
    assertEquals(2, appt2.getRecurIncrement());
    assertEquals(Appt.RECUR_NUMBER_FOREVER, appt2.getRecurNumber());
    // test isRecurring for other appointment
    assertTrue(appt2_2.isRecurring());
    // test isOn with correct date
    assertTrue(appt2.isOn(1,1,2020));
    // test isOn with incorrect dates
    assertFalse(appt2.isOn(0,1,2020));
    assertFalse(appt2.isOn(1,0,2020));
    assertFalse(appt2.isOn(1,1,2021));
  }
  // test toString with valid appointment
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
    // initliaze test attributes
    int startHour = 12;
    int startMinute = 0;
    int startDay = 1;
    int startMonth = 1;
    int startYear = 2020;
    String title = "Test Title";
    String description = "Test Description";
    String emailAddress = "test@email.com";
    // create valid appointment
    Appt appt3 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    // test toString
    assertEquals("1/1/2020 at 12:00 pm , Test Title , Test Description",appt3.toString());
  }
  // test all branches of setValid
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
    // initliaze test attributes
    int startHour = 12;
    int startMinute = 0;
    int startDay = 1;
    int startMonth = 1;
    int startYear = 2020;
    String title = "Test Title";
    String description = "Test Description";
    String emailAddress = "test@email.com";
    // startMonth < 1
    Appt appt4 = new Appt(startHour, startMinute, startDay, 0, startYear, title, description, emailAddress);
    appt4.setValid();
    // startHour < 0
    Appt appt4_2 = new Appt(-10, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    appt4_2.setValid();
    // startMinute < 0
    Appt appt4_3 = new Appt(startHour, -10, startDay, startMonth, startYear, title, description, emailAddress);
    appt4_3.setValid();
    // startYear <= 0
    Appt appt4_4 = new Appt(startHour, startMinute, startDay, startMonth, 0, title, description, emailAddress);
    appt4_4.setValid();
    // startDay < 1
    Appt appt4_5 = new Appt(startHour, startMinute, -10, startMonth, 0, title, description, emailAddress);
    appt4_5.setValid();
    // test validity of appointments (all should be invalid)
    assertFalse(appt4.getValid());
    assertFalse(appt4_2.getValid());
    assertFalse(appt4_3.getValid());
    assertFalse(appt4_4.getValid());
    assertFalse(appt4_5.getValid());
  }
  // test toString with invalid appointment
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
    // initliaze test attributes
    int startHour = 12;
    int startMinute = 0;
    int startDay = 1;
    int startMonth = 1;
    int startYear = 2020;
    String title = "Test Title";
    String description = "Test Description";
    String emailAddress = "test@email.com";
    // create invalid appointment
    Appt appt5 = new Appt(-1, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    appt5.setValid();
    // test toString
    assertNull(appt5.toString());
  }

}
