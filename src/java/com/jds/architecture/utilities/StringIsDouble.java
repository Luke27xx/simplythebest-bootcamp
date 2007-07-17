/*
 * Created on Feb 2, 2005
 */
package com.jds.architecture.utilities;
import java.lang.Object;

/**
 * Validation strategy object used to determine if the argument object can translates
 * to a dobule a value.  The method uses the argument object's toString() method to 
 * obtain its string representation and the <code>Double.parseDouble(String)</code> method
 * for parsing.
 * 
 * The overriden method <code>transform(Object target)</code> accepts any object. 
 * RuntimeExceptions will be thrown when any other argument is passed to the method.
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
public class StringIsDouble implements ValidationStrategy{

	/**
	 * Determines if the string representation of the argument object can be 
	 * translated as a double.
	 * 
	 * @param target the object to be validated
	 * @return boolean true if the object can be parsed as a double, false otherwise
	 */
	public boolean validate(Object target) {
		//double temp = Double.parseDouble(target.toString());
		//String s = target.toString();
		//String x = String.valueOf(target);
		//double z = Double.valueOf(x);
		
		//if( target.equals(Double.parseDouble(target.toString() ) ) ){
		//if (x.equals(Double.toString(z)) ){
		//	return true;
		//}
	    
		//return false;
		
		if (target==null) throw new NullPointerException();
		
		try{
			
			String x = String.valueOf(target);
			Double z = Double.valueOf(x); 
			
		}catch(Exception e){
			return false;
		}
		
		return true;
		
	}

}
