/*
 * Created on Feb 16, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.utilities;

/**
 * Validation strategy object used to determine if the given argument translates
 * to a string containing letters or digits or any valid characters as specified 
 * by the constructor.  The method uses the argument object's toString() method to
 * obtain a string representation.
 * 
 * The inherited method <code>validate(Object target)</code> accepts an object
 * to be validated.  Exceptions will be thrown when any other argument is passed 
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
public class StringIsValid implements ValidationStrategy{
    ;
	String specialChars="";
	
	
	/**
	 * Creates a new string validation strategy object and specifies 
	 * additional characters to be considered as valid
	 * 
	 * @param specialChars String containing characters considered as valid.
	 */
	public StringIsValid(String specialChars){
		this.specialChars= specialChars;
	}

	/** 
	 * 
	 * Determines if the object argument contains only validat letters and digits
	 * 
	 * @param target object argument to be valdiated
	 * @return true if the object argument's string representation only contains 
	 * qualified  Unicode letters and digits , returns false otherwise.
	 * 
	 */
	public boolean validate(Object target) {
		
		String targetStr = target.toString();
		int targetLen = targetStr.length();
		char[] charArray = targetStr.toCharArray();
		

		for(int i = 0; i < targetLen; i++){
			if(Character.isLetterOrDigit(charArray[i]) || specialCharIsOK(charArray[i])){
			   	continue;
			}
			else{
				return false;
			}
		}
		
		return true;
	}
	
	private boolean specialCharIsOK(char c){
		
		
		return false;
	}
	
	
}
