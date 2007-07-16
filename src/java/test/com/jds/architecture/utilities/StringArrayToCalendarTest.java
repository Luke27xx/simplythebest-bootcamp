/*
 * Created on Feb 21, 2005
 */
package test.com.jds.architecture.utilities;

import java.util.Calendar;
import com.jds.architecture.utilities.StringArrayToCalendar;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class StringArrayToCalendarTest extends TestCase {

	private static final String[] validTarget1 = {"2004", "1", "1"};
	private static final String[] validTarget2 = {"2004", "12", "31"};
	private static final String[] validTarget3 = {"2004", "12", "31", "additional"};
	private static final String[] validTarget4 = {"2004", "100", "100"};
	private static final String[] errorTarget1 = {"2004", "1"};
	private static final String errorTarget2 = "2004, 1, 1";
	private static final Character[] errorTarget3 = {new Character('A'), new Character('A'), new Character('A')};
	private static final String[] errorTarget4 = {"A", "A", "A"};
	private static final String[] errorTarget5 = null;
	
	public void testTransformNormal() {
		StringArrayToCalendar stringArrayToCalendar = new StringArrayToCalendar();

		Calendar tempCal1 = (Calendar) stringArrayToCalendar.transform(validTarget1);
		Calendar tempCal2 = (Calendar) stringArrayToCalendar.transform(validTarget2);
		Calendar tempCal3 = (Calendar) stringArrayToCalendar.transform(validTarget3);
		
		if(!( (tempCal1.get(Calendar.YEAR)==2004) && (tempCal1.get(Calendar.MONTH)==0) &&
				(tempCal1.get(Calendar.DATE)==1) ))
			fail("Error: XRef 1.01");
		if(!( (tempCal2.get(Calendar.YEAR)==2004) && (tempCal2.get(Calendar.MONTH)==11) &&
				(tempCal2.get(Calendar.DATE)==31) ))
			fail("Error: XRef 1.02");
		if(!( (tempCal3.get(Calendar.YEAR)==2004) && (tempCal3.get(Calendar.MONTH)==11) &&
				(tempCal3.get(Calendar.DATE)==31) ))
			fail("Error: XRef 1.03");
		
		try {
			Calendar tempCal4 = (Calendar) stringArrayToCalendar.transform(validTarget4);
			} catch(Exception e) {
				fail("Error: XRef 1.04");
			}
			
	}
	
	public void testTransformError() {
		StringArrayToCalendar stringArrayToCalendar = new StringArrayToCalendar();
		
		//2.01
		try {
			stringArrayToCalendar.transform(errorTarget1);
		} catch (ArrayIndexOutOfBoundsException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.01");
		}
		fail("invalid exception - Xref 2.01");
		
		//2.02
		try {
			stringArrayToCalendar.transform(errorTarget2);
		} catch (ClassCastException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.02");
		}
		fail("invalid exception - Xref 2.02");
		
		//2.03
		try {
			stringArrayToCalendar.transform(errorTarget3);
		} catch (NumberFormatException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.03");
		}
		fail("invalid exception - Xref 2.03");
		
		//2.04
		try {
			stringArrayToCalendar.transform(errorTarget4);
		} catch (NumberFormatException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.04");
		}
		fail("invalid exception - Xref 2.04");
		
		//2.05
		try {
			stringArrayToCalendar.transform(errorTarget5);
		} catch (NullPointerException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.05");
		}
		fail("invalid exception - Xref 2.05");
		
	}

}
