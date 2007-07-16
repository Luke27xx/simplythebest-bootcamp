/*
 * Created on Feb 16, 2005
 */
package test.com.jds.architecture.utilities;

import com.jds.architecture.utilities.StringIsLong;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class StringIsLongTest extends TestCase {

	private static final String normalTarget1 = "-9223372036854775808";
	private static final String normalTarget2 = "0";
	private static final String normalTarget3 = "9223372036854775807";
	private static final String normalTarget4 = "-9223372036854775809";
	private static final String normalTarget5 = "9223372036854775808";
	private static final String normalTarget6 = "123.321";
	private static final String normalTarget7 = "TEST";
	private static final String normalTarget8 = "Test123";
	private static final String normalTarget9 = "123tesT";
	private static final String normalTarget10 = "123^456";
	private static final Character normalTarget11 = new Character('C');
	private static final String normalTarget12 = "";
	private static final String errorTarget2 = null;
	
	public void testValidateNormal() {
		StringIsLong stringIsLong = 
			new StringIsLong();
		
		//1.01
		assertEquals(true, stringIsLong.validate(normalTarget1));
		assertEquals(true, stringIsLong.validate(normalTarget2));
		assertEquals(true, stringIsLong.validate(normalTarget3));
		
		//1.02 & 1.04
		assertEquals(false, stringIsLong.validate(normalTarget4));
		assertEquals(false, stringIsLong.validate(normalTarget5));
		assertEquals(false, stringIsLong.validate(normalTarget6));
		assertEquals(false, stringIsLong.validate(normalTarget7));
		assertEquals(false, stringIsLong.validate(normalTarget8));
		assertEquals(false, stringIsLong.validate(normalTarget9));
		assertEquals(false, stringIsLong.validate(normalTarget10));
		assertEquals(false, stringIsLong.validate(normalTarget12));
		
		//1.03
		//assertEquals(false, stringIsLong.validate(normalTarget11));
		try {
			stringIsLong.validate(normalTarget11);
		} catch(Exception e) {
			fail("invalid exception - Xref 1.03");
		}
		
	}
	
	public void testValidateError() {
		StringIsLong stringIsLong = 
			new StringIsLong();
		
		//2.01
		try {
			stringIsLong.validate(errorTarget2);
		} catch(NullPointerException ex) {
			return;
		} catch(Exception e) {
			fail("invalid exception - Xref 2.01");
		}
		fail("invalid exception - Xref 2.01");
	
	}

}
