package calendar;

import java.util.*;
import java.io.*;
import javax.xml.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {

	private static final long TestTimeout = 90 * 50 * 20; /* Timeout at 90 seconds */
	private static final int NUM_TESTS=3;

	// return a randomly selected method to be tested
  public static String RandomSelectMethod(Random random) {
    String[] methodArray = new String[] {"deleteAppt","getApptRange"};
    int n = random.nextInt(methodArray.length);
    return methodArray[n];
  }

	// return a randomly selected appointments to recur Weekly,Monthly, or Yearly
		public static int RandomSelectRecur(Random random) {
			int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};
			int n = random.nextInt(RecurArray.length);
			return RecurArray[n];
		}

	// return a randomly selected appointments to recur forever or Never recur
	public static int RandomSelectRecurForEverNever(Random random) {
		int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};
		int n = random.nextInt(RecurArray.length);
		return RecurArray[n];
	}

  /**
  *** Generate Random Tests that tests DataHandler Class.
  **/

	@Test
	public void radnomtest()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed =System.currentTimeMillis();
				 Random random = new Random(randomseed);
				 // create calDay
		     LinkedList<CalDay> calDay = new LinkedList<CalDay>();
					// good appointment
					int startHour = ValuesGenerator.getRandomIntBetween(random, 1, 13);
					int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 60);
					int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 29);
					int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 13);
					int startYear = ValuesGenerator.getRandomIntBetween(random, 1, 1000);
					String title="Test valid appointment";
					String description="valid";
					String emailAddress="test@null.net";
					// bad appointment
					int startHourAlt=ValuesGenerator.getRandomIntBetween(random, -12, 24);
					int startMinuteAlt=ValuesGenerator.getRandomIntBetween(random, -30, 90);
					int startDayAlt=ValuesGenerator.getRandomIntBetween(random, -15, 44);
					int startMonthAlt=ValuesGenerator.getRandomIntBetween(random, -6, 17);
					int startYearAlt=ValuesGenerator.getRandomIntBetween(random, -500 , -1);
					// make days
					GregorianCalendar firstDay = new GregorianCalendar(startYear, startMonth, startDay);
 				  GregorianCalendar lastDay = new GregorianCalendar(startYear + 1, startMonth, startDay);
					// create datahandler
					DataHandler dataHandler1;
					int toggleDH = ValuesGenerator.getRandomIntBetween(random, 0, 1);
					if (toggleDH == 0) {
						dataHandler1 = new DataHandler();
					}
					else {
						dataHandler1 = new DataHandler("calendar.xml", false);
					}
					// DataHandler dataHandler1 = new DataHandler();
				  // DataHandler dataHandler1 = new DataHandler("testFile" + randomseed + ".xml", true);
 				  // DataHandler dataHandler2 = new DataHandler("testFile2" + randomseed + ".xml", false);
					// DataHandler dataHandler2 = new DataHandler();
					// construct a new Appointment object with the initial data
					Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
					Appt appt2 = new Appt(startHour + 1, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
					Appt badappt = new Appt(startHourAlt, startMinuteAlt, startDayAlt, startMonthAlt, startYearAlt, title, description, emailAddress);

					int[] recurrence1 = new int[]{3};
			 		int[] recurrence2 = new int[]{3};

					// appt1.setRecurrence(recurrence1, 0, 1, appt1.RECUR_NUMBER_FOREVER);
					// appt2.setRecurrence(recurrence2, 2, 3, appt2.RECUR_NUMBER_FOREVER);

					LinkedList<Appt> listAppts = new LinkedList<Appt>();
					LinkedList<Appt> nullListAppts = null;

					// listAppts.add(appt1);
					// listAppts.add(appt2);
					// listAppts.add(badappt);

					// appt1.setValid();
					// appt2.setValid();
					// check validity
				 	// if (!appt1.getValid() && appt2.getValid()) continue;

					int[] recurDays;
					int randRecur = ValuesGenerator.getRandomIntBetween(random, -1, 4);
					if (randRecur < 0) {
						recurDays = null;
					}
					else {
			 			recurDays = ValuesGenerator.generateRandomArray(random, randRecur);
					}
					int recur=ApptRandomTest.RandomSelectRecur(random);
			 		int recurIncrement = ValuesGenerator.RandInt(random);
			 		int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
			 		appt1.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
					// save appts
					dataHandler1.saveAppt(appt1);
					// dataHandler1.saveAppt(appt2);
					// dataHandler1.saveAppt(badappt);
					// dataHandler2.saveAppt(appt1);
					// dataHandler2.saveAppt(appt2);
					// dataHandler2.saveAppt(badappt);
					// // for (int i = 0; i < NUM_TESTS; i++) {
					// 	String methodName = ApptRandomTest.RandomSelectMethod(random);
					// 	if (methodName.equals("deleteAppt")) {
					// 		System.out.println("deleting appointments");
					// 		assertTrue(dataHandler1.deleteAppt(appt1));
					// 		assertTrue(dataHandler1.deleteAppt(appt2));
					// 		dataHandler1.deleteAppt(badappt);
					// 		assertTrue(dataHandler2.deleteAppt(appt1));
					// 		assertTrue(dataHandler2.deleteAppt(appt2));
					// 		dataHandler2.deleteAppt(badappt);
					// 	}
					//   else if (methodName.equals("getApptRange"))	{
					// 		System.out.println("checking ranges");
					// 		dataHandler1.getApptRange(firstDay, lastDay);
					// 		dataHandler2.getApptRange(firstDay, lastDay);
					//   }
				 // // }
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if ((iteration%10000)==0 && iteration!=0 )
				 	 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
				 try{
					 int toggleGetApptRange = ValuesGenerator.getRandomIntBetween(random, 0, 1);
					 if (toggleGetApptRange == 0) {
						 dataHandler1.getApptRange(lastDay, firstDay);
					 }
					 else {
						 dataHandler1.getApptRange(firstDay, lastDay);
					 }
		 		 }	catch(DateOutOfRangeException e){}
			   dataHandler1.deleteAppt(appt1);
				 dataHandler1.deleteAppt(appt2);
				 badappt.setValid();
				 dataHandler1.deleteAppt(badappt);
			   // dataHandler1.deleteAppt(appt2);
				 // dataHandler1.deleteAppt(null);
			 	 // dataHandler.deleteAppt(nullListAppts, null);
			 }

		}	catch(NullPointerException e){}
			System.out.println("Done testing...");
	}
}
