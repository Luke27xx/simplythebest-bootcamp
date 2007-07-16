/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 15, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.beans.valueutil;

import java.util.Calendar;

import com.jds.apps.beans.ProjectInfo;
import com.jds.apps.hr.project.form.ProjectForm;
import com.jds.apps.hr.project.form.SearchListItemForm;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.utilities.CalendarToIntArray;
import com.jds.architecture.utilities.CalendarToString;
import com.jds.architecture.utilities.StringArrayToCalendar;
import com.jds.architecture.utilities.Transformer;


/**
 * 
 *
 * @author ma.j.a.valiente
 * @author last modified by: $Author: r.c.delos.santos $
 * @version $Revision: 1.4 $ $Date: 2005/03/03 12:30:20 $
 * 
 */
public class ProjectInfoValueUtil {


    public static void formToValue(ProjectForm form, 
    		ProjectInfo value) {
        
        Transformer transformerCalendar = new Transformer(new 
                StringArrayToCalendar());

        value.setProjectId(form.getProjectId());
    	value.setProjectName(form.getProject());
    	value.setClient(form.getClient());
    	value.setDescription(form.getDescription());
    	value.setProjectId(form.getProjectId());
    	
    	Calendar utilStartDate = (Calendar) transformerCalendar.transform(
                new String[] {form.getStartYear(), form.getStartMonth(),
                form.getStartDay()});
    	
        value.setStartDate(utilStartDate.getTime());

        if((form.getEndYear().length()!=0) || (!form.getEndMonth().equals("0"))
                || (form.getEndDay().length()!=0)) {
            Calendar utilEndDate = (Calendar) transformerCalendar.transform(
                    new String[] {form.getEndYear(),form.getEndMonth(),form.getEndDay() });
            value.setEndDate(utilEndDate.getTime());
        }
    }

    public static void valueToForm(ProjectInfo value, 
    		ProjectForm form) throws HRSLogicalException {
        
        Transformer transformerCalendar = new Transformer(new 
                CalendarToIntArray());
        
        form.setProject(value.getProjectName());
    	form.setProjectId(value.getProjectId());
    	form.setDescription(value.getProjectDescrition());
    	form.setClient(value.getClient());
    	
		int []startDate = (int[]) transformerCalendar.transform(
                value.getStartDate());

        form.setStartDay(String.valueOf(startDate[2]));
        form.setStartMonth(String.valueOf(startDate[1]));
        form.setStartYear(String.valueOf(startDate[0]));
        form.setStartDate((String) Transformer.transform(new CalendarToString(), 
                value.getStartDate()));

        if(value.getEndDate()!=null){
            int []endDate = (int[]) transformerCalendar.transform(
                    value.getEndDate());

            form.setEndDay(String.valueOf(endDate[2]));
            form.setEndMonth(String.valueOf(endDate[1]));
            form.setEndYear(String.valueOf(endDate[0]));
            form.setEndDate((String) Transformer.transform(
                new CalendarToString(), value.getEndDate()));
        }
    }

    public static void valueToListForm(ProjectInfo value, 
    		SearchListItemForm form) {

        form.setProject(value.getProjectName());
    	form.setProjectId(value.getProjectId());
        
    	form.setStartDate((String) Transformer.transform(new CalendarToString(), 
                value.getStartDate()));

    	form.setEndDate((String) Transformer.transform(new CalendarToString(), 
                value.getEndDate()));
    }
}
