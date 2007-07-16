/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 3, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.skill.category.form.ext;

import com.jds.architecture.abstraction.AbstractForm;

/**
 * 
 *
 * @author ma.j.a.valiente
 * @author last modified by: $Author: r.c.delos.santos ${date}
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:30:35 $
 * 
 */
public abstract class AbstractCategorySearchForm extends AbstractForm {

    private String categoryCriteria;

    /**
     * @return Returns the category.
     */
    public String getCategoryCriteria() {
        return categoryCriteria;
    }
    
    /**
     * @param category The category to set.
     */
    public void setCategoryCriteria(String categoryCriteria) {
        if( categoryCriteria != null ){
            categoryCriteria = categoryCriteria.trim();
        }
        this.categoryCriteria = categoryCriteria;
    }
    
 
}
