/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 10, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.project.form;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.Constants;
import com.jds.apps.hr.project.form.ext.AbstractProjectForm;
import com.jds.architecture.utilities.CalendarIsValid;
import com.jds.architecture.utilities.IntArrayToCalendar;
import com.jds.architecture.utilities.ObjectIsNull;
import com.jds.architecture.utilities.StringIsAlphaNumeric;
import com.jds.architecture.utilities.StringIsEmpty;
import com.jds.architecture.utilities.StringIsNumeric;
import com.jds.architecture.utilities.StringIsValid;
import com.jds.architecture.utilities.StringLengthIsValid;
import com.jds.architecture.utilities.Transformer;
import com.jds.architecture.utilities.Validator;

/**
 * 
 *
 * @author ma.j.a.valiente
 * @author last modified by: $Author: c.b.balajadia $
 * @version $Revision: 1.8 $ $Date: 2005/05/04 10:00:30 $
 * 
 */
public class ProjectForm extends AbstractProjectForm {

    //static Logger log = Logger.getLogger(PropertiesMonitor.class);
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
        
        
//      TODO Implement validation
		Validator objectIsNull        =  new Validator( new ObjectIsNull() );
        Validator stringIsEmpty       =  new Validator ( new StringIsEmpty() );
        Validator calendarIsValid     =  new Validator( new CalendarIsValid() );

        
        /*
         * Input validation criteria:
         *		A: numbers only 
         *		B: numbers, spaces ( ), and dashes (-) only
         *		C: letters and numbers only
         *		D: letters, numbers, underscores (_), dashes (-), spaces ( ), and dots (.) only
         *		E: E plus line carriage (\n\r), commas (,), and slashes (/ ,\) only
         *		F: E plus at signs (@) only <-- com.jds.architecture.utilities.EmailIsValid
         */
        
        Validator stringIsValidA = new Validator( new StringIsNumeric() );
        Validator stringIsValidB = new Validator( new StringIsNumeric(" -") );
        Validator stringIsValidC = new Validator( new StringIsAlphaNumeric() );
        Validator stringIsValidD = new Validator( new StringIsValid("_- .") );
        Validator stringIsValidE = new Validator( new StringIsValid("_- .\n\r,/\\+#()") );
        
        String allowedCharactersA = "numbers";
        String allowedCharactersB = "numbers, spaces, and dashes ";        
        String allowedCharactersC = "letters & numbers";
        String allowedCharactersD = allowedCharactersC + ", underscores, dashes, spaces, dots ";
        String allowedCharactersE = allowedCharactersD + ", line carriage, commas, slashes, pluses, pounds, and parenthesis";        
        
        Validator stringLengthIsValidFive        = new Validator( new StringLengthIsValid(5) );
        Validator stringLengthIsValidFifteen     = new Validator( new StringLengthIsValid(15) );        
        Validator stringLengthIsValidThirty      = new Validator( new StringLengthIsValid(30) );        
        Validator stringLengthIsValidFifty       = new Validator( new StringLengthIsValid(50) );        
        Validator stringLengthIsValidHundred     = new Validator( new StringLengthIsValid(100) );
        Validator stringLengthIsValidFiveHundred = new Validator( new StringLengthIsValid(500) );

//Text Fields
        //Project Name: if it is empty, has a special character, or exceeds it's maximum length
        if (objectIsNull.validate(this.getProject()) || stringIsEmpty.validate(this.getProject()))
        {
        	errors.add("project", new ActionError("field.null", "Project Name"));
        	//errors.
        }
        else if (!stringIsValidE.validate(this.getProject()))
        {
        	errors.add("project", new ActionError("field.invalid.specialcharacter", "Project Name", allowedCharactersE));
        }
        else if (!stringLengthIsValidFifty.validate(this.getProject()))
        {
        	errors.add("project", new ActionError("field.invalid.length", "Project Name", "50"));
        }
        
        //Client: if it's empty, has a special character, or exceeds it's maximum length
        if (objectIsNull.validate(this.getClient()) || stringIsEmpty.validate(this.getClient()))
        {
        	errors.add("client", new ActionError("field.null", "Client"));
        }
        else if (!stringIsValidE.validate(this.getClient()))
        {
        	errors.add("client", new ActionError("field.invalid.specialcharacter", "Client", allowedCharactersE));
        }
        else if (!stringLengthIsValidFifty.validate(this.getClient()))
        {
        	errors.add("client", new ActionError("field.invalid.length", "Client", "50"));
        }
        
        //Description: if it's empty, has a special character, or exceeds it's maximum length
        if (objectIsNull.validate(this.getDescription()) || stringIsEmpty.validate(this.getDescription()))
        {
        	errors.add("description", new ActionError("field.null", "Description"));
        }
        else if (!stringIsValidE.validate(this.getDescription()))
        {
        	errors.add("description", new ActionError("field.invalid.specialcharacter", "Description", allowedCharactersE));
        }
        else if (!stringLengthIsValidHundred.validate(this.getDescription()))
        {
        	errors.add("description", new ActionError("field.invalid.length", "Description", "100"));
        }
        
        
//Date fields
        //Start Date: if it's empty or invalid
        if
        (
        		(objectIsNull.validate(this.getStartDate()) || stringIsEmpty.validate(this.getStartDate()))
        		&& this.getStartMonth().equals("0") &&
        		(objectIsNull.validate(this.getStartYear()) || stringIsEmpty.validate(this.getStartYear()))
        )
        {
        	errors.add("startDate", new ActionError("field.null", "Start Date"));
        }
        else
        {
        	try
        	{
        		int startDate[] = {Integer.parseInt(this.getStartYear()), Integer.parseInt(this.getStartMonth()), Integer.parseInt(this.getStartDay())};
        		
        		if (!calendarIsValid.validate(startDate))
        		{
        			throw new Exception();
        		}
        	}
        	catch (Exception e)
        	{
        		errors.add("startDate", new ActionError("field.invalid","Start Date"));
        	}
        }
        
      //End Date: if it's empty or invalid
        if
        (
        		(objectIsNull.validate(this.getEndDate()) || stringIsEmpty.validate(this.getEndDate()))
        		&& this.getEndMonth().equals("0") &&
        		(objectIsNull.validate(this.getEndYear()) || stringIsEmpty.validate(this.getEndYear()))
        )
        {
        	errors.add("endDate", new ActionError("field.null", "End Date"));
        }
        else
        {
        	try
        	{
        		int endDate[] = {Integer.parseInt(this.getEndYear()), Integer.parseInt(this.getEndMonth()), Integer.parseInt(this.getEndDay())};
        		
        		if (!calendarIsValid.validate(endDate))
        		{
        			throw new Exception();
        		}
        	}
        	catch (Exception e)
        	{
        		errors.add("endDate", new ActionError("field.invalid", "End Date"));
        	}
        }
        
		return errors;
	}
	
	public List getMonth() {
		Constants cons = new Constants();
		return  cons.getMonth();
	}
	
}
