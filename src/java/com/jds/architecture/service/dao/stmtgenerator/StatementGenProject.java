package com.jds.architecture.service.dao.stmtgenerator;

import org.apache.log4j.Logger;

import com.jds.apps.beans.ProjectInfo;
import com.jds.architecture.service.dao.DAOConstants;
import com.jds.architecture.service.dao.assembler.ProjectAssembler;
import com.jds.architecture.utilities.CalendarToString;
import com.jds.architecture.utilities.Transformer;


/**
 * StatementGenProject is a class that generates SQL statements for ProjectInfo
 * Statement Generator DAO functions
 * @author Vytautas Streimikis
 * 
 *
 */
public class StatementGenProject extends StatementGenerator {

	Logger log = Logger.getLogger(StatementGenProject.class);
		
	/**
	 * transformStmt creates an extension for SQL statements
	 * @param Object object 
	 * @param int stmtType  
	 * @throws Exception throws exception when unexpected error occurs
	 */
	public String transformStmt(Object object, int stmtType) throws Exception {
		StringBuffer strBuffer = new StringBuffer();
		String strTemp = null;
		String strConstant =  DAOConstants.STR_AND;
		boolean isSet = false;
		ProjectInfo obj = (ProjectInfo)object;
        
		if (stmtType == DAOConstants.STMT_TYPE_SET) {
			strConstant = DAOConstants.CHAR_COMMA;
			isSet = true;
			ProjectAssembler.toEmptyStringAllNull(obj);
		}
         
        
		if(obj.getProjectId() != null) {			
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_ID, 
					obj.getProjectId(), strConstant));				
			
		} 
		
		        
		if(obj.getProjectName() != null) {  
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_NAME, 
					obj.getProjectName(), strConstant));	
			log.debug("project name:" + strBuffer.toString());			
			
		}
		
		if(obj.getDescription() != null) {  
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_DESCRIPTION, 
					obj.getDescription(), strConstant));			
			
		} 
        
		if(obj.getClient() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_CLIENTNAME, 
					obj.getClient(), strConstant));				
			
		} 
		
		if(obj.getStartDate() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_STARTDATE, 
					(String)Transformer.transform(new CalendarToString(), obj.getStartDate())
					, strConstant));
		}
		
		if(obj.getEndDate() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_ENDDATE, 
					(String)Transformer.transform(new CalendarToString(), obj.getEndDate())
					, strConstant));
		}
		
		
		
		if ( strBuffer.toString().length() > 0) {
			if (stmtType == DAOConstants.STMT_TYPE_SET) { 
				strTemp = strBuffer.toString().substring(0,
				strBuffer.toString().length()-1);
			} else {
				strTemp = strBuffer.toString().substring(0, 
				strBuffer.toString().lastIndexOf(DAOConstants.STR_AND));
			}
		}

		log.debug("transform strTemp:" + strTemp);
		return strTemp;
	}

}
