/*
 * Created on Feb 16, 2005
 */
package test.com.jds.architecture.utilities;

import java.util.Calendar;

import com.jds.architecture.utilities.IntArrayToCalendar;

import junit.framework.TestCase;

/**
 * @author Arthur D. Gerona
 */
public class IntArrayToCalendarTest extends TestCase {

	public static final int[] validTarget1 = {2004, 1, 1};
	public static final int[] validTarget2 = {2004, 12, 31};
	public static final int[] validTarget3 = {2004, 1, 1, 1};
	public static final int[] validTarget4 = {2004, 120, 310};
	public static final int[] errorTarget1 = {2004, 1};
	public static final String[] errorTarget2 = {"2004", "5", "15"};
	public static final int[] errorTarget3 = null;
	
	
	public void testTransformNormal() {
		IntArrayToCalendar intArrayToCalendar = 
			new IntArrayToCalendar();

//		*assertion implementation*
//		Calendar test1 = Calendar.getInstance();
//		test1.set(Calendar.YEAR, validTarget1[0]);
//		test1.set(Calendar.MONTH, validTarget1[1] - 1);
//		test1.set(Calendar.DATE, validTarget1[2]);
//		
//		Calendar test2 = Calendar.getInstance();
//		test2.set(Calendar.YEAR, validTarget2[0]);
//		test2.set(Calendar.MONTH, validTarget2[1] - 1);
//		test2.set(Calendar.DATE, validTarget2[2]);
//		
//		Calendar test3 = Calendar.getInstance();
//		test3.set(Calendar.YEAR, validTarget3[0]);
//		test3.set(Calendar.MONTH, validTarget3[1] - 1);
//		test3.set(Calendar.DATE, validTarget3[2]);
//		
//		assertEquals(test1, intArrayToCalendar.transform(validTarget1));
//		assertEquals(test2, intArrayToCalendar.transform(validTarget2));
//		assertEquals(test3, intArrayToCalendar.transform(validTarget3));
		
		Calendar temp1 = (Calendar)(intArrayToCalendar.transform(validTarget1));
		Calendar temp2 = (Calendar)(intArrayToCalendar.transform(validTarget2));
		Calendar temp3 = (Calendar)(intArrayToCalendar.transform(validTarget3));
		
		//1.01
		assertEquals(2004, temp1.get(Calendar.YEAR));
		assertEquals(0, temp1.get(Calendar.MONTH));
		assertEquals(1, temp1.get(Calendar.DATE));
		
		//1.02
		assertEquals(2004, temp2.get(Calendar.YEAR));
		assertEquals(11, temp2.get(Calendar.MONTH));
		assertEquals(31, temp2.get(Calendar.DATE));
		
		//1.03
		assertEquals(2004, temp3.get(Calendar.YEAR));
		assertEquals(0, temp3.get(Calendar.MONTH));
		assertEquals(1, temp3.get(Calendar.DATE));
		
		//1.04
		try {
			Calendar temp4 = (Calendar)(intArrayToCalendar.transform(validTarget3));
		} catch(Exception e) {
			fail("exception not expected - Xref 1.04");
		}
		
	}
	
	public void testTransformError() {
		IntArrayToCalendar intArrayToCalendar = 
			new IntArrayToCalendar();
		
		//2.01
		try {
			intArrayToCalendar.transform(errorTarget1);
		} catch (ArrayIndexOutOfBoundsException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.01");
		}
		fail("invalid exception - Xref 2.01");
		
		
		//2.02
		try {
			intArrayToCalendar.transform(errorTarget2);
		} catch (ClassCastException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.02");
		}
		fail("invalid exception - Xref 2.02");
		
		//2.03
		try {
			intArrayToCalendar.transform(errorTarget3);
		} catch (NullPointerException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.03");
		}
		fail("invalid exception - Xref 2.03");
		
	}

}
