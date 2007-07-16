/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 3, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.employee.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.Constants;
import com.jds.apps.hr.employee.form.ext.AbstractEmployeeForm;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.exceptions.HRSSystemException;
import com.jds.architecture.utilities.CalendarIsValid;
import com.jds.architecture.utilities.CalendarToIntArray;
import com.jds.architecture.utilities.EmailIsValid;
import com.jds.architecture.utilities.ObjectIsNull;
import com.jds.architecture.utilities.StringIsAlphaNumeric;
import com.jds.architecture.utilities.StringIsEmpty;
import com.jds.architecture.utilities.StringIsNumeric;
import com.jds.architecture.utilities.StringIsValid;
import com.jds.architecture.utilities.StringLengthIsValid;
import com.jds.architecture.utilities.Transformer;
import com.jds.architecture.utilities.VOCollectionToMap;
import com.jds.architecture.utilities.Validator;
//import com.jds.businesscomponent.HRManager;
import com.jds.businesscomponent.stub.HRManager;

/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Author: c.b.balajadia ${date}
 * @version $Revision $ $Date: 2005/03/18 09:46:56 $
 * 
 */
public class EmployeeInfoForm extends AbstractEmployeeForm {
    
    /* (non-Javadoc)
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

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
        

        // Last Name: if it's empty, has a special character, or exceeds it's maximum length
        if( objectIsNull.validate(this.getLastName() ) ||
                stringIsEmpty.validate( this.getLastName() ) ){
        	errors.add("lastName", new ActionError("field.null","Last Name"));
        }
        else if( !stringIsValidD.validate( this.getLastName() ) ){
			errors.add("lastName", new ActionError("field.invalid.specialcharacter", "Last Name", allowedCharactersD));
        }
        else if( !stringLengthIsValidFifty.validate( this.getLastName() ) ){
			errors.add("lastName", new ActionError("field.invalid.length", "Last Name", "50"));        	
        }        
        
        
        // First Name: if it's empty, has a special character, or exceeds it's maximum length        
        if( objectIsNull.validate(this.getFirstName() ) ||
                stringIsEmpty.validate( this.getFirstName() ) ){
        	errors.add("firstName", new ActionError("field.null","First Name"));
        }
        else if( !stringIsValidD.validate( this.getFirstName() ) ){
			errors.add("firstName", new ActionError("field.invalid.specialcharacter", "First Name", allowedCharactersD));
        }
        else if( !stringLengthIsValidFifty.validate( this.getFirstName() ) ){
			errors.add("firstName", new ActionError("field.invalid.length", "First Name", "50"));        	
        }        
        
        
        // Middle Name: if it's empty, has a special character, or exceeds it's maximum length
        if( objectIsNull.validate(this.getMiddleName() ) ||
                stringIsEmpty.validate( this.getMiddleName() ) ){
        	errors.add("middleName", new ActionError("field.null","Middle Name"));
        }
        else if( !stringIsValidD.validate( this.getMiddleName() ) ){
			errors.add("middleName", new ActionError("field.invalid.specialcharacter", "Middle Name", allowedCharactersD));
        }
        else if( !stringLengthIsValidFifty.validate( this.getMiddleName() ) ){
			errors.add("middleName", new ActionError("field.invalid.length", "Middle Name", "50"));        	
        }
        
        // Birth Date: if it's empty or invalid
        if( ( objectIsNull.validate( this.getBirthDate() ) || 
                stringIsEmpty.validate( this.getBirthDate() ) ) 
                  && this.getBirthMonth().equals("0") &&
                     (objectIsNull.validate( this.getBirthYear() ) || 
                          stringIsEmpty.validate( this.getBirthYear() ) ) ){
            errors.add("dob", new ActionError("field.null","Birthday"));
        } else {
            try {

                int dob[] = { Integer.parseInt( this.getBirthYear() ), 
                        				Integer.parseInt( this.getBirthMonth() ),
                        					Integer.parseInt( this.getBirthDate() ) };
                
                if( !calendarIsValid.validate( dob ) ){
                    throw new Exception();
                }
                
                // Set Age                
                final int YEAR  = 0;
                final int MONTH = 1;
                final int DAY   = 2;
                
                int age = 0;
 
                int currentDate[] = (int[])Transformer.transform( new CalendarToIntArray(), Calendar.getInstance());
                
                age = currentDate[YEAR]-dob[YEAR];
                
                if( currentDate[MONTH] < dob[MONTH] ){
                    --age;
                }
                else if ( currentDate[MONTH] == dob[MONTH] && currentDate[DAY] < dob[DAY] ) {
                    --age;
                }
                this.setAge(age);
                
            } catch (Exception e) {
                errors.add("dob", new ActionError("field.invalid","Birthday"));
            } 
        }
        
        // Gender: if it has a special character, or exceeds it's maximum length
        if(super.getGender()==' ') {
            errors.add("gender", new ActionError("field.null","Gender"));
        }
        
        // Citizenship: if it has a special character, or exceeds it's maximum length
        if ( !stringIsValidD.validate( this.getCitizenship() ) ){
			errors.add("citizenship", new ActionError("field.invalid.specialcharacter", "Citizenship", allowedCharactersD));            
        }
        else if( !stringLengthIsValidThirty.validate( this.getCitizenship() ) ){
			errors.add("citizenship", new ActionError("field.invalid.length", "Citizenship", "30"));        	
        }
        
        // SSS Number: if it's empty, has a special character, or exceeds it's maximum length
        if( objectIsNull.validate(this.getSssNo() ) ||
                stringIsEmpty.validate( this.getSssNo() ) ){
        	errors.add("sssNo", new ActionError("field.null","SSS Number"));
        }
        else if( !stringIsValidB.validate( this.getSssNo() ) ){
			errors.add("sssNo", new ActionError("field.invalid.specialcharacter", "SSS Number", allowedCharactersB));
        }
        else if( !stringLengthIsValidFifteen.validate( this.getSssNo() ) ){
			errors.add("sssNo", new ActionError("field.invalid.length", "SSS Number", "15"));        	
        }        
        
        // Tin Number: if it's empty, has a special character, or exceeds it's maximum length
        if( objectIsNull.validate(this.getTinNo() ) ||
                stringIsEmpty.validate( this.getTinNo() ) ){
        	errors.add("tinNo", new ActionError("field.null","TIN"));
        }
        else if( !stringIsValidB.validate( this.getTinNo() ) ){
			errors.add("tinNo", new ActionError("field.invalid.specialcharacter", "TIN", allowedCharactersB));
        }
        else if( !stringLengthIsValidFifteen.validate( this.getTinNo() ) ){
			errors.add("tinNo", new ActionError("field.invalid.length", "TIN", "15"));        	
        }        
        
        // Street1: if it's empty, has a special character, or exceeds it's maximum length
        if( objectIsNull.validate(this.getStreet1() ) ||
                stringIsEmpty.validate( this.getStreet1() ) ){
        	errors.add("street1", new ActionError("field.null","Street"));
        }
        else if( !stringIsValidE.validate( this.getStreet1() ) ){
			errors.add("street1", new ActionError("field.invalid.specialcharacter", "Street", allowedCharactersE));
        }
        else if( !stringLengthIsValidHundred.validate( this.getStreet1() ) ){
			errors.add("street1", new ActionError("field.invalid.length", "Street", "100"));        	
        }        
        
        // Street2: if it has a special character, or exceeds it's maximum length
        if( !stringIsValidE.validate( this.getStreet2() ) ){
			errors.add("street2", new ActionError("field.invalid.specialcharacter", "Street", allowedCharactersE));
        }
        else if( !stringLengthIsValidHundred.validate( this.getStreet2() ) ){
			errors.add("street2", new ActionError("field.invalid.length", "Street", "100"));        	
        }        
        
        // City: if it's empty, has a special character, or exceeds it's maximum length
        if( objectIsNull.validate(this.getCity() ) ||
                stringIsEmpty.validate( this.getCity() ) ){
        	errors.add("city", new ActionError("field.null","City"));
        }
        else if( !stringIsValidD.validate( this.getCity() ) ){
			errors.add("city", new ActionError("field.invalid.specialcharacter", "City", allowedCharactersD));
        }
        else if( !stringLengthIsValidHundred.validate( this.getCity() ) ){
			errors.add("city", new ActionError("field.invalid.length", "City", "100"));        	
        }        
      
        // State: if it's empty, has a special character, or exceeds it's maximum length
        if( objectIsNull.validate(this.getState() ) ||
                stringIsEmpty.validate( this.getState() ) ){
        	errors.add("state", new ActionError("field.null","State"));
        }
        else if( !stringIsValidD.validate( this.getState() ) ){
			errors.add("state", new ActionError("field.invalid.specialcharacter", "State", allowedCharactersD));
        }
        else if( !stringLengthIsValidHundred.validate( this.getState() ) ){
			errors.add("state", new ActionError("field.invalid.length", "State", "100"));       	
        }        
        
        // Country: if it's empty, has a special character, or exceeds it's maximum length
        if( objectIsNull.validate(this.getCountry() ) ||
                stringIsEmpty.validate( this.getCountry() ) ){
        	errors.add("country", new ActionError("field.null","Country"));
        }
        else if( !stringIsValidD.validate( this.getCountry() ) ){
			errors.add("country", new ActionError("field.invalid.specialcharacter", "Country", allowedCharactersD));
        }
        else if( !stringLengthIsValidHundred.validate( this.getCountry() ) ){
			errors.add("country", new ActionError("field.invalid.length", "Country", "100"));        	
        }        
        
        // Mobile Phone
        if( !stringIsValidE.validate( this.getMobilePhoneNo() ) ){
			errors.add("mobilePhoneNo", new ActionError("field.invalid.specialcharacter", "Mobile Phone", allowedCharactersE));
        }
        else if( !stringLengthIsValidFifteen.validate( this.getMobilePhoneNo() ) ){
			errors.add("mobilePhoneNo", new ActionError("field.invalid.length", "Mobile Phone", "15"));        	
        }         
        
        // Home Phone
        if( !stringIsValidE.validate( this.getHomePhoneNo() ) ){
			errors.add("homePhoneNo", new ActionError("field.invalid.specialcharacter", "Home Phone", allowedCharactersE));
        }
        else if( !stringLengthIsValidFifteen.validate( this.getHomePhoneNo() ) ){
			errors.add("homePhoneNo", new ActionError("field.invalid.length", "Home Phone", "15"));        	
        } 
        
        // Email Address: if it's empty, invalid, or exceeds it's maximum length
        if( objectIsNull.validate(this.getEnterpriseAddress() ) ||
                stringIsEmpty.validate( this.getEnterpriseAddress() ) ){
        	errors.add("enterpriseAddress", new ActionError("field.null","Email"));
        }
        else if( !Validator.validate( new EmailIsValid(), this.getEnterpriseAddress() ) ){
            errors.add("enterpriseAddress", new ActionError("field.invalid","Email"));            
        }
        else if( !stringLengthIsValidFifty.validate( this.getEnterpriseAddress() ) ){
			errors.add("enterpriseAddress", new ActionError("field.invalid.length", "Email", "50"));        	
        }        
        
        // GMU: if it's empty, has a special character, or exceeds it's maximum length
        if( objectIsNull.validate(this.getGMU() ) ||
                stringIsEmpty.validate( this.getGMU() ) ){
        	errors.add("gmu", new ActionError("field.null","GMU"));
        }
        else if( !stringIsValidC.validate( this.getGMU() ) ){
			errors.add("gmu", new ActionError("field.invalid.specialcharacter", "GMU", allowedCharactersC));
        }
        else if( !stringLengthIsValidFive.validate( this.getGMU() ) ){
			errors.add("gmu", new ActionError("field.invalid.length", "GMU", "50"));        	
        }        

        // Hire Date: if it's empty or invalid
        if( ( objectIsNull.validate( this.getHireDate() ) || 
                stringIsEmpty.validate( this.getHireDate() ) ) 
                  && this.getHireMonth().equals("0") &&
                     (objectIsNull.validate( this.getHireYear() ) || 
                          stringIsEmpty.validate( this.getHireYear() ) ) ){
            errors.add("hireDate", new ActionError("field.null","Date Hired"));
        } else {
            try {
                int hireDate[] = { Integer.parseInt( this.getHireYear() ), 
                        				Integer.parseInt( this.getHireMonth() ),
                        					Integer.parseInt( this.getHireDate() ) };
                
                if( !calendarIsValid.validate( hireDate ) ){
                    throw new Exception();
                }
            } catch (Exception e) {
                errors.add("hireDate", new ActionError("field.invalid","Date Hired"));
            } 
        }

        // WorkGroup
        if( !stringIsValidE.validate( this.getWorkGroup() ) ){
			errors.add("workGroup", new ActionError("field.invalid.specialcharacter", "Work Group", allowedCharactersE));
        }        
        else if( !stringLengthIsValidThirty.validate( this.getWorkGroup() ) ){
			errors.add("workGroup", new ActionError("field.invalid.length", "Work Group", "30"));        	
        } 
        
        // Enterprise ID: if it's empty, has a special character, or exceeds it's maximum length
        if( objectIsNull.validate(this.getEnterpriseId() ) ||
                stringIsEmpty.validate( this.getEnterpriseId() ) ){
        	errors.add("enterpriseId", new ActionError("field.null","Enterpise ID"));
        }
        else if( !stringIsValidD.validate( this.getEnterpriseId() ) ){
			errors.add("enterpriseId", new ActionError("field.invalid.specialcharacter", "Enterprise ID", allowedCharactersD));
        }
        else if( !stringLengthIsValidFifty.validate( this.getEnterpriseId() ) ){
			errors.add("enterpriseId", new ActionError("field.invalid.length", "Enterprise ID", "50"));        	
        }        

        // LMU: if it's empty, has a special character, or exceeds it's maximum length
        if( objectIsNull.validate(this.getLMU() ) ||
                stringIsEmpty.validate( this.getLMU() ) ){
        	errors.add("lmu", new ActionError("field.null","LMU"));
        }
        else if( !stringIsValidC.validate( this.getLMU() ) ){
			errors.add("lmu", new ActionError("field.invalid.specialcharacter", "LMU", allowedCharactersC));
        }
        else if( !stringLengthIsValidFive.validate( this.getLMU() ) ){
			errors.add("lmu", new ActionError("field.invalid.length", "LMU", "50"));        	
        }    
        
        // Status
        if( !stringIsValidD.validate( this.getStatus() ) ){
			errors.add("status", new ActionError("field.invalid.specialcharacter", "Status", allowedCharactersD));
        }        
        else if( !Validator.validate( new StringLengthIsValid(20), this.getStatus() ) ){
			errors.add("status", new ActionError("field.invalid.length", "Status", "20"));        	
        } 
        
        
        // Service Line 
        if( !stringIsValidE.validate( this.getServiceLine() ) ){
			errors.add("serviceLine", new ActionError("field.invalid.specialcharacter", "Service Line", allowedCharactersE));
        }        
        else if( !stringLengthIsValidFifty.validate( this.getServiceLine() ) ){
			errors.add("serviceLine", new ActionError("field.invalid.length", "Service Line", "50"));        	
        } 
        
        // Education Background: if it's empty, has a special character, or exceeds it's maximum length
        if( objectIsNull.validate(this.getEducationalAttainment() ) ||
                stringIsEmpty.validate( this.getEducationalAttainment() ) ){
        	errors.add("educationalAttainment", new ActionError("field.null"," "));
        }
        else if( !stringIsValidE.validate( this.getEducationalAttainment() ) ){
			errors.add("educationalAttainment", new ActionError("field.invalid.specialcharacter", " ", allowedCharactersE));
        }        
        else if( !Validator.validate( new StringLengthIsValid(500), this.getEducationalAttainment() ) ){
			errors.add("educationalAttainment", new ActionError("field.invalid.length", " ", "500"));        	
        }        

        // Certification/Awards
        if( !stringIsValidE.validate( this.getRecognitions() ) ){
			errors.add("recognitions", new ActionError("field.invalid.specialcharacter", " ", allowedCharactersE));
        }        
        else if( !stringLengthIsValidFiveHundred.validate( this.getRecognitions() ) ){
			errors.add("recognitions", new ActionError("field.invalid.length", " ", "500"));        	
        }
        
        return errors;
    }

    public List getMonth() {
        Constants cons = new Constants();
        return cons.getMonth();
    }

    public List getEmpGender() {
        Constants cons = new Constants();
        return cons.getGender();
    }

    public List getEmpCivilStatus() {
        Constants cons = new Constants();
        return cons.getCivilStatus();
    }

    public List getEmpLevel() {
        Constants cons = new Constants();
        return cons.getLevel();
    }

	public List getSkills() {
	    Transformer list = new Transformer( new VOCollectionToMap() );
	    
	    List tempList = new ArrayList();
		try {
		    HRManager hr = HRManager.getInstance();
		    tempList = (List)list.transform( hr.searchApprovedSkills(null) );		    
		} catch (HRSLogicalException logicalException) {
            // create error 
            ActionErrors errors = new ActionErrors();
            errors.add("skillFormError", new ActionError(
                    logicalException.getMessage()));
		} catch (HRSSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return  tempList;
	}
    private String doProcess;
    
    /**
     * @return Returns the doProcess.
     */
    public String getDoProcess() {
        return doProcess;
    }
    
    /**
     * @param doProcess The doProcess to set.
     */
    public void setDoProcess(String doProcess) {
        this.doProcess = doProcess;
    }
}
