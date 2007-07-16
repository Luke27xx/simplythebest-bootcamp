/*
 * Created on Mar 10, 2005
 */
package com.jds.architecture.utilities;

/**
 * Validation strategy object used to determine if the given argument translates
 * to a string containing letters only.  The method uses the argument object's
 * toString() method to obtain a string representation and validates them using 
 * Character.isLetter() 
 * 
 * The inherited method <code>validate(Object target)</code> accepts an object
 * to be validated. RuntimeExceptions  Exceptions will be thrown when any other argument is passed 
 * to the method.
 * 
 * Classes that implement the <code>ValidationStrategy</code> interface should be 
 * passed to <code>Validator</code> objects via their constructor or to the 
 * <code>Validator.validate(ValidationStrategy, Object)</code> method
 * 
 * 
 * @author Arthur D. Gerona
 * @see Validator
 * @see ValidationStrategy
 * 
 */
public class StringIsAlpha implements  ValidationStrategy {

	/** 
	 * Determines if the object argument contains only valid letters
	 * 
	 * @param target object argument to be valdiated
	 * @return true if the object argument's string representation only contains 
	 * qualified  Unicode letters and digits , returns false otherwise.
	 * 
	 */
	public boolean validate(Object target) {
		char[] charArray = target.toString().toCharArray();
		
		for(int i = 0 ; i < charArray.length; i++) {
			if(Character.isLetter(charArray[i]))	
				return false;
		}
		
		return true;
	}

}
