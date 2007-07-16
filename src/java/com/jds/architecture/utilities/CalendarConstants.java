/*
 * Created on Feb 17, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.utilities;

import java.util.Calendar;

/**
 * This class defines constants used as a reference for converting the values returned by
 * <code>Calendar.get(Calendar.MONTH)</code> to appropriate values.  The current implementation
 * of the <code>Calendar</code> class sets starting month JANUARY to 0.  This class provides
 * methods to translate values to from Calendar to JDS architecture standards with the month
 * JAN starting at 1.
 * 
 * @author eugene.p.lozada
 *
 */
public final class CalendarConstants {

	public static final int JANUARY=1;
	public static final int FEBRUARY=2;
	public static final int MARCH=3;
	public static final int APRIL=4;
	public static final int MAY=5;
	public static final int JUNE=6;
	public static final int JULY=7;
	public static final int AUGUST=8;
	public static final int SEPTEMBER=9;
	public static final int OCTOBER=10;
	public static final int NOVEMBER=11;
	public static final int DECEMBER=12;
	public static final int ERR=-1;
	
	

	
	/**
	 * Translates and returns an integer representation of the month of a <code>Calendar</code> instance
	 * to the standard month values used by the JDS architecture.
	 * 
	 * @param calendar The <code>Calendar</code> to transform
	 * 
	 * @return An integer value representing the current month using JDS architecture standards or ERR
	 * if the month has no equivalent translation.
	 */
	public static int toStandardMonth(Calendar calendar){
	
	    switch(calendar.get(Calendar.MONTH)){
            case Calendar.JANUARY : return JANUARY ;
            case Calendar.FEBRUARY: return FEBRUARY;
            case Calendar.MARCH : return MARCH ;
            case Calendar.APRIL : return APRIL ;
            case Calendar.MAY : return MAY;
            case Calendar.JUNE: return JUNE;
            case Calendar.JULY : return JULY ;
            case Calendar.AUGUST: return AUGUST;
            case Calendar.SEPTEMBER: return SEPTEMBER;
            case Calendar.OCTOBER : return OCTOBER;
            case Calendar.NOVEMBER: return NOVEMBER;
            case Calendar.DECEMBER: return DECEMBER;
            default : return ERR;
        }
    }
	
	/**
	 * Translates and return an integer representation of the JDS architecture month, to the 
	 * standard used by the <code>Calendar</code> class
	 * 
	 * @param month The JDS architecture standard month to transform
	 * @return The equivalent month as represented by the <code>Calendar</code> class or the
	 * argument itself if it has no equivalent translation.
	 */
	public static int toCalendarMonth(int month){
        
        switch(month){
        case JANUARY : return Calendar.JANUARY ;
        case FEBRUARY: return Calendar.FEBRUARY;
        case MARCH : return Calendar.MARCH ;
        case APRIL : return Calendar.APRIL ;
        case MAY : return Calendar.MAY;
        case JUNE: return Calendar.JUNE;
        case JULY : return Calendar.JULY ;
        case AUGUST: return Calendar.AUGUST;
        case SEPTEMBER: return Calendar.SEPTEMBER;
        case OCTOBER : return Calendar.OCTOBER;
        case NOVEMBER: return Calendar.NOVEMBER;
        case DECEMBER: return Calendar.DECEMBER;
        default : return ERR;
    }
	}
	
}
