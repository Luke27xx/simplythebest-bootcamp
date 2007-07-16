/*
 * Created on Feb 15, 2005
 */
package test.com.jds.architecture.utilities;

import com.jds.architecture.utilities.StringIsAlphaNumeric;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class StringIsAlphaNumericTest extends TestCase {

	private String normTarget1 = "";
	private String normTarget2 = "";
	private final String normTarget3 = "Test123!";
	private final String normTarget4 = "@Test123";
	private final String normTarget5 = "Test^123";
	private final String normTarget6 = "Test123!";
	private final String normTarget7 = "name@myemaildotcom";
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
			} else {
				normTarget2 += new Character((char) i).toString();
			}
		}
		
//		System.out.println("norm 1" + normTarget1);
//		System.out.println("norm 2" + normTarget2);

//		*test code*
//		for(int i=0; i < 256; i++) {
//			if(Character.isLetterOrDigit((char) i ))
//				System.out.print(i + ", ");
//		}
		
	}

	
	public void testValidateNormal() {
		StringIsAlphaNumeric stringIsAlphaNumeric = new StringIsAlphaNumeric();
		
		//1.01 & 1.05
		assertEquals(true, stringIsAlphaNumeric.validate(normTarget1));
		assertEquals(true, stringIsAlphaNumeric.validate(normTarget9));
		
		//1.02-1.03
		assertEquals(false, stringIsAlphaNumeric.validate(normTarget2));
		assertEquals(false, stringIsAlphaNumeric.validate(normTarget3));
		assertEquals(false, stringIsAlphaNumeric.validate(normTarget4));
		assertEquals(false, stringIsAlphaNumeric.validate(normTarget5));
		assertEquals(false, stringIsAlphaNumeric.validate(normTarget6));
		assertEquals(false, stringIsAlphaNumeric.validate(normTarget7));
		
		//1.04
		try {
			stringIsAlphaNumeric.validate(normTarget8);
		} catch(Exception e) {
			fail("exception not expected - Xref 1.04");
		}
	}
	
	public void testValidateError() {
		StringIsAlphaNumeric stringIsAlphaNumeric = new StringIsAlphaNumeric();
		
		//2.01
		try {
			stringIsAlphaNumeric.validate(errorTarget1);
		} catch(NullPointerException ex) {
			return;
		} catch(Exception e) {
			fail("invalid exception - Xref 2.01");
		}
		fail("invalid exception - Xref 2.01");
				
	}
	
}