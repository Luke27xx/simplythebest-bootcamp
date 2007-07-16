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
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:30:28 $
 * 
 */
public class ProjectCloseAction extends AbstractAction {

    public ActionForward execute(ActionMapping actionMapping, 
    		ActionForm form, 
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        //Get the user information
        UserBean user = this.getUserBean(request);
        String viewer="";
        
        if("HR".equalsIgnoreCase(user.getUserType())) {
			viewer = "closebyhr";
        } else if ("approver".equalsIgnoreCase(user.getUserType())) {
			viewer = "closebyapprover";
		} else if("STAFF".equalsIgnoreCase(user.getUserType())) {
			viewer = "closebystaff";
		}
        return actionMapping.findForward(viewer);
    }

}
