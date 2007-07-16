/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 17, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.employee.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jds.architecture.abstraction.AbstractAction;


/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Author: r.c.delos.santos $
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:30:35 $
 * 
 */
public class EmployeeLoadAddAction extends AbstractAction {

    /* (non-Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public ActionForward execute(ActionMapping actionMapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        return actionMapping.findForward("success");
    }

}
