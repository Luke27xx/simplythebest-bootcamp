/*
 * Created on Feb 14, 2005
 * 
 * JAVA Development School
 * Copyright 2007 Accenture
 *
 */
package com.jds.businesscomponent.hr;

import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.sql.RowSet;

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
import com.jds.architecture.service.dao.assembler.SkillsAssembler;
import com.jds.architecture.service.dbaccess.DBAccess;
import com.jds.architecture.service.dbaccess.DBAccessException;
import com.jds.architecture.service.idgenerator.CategoryIdGenerator;
import com.jds.architecture.service.idgenerator.EmployeeIdGenerator;
import com.jds.architecture.service.idgenerator.IdGeneratorException;
import com.jds.architecture.service.idgenerator.SkillIdGenerator;

/**
 * SkillBC is a class that serves as an HR module business functions
 * 
 * @author Dmitrijs.Sadovskis
 */
public class SkillBC {

	private Constants cons;
	private DataAccessObjectInterface skillDao = null;
	private DataAccessObjectInterface catDao = null;
	private DBAccess dbAccess = null;

	private static Logger log = (Logger) ServiceFactory.getInstance()
			.getService(LoggerService.class);

	/**
	 * Constructor initializes data access objects
	 */
	public SkillBC() throws HRSSystemException {

		log.info("entered SkillBC constructor");

		try {
			skillDao = (SkillDAO) DAOFactory.getFactory().getDAOInstance(
					DAOConstants.DAO_SKILL);

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

		log.info("exited SkillBC constructor");

	}

	/**
	 * Create skill information by HRManager
	 * 
	 * @param info
	 *            SkillsInformation
	 * @throws HRSLogicalException
	 *             when info, date of birth and accenture details is null
	 * @throws HRSSystemException
	 *             when system exception occurred (e.g. Failed database
	 *             connection)
	 */
	public void createSkill(SkillsInformation info) throws HRSSystemException,
			HRSLogicalException {

		log.info("entered createSkill method");

		if (info == null)
			throw new HRSLogicalException("invalid.input.exception");

		if (info.getCategoryName() == null) {
			throw new HRSLogicalException("skill.category.no.record.exception");
		}
		
		if (info.getStatus() != null
				&& !info.getStatus().equalsIgnoreCase("approved")) {
			throw new HRSLogicalException("category.not.approved.exception");
		}

		Connection conn = null;

		try {
			conn = dbAccess.getConnection();

			SkillCategory sci = new SkillCategory();
			sci.setCategoryId(info.getCategoryId());

			RowSet rs = catDao.find(sci);

			try {
				if (!rs.next()) {
					throw new HRSLogicalException(
							"skill.category.no.record.exception");
				}
			} catch (SQLException ex) {
				throw new HRSLogicalException(
						"skill.category.no.record.exception");
			}

			long id = SkillIdGenerator.getInstance().getNextId();
			info.setSkillId(String.valueOf(id));

			skillDao.create(conn, info);
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

		log.info("exited createSkill method");

	}

	/**
	 * Searches skill by primary key which is the skill no. by HRManager
	 * 
	 * @param id
	 *            String
	 * @return SkillsInformation object of searched skill
	 * @throws HRSLogicalException
	 *             when skill no. is null
	 * @throws HRSSystemException
	 *             when system exception occurred (e.g. Failed database
	 *             connection)
	 */
	public SkillsInformation searchSkill(String id) throws HRSSystemException,
			HRSLogicalException {

		log.info("entered searchSkill method");

		if (id == null)
			throw new HRSLogicalException("id.required.exception");

		SkillsInformation data = null;

		try {
			data = (SkillsInformation) skillDao.findByPK(id);

			if (data == null)
				throw new HRSLogicalException("record.not.found.exception");

			/*
			 * SkillCategory catData = (SkillCategory) catDao.findByPK(data
			 * .getCategoryId()); data.setCategoryId(catData.getCategoryId());
			 * data.setCategoryName(catData.getCategoryName());
			 */
		} catch (DAOException e) {
			throw new HRSSystemException(e.getMessageKey(), e.getCause());
		} catch (Exception e) {
			throw new HRSSystemException("business.component.exception", e
					.getCause());
		}

		log.info("exited searchSkill method");

		return data;
	}

	/**
	 * Searches skill
	 * 
	 * @param dataFind
	 *            SkillsInformation
	 * @return Collection of skills
	 * @throws HRSLogicalException
	 *             when nothing can be found
	 * @throws HRSSystemException
	 *             when system exception occurred (e.g. Failed database
	 *             connection)
	 */
	public Collection searchApprovedSkills(SkillsInformation dataFind)
			throws HRSSystemException, HRSLogicalException {

		log.info("entered searchApprovedSkills method");

		Collection result = searchReferenceData(dataFind, "approved");

		log.info("exited searchApprovedSkills method");

		return result;
	}

	/**
	 * Searches skills
	 * 
	 * @param dataFind
	 *            SkillsInformation
	 * @return Collection of skills
	 * @throws HRSLogicalException
	 *             when nothing can be found
	 * @throws HRSSystemException
	 *             when system exception occurred (e.g. Failed database
	 *             connection)
	 */
	public Collection searchReferenceData(AbstractReferenceData dataFind,
			String approvalType) throws HRSSystemException, HRSLogicalException {

		log.info("entered searchReferenceData method");

		Collection<SkillsInformation> returnCollection = new ArrayList<SkillsInformation>();

		try {
			ResultSet rs;
			if (dataFind == null) {
				rs = skillDao.findByAll();
			} else {
				rs = skillDao.find(dataFind);
			}

			while (rs.next()) {
				SkillsInformation skinfo = SkillsAssembler.getInfo(rs);
				if (!(skinfo.getStatus() == null)
						&& skinfo.getStatus().equalsIgnoreCase("approved"))
					returnCollection.add(skinfo);
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

		return (Collection<SkillsInformation>) returnCollection;
	}

	/**
	 * Updates skill
	 * 
	 * @param info
	 *            SkillsInformation
	 * @throws HRSLogicalException
	 *             can't update
	 * @throws HRSSystemException
	 *             when system exception occurred (e.g. Failed database
	 *             connection)
	 */
	public void updateSkill(SkillsInformation info) throws HRSSystemException,
			HRSLogicalException {

		log.info("entered updateSkill method");

		if (info == null) {
			throw new HRSLogicalException("invalid.input.exception");
		}
		if (info.getSkillId() == null) {
			throw new HRSLogicalException("id.required.exception");
		}

		Connection conn = null;

		try {
			conn = dbAccess.getConnection();

			SkillsInformation objWhere = new SkillsInformation();
			objWhere.setSkillId(info.getSkillId());

			if (!skillDao.update(conn, info, objWhere))
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

		log.info("exited updateSkill method");
	}

}
