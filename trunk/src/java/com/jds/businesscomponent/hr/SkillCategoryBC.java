/*
 * Created on Feb 14, 2005
 * 
 * JAVA Development School
 * Copyright 2007 Accenture
 *
 */
package com.jds.businesscomponent.hr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.sql.RowSet;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.jds.apps.Constants;
import com.jds.apps.beans.AbstractReferenceData;
import com.jds.apps.beans.AccentureDetails;
import com.jds.apps.beans.EmployeeInfo;
import com.jds.apps.beans.SkillCategory;
import com.jds.apps.beans.SkillsInformation;
import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.exceptions.HRSSystemException;
import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.service.dao.DAOConstants;
import com.jds.architecture.service.dao.DAOException;
import com.jds.architecture.service.dao.DAOFactory;
import com.jds.architecture.service.dao.DataAccessObjectInterface;
import com.jds.architecture.service.dao.SkillCategoryDAO;
import com.jds.architecture.service.dao.SkillDAO;

// TODO For implementation
import com.jds.architecture.service.dao.EmployeeDAO;
import com.jds.architecture.service.dao.assembler.EmployeeAssembler;
import com.jds.architecture.service.dao.assembler.SkillCategoryAssembler;
import com.jds.architecture.service.dbaccess.DBAccess;
import com.jds.architecture.service.dbaccess.DBAccessException;
import com.jds.architecture.service.idgenerator.CategoryIdGenerator;
import com.jds.architecture.service.idgenerator.EmployeeIdGenerator;
import com.jds.architecture.service.idgenerator.IdGeneratorException;
import com.jds.architecture.service.idgenerator.SkillIdGenerator;

/**
 * SkillCategoryBC is a class that serves as an HR module business functions
 * 
 * @author Dmitrijs.Sadovskis
 * 
 */
public class SkillCategoryBC {

	private Constants cons;
	private DataAccessObjectInterface catDao = null;
	private DBAccess dbAccess = null;

	private static Logger log = (Logger) ServiceFactory.getInstance()
			.getService(LoggerService.class);

	/**
	 * Constructor initializes data access objects
	 */
	public SkillCategoryBC() throws HRSSystemException {

		log.info("entered SkillCategoryBC constructor");

		try {
			catDao = (SkillCategoryDAO) DAOFactory.getFactory().getDAOInstance(
					DAOConstants.DAO_SKILLCAT);

			dbAccess = DBAccess.getDBAccess();
			cons = new Constants();

		} catch (DBAccessException e) {
			throw new HRSSystemException("intialize.dbaccess.exception", e
					.getCause());
		} catch (DAOException e) {
			e.printStackTrace();
			throw new HRSSystemException("intialize.dao.exception", e
					.getCause());
		} catch (Exception e) {
			e.printStackTrace();
			throw new HRSSystemException("intialize.bc.exception", e.getCause());
		}

		log.info("exited SkillCategoryBC constructor");

	}

	/**
	 * Create category information by HRManager
	 * 
	 * @param info
	 *            SkillCategory
	 * @throws HRSLogicalException
	 *             when info, date of birth and accenture details is null
	 * @throws HRSSystemException
	 *             when system exception occurred (e.g. Failed database
	 *             connection)
	 */
	public void createCategory(SkillCategory info) throws HRSSystemException,
			HRSLogicalException {

		log.info("entered createCategory method");

		long id = 0;

		if (info == null)
			throw new HRSLogicalException("invalid.input.exception");

		Connection conn = null;

		try {
			conn = dbAccess.getConnection();

			id = CategoryIdGenerator.getInstance().getNextId();
			info.setCategoryId(String.valueOf(id));

			catDao.create(conn, info);
			dbAccess.commitConnection(conn);
		} catch (IdGeneratorException e) {
			try {
				dbAccess.rollbackConnection(conn);
			} catch (DBAccessException e1) {
			}
			throw new HRSSystemException(e.getMessageKey(), e.getCause());
		} catch (DBAccessException e) {
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
				throw new HRSLogicalException(e.getMessageKey() + ".employee");
			else
				throw new HRSSystemException(e.getMessageKey(), e.getCause());
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {
			}
		}

		log.info("exited createCategory method");

	}

