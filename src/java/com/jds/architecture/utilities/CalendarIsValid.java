/*
 * Created on Feb 1, 2005
 */
package com.jds.architecture.utilities;

import java.util.Calendar;

/**
 * Validation strategy object used to determine the validity of a given date.
 * This strategy object uses a non-lenient <code>java.util.Calendar</code>
 * instance to verify if the given date is valid.
 * 
 * The overriden method <code>validate(Object target)</code> accepts an array
 * of 3 integers {month, date, year} to represent the date to be validated.
 * Exceptions will be thrown when any other argument is passed to the method.
 * 
 * Classes that implement the <code>ValidationStrategy</code> interface should
 * be passed to <code>Validator</code> objects via their constructor or to the
 * <code>Validator.validate(ValidationStrategy, Object)</code> method
 * 
 * 
 * 
 * @author Dmitrijs.Sadovskis
 * @author Eugene P. Lozada, Arthur D. Gerona
 * @see Validator
 * @see ValidationStrategy
 * 
 */
public class CalendarIsValid implements ValidationStrategy {
	/**
	 * 
	 * Inherited method from <code>ValidationStrategy</code>. Overriden to
	 * represent a specific validation algorithm.
	 * 
	 * @param target
	 *            An array of 3 integers representing the {year, month, date} to
	 *            validate.
	 * @return boolean <code>true</code> if the date is valid,
	 *         <code>false</code> otherwise
	 * 
	 * 
	 */
	public boolean validate(Object target) {
		int year = ((int[]) target)[0];
		int month = ((int[]) target)[1];
		int date = ((int[]) target)[2];

		if (year < 0)
			return false;

		if (date > 31)
			return false;

		if (date > 30
				&& (month == 2 || month == 4 || month == 6 || month == 9 || month == 11))
			return false;
		if (date == 30 && month == 2)
			return false;
		if (date == 29 && month == 2 && !isLeap(year))
			return false;

		if (month > 12)
			return false;

		if (date < 1 || month < 1)
			return false;

		return true;
	}

	private boolean isLeap(int year) {
		if (year % 400 == 0)
			return true;
		if (year % 100 == 0)
			return false;
		if (year % 4 == 0)
			return true;
		return false;
	}

}
