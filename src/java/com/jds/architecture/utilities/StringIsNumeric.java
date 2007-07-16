/*
 * Created on Mar 10, 2005 
 */
package com.jds.architecture.utilities;

/**
 * Validation strategy object used to determine if the given argument translates
 * to a string containing numbers only.  The method uses the argument object's
 * toString() method to obtain a string representation and validates them using 
 * Character.isLetter() 
 * 
 * The inherited method <code>validate(Object target)</code> accepts an object
 * to be validated.  RuntimeExceptions will be thrown when any other argument is passed 
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
public class StringIsNumeric implements ValidationStrategy {

	private String specialChars;
	
	public StringIsNumeric() {
		this.specialChars = "";
	}
	
	/**
	 * Creates a new string validation strategy object and specifies 
	 * additional characters to be considered as valid
	 * 
	 * @param specialChars String containing characters considered as valid.
	 */
	public StringIsNumeric(String specialChars){
		this.specialChars = specialChars;
	}
	
	/** 
	 * Determines if the object argument contains only valid numbers
	 * 
	 * @param target object argument to be valdiated
	 * @return true if the object argument's string representation only contains 
	 * qualified  Unicode letters and digits , returns false otherwise.
	 * 
	 */
	public boolean validate(Object target) {
		char[] charArray = target.toString().toCharArray();
		


		return true;
	}

	private boolean specialCharIsOK(char c){
		
		
		return false;
	}
	
}
