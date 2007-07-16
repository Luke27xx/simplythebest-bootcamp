/*
 * Created on Feb 17, 2005
 */
package test.com.jds.architecture.utilities;

import com.jds.architecture.utilities.ObjectIsNull;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class ObjectIsNullTest extends TestCase {
	
	private class TestObject {
		Object obj = null;
	}
	
	public static final Object validTarget1 = null;
	public final TestObject validTarget2 = new TestObject();
	public static final Object validTarget3 = new Object();
	
	public void testValidateNormal() {
		ObjectIsNull objectIsNull = 
			new ObjectIsNull();
		
		//1.01 - 1.03
		assertEquals(true, objectIsNull.validate(validTarget1));
		assertEquals(false, objectIsNull.validate(validTarget2));
		assertEquals(false, objectIsNull.validate(validTarget3));
		
	}

}
