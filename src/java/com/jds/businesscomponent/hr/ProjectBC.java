package com.jds.businesscomponent.hr;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import com.jds.apps.Constants;
import com.jds.apps.beans.AbstractReferenceData;
import com.jds.apps.beans.AccentureDetails;
import com.jds.apps.beans.EmployeeInfo;
import com.jds.apps.beans.ProjectInfo;
import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.exceptions.HRSSystemException;
import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.service.dao.DAOConstants;
import com.jds.architecture.service.dao.DAOException;
import com.jds.architecture.service.dao.DAOFactory;
import com.jds.architecture.service.dao.DataAccessObjectInterface;
import com.jds.architecture.service.dao.EmployeeDAO;
import com.jds.architecture.service.dao.ProjectDAO;
import com.jds.architecture.service.dao.assembler.ProjectAssembler;
import com.jds.architecture.service.dbaccess.DBAccess;
import com.jds.architecture.service.dbaccess.DBAccessException;
import com.jds.architecture.service.idgenerator.EmployeeIdGenerator;
import com.jds.architecture.service.idgenerator.IdGeneratorException;
import com.jds.architecture.service.idgenerator.ProjectIdGenerator;

/**
 * ProjectBC is a class that serves as an HR module business functions
 * @authors Jelena Sokolova and Vytautas Streimikis
 * @version 1.0
 */


public class ProjectBC {
	
	private Constants cons;
	private DataAccessObjectInterface projDao = null; 	
	private DBAccess dbAccess = null;
	
	private static Logger log = (Logger) ServiceFactory.getInstance()
	.getService(LoggerService.class);
	
	//TODO Lena
	public ProjectBC () throws HRSSystemException {
		
	log.info("entered ProjectBC constructor");
	
	   try {
		   projDao = (ProjectDAO)DAOFactory.getFactory()
			 .getDAOInstance(DAOConstants.DAO_PROJ);
			
		   dbAccess = DBAccess.getDBAccess();
			cons = new Constants();
					
	   } catch (DBAccessException ex) {
	   		throw new HRSSystemException ("intialize.dbaccess.exception",ex.getCause());	
	   } catch (DAOException ex) {
	   		ex.printStackTrace();
	   		throw new HRSSystemException ("intialize.dao.exception",ex.getCause());					
	   } catch (Exception ex) {
	   		ex.printStackTrace();
	   		throw new HRSSystemException ("intialize.bc.exception",ex.getCause());
	   } 
	 
	 log.info("exited ProjectBC constructor");
}
	//TODO Lena
	/**
	 * Create employee information by HRManager
	 * @param info  ProjectInfo
	 * @throws HRSLogicalException when info or start date are null 
	 * @throws HRSSystemException when system exception occurred (e.g. Failed database connection)
	 */
	public void createProject(ProjectInfo info) 
		throws HRSSystemException, HRSLogicalException {
		
		log.info("entered createProject method");
		
		long id = 0;
		
		if (info  == null) throw new HRSLogicalException ("invalid.input.exception");
		
		if (info.getStartDate() == null)
			throw new HRSLogicalException ("start.date.required.exception");		
		
		Connection conn = null;					
		
		try {					
		   conn = dbAccess.getConnection();
		   id = ProjectIdGenerator.getInstance().getNextId();
		   info.setProjectId(String.valueOf(id) );
		   projDao.create(conn, info);
		   //RowSet set = projDao.find(info);		    
		   dbAccess.commitConnection(conn);
		} catch (IdGeneratorException e) {
			try {
				dbAccess.rollbackConnection(conn);
			} catch (DBAccessException e1) {}
			throw new HRSSystemException (e.getMessageKey(),e.getCause());			   
		} catch (DBAccessException e) {
			try {
				dbAccess.rollbackConnection(conn);
			} catch (DBAccessException e1) {}
			throw new HRSSystemException (e.getMessageKey(),e.getCause());			   
		} catch (DAOException e) {
			try {
				dbAccess.rollbackConnection(conn);
			} catch (DBAccessException e1) {}
			if (e.isLogical()) throw new HRSLogicalException (e.getMessageKey()+".project");
			else throw new HRSSystemException (e.getMessageKey(),e.getCause());
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {}  
		}	
		
		log.info("exited createProject method");
	
	}
    
