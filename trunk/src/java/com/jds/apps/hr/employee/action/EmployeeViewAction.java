/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 3, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.employee.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.beans.EmployeeInfo;
import com.jds.apps.beans.valueutil.EmployeeInfoValueUtil;
import com.jds.apps.hr.employee.form.EmployeeInfoForm;
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
 * @author last modified by: $Author: c.b.balajadia $
 * @version $Revision: 1.3 $ $Date: 2005/03/23 02:59:36 $
 * 
 */
public class EmployeeViewAction extends AbstractAction {

    public ActionForward execute(ActionMapping actionMapping,
            ActionForm form, 
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        EmployeeInfoForm viewForm = (EmployeeInfoForm) form;

        /*
         * determine action, if edit or view mode
         */
        String viewType = (String) request.getParameter("viewtype");
        String empNo = (String) request.getParameter("id");
        
        try {
            HRManager hrBC = HRManager.getInstance();
            EmployeeInfo employeeRecord = hrBC.searchEmployee(empNo);

            EmployeeInfoValueUtil.valueToForm(employeeRecord, viewForm);
        } catch (HRSSystemException systemException) {
            ActionErrors errors = new ErrorHandler("EmployeeAdd", 
                    systemException);
            super.saveErrors(request, errors);
			return actionMapping.findForward("systemError");
        } catch (HRSLogicalException logicalException) {
            // create error 
            ActionErrors errors = new ActionErrors();
            errors.add("BCerror", new ActionError(
                    logicalException.getMessageKey()));
            // save error 
			super.saveErrors(request, errors);
			// forward to the input page 
			ActionForward forwardPage = new ActionForward(
					actionMapping.getInput(), false);
			return forwardPage;
        }

        return actionMapping.findForward(viewType);
    }

}
