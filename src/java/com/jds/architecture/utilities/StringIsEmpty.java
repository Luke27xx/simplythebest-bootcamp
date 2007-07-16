/*
 * Created on Feb 16, 2005
 */
package com.jds.architecture.utilities;

/**
 * Validation strategy object used to determine if the argument object's string representation
 * compares to an empty string "" according to the <code>String.equals()</code>. 
 *   
 * The inherited method <code>validate(Object target)</code> accepts any object
 * to be validated.  RuntimeExceptions will be thrown when any other argument is passed 
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
public class StringIsEmpty implements ValidationStrategy{

	/**
	 * Determines if the string representaiton of the argument object compares
	 * to an empty string "".
	 * 
	 * @param target the object whose string representation is to be validated
	 * @return boolean true if the argument's string representation is equivalent to "" according 
	 * to the String.equals(String) method, false otherwise.
	 */
	public boolean validate(Object target) {
		
	
		return false;
		
	}

}
