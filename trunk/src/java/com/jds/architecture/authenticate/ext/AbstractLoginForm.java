/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 3, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.architecture.authenticate.ext;

import com.jds.architecture.abstraction.AbstractForm;

/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Autohr: rds ${date}
 * @version $Revision $ $Date: 2005/02/24 05:30:49 $
 * 
 */
public abstract class AbstractLoginForm extends AbstractForm {

    String username;
    String password;
    
    /**
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return Returns the username.
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
