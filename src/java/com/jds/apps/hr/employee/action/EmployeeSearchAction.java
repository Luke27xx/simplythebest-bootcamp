/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 3, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.employee.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.beans.EmployeeInfo;
import com.jds.apps.beans.valueutil.EmployeeInfoValueUtil;
import com.jds.apps.hr.employee.form.EmployeeSearchForm;
import com.jds.apps.hr.employee.form.EmployeeSearchListItemForm;
import com.jds.architecture.abstraction.AbstractAction;
import com.jds.architecture.exceptions.ErrorHandler;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.exceptions.HRSSystemException;
//import com.jds.businesscomponent.HRManager;
import com.jds.businesscomponent.stub.HRManager;

/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Author: r.c.delos.santos ${date}
 * @version $Revision: 1.2 $ $Date: 2005/02/24 06:31:56 $
 * 
 */
public class EmployeeSearchAction extends AbstractAction {

    /* (non-Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public ActionForward execute(ActionMapping actionMapping, 
            ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response)
            throws Exception {

        EmployeeSearchForm searchForm = (EmployeeSearchForm) form;
		
        // Manually invoke validation
		ActionErrors hasError = searchForm.validate(actionMapping, request);
		if (!hasError.isEmpty()) {
			super.saveErrors(request, hasError);
			ActionForward forwardPage = new ActionForward(
					actionMapping.getInput(), false);
			return forwardPage;
		}
				
		try {
            // Create search value object 
            EmployeeInfo valueObject = new EmployeeInfo();
            // Transfer form values to value object 
            EmployeeInfoValueUtil.searchToValue(searchForm, valueObject);

            // Create hr manager 
            HRManager hrBC = HRManager.getInstance();
            // Search using search value object 
            List employeesFound = new ArrayList();
            employeesFound = (List) hrBC.searchEmployees(valueObject);
            
            Iterator iterate = employeesFound.iterator();
            List employeesFoundForm = new ArrayList();
            
            while(iterate.hasNext()) {
                // Get record 
                EmployeeInfo tempRecord = (EmployeeInfo) iterate.next();
                // Transfer record to form list 
                EmployeeSearchListItemForm tempRecordForm = new 
                		EmployeeSearchListItemForm();
                EmployeeInfoValueUtil.valueToListForm(tempRecord, 
                        tempRecordForm);
                // Add form list 
                employeesFoundForm.add(tempRecordForm);
            }
            
            searchForm.setEmployees(employeesFoundForm);
            searchForm.setSearchMode(true);
        } catch (HRSSystemException e) {
            ActionErrors errors = new ErrorHandler("EmployeeSearch", e);
            super.saveErrors(request, errors);
			return actionMapping.findForward("systemError");
        } catch (HRSLogicalException logicalException) {
            // Create error 
            ActionErrors errors = new ActionErrors();
            errors.add("zeroResult", new ActionError(
                    logicalException.getMessage()));
            // Save error 
			super.saveErrors(request, errors);
			// Forward to the input page 
			ActionForward forwardPage = new ActionForward(
					actionMapping.getInput(), false);
			return forwardPage;
        }
		
        return actionMapping.findForward("success");
    }

}
