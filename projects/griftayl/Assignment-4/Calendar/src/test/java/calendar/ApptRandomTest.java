package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=300;

	// return a randomly selected method to be tested
  public static String RandomSelectMethod(Random random) {
    String[] methodArray = new String[] {"isOn","setValid","setRecur"};
		int n = random.nextInt(methodArray.length);
		return methodArray[n] ; // return the method name
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

   // generate Random Tests that tests Appt Class.
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
				 int startYearAlt=ValuesGenerator.getRandomIntBetween(random, -500 , 0);
				 //Construct a new Appointment object with the initial data
				 //Construct a new Appointment object with the initial data
		     Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
				 Appt badappt = new Appt(startHourAlt, startMinuteAlt, startDayAlt, startMonthAlt, startYearAlt, title, description, emailAddress);

			  if(!appt.getValid())continue;
			   for (int i = 0; i < NUM_TESTS; i++) {
					 String methodName = ApptRandomTest.RandomSelectMethod(random);
					 if (methodName.equals("isOn")) {
					 // check isOn with known date
					 assertTrue(appt.isOn(startDay, startMonth, startYear));
					 badappt.isOn(startDayAlt, startMonthAlt, startYearAlt);
					 // check isOn with random date
					 int notStartDay = ValuesGenerator.getRandomIntBetween(random, 30, 60);
					 int notStartMonth = ValuesGenerator.getRandomIntBetween(random, 14, 25);
					 int notStartYear = ValuesGenerator.getRandomIntBetween(random, 1001, 2000);
					 assertFalse(appt.isOn(notStartDay, notStartMonth, notStartYear));
					 assertFalse(appt.isOn(startDay, notStartMonth, notStartYear));
					 assertFalse(appt.isOn(startDay, startMonth, notStartYear));
					}
					else if (methodName.equals("setRecur")){
					   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
					   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
					   int recur=ApptRandomTest.RandomSelectRecur(random);
					   int recurIncrement = ValuesGenerator.RandInt(random);
					   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
					   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						 appt.setRecurrence(null, recur, recurIncrement, recurNumber);
					}
					else if (methodName.equals("setValid")) {
						appt.setValid();
						badappt.setValid();
					}
				}

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){}
		 System.out.println("Done testing...");
	}
}
