/*
 * Created on Feb 16, 2005
 */
package test.com.jds.architecture.utilities;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.jds.architecture.utilities.CalendarToString;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class CalendarToStringTest extends TestCase {
	
	public static final String className = 
		"class com.jds.architecture.utilities.CalendarToString";
	public static final Calendar validTarget1 = 
		new GregorianCalendar(2004, 0, 1);
	public static final Calendar validTarget2 = 
		new GregorianCalendar(2004, 11, 31);
	public Date validTarget3;
	public Date validTarget4;
	public static final String[] errorTarget1 = {"2004", "5", "15"};
	public static final Calendar errorTarget2 = null;
	
	/*
	 * Class under test for void CalendarToString(int)
	 */
	public void testCalendarToStringint() {
		CalendarToString calendarToString = 
			new CalendarToString(DateFormat.SHORT);
		
		if(!( className.equals(calendarToString.getClass().toString()) ))
			fail("incorrect instance");
	}

	/*
	 * Class under test for void CalendarToString()
	 */
	public void testCalendarToString() {
		CalendarToString calendarToString = 
			new CalendarToString();
		
		if(!( className.equals(calendarToString.getClass().toString()) ))
			fail("incorrect instance");
	}

	public void testTransformNormal() {
		validTarget3 = new Date(validTarget1.getTimeInMillis());
		validTarget4 = new Date(validTarget2.getTimeInMillis());
		
		CalendarToString calendarToString1 = 
			new CalendarToString(DateFormat.FULL);
		CalendarToString calendarToString2 = 
			new CalendarToString(DateFormat.LONG);
		CalendarToString calendarToString3 = 
			new CalendarToString(DateFormat.MEDIUM);
		CalendarToString calendarToString4 = 
			new CalendarToString(DateFormat.SHORT);
		CalendarToString calendarToString5 = 
			new CalendarToString();
		
		String test1a = (String) calendarToString1.transform(validTarget1);
		String test1b = (String) calendarToString1.transform(validTarget2);
		String test1c = (String) calendarToString1.transform(validTarget3);
		String test1d = (String) calendarToString1.transform(validTarget4);
		String test2a = (String) calendarToString2.transform(validTarget1);
		String test2b = (String) calendarToString2.transform(validTarget2);
		String test2c = (String) calendarToString2.transform(validTarget3);
		String test2d = (String) calendarToString2.transform(validTarget4);
		String test3a = (String) calendarToString3.transform(validTarget1);
		String test3b = (String) calendarToString3.transform(validTarget2);
		String test3c = (String) calendarToString3.transform(validTarget3);
		String test3d = (String) calendarToString3.transform(validTarget4);
		String test4a = (String) calendarToString4.transform(validTarget1);
		String test4b = (String) calendarToString4.transform(validTarget2);
		String test4c = (String) calendarToString4.transform(validTarget3);
		String test4d = (String) calendarToString4.transform(validTarget4);
		String test5  = (String) calendarToString5.transform(validTarget1);
		
		String temp1a = "Thursday, January 1, 2004";
		String temp1b = "Friday, December 31, 2004";
		String temp2a = "January 1, 2004";
		String temp2b = "December 31, 2004";
		String temp3a = "Jan 1, 2004";
		String temp3b = "Dec 31, 2004";
		String temp4a = "1/1/04";
		String temp4b = "12/31/04";
		String temp5  = "01-Jan-04";
				
		//1.01-1.02
		if(!( (temp1a.equals(test1a)) && (temp1b.equals(test1b)) &&
					(temp1a.equals(test1c)) && (temp1b.equals(test1d)) ))
				fail("invalid transform - Xref 1.01 or 1.02");
		
		
		//1.03-1.04
		if(!( (temp2a.equals(test2a)) && (temp2b.equals(test2b)) &&
					(temp2a.equals(test2c)) && (temp2b.equals(test2d)) ))
				fail("invalid transform - Xref 1.03 or 1.04");
		

		//1.05-1.06
		if(!( (temp3a.equals(test3a)) && (temp3b.equals(test3b)) &&
					(temp3a.equals(test3c)) && (temp3b.equals(test3d)) ))
				fail("invalid transform - Xref 1.05 or 1.06");
		
		
		//1.07-1.08
		if(!( (temp4a.equals(test4a)) && (temp4b.equals(test4b)) &&
					(temp4a.equals(test4c)) && (temp4b.equals(test4d)) ))
				fail("invalid transform - Xref 1.07 or 1.08");
		
		//1.11
		if(!( (temp5.equals(test5)) ))
				fail("invalid transform - Xref 1.05");
		
	}
	
	public void testTransformError() {
		CalendarToString calendarToString = 
			new CalendarToString();
		
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