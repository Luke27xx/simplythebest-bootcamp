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

import org.apache.struts.action.ActionErrors;

import com.jds.apps.beans.AccentureDetails;
import com.jds.apps.beans.EmployeeInfo;
import com.jds.apps.hr.employee.form.EmployeeInfoForm;
import com.jds.apps.hr.employee.form.EmployeeSearchForm;
import com.jds.apps.hr.employee.form.EmployeeSearchListItemForm;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.utilities.CalendarToIntArray;
import com.jds.architecture.utilities.CalendarToString;
import com.jds.architecture.utilities.StringArrayToCalendar;
import com.jds.architecture.utilities.Transformer;


/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Author: r.c.delos.santos $
 * @version $Revision: 1.2 $ $Date: 2005/02/24 06:31:58 $
 * 
 */
public class EmployeeInfoValueUtil {

    /**
     * Function Name: <b>public static void formToValue</b>
     * <br>
     * This methods copies the form values to the value object for business 
     * component functions.
     * <br>
     * @author r.c.delos.santos
     * <br>
     * @param <b>EmployeeInfo</b> value
     * @param <b>EmployeeInfoForm</b> form
     * @throws HRSLogicalException
     */
    public static void formToValue(EmployeeInfoForm form, 
            EmployeeInfo value) {
        
        Transformer transformCalendar = new Transformer(new 
                StringArrayToCalendar());
        
        value.setAge(form.getAge());
        value.setCitizenship(form.getCitizenship());
        value.setCity(form.getCity());
        value.setCivilStatus(form.getCivilStatus());
        value.setCountry(form.getCountry());
        
        Calendar dob = (Calendar) transformCalendar.transform(new String[] {
                form.getBirthYear(), form.getBirthMonth(), 
                form.getBirthDate()});
        value.setDob(dob.getTime());
        
        value.setEducationalAttainment(form.getEducationalAttainment());
        value.setEmpNo(form.getEmpNo());
        value.setFirstName(form.getFirstName());
        value.setGender(form.getGender());
        value.setHomePhoneNo(form.getHomePhoneNo());
        value.setLastName(form.getLastName());
        value.setMiddleName(form.getMiddleName());
        value.setMobilePhoneNo(form.getMobilePhoneNo());
        value.setRecognitions(form.getRecognitions());
        value.setReligion(form.getReligion());
        value.setSssNo(form.getSssNo());
        value.setState(form.getState());
        value.setStreet1(form.getStreet1());
        value.setStreet2(form.getStreet2());
        value.setTinNo(form.getTinNo());
        value.setZipcode(form.getZipcode());

        /* accenture details */
        AccentureDetails accentureDetails = new AccentureDetails();
        Calendar hireDate = (Calendar) transformCalendar.transform(new String[] 
                {form.getHireYear(), form.getHireMonth(), form.getHireDate()});
        accentureDetails.setDateHired(hireDate.getTime());
        
        accentureDetails.setEnterpriseAddress(form.getEnterpriseAddress());
        accentureDetails.setEnterpriseId(form.getEnterpriseId());
        accentureDetails.setGMU(form.getGMU());
        accentureDetails.setLMU(form.getLMU());
        accentureDetails.setLevel(form.getLevel());
        accentureDetails.setMembershipLevel(form.getMembershipLevel());
        accentureDetails.setServiceLine(form.getServiceLine());
        accentureDetails.setSpecialty(form.getSpecialty());
        accentureDetails.setStatus(form.getStatus());
        accentureDetails.setWorkGroup(form.getWorkGroup());
        
        value.setAccentureDetails(accentureDetails);
    }

    /**
     * Function Name: <b>public static void valueToForm</b>
     * <br>
     * This methods copies the value object values to the form for displaying.
     * <br>
     * @author r.c.delos.santos
     * <br>
     * @param <b>EmployeeInfo</b> value
     * @param <b>EmployeeInfoForm</b> form
     */
    public static void valueToForm(EmployeeInfo value, 
            EmployeeInfoForm form) {
        
        Transformer transformCalendar = new Transformer(new 
                CalendarToIntArray());

        ActionErrors convertErrors = new ActionErrors();
        
        form.setAge(value.getAge());
        form.setCitizenship(value.getCitizenship());
        form.setCity(value.getCity());
        form.setCivilStatus(value.getCivilStatus());
        form.setCountry(value.getCountry());
        
        //DateTransform birthDate = new DateTransform(value.getDob());
        int[] dob = (int[]) transformCalendar.transform(value.getDob()); 

        /* birthday */
        form.setDob((String) Transformer.transform(new CalendarToString(), 
                value.getDob()));
        form.setBirthDate(Integer.toString(dob[2]));
        form.setBirthMonth(Integer.toString(dob[1]));
        form.setBirthYear(Integer.toString(dob[0]));
        
        form.setEducationalAttainment(value.getEducationalAttainment());
        form.setEmpNo(value.getEmpNo());
        form.setFirstName(value.getFirstName());
        form.setGender(value.getGender());
        form.setHomePhoneNo(value.getHomePhoneNo());
        form.setLastName(value.getLastName());
        form.setMiddleName(value.getMiddleName());
        form.setMobilePhoneNo(value.getMobilePhoneNo());
        form.setRecognitions(value.getRecognitions());
        form.setReligion(value.getReligion());
        form.setSssNo(value.getSssNo());
        form.setState(value.getState());
        form.setStreet1(value.getStreet1());
        form.setStreet2(value.getStreet2());
        form.setTinNo(value.getTinNo());
        form.setZipcode(value.getZipcode());

        /* accenture details */
        /* hire date */
        int[] hireDate = (int[]) transformCalendar.transform(
                value.getAccentureDetails().getDateHired()); 

        //DateTransform hireDate = new DateTransform();
        form.setDateHired((String) Transformer.transform(new CalendarToString(), 
                value.getAccentureDetails().getDateHired()));
        
        form.setHireDate(Integer.toString(hireDate[2]));
        form.setHireMonth(Integer.toString(hireDate[1]));
        form.setHireYear(Integer.toString(hireDate[0]));
        
        form.setEnterpriseAddress(value.getAccentureDetails().getEnterpriseAddress());
        form.setEnterpriseId(value.getAccentureDetails().getEnterpriseId());
        form.setGMU(value.getAccentureDetails().getGMU());
        form.setLMU(value.getAccentureDetails().getLMU());
        form.setLevel(value.getAccentureDetails().getLevel());
        form.setMembershipLevel(value.getAccentureDetails().getMembershipLevel());
        form.setServiceLine(value.getAccentureDetails().getServiceLine());
        form.setSpecialty(value.getAccentureDetails().getSpecialty());
        
        System.out.println("search status value = " + value.getAccentureDetails().getStatus());
        form.setStatus(value.getAccentureDetails().getStatus());
        form.setWorkGroup(value.getAccentureDetails().getWorkGroup());
    }
    
    public static void valueToListForm(EmployeeInfo value, 
            EmployeeSearchListItemForm tempRecordForm) {
        tempRecordForm.setEmployeeId(value.getEmpNo());
        tempRecordForm.setLastName(value.getLastName());
        tempRecordForm.setFirstName(value.getFirstName());
        tempRecordForm.setMiddleName(value.getMiddleName());
        tempRecordForm.setLevel(value.getAccentureDetails().getLevel());
    }

    public static void searchToValue(EmployeeSearchForm form, 
            EmployeeInfo value) {
        value.setLastName(form.getLastName());
        value.setFirstName(form.getFirstName());
    }
}
