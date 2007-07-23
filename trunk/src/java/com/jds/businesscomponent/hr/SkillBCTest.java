/**
 * 
 */
package com.jds.businesscomponent.hr;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jds.apps.beans.EmployeeInfo;
import com.jds.apps.beans.SkillsInformation;
import com.jds.architecture.exceptions.HRSException;
import com.jds.architecture.exceptions.HRSLogicalException;

/**
 * @author training
 * 
 */
public class SkillBCTest {

	static SkillBC skillBc = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception, HRSException {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception, HRSException {
		skillBc = new SkillBC();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {}

	/**
	 * Test method for
	 * {@link com.jds.businesscomponent.hr.SkillBC#createSkill(com.jds.apps.beans.SkillsInformation)}.
	 */
	@Test
	public final void testCreateSkill() throws HRSException {
		SkillsInformation si = new SkillsInformation();
		si.setCategoryId("cat1");
		si.setCategoryName("cat_name1");
		si.setDescription("desc");
		si.setId("1");
		si.setName("name1");
		si.setSkillDescription("skill_desc");
		si.setSkillId("sk_id");
		si.setSkillName("sk_name");
		si.setStatus("APPROVED");

		skillBc.createSkill(si);
		
		//assertTrue(true)
		//fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.jds.businesscomponent.hr.SkillBC#searchSkill(java.lang.String)}.
	 */
	@Test
	public final void testSearchSkill() {
		
		SkillsInformation info = null;
		try {
			// skill exists
			info = skillBc.searchSkill("123");
			assertEquals("123" , info.getSkillId());
			
		} catch (HRSException e) {
			fail("search failed");
		} catch (Exception e) {
			fail("search failed");
		}
		
		try {
			// skill doesn't exist
			info = skillBc.searchSkill("123");
			
			fail("no exception");
		} catch (HRSException ex) {
			return;
		}
		
		fail("Wrong exception");
	}

	/**
	 * Test method for
	 * {@link com.jds.businesscomponent.hr.SkillBC#searchApprovedSkills(com.jds.apps.beans.SkillsInformation)}.
	 */
	@Test
	public final void testSearchApprovedSkills() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.jds.businesscomponent.hr.SkillBC#searchReferenceData(com.jds.apps.beans.AbstractReferenceData, java.lang.String)}.
	 */
	@Test
	public final void testSearchReferenceData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.jds.businesscomponent.hr.SkillBC#updateSkill(com.jds.apps.beans.SkillsInformation)}.
	 */
	@Test
	public final void testUpdateSkill() {
		fail("Not yet implemented");
	}

}
