/*
 * Created on Feb 16, 2005
 */
package test.com.jds.architecture.utilities;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.jds.architecture.utilities.CalendarToIntArray;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class CalendarToIntArrayTest extends TestCase {

	public static final Calendar validTarget1 = 
		new GregorianCalendar(2004, 0, 1);
	public static final Calendar validTarget2 = 
		new GregorianCalendar(2004, 11, 31);
	public Date validTarget3;
	public Date validTarget4;
	public static final String[] errorTarget1 = {"2004", "5", "15"};
	public static final Calendar errorTarget2 = null;
	
	public void testTransformNormal() {
		validTarget3 = new Date(validTarget1.getTimeInMillis());
		validTarget4 = new Date(validTarget2.getTimeInMillis());
		
		CalendarToIntArray calendarToIntArray = 
			new CalendarToIntArray();
		
		int[] temp1 = {2004, 1, 1};
		int[] temp2 = {2004, 12, 31};
				
		int[] test1 = (int[])calendarToIntArray.transform(validTarget1);
		int[] test2 = (int[])calendarToIntArray.transform(validTarget2);
		int[] test3 = (int[])calendarToIntArray.transform(validTarget3);
		int[] test4 = (int[])calendarToIntArray.transform(validTarget4);
		
		//1.01
		for(int i=0; i < 3; i++) {
			if(!( (temp1[i] == test1[i]) && (temp2[i] == test2[i]) && 
					(temp1[i] == test3[i]) && (temp2[i] == test4[i]) ))
				fail("invalid transform - Xref 1.01");
		}

//		*iplementation using assertions*		
//		assertEquals(temp1, (int[])calendarToIntArray.transform(validTarget1));
//		assertEquals(temp2, (int[])calendarToIntArray.transform(validTarget2));
//		assertEquals(temp3, (int[])calendarToIntArray.transform(validTarget3));
		
	}
	
	public void testTransformError() {
		
		
		CalendarToIntArray calendarToIntArray = 
			new CalendarToIntArray();
		
		//2.01
		try {
			calendarToIntArray.transform(errorTarget1);
		} catch (ClassCastException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.01");
		}
		fail("invalid exception - Xref 2.01");
		
		//2.02
		try {
			calendarToIntArray.transform(errorTarget2);
		} catch (NullPointerException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.02");
		}
		fail("invalid exception - Xref 2.02");
		
	}

}
