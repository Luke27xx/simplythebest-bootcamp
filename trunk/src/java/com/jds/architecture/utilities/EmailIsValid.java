/*
 * Created on Feb 22, 2005
 */
package com.jds.architecture.utilities;

import java.util.StringTokenizer;


/**
 * Validation strategy object used to determine the validity of a given email.  
 * This strategy object checks if the given email address contains a single '@' 
 * sign. 
 * 
 * The overriden method <code>validate(Object target)</code> accepts any object
 * to be validated.  Any other elements of the array will be ignored. RuntimeExceptions   
 * will be thrown when any other argument is passed to the method.
 * 
 * 
 * Classes that implement the <code>ValidationStrategy</code> interface should be 
 * passed to <code>Validator</code> objects via their constructor or to the 
 * <code>Validator.validate(ValidationStrategy, Object)</code> method
 * 
 * 
 * 
 * @author ghel.marie.l.oracion, eugene.p.lozada
 * @see Validator
 * @see ValidationStrategy
 * 
 */
public class EmailIsValid implements  ValidationStrategy  {
	/**
	 * Determines if a string is a valid email according to the specifications ofthe
	 * JDS architecture
	 * 
	 * @param target Object whose string representation is to be validated 	
	 * @return boolean true if the string contains a single '@', false otherwise
	 */
	public boolean validate(Object target) {
		
		StringTokenizer st = new StringTokenizer(target.toString(), "@");
		System.out.println(st.countTokens());
		return st.countTokens() == 2 ?  true : false;
	}

	
}
