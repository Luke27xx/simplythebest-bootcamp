/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 3, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.architecture.abstraction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jds.architecture.beans.UserBean;


/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Autohr: rds ${date}
 * @version $Revision $ $Date: 2005/02/24 05:30:41 $
 * 
 */
public abstract class AbstractAction extends Action {

    /**
     * 
     * @param actionMapping
     * @param form
     * @param request
     * @param response
     * @param context
     * @return
     * @throws Exception
     */
    public abstract ActionForward execute(ActionMapping actionMapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception;

	/**
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	protected UserBean getUserBean(HttpServletRequest request) throws Exception {
		try {
			UserBean user = (UserBean) request.getSession().getAttribute("user");
			if(null == user) {
				throw new Exception("user.notlogged");
			}
			return user;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	protected boolean isLogged(HttpSession session) throws Exception {
		UserBean user = (UserBean) session.getAttribute("user");
		return (user != null);
	}
}
