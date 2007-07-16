/*
 * Created on Feb 17, 2005
 */
package test.com.jds.architecture.utilities;

import com.jds.architecture.utilities.StringIsValid;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class StringIsValidTest extends TestCase {
	
	private String normTarget1 = "";
	private String normTarget2 = "";
	private String normTarget3 = "";
	private final String normTarget4 = "$Test123%";
	private final String normTarget5 = "$Test123!";
	private final String normTarget6 = "@Test^123!";
	private final String normTarget7 = "@Test123%";
	private final Character normTarget8 = new Character('C');
	private final String normTarget9 = "";
	private final String errorTarget1 = null;
	
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		for(int i=0; i < 256; i++) {
			
			if( ((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)) || 
					(i == 170) || (i == 181) || (i ==186) ||
					((i >= 192) && (i <= 214)) || ((i >= 216) && 
					(i <= 246)) || ((i >= 248) && (i <= 255)) ||
					((i >= 48) && (i <= 57)) ) {
				normTarget1 += new Character((char) i).toString();
				normTarget3 += new Character((char) i).toString();
			} else if ( ('!' == (char) i) || ('@' == (char) i) || ('#' == (char) i) ) {
				normTarget1 += new Character((char) i).toString();
				normTarget3 += new Character((char) i).toString();
			} else {
				normTarget2 += new Character((char) i).toString();
				normTarget3 += new Character((char) i).toString();
			}
			
		}
	
	}
	
	public void testValidateNormal() {
		StringIsValid stringIsValid = new StringIsValid("!@#");
		
		//1.01 & 1.05
		assertEquals(true, stringIsValid.validate(normTarget1));
		assertEquals(true, stringIsValid.validate(normTarget9));
		
		//1.02-1.03
		assertEquals(false, stringIsValid.validate(normTarget2));
		assertEquals(false, stringIsValid.validate(normTarget3));
		assertEquals(false, stringIsValid.validate(normTarget4));
		assertEquals(false, stringIsValid.validate(normTarget5));
		assertEquals(false, stringIsValid.validate(normTarget6));
		assertEquals(false, stringIsValid.validate(normTarget7));
		
		//1.04
		try {
			stringIsValid.validate(normTarget8);
		} catch(ClassCastException ex) {
			fail("exception not expected - Xref 1.04");
		}
		
	}
	
	public void testValidateError() {
		StringIsValid stringIsValid = new StringIsValid("!@#");
		
		//2.01
		try {
			stringIsValid.validate(errorTarget1);
		} catch(NullPointerException ex) {
			return;
		} catch(Exception e) {
			fail("invalid exception - Xref 2.01");
		}
		fail("invalid exception - Xref 2.01");
				
	}
	
}
