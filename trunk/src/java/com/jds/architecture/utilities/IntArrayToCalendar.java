/*
 * Created on Feb 9, 2005
 */
package com.jds.architecture.utilities;

import java.util.Calendar;


/**
 * Transform strategy object used to transform an array of integers into a Calendar object
 * The Calendar used will use the locale as specified by a non-lenient, no-argument Calendar
 * as obtained by Calendar.getInstance(), that will then be populated by the values of the
 * integer array.
 * 
 * The overriden method <code>transform(Object target)</code> accepts an integer array containing
 * at least 3 integers representing the date to be transformed.  Extra elements in the array are 
 * ignored.  RuntimeExceptions  will be thrown when any other argument is passed to the method.
 * 
 * Classes that implement the <code>TransformStrategy</code> interface should be 
 * passed to <code>Transformer</code> objects via their constructor or to the 
 * <code>Transformer.transform(TransformStrategy, Object)</code> method.
 *  
 * @author Eugene P. Lozada, Arthur D. Gerona
 * @see Transformer
 * @see TransformStrategy
 */

public class IntArrayToCalendar implements  TransformStrategy {

	/**
	 * Returns an equivalent Calendar object representation of the 
	 * input array of integers {year, month, date}. 
	 * 
	 * @param target array of integers containing 3 elements to be transformed
	 * @return Calendar object equivalent of the argument
	 */
	public Object transform(Object target) {

	// declaring calendar variable to store our date
	Calendar calendar = Calendar.getInstance();
	
	// external try
	try {
	
	// trying to convert types from unknown to integer
	int[] transformedTargetInIntArray = (int[])target;

		// internal try
		try {
			
		// internal try: trying to setup fields with year, month-1 , date	
		calendar.set(transformedTargetInIntArray[0], transformedTargetInIntArray[1]-1, transformedTargetInIntArray[2]);
		
		//internal try: catching exeption on trying to access
		// to pointer not in Array range
		} catch( ArrayIndexOutOfBoundsException e) {
			
			throw new ArrayIndexOutOfBoundsException();
		}
	
	// external try : cathing Converting types
	} catch (ClassCastException ex) {
	
		throw new ClassCastException();
	}
		
	// if everything normal then return calendar
	return calendar;
	
	}

	

}
