/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 29, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.architecture.exceptions;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Author: r.c.delos.santos $
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:36:26 $
 * 
 */
public class ErrorHandler extends ActionErrors {

    public ErrorHandler(String siteAddress, HRSSystemException exception) {
        ActionError errorMessageKey = new ActionError(exception.getMessageKey());
        this.add("msgKey", errorMessageKey);
        
    }
}
