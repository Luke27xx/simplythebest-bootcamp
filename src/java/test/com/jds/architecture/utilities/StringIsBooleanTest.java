/*
 * Created on Feb 15, 2005
 */
package test.com.jds.architecture.utilities;

import com.jds.architecture.utilities.StringIsBoolean;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class StringIsBooleanTest extends TestCase {

	private static final String normalTarget1 = "TRUE";
	private static final String normalTarget2 = "YES";
	private static final String normalTarget3 = "OK";
	private static final String normalTarget4 = new String("true");
	private static final String normalTarget5 = "Yes";
	private static final String normalTarget6 = "oK";
    
	private static final String normalTarget7 = "CORRECT";
	private static final String normalTarget8 = "TRUE123";
	private static final String normalTarget9 = "123TRUE";
	private static final String normalTarget10 = "123TRUE456";
	private static final String normalTarget11 = "TR123UE";
	private static final Character normalTarget12 = new Character('C');
	private static final String normalTarget13 = "";
	private static final String errorTarget1 = null;
	
	public void testValidateNormal() {
		StringIsBoolean stringIsBoolean = 
			new StringIsBoolean();
		
		//1.01
		assertEquals(true, stringIsBoolean.validate(normalTarget1));
		assertEquals(true, stringIsBoolean.validate(normalTarget2));
		assertEquals(true, stringIsBoolean.validate(normalTarget3));
		assertEquals(true, stringIsBoolean.validate(normalTarget4));
		assertEquals(true, stringIsBoolean.validate(normalTarget5));
		assertEquals(true, stringIsBoolean.validate(normalTarget6));
		
		//1.02 & 1.04
		assertEquals(false, stringIsBoolean.validate(normalTarget7));
		assertEquals(false, stringIsBoolean.validate(normalTarget8));
		assertEquals(false, stringIsBoolean.validate(normalTarget9));
		assertEquals(false, stringIsBoolean.validate(normalTarget10));
		assertEquals(false, stringIsBoolean.validate(normalTarget11));
		assertEquals(false, stringIsBoolean.validate(normalTarget13));
		
		//1.03
		//assertEquals(false, stringIsInt.validate(normalTarget12));
		try {
			stringIsBoolean.validate(normalTarget12);
		} catch(Exception e) {
			fail("invalid exception - Xref 1.03");
		}
			
	}
	
	public void testValidateError() {
		StringIsBoolean stringIsBoolean = 
			new StringIsBoolean();
		
		//2.01
		try {
			stringIsBoolean.validate(errorTarget1);
		} catch(NullPointerException ex) {
			return;
		} catch(Exception e) {
			fail("invalid exception - Xref 2.01");
		}
		fail("invalid exception - Xref 2.01");
		
	}

}
