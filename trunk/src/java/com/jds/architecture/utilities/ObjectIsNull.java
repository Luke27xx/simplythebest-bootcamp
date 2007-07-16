/*
 * Created on Feb 16, 2005
 */
package com.jds.architecture.utilities;

/**
 * Validation strategy object used to determine if the argument object reference 
 * is null.
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
public class ObjectIsNull implements ValidationStrategy {

	/**
	 * Returns true if the input is null, returns false 
	 * otherwise. 
	 * 
	 * @param target the object reference to be tested
	 * @return true if the argument is null, false otherwise
	 */
	public boolean validate(Object target) {
		if(target == null){
			return true;
		}
		return false;
	}

}
