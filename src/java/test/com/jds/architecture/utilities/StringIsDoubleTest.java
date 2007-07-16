/*
 * Created on Feb 16, 2005
 */
package test.com.jds.architecture.utilities;

import com.jds.architecture.utilities.StringIsDouble;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class StringIsDoubleTest extends TestCase {

	private static final String normalTarget1 = "1";
	private static final String normalTarget2 = "2.0";
	private static final String normalTarget3 = "22.00";
	private static final String normalTarget4 = "222.000";
	private static final String normalTarget5 = "33.3";
	private static final String normalTarget6 = "44.44";
	private static final String normalTarget7 = "888.808080";
	private static final String normalTarget8 = "1616.000016";
	private static final String normalTarget9 = "001.100";
	private static final String normalTarget10 = "TEST";
	private static final String normalTarget11 = "Test1.0";
	private static final String normalTarget12 = "1.0tesT";
	private static final String normalTarget13 = "1.0.1";
	private static final String normalTarget14 = "1/1/2001";
	private static final String normalTarget15 = "1.0^0";
	private static final Character normalTarget16 = new Character('C');
	private static final String normalTarget17 = "";
	private static final String errorTarget1 = null;
	
	public void testValidateNormal() {
		StringIsDouble stringIsDouble = 
			new StringIsDouble();
		
		//1.01
		assertEquals(true, stringIsDouble.validate(normalTarget1));
		assertEquals(true, stringIsDouble.validate(normalTarget2));
		assertEquals(true, stringIsDouble.validate(normalTarget3));
		assertEquals(true, stringIsDouble.validate(normalTarget4));
		assertEquals(true, stringIsDouble.validate(normalTarget5));
		assertEquals(true, stringIsDouble.validate(normalTarget6));
		assertEquals(true, stringIsDouble.validate(normalTarget7));
		assertEquals(true, stringIsDouble.validate(normalTarget8));
		assertEquals(true, stringIsDouble.validate(normalTarget9));
		
		//1.02
		assertEquals(false, stringIsDouble.validate(normalTarget10));
		assertEquals(false, stringIsDouble.validate(normalTarget11));
		assertEquals(false, stringIsDouble.validate(normalTarget12));
		assertEquals(false, stringIsDouble.validate(normalTarget13));
		assertEquals(false, stringIsDouble.validate(normalTarget14));
		assertEquals(false, stringIsDouble.validate(normalTarget15));
		
		//1.03
		//assertEquals(false, stringIsDouble.validate(normalTarget16));
		try {
			stringIsDouble.validate(normalTarget16);
		} catch(Exception e) {
			fail("invalid exception - Xref 1.03");
		}
		
		//1.04
		assertEquals(false, stringIsDouble.validate(normalTarget17));
	}
	
	public void testValidateError() {
		StringIsDouble stringIsDouble = 
			new StringIsDouble();
		
		//2.01
		try {
			stringIsDouble.validate(errorTarget1);
		} catch(NullPointerException ex) {
			return;
		} catch(Exception e) {
			fail("invalid exception - Xref 2.01");
		}
		fail("invalid exception - Xref 2.01");
		
	}

}