	//TODO Lena
    /**
     * Searches Project records by primary key which is the project id. by HRManager
     * @param id String
     * @return ProjectInfo object of searched Project records as a default and 
     * with all Project related records as an option
     * @throws HRSLogicalException when project id. is null
     * @throws HRSSystemException when system exception occurred (e.g. Failed database connection)
     */
    public ProjectInfo searchProject(String id)
        throws HRSSystemException, HRSLogicalException { 
        
        log.info("entered searchProject method");
            
        if (id == null) 
         throw new HRSLogicalException ("id.required.exception");

        ProjectInfo data = null; 
      
        try{
            data = (ProjectInfo) projDao.findByPK(id);
            
            if (data == null) 
                throw new HRSLogicalException ("record.not.found.exception");
            
        } catch (DAOException e) {
            throw new HRSSystemException (e.getMessageKey(),e.getCause());
        } catch (Exception e) {
            throw new HRSSystemException ("business.component.exception",e.getCause());
        }       
        
        log.info("exited searchProject method");
        
        return data;            
    }
    
  //TODO Lena
    /**
     * Searches Project records in the database. by HRManager
     * @param dataFind ProjectInfo
     * @return Collection of searched Project records 
     * @throws HRSLogicalException 
     * @throws HRSSystemException 
      */
    public Collection searchApprovedProjects(ProjectInfo dataFind) throws HRSSystemException, HRSLogicalException{
		
    	Collection result = searchReferenceData(dataFind, "approved");
    	return result;
    	
    }
   
    //TODO Vytas
    public Collection searchReferenceData(AbstractReferenceData dataFind, String approvalType) throws HRSSystemException, HRSLogicalException { 
        
        log.info("entered searchReferenceData method");
            
        RowSet rset = null;
        List<ProjectInfo> resultList = new ArrayList<ProjectInfo>();
      
        try{
        	if (dataFind == null){
        		rset = projDao.findByAll();
        	}
            else{
            	rset = projDao.find(dataFind);
            }
        	
        	while(rset.next()){
               if (rset.getString("status").equalsIgnoreCase(approvalType)){
                  resultList.add(ProjectAssembler.getInfo(rset)); 
               }
        		
        	}
        	
        } catch (DAOException e) {
            throw new HRSSystemException (e.getMessageKey(),e.getCause());
        } catch (Exception e) {
            throw new HRSSystemException ("business.component.exception",e.getCause());
        }       
        
        log.info("exited searchReferenceData method");
        
    	return resultList;
    }
    
    //TODO Vytas
    public void updateProject(ProjectInfo info) throws HRSLogicalException, HRSSystemException {

		log.info("entered updateProject method");

		ProjectInfo proj = new ProjectInfo();
		if (info == null)
			throw new HRSLogicalException("invalid.input.exception");

		if (info.getProjectId() == null)
			throw new HRSLogicalException("id.required.exception");

		proj.setProjectId(info.getProjectId());
		Connection conn = null;
		
		//info.setProjectId(null);

		try {
			conn = dbAccess.getConnection();
			
			if (!(projDao.update(conn, info, proj))){
				throw new HRSLogicalException("record.not.updated.exception");
			}
			dbAccess.commitConnection(conn);
			
		}catch (DBAccessException e) {
			try {
				dbAccess.rollbackConnection(conn);
			} catch (DBAccessException e1) {
			}
			throw new HRSSystemException(e.getMessageKey(), e.getCause());
		} catch (DAOException e) {
			try {
				dbAccess.rollbackConnection(conn);
			} catch (DBAccessException e1) {
			}
			if (e.isLogical())
				throw new HRSLogicalException(e.getMessageKey() + ".project");
			else
				throw new HRSSystemException(e.getMessageKey(), e.getCause());
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {
			}
		}

		log.info("exited updateProject method");
	}
    

}
