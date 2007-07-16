/*
 * Created on Feb 16, 2005
 */
package test.com.jds.architecture.utilities;

import com.jds.architecture.utilities.StringIsInt;
//import com.jds.architecture.utilities.StringIsLongValidation;

import junit.framework.TestCase;

/**
 * @author Arthur D. Gerona
 */
public class StringIsIntTest extends TestCase {

	private static final String normalTarget1 = "-2147483648";
	private static final String normalTarget2 = "0";
	private static final String normalTarget3 = "2147483647";
	private static final String normalTarget4 = "-2147483649";
	private static final String normalTarget5 = "2147483648";
	private static final String normalTarget6 = "123.321";
	private static final String normalTarget7 = "TEST";
	private static final String normalTarget8 = "Test123";
	private static final String normalTarget9 = "123tesT";
	private static final String normalTarget10 = "123^456";
	private static final Character normalTarget11 = new Character('C');
	private static final String normalTarget12 = "";
	private static final String errorTarget1 = null;
	
	public void testValidateNormal() {
		StringIsInt stringIsInt = 
			new StringIsInt();
		
		//1.01
		assertEquals(true, stringIsInt.validate(normalTarget1));
		assertEquals(true, stringIsInt.validate(normalTarget2));
		assertEquals(true, stringIsInt.validate(normalTarget3));
		
		//1.02
		assertEquals(false, stringIsInt.validate(normalTarget4));
		assertEquals(false, stringIsInt.validate(normalTarget5));
		assertEquals(false, stringIsInt.validate(normalTarget6));
		assertEquals(false, stringIsInt.validate(normalTarget7));
		assertEquals(false, stringIsInt.validate(normalTarget8));
		assertEquals(false, stringIsInt.validate(normalTarget9));
		assertEquals(false, stringIsInt.validate(normalTarget10));
		assertEquals(false, stringIsInt.validate(normalTarget12));
		
		//1.03
		//assertEquals(false, stringIsInt.validate(normalTarget11));
		try {
			stringIsInt.validate(normalTarget11);
		} catch(Exception e) {
			fail("invalid exception - Xref 1.03");
		}
		
	}
	
	public void testValidateError() {
		StringIsInt stringIsInt = 
			new StringIsInt();
		
		//2.01
		try {
			stringIsInt.validate(errorTarget1);
		} catch(NullPointerException ex) {
			return;
		} catch(Exception e) {
			fail("invalid exception - Xref 2.01");
		}
		fail("invalid exception - Xref 2.01");
	
	}
	
}
