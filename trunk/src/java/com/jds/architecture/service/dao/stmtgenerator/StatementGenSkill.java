/**
 * 
 */
package com.jds.architecture.service.dao.stmtgenerator;

import org.apache.log4j.Logger;

import com.jds.apps.beans.SkillsInformation;
import com.jds.architecture.service.dao.DAOConstants;
//import com.jds.architecture.service.dao.assembler.SkillsAssembler;

/**
 * StatementGenSkill generates SQL statements (SET, WHERE)
 * for SkillDao class
 * @author Ivars Lacis
 *
 */
public class StatementGenSkill extends StatementGenerator
{
	Logger log = Logger.getLogger(StatementGenAccDetails.class);
		
	/**
	 * transformStmt creates an extension for SQL statements
	 * @param Object object 
	 * @param int stmtType  
	 * @throws Exception throws exception when unexpected error occurs
	 */
	public String transformStmt(Object object, int stmtType) throws Exception
	{
		StringBuffer sb = new StringBuffer();
		String strTemp = null;
		String strConstant =  DAOConstants.STR_AND;
		boolean isSet = false;
		SkillsInformation obj = (SkillsInformation)object;
        
		if (stmtType == DAOConstants.STMT_TYPE_SET)
		{
			strConstant = DAOConstants.CHAR_COMMA;
			isSet = true;
		}
		
		if (obj.getSkillId() != null)
		{
			sb.append(getColumnValue(isSet, DAOConstants.COL_ID, obj.getSkillId(), strConstant));
		}
		if (obj.getSkillName() != null)
		{
			sb.append(getColumnValue(isSet, DAOConstants.COL_NAME, obj.getSkillName(), strConstant));
		}
		if (obj.getCategoryId() != null)
		{
			sb.append(getColumnValue(isSet, DAOConstants.COL_CATID, obj.getCategoryId(), strConstant));
		}
		if (obj.getSkillDescription() != null)
		{
			sb.append(getColumnValue(isSet, DAOConstants.COL_DESCRIPTION, obj.getDescription(), strConstant));
		}

		
		if (sb.toString().length() > 0)
		{
			if (stmtType == DAOConstants.STMT_TYPE_SET)
			{ 
				strTemp = sb.toString().substring(0, sb.toString().length()-1);
			}
			else
			{
				strTemp = sb.toString().substring(0, sb.toString().lastIndexOf(DAOConstants.STR_AND));
			}
		}
		
		if (sb.toString().length() < 1)
		{
			if (stmtType == DAOConstants.STMT_TYPE_WHERE)
			{
				strTemp = "1 = 1";
			}
		}

		log.debug("transform");

		return strTemp;
	}

}
