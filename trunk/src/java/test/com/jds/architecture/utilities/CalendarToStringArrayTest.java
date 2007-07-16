/*
 * Created on Feb 16, 2005
 */
package test.com.jds.architecture.utilities;

import java.sql.Date;
//import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


import com.jds.architecture.utilities.CalendarToStringArray;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class CalendarToStringArrayTest extends TestCase {
	
	public static final String className = 
		"class com.jds.architecture.utilities.CalendarToStringArray";
	public static final Calendar validTarget1 = 
		new GregorianCalendar(2004, 0, 1);
	public static final Calendar validTarget2 = 
		new GregorianCalendar(2004, 11, 31);
	public Date validTarget3;
	public Date validTarget4;
	public static final String[] errorTarget1 = {"2004", "5", "15"};
	public static final Calendar errorTarget2 = null;
	
//	NOTE: This constructor has been depricated due to conflicts with the documented functionality
//	/*
//	 * Class under test for void calendarToStringArray(int)
//	 */
//	public void testcalendarToStringArrayint() {
//		CalendarToStringArray calendarToString = 
//			new CalendarToStringArray(DateFormat.SHORT);
//		
//		if(!( className.equals(calendarToString.getClass().toString()) ))
//			fail("incorrect instance");
//	}

	/*
	 * Class under test for void calendarToStringArray()
	 */
	public void testcalendarToStringArray() {
		CalendarToStringArray calendarToString = 
			new CalendarToStringArray();
		
		if(!( className.equals(calendarToString.getClass().toString()) ))
			fail("incorrect instance");
	}
	
//	NOTE: This test method has been modified in accordance with changes made in the code
	public void testTransformNormal() {
		validTarget3 = new Date(validTarget1.getTimeInMillis());
		validTarget4 = new Date(validTarget2.getTimeInMillis());
		
		CalendarToStringArray calendarToString0 = 
			new CalendarToStringArray();
//		CalendarToStringArray calendarToString1 = 
//			new CalendarToStringArray(DateFormat.FULL);
//		CalendarToStringArray calendarToString2 = 
//			new CalendarToStringArray(DateFormat.LONG);
//		CalendarToStringArray calendarToString3 = 
//			new CalendarToStringArray(DateFormat.MEDIUM);
//		CalendarToStringArray calendarToString4 = 
//			new CalendarToStringArray(DateFormat.SHORT);
		
		String[] test3a = (String[]) calendarToString0.transform(validTarget1);
		String[] test3b = (String[]) calendarToString0.transform(validTarget2);
		String[] test3c = (String[]) calendarToString0.transform(validTarget3);
		String[] test3d = (String[]) calendarToString0.transform(validTarget4);
//		String[] test1a = (String[]) calendarToString1.transform(validTarget1);
//		String[] test1b = (String[]) calendarToString1.transform(validTarget2);
//		String[] test1c = (String[]) calendarToString1.transform(validTarget3);
//		String[] test1d = (String[]) calendarToString1.transform(validTarget4);
//		String[] test2a = (String[]) calendarToString2.transform(validTarget1);
//		String[] test2b = (String[]) calendarToString2.transform(validTarget2);
//		String[] test2c = (String[]) calendarToString2.transform(validTarget3);
//		String[] test2d = (String[]) calendarToString2.transform(validTarget4);
//		String[] test3a = (String[]) calendarToString3.transform(validTarget1);
//		String[] test3b = (String[]) calendarToString3.transform(validTarget2);
//		String[] test3c = (String[]) calendarToString3.transform(validTarget3);
//		String[] test3d = (String[]) calendarToString3.transform(validTarget4);
//		String[] test4a = (String[]) calendarToString4.transform(validTarget1);
//		String[] test4b = (String[]) calendarToString4.transform(validTarget2);
//		String[] test4c = (String[]) calendarToString4.transform(validTarget3);
//		String[] test4d = (String[]) calendarToString4.transform(validTarget4);
		
//		String[] temp1a = {"Thursday, January 1, 2004", "Thursday", "January", "1", "2004"};
//		String[] temp1b = {"Friday, December 31, 2004", "Friday", "December", "31", "2004"};
//		String[] temp2a = {"January 1, 2004", "January", "1", "2004"};
//		String[] temp2b = {"December 31, 2004", "December", "31", "2004"};
		String[] temp3a = {"Jan 1, 2004", "2004", "Jan", "1"};
		String[] temp3b = {"Dec 31, 2004", "2004", "Dec", "31"};
//		String[] temp3a = {"Jan 1, 2004", "Jan", "1", "2004"};
//		String[] temp3b = {"Dec 31, 2004", "Dec", "31", "2004"};
//		String[] temp4a = {"1/1/04", "1", "1", "04"};
//		String[] temp4b = {"12/31/04", "12", "31", "04"};
				
		//1.01-1.02
//		for(int i=0; i < 5; i++) {
//			if(!( (temp1a[i].equals(test1a[i])) && (temp1b[i].equals(test1b[i])) &&
//					(temp1a[i].equals(test1c[i])) && (temp1b[i].equals(test1d[i])) ))
//				fail("invalid transform - Xref 1.01 or 1.02");
//		}
		
		//1.03-1.04
//		for(int i=0; i < 4; i++) {
//			if(!( (temp2a[i].equals(test2a[i])) && (temp2b[i].equals(test2b[i])) &&
//					(temp2a[i].equals(test2c[i])) && (temp2b[i].equals(test2d[i])) ))
//				fail("invalid transform - Xref 1.03 or 1.04");
//		}
		 
		//1.01-1.04
		for(int i=0; i < 4; i++) {
			if(!( (temp3a[i].equals(test3a[i])) && (temp3b[i].equals(test3b[i])) &&
					(temp3a[i].equals(test3c[i])) && (temp3b[i].equals(test3d[i])) ))
				fail("invalid transform - Xref 1.01 or 1.04");
		}
		
		//1.07-1.08
//		for(int i=0; i < 4; i++) {
//			if(!( (temp4a[i].equals(test4a[i])) && (temp4b[i].equals(test4b[i])) &&
//					(temp4a[i].equals(test4c[i])) && (temp4b[i].equals(test4d[i])) ))
//				fail("invalid transform - Xref 1.07 or 1.08");
//		}
				
	}
	
	public void testTransformError() {
		CalendarToStringArray calendarToString = 
			new CalendarToStringArray();
		
		//2.01
		try {
			calendarToString.transform(errorTarget1);
		} catch (ClassCastException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.01");
		}
		fail("invalid exception - Xref 2.01");
		
		//2.02
		try {
			calendarToString.transform(errorTarget2);
		} catch (NullPointerException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.02");
		}
		fail("invalid exception - Xref 2.02");
		
	}

}