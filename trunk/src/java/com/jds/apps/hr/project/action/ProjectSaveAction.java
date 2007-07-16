/* 
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 13, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.beans.ProjectInfo;
import com.jds.apps.beans.valueutil.ProjectInfoValueUtil;
import com.jds.apps.hr.project.form.ProjectForm;
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
 * @author ma.j.a.valiente
 * @author last modified by: $Author: r.c.delos.santos ${date}
 * @version $Revision: 1.2 $ $Date: 2005/02/24 06:31:57 $
 * 
 */
public class ProjectSaveAction extends AbstractAction {

    /* (non-Javadoc)
     * @see accenture.manila.architecture.abstraction.AbstractPostAction#doProcess(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.naming.Context)
     */
    public ActionForward execute(ActionMapping actionMapping,
            ActionForm form, 
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		
		ProjectForm projectForm = (ProjectForm) form;
        UserBean user = this.getUserBean(request);
        
		ActionErrors hasError = projectForm.validate(actionMapping,request);
		if (!hasError.isEmpty()) {
			super.saveErrors(request, hasError);
			ActionForward forwardPage = new ActionForward(
					actionMapping.getInput(), false);
			return forwardPage;
		}
		
		ProjectInfo info = new ProjectInfo();
		try{
			ProjectInfoValueUtil.formToValue(projectForm,info);
			HRManager bo = HRManager.getInstance();
			bo.createProject(info);
		} catch (HRSSystemException e) {
            ActionErrors errors = new ErrorHandler("ProjectCreate", e);
            super.saveErrors(request, errors);
			return actionMapping.findForward("systemError");
		}catch(HRSLogicalException logicalException){
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

       return actionMapping.findForward("success");
    }

}
