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
import com.jds.architecture.utilities.StringIsEmpty;
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
        
		return errors;
	}
	
	public List getMonth() {
		Constants cons = new Constants();
		return  cons.getMonth();
	}
	
}
