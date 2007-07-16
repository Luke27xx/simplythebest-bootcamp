/*
 * Created on Feb 21, 2005
 */
package test.com.jds.architecture.utilities;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.jds.architecture.utilities.CalendarConstants;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class CalendarConstantsTest extends TestCase {

	private static final Calendar validTarget1 = new GregorianCalendar(2004, 0, 1);
	private static final Calendar validTarget2 = new GregorianCalendar(2004, 11, 31);
	private static final int validTarget3 = 1;
	private static final int validTarget4 = 12;
	private static final String errorTarget1 = "Calendar";
	private static final Calendar errorTarget2 = null;
	
	public void testToStandardMonthNormal() {
		
		//1.01a-b
		assertEquals(1, CalendarConstants.toStandardMonth(validTarget1));
		assertEquals(12, CalendarConstants.toStandardMonth(validTarget2));
		
	}
	
	public void testToStandardMonthError() {
		
		//2.01
//		try {
//			CalendarConstants.toStandardMonth(errorTarget1);
//		} catch (NullPointerException ex) {
//			return;
//		} catch (Exception e) {
//			fail("invalid exception - Xref 2.01" + e);
//		}
//		fail("invalid exception - Xref 2.01");
		
		//2.02
		try {
			CalendarConstants.toStandardMonth(errorTarget2);
		} catch (NullPointerException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.02");
		}
		fail("invalid exception - Xref 2.02");
		
	}

	public void testToCalendarMonthNormal() {
		
		//1.03a-b
		assertEquals(0, CalendarConstants.toCalendarMonth(validTarget3));
		assertEquals(11, CalendarConstants.toCalendarMonth(validTarget4));
		
	}

}
