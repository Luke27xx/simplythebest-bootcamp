/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 3, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.skill.category.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.beans.SkillCategory;
import com.jds.apps.beans.valueutil.SkillCategoryValueUtil;
import com.jds.apps.hr.skill.category.form.SearchCategoryForm;
import com.jds.apps.hr.skill.category.form.SearchListItemForm;
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
public class CategorySearchAction extends AbstractAction {

    /* (non-Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public ActionForward execute(ActionMapping actionMapping, 
            ActionForm form,
            HttpServletRequest request, 
            HttpServletResponse response)
            throws Exception {

        SearchCategoryForm searchForm = (SearchCategoryForm) form;
		

		/*
		 * manually invoke validation
		 */
		ActionErrors hasError = searchForm.validate(actionMapping,request);
		if (!hasError.isEmpty()) {
			super.saveErrors(request, hasError);
			ActionForward forwardPage = new ActionForward(
					actionMapping.getInput(), false);
			return forwardPage;
		}
		try {
		    HRManager bo = HRManager.getInstance();
			SkillCategory info = new SkillCategory();
			info.setCategoryName(searchForm.getCategoryCriteria());

			List results = new ArrayList(); 
			results = (List) bo.searchApprovedCategories(info);
			Iterator iter = results.iterator();
			java.util.List myList = new ArrayList();
			while(iter.hasNext()){
				info = new SkillCategory();
				info = (SkillCategory) iter.next();
				SearchListItemForm listItem =  new SearchListItemForm();
				SkillCategoryValueUtil.valueToListForm(info,listItem);
				myList.add(listItem);
			}
			searchForm.setCategories(myList);
			searchForm.setSearchMode(true);
		} catch (HRSSystemException e) {
            ActionErrors errors = new ErrorHandler("CategorySearch", e);
            super.saveErrors(request, errors);
			return actionMapping.findForward("systemError");
		}catch(HRSLogicalException logicalException){
            // search error 
            ActionErrors errors = new ActionErrors();
            errors.add("zeroResult", new ActionError(
                    logicalException.getMessage()));
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
