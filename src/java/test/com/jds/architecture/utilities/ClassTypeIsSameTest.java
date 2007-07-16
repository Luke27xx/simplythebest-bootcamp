/*
 * Created on Feb 15, 2005
 */
package test.com.jds.architecture.utilities;

import com.jds.architecture.utilities.ClassTypeIsSame;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class ClassTypeIsSameTest extends TestCase {
	
	
	private static final Object temp = new Object();
	private static final Object[] normTarget1 = {temp, temp};
	private static final Object[] normTarget2 = {new Object(), new Object()};
	private static final Object[] normTarget3 = {new Object(), new Object(), new Object()};
	private static final Object[] normTarget4 = {null, null};
	private static final Object[] normTarget5 = {new Object(), new String()};
	private static final Object[] normTarget6 = {new Object(), new String(), new Object()};
	private static final Object[] normTarget7 = {new Object(), null};
	private static final Object[] normTarget8 = {null, new Object()};
	
	private static final Object errorTarget1 = new Object();
	private static final Object[] errorTarget2 = {new Object()};
	private static final Object[] errorTarget3 = null;
	
	
	public void testValidateNormal() {
		ClassTypeIsSame classTypeIsSame = new ClassTypeIsSame();
		
		//1.01-1.07
		assertEquals(true, classTypeIsSame.validate(normTarget1));		//1.01
		assertEquals(true, classTypeIsSame.validate(normTarget2));		//1.02
		assertEquals(true, classTypeIsSame.validate(normTarget3));		//1.03
		assertEquals(true, classTypeIsSame.validate(normTarget4));		//1.04
		assertEquals(false, classTypeIsSame.validate(normTarget5));		//1.05
		assertEquals(false, classTypeIsSame.validate(normTarget6));		//1.06
		assertEquals(false, classTypeIsSame.validate(normTarget7));		//1.07a
		assertEquals(false, classTypeIsSame.validate(normTarget8));		//1.07b
		
	}
	
	public void testValidateError() {
		ClassTypeIsSame classTypeIsSame = new ClassTypeIsSame();
		
		//2.01
		try {
			classTypeIsSame.validate(errorTarget1);
		} catch(ClassCastException ex) {
			return;
		} catch(Exception e) {
			fail("invalid exception - Xref 2.01");
		}
		fail("invalid exception - Xref 2.01");
		
		//2.02
		try {
			classTypeIsSame.validate(errorTarget2);
		} catch(ArrayIndexOutOfBoundsException ex) {
			return;
		} catch(Exception e) {
			fail("invalid exception - Xref 2.02");
		}
		fail("invalid exception - Xref 2.02");
		
		//2.03
		try {
			classTypeIsSame.validate(errorTarget3);
		} catch(NullPointerException ex) {
			return;
		} catch(Exception e) {
			fail("invalid exception - Xref 2.03");
		}
		fail("invalid exception - Xref 2.03");
		
	}
	
}
