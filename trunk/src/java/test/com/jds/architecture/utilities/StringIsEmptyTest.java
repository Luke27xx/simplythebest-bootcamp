/*
 * Created on Feb 17, 2005
 */
package test.com.jds.architecture.utilities;

import com.jds.architecture.utilities.StringIsEmpty;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class StringIsEmptyTest extends TestCase {

	public static final String validTarget1 = "";
	public static final String validTarget2 = "Test String";
	public static final Character validTarget3 = new Character('C');
	public static final String errorTarget1 = null;
	
	public void testValidateNormal() {
		StringIsEmpty stringIsEmpty = 
			new StringIsEmpty();
		
		//1.01
		assertEquals(true, stringIsEmpty.validate(validTarget1));
		
		//1.02
		assertEquals(false, stringIsEmpty.validate(validTarget2));
		assertEquals(false, stringIsEmpty.validate(validTarget3));
	}
	
	public void testValidateError() {
		StringIsEmpty stringIsEmpty = 
			new StringIsEmpty();
		
		//2.01
		try {
			stringIsEmpty.validate(errorTarget1);
		} catch (NullPointerException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.01");
		}
		fail("invalid exception - Xref 2.01");
		
	}

}
