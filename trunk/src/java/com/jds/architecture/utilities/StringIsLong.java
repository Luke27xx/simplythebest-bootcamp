/*
 * Created on Feb 2, 2005
 */
package com.jds.architecture.utilities;
/**
 * Validation strategy object used to determine if the argument object can translates
 * to an long a value.  The method uses the argument object's toString() method to 
 * obtain its string representation and the <code>Long.parseLong(String)</code> method
 * for parsing.
 * 
 * The overriden method <code>transform(Object target)</code> accepts any object. 
 * RuntimeExceptions  will be thrown when any other argument is passed to the method.
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
public class StringIsLong implements  ValidationStrategy{

	/**
	 * Determines if the string representation of the argument object can be 
	 * translated as a long.
	 * 
	 * @param target the object to be validated
	 * @return boolean true if the object can be parsed as a long, false otherwise
	 */
	public boolean validate(Object target) {
		
	    
        return false;
		
	}

}
