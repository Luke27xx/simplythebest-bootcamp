/*
 * Created on Feb 17, 2005
 */
package test.com.jds.architecture.utilities;

import com.jds.architecture.utilities.StringLengthIsValid;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class StringLengthIsValidTest extends TestCase {
	
	private static final String validTarget1  = "";
	private static final String validTarget2  = "A";
	private static final String validTarget3  = "";
	private static final String validTarget4  = "AB";
	private static final String validTarget5  = "A";
	private static final String validTarget6  = "";
	private static final String validTarget7  = "12";
	private static final String validTarget8  = "123";
	private static final String validTarget9  = "1234";
	private static final String validTarget10 = "123";
	private static final String validTarget11 = "12";
	
	private static final String errorTarget1 = null;
	
	
	public void testValidateNormal() {
		StringLengthIsValid stringLengthIsValid1 = new StringLengthIsValid(1);
		StringLengthIsValid stringLengthIsValid2 = new StringLengthIsValid(3);
		StringLengthIsValid stringLengthIsValid0 = new StringLengthIsValid(0);
		StringLengthIsValid stringLengthIsValidNeg1 = new StringLengthIsValid(-1);
		
		//1.01-1.10
		assertEquals(true, stringLengthIsValid1.validate(validTarget1));
		assertEquals(true, stringLengthIsValid1.validate(validTarget2));
		assertEquals(true, stringLengthIsValid0.validate(validTarget3));
		assertEquals(false, stringLengthIsValid1.validate(validTarget4));
		assertEquals(false, stringLengthIsValid0.validate(validTarget5));
		assertEquals(true, stringLengthIsValidNeg1.validate(validTarget6));
		assertEquals(true, stringLengthIsValid2.validate(validTarget7));
		assertEquals(true, stringLengthIsValid2.validate(validTarget8));
		assertEquals(false, stringLengthIsValid2.validate(validTarget9));
		assertEquals(false, stringLengthIsValid0.validate(validTarget10));
		assertEquals(true, stringLengthIsValidNeg1.validate(validTarget11));
	
	}
	
	public void testValidateError() {
		StringLengthIsValid stringLengthIsValid1 = new StringLengthIsValid(1);
		StringLengthIsValid stringLengthIsValid0 = new StringLengthIsValid(0);
		StringLengthIsValid stringLengthIsValidNeg1 = new StringLengthIsValid(-1);
		
		//2.01-2.03
		try {
			stringLengthIsValid1.validate(errorTarget1);
			stringLengthIsValid0.validate(errorTarget1);
			stringLengthIsValidNeg1.validate(errorTarget1);
		} catch (NullPointerException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.01-2.03");
		}
		fail("invalid exception - Xref 2.01-2.03");
	
	}

}
