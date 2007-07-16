/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 21, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.skill.set.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.beans.SkillsInformation;
import com.jds.apps.beans.valueutil.SkillInformationValueUtil;
import com.jds.apps.hr.skill.set.form.SkillForm;
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
 * @version $Revision: 1.2 $ $Date: 2005/02/24 06:31:56 $
 * 
 */
public class SkillViewAction extends AbstractAction {

    public ActionForward execute(ActionMapping actionMapping,            
    		ActionForm form, 
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        /*
         * get the user information
         */
    	SkillForm viewForm = (SkillForm) form;
        String viewType = (String) request.getParameter("viewtype");
        String id = request.getParameter("id");
        try {
            HRManager bo = HRManager.getInstance();
			SkillsInformation info = new SkillsInformation();
			info = (SkillsInformation) bo.searchSkill(id);
			SkillInformationValueUtil.valueToForm(info,viewForm);
		} catch (HRSLogicalException logicalException) {
            /* view error */
            ActionErrors errors = new ActionErrors();
            errors.add("BCerror", new ActionError(
                    logicalException.getMessageKey()));
            /* save error */
			super.saveErrors(request, errors);
			/* forward to the input page */
			ActionForward forwardPage = new ActionForward(
					actionMapping.getInput(), false);
			return forwardPage;
		} catch (HRSSystemException e) {
            ActionErrors errors = new ErrorHandler("SkillView", e);
            super.saveErrors(request, errors);
			return actionMapping.findForward("systemError");
		}
        return actionMapping.findForward(viewType);
    }

}
