package com.jds.architecture.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Transform strategy object used to transform a <code>Calendar</code> instance
 * to a <code>String</code>.  This class uses the <code>java.text.DateFormat</code>
 * to provide the formatting.
 * 
 * The overriden method <code>transform(Object target)</code> accepts a <code>java.util.Calendar</code>
 * or <code>java.util.Date</code>object representing the date to be transformed.  RuntimeExceptions will be thrown when any other 
 * argument is passed to the method.
 * 
 * Classes that implement the <code>TransformStrategy</code> interface should be 
 * passed to <code>Transformer</code> objects via their constructor or to the 
 * <code>Transformer.transform(TransformStrategy, Object)</code> method.
 * 
 * @author Eugene P. Lozada, Arthur D. Gerona
 * @see Transformer
 * @see TransformStrategy
 */
public class CalendarToString implements TransformStrategy{
	
	private DateFormat df;
	
	/**
	 * Constructs a new strategy object using the specified format for its transform rule.
	 * 
	 * @param format format to be used by this transfrom strategy
	 * @see java.text.DateFormat
	 */
	public CalendarToString(int format) {
		
		df = DateFormat.getDateInstance(format);
		
	}
	
	/**
	 * Constructs a new strategy object using the default format DateFormat.FULL for its 
	 * transform rule.
	 */
	public CalendarToString(){
	
		//df = DateFormat.getDateInstance(DateFormat.FULL);
		df = new SimpleDateFormat("dd-MMM-yy");
		
	}
	
	/** 
	 * Returns the specified argument <code>Calendar<code> instance as a string
	 * 
	 * @param target <code>Calendar</code> instance to transform
	 * @return formatted string representing the <code>Calendar</code> instance
	 * 
	 */
	public Object transform(Object target) {
	
	    
        return null;
	}

}
