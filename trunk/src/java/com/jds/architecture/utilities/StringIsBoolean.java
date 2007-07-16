/*
 * Created on Feb 2, 2005
 */
package com.jds.architecture.utilities;

/**
 * Validation strategy object used to determine if the argument object can translates
 * to a boolean value using JDS architecture standards {"TRUE", "YES", "OK"}.  The method 
 * uses the argument object's toString() method to obtain its string representation.
 * 
 * The overriden method <code>validate(Object target)</code> accepts any object
 * to be validated.  RuntimeExceptions  will be thrown when any other argument is passed 
 * to the method.
 *  
 * Classes that implement the <code>ValidationStrategy</code> interface should be 
 * passed to <code>Validator</code> objects via their constructor or to the 
 * <code>Validator.validate(ValidationStrategy, Object)</code> method
 * 
 * @author Eugene P. Lozada, Arthur D. Gerona
 * @see Validator
 * @see ValidationStrategy
 * 
 */
public class StringIsBoolean implements  ValidationStrategy {

	
	private static String[] TRUE = {"TRUE", "YES", "OK"};

	/**
	 * Determines if the string representation of the argument object can be 
	 * translated as a boolean using standards set by the JDS architecture.
	 * 
	 * @param target the object to be validated
	 * @return boolean true if the object's toString() method returns "true", "yes"
	 * pr "ok" (case insensitive) and false otherwise
	 */
	public boolean validate(Object target) {
	
		
		
	
		return false;
		
	}

}
