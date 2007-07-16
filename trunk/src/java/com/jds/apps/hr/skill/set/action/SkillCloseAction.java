/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 10, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.skill.set.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jds.architecture.abstraction.AbstractAction;
import com.jds.architecture.beans.UserBean;


/**
 * 
 *
 * @author ma.j.a.valiente
 * @author last modified by: $Author: r.c.delos.santos ${date}
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:30:24 $
 * 
 */
public class SkillCloseAction extends AbstractAction {

    public ActionForward execute(ActionMapping actionMapping,            ActionForm form, 
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        /*
         * get the user information
         */
        UserBean user = this.getUserBean(request);
        String viewer="";
        
        if("HR".equalsIgnoreCase(user.getUserType())) {
			viewer = "closebyhr";
        } else if ("approver".equalsIgnoreCase(user.getUserType())) {
			viewer = "closebyapprover";
		}
        
        
        return actionMapping.findForward(viewer);
    }

}
