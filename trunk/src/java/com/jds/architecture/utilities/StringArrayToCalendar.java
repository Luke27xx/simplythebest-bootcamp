/*
 * Created on Feb 18, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.utilities;

import java.util.Calendar;


/**
 * Transform strategy object used to transform an array of 3 objects into an equivalent
 * instance of a Calendar.  Contents of the object array are translated to strings using their
 * toString() method and parsed according to the <code>Integer.parseInt(String)</code> to represent
 * the {year, month, date} of the Calendar.
 * 
 * The overriden method <code>transform(Object target)</code> accepts a <code>String</code>array
 * representing the date to be transformed. Extra elements in the array will be ignored. 
 * RuntimeExceptions will be thrown when any other argument is passed to the method, or if the 
 * elements of the array are not Strings that can be parsed as integers.
 * 
 * Classes that implement the <code>TransformStrategy</code> interface should be 
 * passed to <code>Transformer</code> objects via their constructor or to the 
 * <code>Transformer.transform(TransformStrategy, Object)</code> method.
 * 
 * @author Eugene P. Lozada, Arthur D. Gerona
 * @see Transformer
 * @see TransformStrategy
 */
public class StringArrayToCalendar implements  TransformStrategy {

	
	
	/**
	 * Returns an instance of a Calendar with values based on the object
	 * array argument.
	 * 
	 * @param target array containing 3 integers as Strings representing {year, month, date}
	 * @return instance of a Calendar based on the argument array.
	 */
	public Object transform(Object target) {
	
        
		return null;
	}

}
