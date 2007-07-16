/*
 * Created on Feb 15, 2005
 */
package test.com.jds.architecture.utilities;

import com.jds.architecture.utilities.CalendarIsValid;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class CalendarIsValidTest extends TestCase {
	
	private static final int[] validTarget1 = {2004, 1, 1};
	private static final int[] validTarget2 = {2004, 12, 31};
	private static final int[] validTarget3 = {2004, 6, 30};
	private static final int[] validTarget4 = {2004, 2, 29};
	private static final int[] validTarget5 = {2004, 1, 1, 1};
	private static final int[] invalidTarget1 = {-2004, 1, 1};
	private static final int[] invalidTarget2 = {2004, 0, 15};
	private static final int[] invalidTarget3 = {2004, 13, 15};
	private static final int[] invalidTarget4 = {2004, -1, 15};
	private static final int[] invalidTarget5 = {2004, 1, 0};
	private static final int[] invalidTarget6 = {2004, 1, 32};
	private static final int[] invalidTarget7 = {2004, 6, 31};
	private static final int[] invalidTarget8 = {2003, 2, 29};
	private static final int[] invalidTarget9 = {2004, 6, -1};
	private static final int[] invalidTarget10 = {-2004, 1, 1, 1};
	private static final double[] errorTarget1 = {2001.0,1.0,1.0};
	private static final int[] errorTarget2 = null;
	private static final int[] errorTarget3 = {2004, 1};
	
	public void testValidateNormal() {
		CalendarIsValid calendarIsValid = new CalendarIsValid();
		
		//1.01 a-d
		assertEquals(true, calendarIsValid.validate(validTarget1));
		assertEquals(true, calendarIsValid.validate(validTarget2));
		assertEquals(true, calendarIsValid.validate(validTarget3));
		assertEquals(true, calendarIsValid.validate(validTarget4));
		
		//1.02 a-i
		assertEquals(false, calendarIsValid.validate(invalidTarget1));
		assertEquals(false, calendarIsValid.validate(invalidTarget2));
		assertEquals(false, calendarIsValid.validate(invalidTarget3));
		assertEquals(false, calendarIsValid.validate(invalidTarget4));
		assertEquals(false, calendarIsValid.validate(invalidTarget5));
		assertEquals(false, calendarIsValid.validate(invalidTarget6));
		assertEquals(false, calendarIsValid.validate(invalidTarget7));
		assertEquals(false, calendarIsValid.validate(invalidTarget8));
		assertEquals(false, calendarIsValid.validate(invalidTarget9));
		
		//1.03
		assertEquals(true, calendarIsValid.validate(validTarget5));
		
		//1.04
		assertEquals(false, calendarIsValid.validate(invalidTarget10));
		
	}
	
	public void testValidateError() {
		CalendarIsValid calendarIsValid = new CalendarIsValid();
		
		//2.01
		try {
			calendarIsValid.validate(errorTarget1);
		} catch (ClassCastException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.01");
		}
		fail("invalid exception - Xref 2.01");
		
		//2.02
		try {
			calendarIsValid.validate(errorTarget2);
		} catch (NullPointerException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.02");
		}
		fail("invalid exception - Xref 2.02");
		
		//2.03
		try {
			calendarIsValid.validate(errorTarget3);
		} catch (ArrayIndexOutOfBoundsException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.03");
		}
		fail("invalid exception - Xref 2.03");
		
	}

}