	/**
	 * Searches category by primary key which is the category no. by HRManager
	 * 
	 * @param id
	 *            String
	 * @return SkillCategory object of searched Category
	 * @throws HRSLogicalException
	 *             when nothing can be found
	 * @throws HRSSystemException
	 *             when system exception occurred (e.g. Failed database
	 *             connection)
	 */
	public SkillCategory searchCategory(String id) throws HRSSystemException,
			HRSLogicalException {

		log.info("entered searchCategory method");

		if (id == null)
			throw new HRSLogicalException("id.required.exception");

		SkillCategory data = null;

		try {
			data = (SkillCategory) catDao.findByPK(id);

			if (data == null)
				throw new HRSLogicalException("record.not.found.exception");

		} catch (DAOException e) {
			throw new HRSSystemException(e.getMessageKey(), e.getCause());
		} catch (Exception e) {
			throw new HRSSystemException("business.component.exception", e
					.getCause());
		}

		log.info("exited searchCategory method");

		return data;
	}

	/**
	 * Searches category by primary key which is the category no. by HRManager
	 * 
	 * @param dataFind
	 *            SkillCategory
	 * @return Collection of categories
	 * @throws HRSLogicalException
	 *             when nothing can be found
	 * @throws HRSSystemException
	 *             when system exception occurred (e.g. Failed database
	 *             connection)
	 */
	public Collection searchApprovedCategories(SkillCategory dataFind)
			throws HRSSystemException, HRSLogicalException {

		log.info("entered searchApprovedCategories method");

		Collection result = searchReferenceData(dataFind, "approved");

		log.info("exited searchApprovedCategories method");

		return result;
	}

	/**
	 * Searches category by primary key which is the category no. by HRManager
	 * 
	 * @param dataFind
	 *            SkillCategory
	 * @return Collection of categories
	 * @throws HRSLogicalException
	 *             when nothing can be found
	 * @throws HRSSystemException
	 *             when system exception occurred (e.g. Failed database
	 *             connection)
	 */
	public Collection searchReferenceData(AbstractReferenceData dataFind,
			String approvalType) throws HRSSystemException, HRSLogicalException {

		log.info("entered searchReferenceData method");

		Collection<SkillCategory> returnCollection = new Vector<SkillCategory>();// <SkillCategory>;

		try {
			ResultSet rs;
			if (dataFind == null) {
				rs = catDao.findByAll();
			} else {
				rs = catDao.find(dataFind);
			}

			while (rs.next()) {
				SkillCategory skcatinfo = SkillCategoryAssembler.getInfo(rs);
				if (skcatinfo.getStatus().equalsIgnoreCase("approved"))
					returnCollection.add(skcatinfo);
			}
		} catch (SQLException e) {
			throw new HRSSystemException(e.getMessage(), e.getCause());
		} catch (DAOException e) {
			throw new HRSSystemException(e.getMessageKey(), e.getCause());
		} catch (Exception e) {
			throw new HRSSystemException("business.component.exception", e
					.getCause());
		}

		log.info("exited searchReferenceData method");

		return returnCollection;
	}

	/**
	 * Updates category
	 * 
	 * @param info
	 *            SkillCategory
	 * @throws HRSLogicalException
	 *             can't update
	 * @throws HRSSystemException
	 *             when system exception occurred (e.g. Failed database
	 *             connection)
	 */
	public void updateCategory(SkillCategory info) throws HRSSystemException,
			HRSLogicalException {

		log.info("entered updateCategory method");

		if (info == null) {
			throw new HRSLogicalException("invalid.input.exception");
		}
		if (info.getCategoryId() == null) {
			throw new HRSLogicalException("id.required.exception");
		}
		
		Connection conn = null;
		
		try {
			conn = dbAccess.getConnection();

			SkillCategory objWhere = new SkillCategory();
			objWhere.setCategoryId(info.getCategoryId());
			
			if (! catDao.update(conn, info, objWhere) )
				throw new HRSLogicalException("record.not.updated.exception");
				
			dbAccess.commitConnection(conn);
		} catch (DBAccessException e) {
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
				throw new HRSLogicalException(e.getMessageKey() + ".employee");
			else
				throw new HRSSystemException(e.getMessageKey(), e.getCause());
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {
			}
		}
		
		log.info("exited updateCategory method");

	}
}
