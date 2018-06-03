package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.LinkedList;
import java.util.GregorianCalendar;

import org.junit.Test;

import static org.junit.Assert.*;

//Random Test Generator  for CalDay class.
public class CalDayRandomTest {

	private static final long TestTimeout = 60 * 50 * 10; /* Timeout at 6 seconds */
	private static final int NUM_TESTS=100;

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


  // Generate Random Tests that tests CalDay
	@Test
	public void radnomtest()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis();
				Random random = new Random(randomseed);
				// good appointment
				int startHour = ValuesGenerator.getRandomIntBetween(random, 1, 12);
				int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
				int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
				int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
				int startYear = ValuesGenerator.getRandomIntBetween(random, 1, 1000);
				String title="Test valid appointment";
				String description="valid";
				String emailAddress="test@null.net";
				// bad appointment
				int startHourAlt=ValuesGenerator.getRandomIntBetween(random, -12, 24);
				int startMinuteAlt=ValuesGenerator.getRandomIntBetween(random, -30, 90);
				int startDayAlt=ValuesGenerator.getRandomIntBetween(random, -15, 44);
				int startMonthAlt=ValuesGenerator.getRandomIntBetween(random, -6, 17);
				int startYearAlt=ValuesGenerator.getRandomIntBetween(random, -500 , 0);
				// initialize day
				int gcDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
				int gcMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
				int gcYear = ValuesGenerator.getRandomIntBetween(random, 1, 1000);
		    GregorianCalendar gregDay = new GregorianCalendar(gcYear, gcMonth, gcDay);
		    CalDay calDay = new CalDay(gregDay);
				// make appointments
				Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
				Appt appt2 = new Appt(startHour - 1, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
				Appt badappt = new Appt(startHourAlt, startMinuteAlt, startDayAlt, startMonthAlt, startYearAlt, title, description, emailAddress);
			 	appt.setValid();
				badappt.setValid();
				for (int i = 0; i < NUM_TESTS; i++) {
					int toggleAppt = ValuesGenerator.getRandomIntBetween(random, 0, 1);
					// System.out.println("toggle value: " + toggleAppt);
					if (toggleAppt == 0) {
						calDay.addAppt(appt);
						calDay.addAppt(appt2);
					}
					else {
						calDay.addAppt(badappt);
					}
			 	}
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
		  }
	  }	catch(NullPointerException e){}
		System.out.println("Done testing...");
	}
}
