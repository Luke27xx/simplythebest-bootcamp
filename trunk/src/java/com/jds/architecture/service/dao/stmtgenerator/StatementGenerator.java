/*
 * Created on Jan 11, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.architecture.service.dao.stmtgenerator;

import com.jds.architecture.service.dao.DAOConstants;

/**
 * <p>
 * StatementGenerator is an abstract class for statement generator classes
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  11/2004 initial draft c.b.balajadia
  * @since 1.1
 */
public abstract class StatementGenerator {
	
	public abstract String transformStmt(Object obj, int stmtType) 
		throws Exception;
	
	/**
	 * getColumnValue gets the column value
	 * @param boolean isSet
	 * @param String[] columnString 
	 * @param String strValue
	 * @param String strConstant
	 * @return the colum value of a string type 
	 */
	public String getColumnValue(boolean isSet, String [] columnString, 
			String strValue, String strConstant) {
		String strTemp = null;
				
		if (isSet) {
			strTemp = columnString[0];
			if(strValue.equalsIgnoreCase(DAOConstants.STR_NULL))
			strTemp = columnString[2];
		} else {
			strTemp  = columnString[1];
		}
			 
		
		if((strValue.length()<= 0)&& (!isSet)) {
			return "";
		} else {
			strTemp = strTemp
			.replaceFirst(DAOConstants.CHAR_AT, strValue); 
			strTemp = strTemp + strConstant;
			


		}
		
		return strTemp;
	}
}
