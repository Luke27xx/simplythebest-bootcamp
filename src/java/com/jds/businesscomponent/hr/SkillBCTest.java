/**
 * 
 */
package com.jds.businesscomponent.hr;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jds.apps.beans.EmployeeInfo;
import com.jds.apps.beans.SkillsInformation;
import com.jds.architecture.exceptions.HRSException;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.service.dbaccess.DBAccess;

/**
 * @author Dmitrijs.Sadovskis
 * 
 */
public class SkillBCTest {

	static SkillBC skillBc = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception, HRSException {
		skillBc = new SkillBC();
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
	public void setUp() throws Exception, HRSException {}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Test method for
	 * {@link com.jds.businesscomponent.hr.SkillBC#createSkill(com.jds.apps.beans.SkillsInformation)}.
	 */
	@Test
	public final void testCreateSkill() throws HRSException, Exception {

		SkillsInformation si = new SkillsInformation();

		si.setSkillName("test skill 23.07"
				+ String.valueOf((long) (Math.random() * 10000)));
		si.setSkillDescription("sodienas datums");

		// FIXME: delete this later
		si.setCategoryId("cat_XXXXXXX1");

		si.setCategoryName("cat_name1");
		si.setStatus("APPROVED");

		skillBc.createSkill(si);
		
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
			assertEquals("JAVA", info.getSkillName());

		} catch (HRSException e) {
			fail("search failed");
		} catch (Exception e) {
			fail("search failed");
		}

		try {
			// skill doesn't exist
			info = skillBc.searchSkill("aaaaaaaaax");

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
	public final void testSearchApprovedSkills() throws HRSException {

		SkillsInformation dataFind = new SkillsInformation();
		dataFind.setSkillName("JAVA");
		ArrayList<SkillsInformation> temp = (ArrayList<SkillsInformation>) skillBc
				.searchApprovedSkills(dataFind);
		String correct = "J2SDK1.5";
		String temp_string = "";
		for (int i = 0; i < temp.size(); i++)
			temp_string += temp.get(i).getSkillDescription();

		assertEquals(correct, temp_string);
	}

	/**
	 * Test method for
	 * {@link com.jds.businesscomponent.hr.SkillBC#searchReferenceData(com.jds.apps.beans.AbstractReferenceData, java.lang.String)}.
	 */
	@Test
	public final void testSearchReferenceData() throws HRSException {

		SkillsInformation dataFind = new SkillsInformation();
		dataFind.setSkillName("A");

		ArrayList<SkillsInformation> temp = (ArrayList<SkillsInformation>) skillBc
				.searchReferenceData(dataFind, null);
		
		String correct1 = "JAVAAdobe Photoshop";
		String correct2 = "Adobe PhotoshopJAVA";
		String temp_string = "";
		for (int i = 0; i < temp.size(); i++)
			temp_string += temp.get(i).getSkillName();

		boolean temp_boolean = temp_string.equals(correct1) ||
		 	temp_string.equals(correct2);
		
		assertEquals(true, temp_boolean);

	}

	/**
	 * Test method for
	 * {@link com.jds.businesscomponent.hr.SkillBC#updateSkill(com.jds.apps.beans.SkillsInformation)}.
	 */
	@Test
	public final void testUpdateSkill() throws HRSException {
		SkillsInformation si = new SkillsInformation();

		si.setSkillId("789");
		si.setSkillName("Adobe Photoshop BLABLABLA");

		skillBc.updateSkill(si);

		si.setSkillName("Adobe Photoshop");
		si.setSkillDescription("VER 10.0");

		skillBc.updateSkill(si);

		try {
			skillBc.updateSkill(si);
			// assertEquals(true, b);
		} catch (Exception e) {
			fail(e.toString());
		} catch (HRSException ex) {
			fail(ex.toString());
		}

	}

}
