/*
 * Created on Feb 17, 2005
 */
package com.jds.architecture.utilities;

/**
 * Validates strategy object that determines if the length of the object's string
 * representation (using the object's toString() method) is less than or equal to 
 * the defined maximum length.

 * The overriden method <code>transform(Object target)</code> accepts any object. 
 * Exceptions will be thrown when any other argument is passed to the method.
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
public class StringLengthIsValid implements ValidationStrategy{

	private int maxLength;
	
	
	/**
	 * Constructs a new string validation object with the specified maximum length.

	 * 
	 * @param maxLength maximum length used for comparison
	 */
	public StringLengthIsValid(int maxLength){
		this.maxLength = maxLength;
	}
	
	
	/** 
	 * Determines if the object argument's string representation complies with the
	 * length restriction as specified by this validation strategy.
	 * 
	 * @param target object whose string representation is to be validated
	 * @return true if the object argument's string representation is less than 
	 * or equal to the maximum specified length or the maximum length specified
	 * is negative, false otherwise.
	 * 
	 */
	public boolean validate(Object target) {
		
		
		
		return false;
		
	}

}
