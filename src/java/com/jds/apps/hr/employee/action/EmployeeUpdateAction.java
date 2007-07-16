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
import com.jds.architecture.beans.UserBean;
import com.jds.architecture.exceptions.ErrorHandler;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.exceptions.HRSSystemException;
//import com.jds.businesscomponent.HRManager;
import com.jds.businesscomponent.stub.HRManager;

/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Author: r.c.delos.santos $
 * @version $Revision: 1.2 $ $Date: 2005/02/24 06:31:56 $
 * 
 */
public class EmployeeUpdateAction extends AbstractAction {

    /* (non-Javadoc)
     * @see accenture.manila.architecture.abstraction.AbstractPostAction#doProcess(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.naming.Context)
     */
    public ActionForward execute(ActionMapping actionMapping,
            ActionForm form, 
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        EmployeeInfoForm viewForm = (EmployeeInfoForm) form;

        UserBean userBean = this.getUserBean(request);
        String userType = userBean.getUserType();

        ActionErrors fieldErrors = viewForm.validate(actionMapping, request);
        if(!fieldErrors.isEmpty()) {
            super.saveErrors(request, fieldErrors);
			ActionForward forwardPage = new ActionForward(
					actionMapping.getInput(), false);
			return forwardPage;
        }
        
        try {
            EmployeeInfo emloyeeValueObject = new EmployeeInfo();

            EmployeeInfoValueUtil.formToValue(
                    viewForm, emloyeeValueObject);

            HRManager hrBC = HRManager.getInstance();
            hrBC.updateEmployee(emloyeeValueObject);
        } catch (HRSSystemException systemException) {
            ActionErrors errors = new ErrorHandler("EmployeeUpdate", 
                    systemException);
            super.saveErrors(request, errors);
			return actionMapping.findForward("systemError");
        } catch (HRSLogicalException logicalException) {
            // create error 
            ActionErrors errors = new ActionErrors();
            errors.add("updateError", new ActionError(
                    logicalException.getMessageKey()));
            // save error 
			super.saveErrors(request, errors);
			// forward to the input page 
			ActionForward forwardPage = new ActionForward(
					actionMapping.getInput(), false);
			return forwardPage;
        }
        
        return actionMapping.findForward(userType);
    }

}
