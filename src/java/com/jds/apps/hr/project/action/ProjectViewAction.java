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
public class ProjectViewAction extends AbstractAction {

    public ActionForward execute(ActionMapping actionMapping,            
    		ActionForm form, 
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ProjectForm viewForm = (ProjectForm) form;
        String viewType = (String) request.getParameter("viewtype");
    	String id = request.getParameter("id");
    	
        try {
            HRManager bo = HRManager.getInstance();
			ProjectInfo info = new ProjectInfo();
			info = (ProjectInfo) bo.searchProject(id);
			ProjectInfoValueUtil.valueToForm(info,viewForm);
		} catch (HRSSystemException e) {
            ActionErrors errors = new ErrorHandler("ProjectView", e);
            super.saveErrors(request, errors);
			return actionMapping.findForward("systemError");
		} catch (HRSLogicalException logicalException) {
	           ActionErrors errors = new ActionErrors();
	            errors.add("BCerror", new ActionError(
	                    logicalException.getMessage()));
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
