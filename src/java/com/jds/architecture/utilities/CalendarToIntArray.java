/*
 * Created on Feb 9, 2005
 */
package com.jds.architecture.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.crypto.IllegalBlockSizeException;


/**
 * Transform strategy object used to transform a <code>Calendar</code> instance
 * to an array of integers containing that <code>Calendar's</code> {year, month, date}.  
 * Date standard used by the array will use those defined by the <code>CalendarConstants</code>
 * class.
 * 
 * The overriden method <code>transform(Object target)</code> accepts a <code>Calendar</code>
 * or <code>Date</code> object representing the date to be transformed.  RuntimeExceptions will be 
 * thrown when any other argument is passed to the method.
 * 
 * Classes that implement the <code>TransformStrategy</code> interface should be 
 * passed to <code>Transformer</code> objects via their constructor or to the 
 * <code>Transformer.transform(TransformStrategy, Object)</code> method.
 * 
 * @author Eugene P. Lozada, Arthur D. Gerona
 * @see Transformer
 * @see TransformStrategy
 */
public class CalendarToIntArray implements TransformStrategy {
	
	/**
	 * Returns an equivalent integer array representation of argument
	 * <code>Calendar</code> instance
	 * 
	 * @param target <code>Calendar</code> instance to transform
	 * @return array of integers representing the Calendar [year, month, date]
	 *
	 */
	public Object transform(Object target) {
		
		String calendarStr;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
		
		if (target.getClass() == Calendar.class ||
				target.getClass() == GregorianCalendar.class) {
				calendarStr = sdf.format(((Calendar)target).getTime());
			} else if (target.getClass() == java.util.Date.class ||
					target.getClass() == java.sql.Date.class) {
				calendarStr = sdf.format(target);
			} else {
				throw new ClassCastException("Wrong argument");
			}

			int[] returnValue = {
					Integer.parseInt(calendarStr.split(" ")[0]),
					Integer.parseInt(calendarStr.split(" ")[1]),
					Integer.parseInt(calendarStr.split(" ")[2])
			};
			
			return returnValue;	
		
	}
}