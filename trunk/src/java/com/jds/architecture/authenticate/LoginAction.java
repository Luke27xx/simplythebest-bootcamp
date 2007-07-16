/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 3, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.architecture.authenticate;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.beans.EmployeeInfo;
import com.jds.architecture.abstraction.AbstractAction;
import com.jds.architecture.beans.UserBean;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.exceptions.HRSSystemException;
import com.jds.architecture.exceptions.ErrorHandler;
//import com.jds.businesscomponent.UserManager;
import com.jds.businesscomponent.stub.UserManager;

/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Autohr: rds $
 * @version $Revision $ $Date: 2005/02/24 05:36:05 $
 * 
 */
public class LoginAction extends AbstractAction {

    /* (non-Javadoc)
     * @see accenture.manila.architecture.abstraction.AbstractPostAction#doProcess(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.naming.Context)
     */
    public ActionForward execute(ActionMapping actionMapping, 
            ActionForm form, 
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

			LoginForm loginPage = (LoginForm) form;
			/*
			 * authenticate user with the username and password. call business
			 * object to do so. business object should return the UserBean of the
			 * user.
			 */
        
			/*
			 * temp only. testing purposes.
			 */
			
            EmployeeInfo employee = new EmployeeInfo();

            try {
                UserManager loggedUser = new UserManager();
                employee = loggedUser.getEmployeeUserDetail(
                        request.getRemoteUser());
            } catch (HRSSystemException e1) {
                ActionErrors errors = new ErrorHandler("Login", e1);
                super.saveErrors(request, errors);
    			return actionMapping.findForward("systemError");
            } catch (HRSLogicalException e) {
                e.printStackTrace();
                throw new Exception(e);
            }
			
			UserBean user = new UserBean();
			user.setEmpNo(employee.getEmpNo());
			user.setFirstName(employee.getFirstName());
			user.setLastName(employee.getLastName());
			user.setMiddleName(employee.getMiddleName());
			
			java.util.Map id = new HashMap();
			id.put("id", employee.getEmpNo());
			user.setLinkDataMap(id);
			
			if(request.isUserInRole("hrrep")) {
				user.setUserType("HR");
			} else if(request.isUserInRole("approver")) {
				user.setUserType("approver");
			} else if(request.isUserInRole("employee")) {
				user.setUserType("staff");
			}

			/*
			 * set UserBean to session
			 */
			request.getSession().setAttribute("user", user);
			return actionMapping.findForward(user.getUserType());
			
    }

}
