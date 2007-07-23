/*
 * Created on Feb 9, 2005
 */
package com.jds.architecture.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

/**
 * Transform strategy object used to transform a <code>Calendar</code>
 * instance to an array of integers containing that <code>Calendar's</code>
 * {year, month, date}. Date standard used by the array will use those defined
 * by the <code>CalendarConstants</code> class.
 * 
 * The overriden method <code>transform(Object target)</code> accepts a
 * <code>Calendar</code> or <code>Date</code> object representing the date
 * to be transformed. RuntimeExceptions will be thrown when any other argument
 * is passed to the method.
 * 
 * Classes that implement the <code>TransformStrategy</code> interface should
 * be passed to <code>Transformer</code> objects via their constructor or to
 * the <code>Transformer.transform(TransformStrategy, Object)</code> method.
 *
 * @author Dmitrijs.Sadovskis
 * @author Eugene P. Lozada, Arthur D. Gerona
 * @see Transformer
 * @see TransformStrategy
 */
public class CalendarToIntArray implements TransformStrategy {

	/**
	 * Returns an equivalent integer array representation of argument
	 * <code>Calendar</code> instance
	 * 
	 * @param target
	 *            <code>Calendar</code> instance to transform
	 * @return array of integers representing the Calendar [year, month, date]
	 * 
	 */
	public Object transform(Object target) {

		String[] calendarStr;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");

		if (target instanceof Calendar) {
			calendarStr = sdf.format(((Calendar) target).getTime()).split(" ");
		} else if (target instanceof Date) {
			calendarStr = sdf.format(target).split(" ");
		} else {
			throw new ClassCastException("Wrong argument");
		}

		int[] returnValue = {
				Integer.parseInt(calendarStr[0]),
				Integer.parseInt(calendarStr[1]),
				Integer.parseInt(calendarStr[2])
				};

		return returnValue;

	}
}
