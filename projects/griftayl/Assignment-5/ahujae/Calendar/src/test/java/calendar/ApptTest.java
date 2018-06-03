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
    assertNotNull(appt3.toString());
    assertTrue(appt3.hasTimeSet());
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
    Appt appt5 = new Appt(-10000, 1222, -1000, 1000, 2300, title, description, emailAddress);
    appt5.setValid();
    Appt appt5_2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    appt5_2.setValid();
    // test toString with invalid (can't be tested?)
    // assertNull(appt5.toString());
    // test toString with valid
    // assertNotNull(appt5_2.toString());
  }
  // test setValid with appointments of different times/dates
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
    // initliaze test attributes
    int startHour = 12;
    int startMinute = 0;
    int startDay = 1;
    int startMonth = 1;
    int startYear = 2020;
    String title = "Test Title";
    String description = "Test Description";
    String emailAddress = "test@email.com";
    // original appt
    Appt appt6_00 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    // altered startHour
    Appt appt6_01 = new Appt(startHour - 10, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_02 = new Appt(startHour - 8, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_03 = new Appt(startHour - 6, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_04 = new Appt(startHour - 4, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_05 = new Appt(startHour - 2, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_06 = new Appt(startHour + 2, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_07 = new Appt(startHour + 4, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_08 = new Appt(startHour + 6, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_09 = new Appt(startHour + 8, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_10 = new Appt(startHour + 10, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    // altered startMinute
    Appt appt6_11 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_12 = new Appt(startHour, startMinute + 8, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_13 = new Appt(startHour, startMinute + 16, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_14 = new Appt(startHour, startMinute + 24, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_15 = new Appt(startHour, startMinute + 32, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_16 = new Appt(startHour, startMinute + 40, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_17 = new Appt(startHour, startMinute + 48, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_18 = new Appt(startHour, startMinute + 56, startDay, startMonth, startYear, title, description, emailAddress);
    // altered startDay
    Appt appt6_19 = new Appt(startHour, startMinute, startDay + 5, startMonth, startYear, title, description, emailAddress);
    Appt appt6_20 = new Appt(startHour, startMinute, startDay + 10, startMonth, startYear, title, description, emailAddress);
    Appt appt6_21 = new Appt(startHour, startMinute, startDay + 15, startMonth, startYear, title, description, emailAddress);
    Appt appt6_22 = new Appt(startHour, startMinute, startDay + 20, startMonth, startYear, title, description, emailAddress);
    Appt appt6_23 = new Appt(startHour, startMinute, startDay + 25, startMonth, startYear, title, description, emailAddress);
    // altered startMonth
    Appt appt6_24 = new Appt(startHour, startMinute, startDay, startMonth + 2, startYear, title, description, emailAddress);
    Appt appt6_25 = new Appt(startHour, startMinute, startDay, startMonth + 4, startYear, title, description, emailAddress);
    Appt appt6_26 = new Appt(startHour, startMinute, startDay, startMonth + 6, startYear, title, description, emailAddress);
    Appt appt6_27 = new Appt(startHour, startMinute, startDay, startMonth + 8, startYear, title, description, emailAddress);
    Appt appt6_28 = new Appt(startHour, startMinute, startDay, startMonth + 10, startYear, title, description, emailAddress);
    // altered startYear
    Appt appt6_29 = new Appt(startHour, startMinute, startDay, startMonth, startYear - 2000, title, description, emailAddress);
    Appt appt6_30 = new Appt(startHour, startMinute, startDay, startMonth, startYear - 1000, title, description, emailAddress);
    Appt appt6_31 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    Appt appt6_32 = new Appt(startHour, startMinute, startDay, startMonth, startYear + 1000, title, description, emailAddress);
    Appt appt6_33 = new Appt(startHour, startMinute, startDay, startMonth, startYear + 2000, title, description, emailAddress);
    // set appointments valid
    // appt6_00.setValid();
    // appt6_01.setValid();
    // appt6_02.setValid();
    // appt6_03.setValid();
    // appt6_04.setValid();
    // appt6_05.setValid();
    // appt6_06.setValid();
    // appt6_07.setValid();
    // appt6_08.setValid();
    // appt6_09.setValid();
    // appt6_10.setValid();
    // appt6_11.setValid();
    // appt6_12.setValid();
    // appt6_13.setValid();
    // appt6_14.setValid();
    // appt6_15.setValid();
    // appt6_16.setValid();
    // appt6_17.setValid();
    // appt6_18.setValid();
    // appt6_19.setValid();
    // appt6_20.setValid();
    // appt6_21.setValid();
    // appt6_22.setValid();
    // appt6_23.setValid();
    // appt6_24.setValid();
    // appt6_25.setValid();
    // appt6_26.setValid();
    // appt6_27.setValid();
    // appt6_28.setValid();
    // appt6_29.setValid();
    // appt6_30.setValid();
    // appt6_31.setValid();
    // appt6_32.setValid();
    // appt6_33.setValid();
    // asserts
    // assertNotNull(appt6_00.toString());
    // assertNotNull(appt6_01.toString());
    // assertNotNull(appt6_02.toString());
    // assertNotNull(appt6_03.toString());
    // assertNotNull(appt6_04.toString());
    // assertNotNull(appt6_05.toString());
    // assertNotNull(appt6_06.toString());
    // assertNotNull(appt6_07.toString());
    // assertNotNull(appt6_08.toString());
    // assertNotNull(appt6_09.toString());
    // assertNotNull(appt6_10.toString());
    // assertNotNull(appt6_11.toString());
    // assertNotNull(appt6_12.toString());
    // assertNotNull(appt6_13.toString());
    // assertNotNull(appt6_14.toString());
    // assertNotNull(appt6_15.toString());
    // assertNotNull(appt6_16.toString());
    // assertNotNull(appt6_17.toString());
    // assertNotNull(appt6_18.toString());
    // assertNotNull(appt6_19.toString());
    // assertNotNull(appt6_20.toString());
    // assertNotNull(appt6_21.toString());
    // assertNotNull(appt6_22.toString());
    // assertNotNull(appt6_23.toString());
    // assertNotNull(appt6_24.toString());
    // assertNotNull(appt6_25.toString());
    // assertNotNull(appt6_26.toString());
    // assertNotNull(appt6_27.toString());
    // assertNotNull(appt6_28.toString());
    // assertNotNull(appt6_29.toString());
    // assertNotNull(appt6_30.toString());
    // assertNotNull(appt6_31.toString());
    // assertNotNull(appt6_32.toString());
    // assertNotNull(appt6_33.toString());
  }

}
