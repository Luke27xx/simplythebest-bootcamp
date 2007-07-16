/*
 * Created on Feb 2, 2005
 */
package com.jds.architecture.utilities;

/**
 * Validation strategy object used to determine if the class types of two argument
 * objects are the same, using the Object.getClass() method.
 * 
 * The overriden method <code>validate(Object target)</code> accepts an array of 2 
 * Objects to represent the objects to be validated.  Any other elements of the array
 * will be ignored. RuntimeExceptions  will be thrown when any other argument is passed to 
 * the method.
 * 
 * Classes that implement the <code>ValidationStrategy</code> interface should be 
 * passed to <code>Validator</code> objects via their constructor or to the 
 * <code>Validator.validate(ValidationStrategy, Object)</code> method
 * 
 * 
 * @author Eugene P. Lozada, Arthur D. Gerona
 * @see Validator
 * @see  ValidationStrategy
 */
public class ClassTypeIsSame implements ValidationStrategy {

	/**
	 * Determines if the pair of objects contained in the array is of the same class
	 * 
	 * @param target array of objects. The array can contain nulls.
	 * @return  returns true if the objects contained in the array are ofthe same class, 
	 * false otherwise
	 *
	 */
	public boolean validate(Object target) {
		
		//Get arguments array
		
		
		return false;
		
	}

}
