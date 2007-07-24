/**
 * 
 */
package com.jds.businesscomponent.hr;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jds.apps.beans.SkillCategory;
import com.jds.apps.beans.SkillsInformation;
import com.jds.architecture.exceptions.HRSException;

/**
 * @author Dmitrijs.Sadovskis
 * 
 */
public class SkillCategoryBCTest {

	static SkillCategoryBC catBc = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws HRSException, Exception {
		catBc = new SkillCategoryBC();
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
	public void setUp() throws Exception {}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {}

	/**
	 * Test method for
	 * {@link com.jds.businesscomponent.hr.SkillCategoryBC#createCategory(com.jds.apps.beans.SkillCategory)}.
	 */
	@Test
	public final void testCreateCategory() throws HRSException {
		SkillCategory sci = new SkillCategory();
		// SkillsInformation si = new SkillsInformation();

		sci.setCategoryName("cat name 1"
				+ String.valueOf((long) (Math.random() * 10000)));
		sci.setCategoryDescription("desc1"
				+ String.valueOf((long) (Math.random() * 10000)));
		sci.setStatus("APPROVED");

		catBc.createCategory(sci);

	}

	/**
	 * Test method for
	 * {@link com.jds.businesscomponent.hr.SkillCategoryBC#searchCategory(java.lang.String)}.
	 */
	@Test
	public final void testSearchCategory() {
		SkillCategory info = null;
		try {
			// skill exists
			info = catBc.searchCategory("124");
			assertEquals("Operating Systems", info.getCategoryName());

		} catch (HRSException e) {
			fail("search failed");
		} catch (Exception e) {
			fail("search failed");
		}

		try {
			// skill doesn't exist
			info = catBc.searchCategory("aaaaaaaaax");

			fail("no exception");
		} catch (HRSException ex) {
			return;
		}

		fail("Wrong exception");
	}

	/**
	 * Test method for
	 * {@link com.jds.businesscomponent.hr.SkillCategoryBC#searchApprovedCategories(com.jds.apps.beans.SkillCategory)}.
	 */
	@Test
	public final void testSearchApprovedCategories() throws HRSException {

		SkillCategory dataFind = new SkillCategory();
		dataFind.setCategoryName("ing");
		ArrayList<SkillCategory> temp = (ArrayList<SkillCategory>) catBc
				.searchApprovedCategories(dataFind);
		String correct1 = "123124";
		String correct2 = "124123";

		String temp_string = "";
		for (int i = 0; i < temp.size(); i++)
			temp_string += temp.get(i).getCategoryId();

		boolean temp_boolean = temp_string.equals(correct1)
				|| temp_string.equals(correct2);

		assertEquals(true, temp_boolean);
	}

	/**
	 * Test method for
	 * {@link com.jds.businesscomponent.hr.SkillCategoryBC#searchReferenceData(com.jds.apps.beans.AbstractReferenceData, java.lang.String)}.
	 */
	@Test
	public final void testSearchReferenceData() throws HRSException {

		ArrayList<SkillCategory> temp = (ArrayList<SkillCategory>) catBc
				.searchReferenceData(null, null);

		String temp_string = "";
		for (int i = 0; i < temp.size(); i++)
			temp_string += temp.get(i).getCategoryName();

		boolean temp_boolean = temp_string.contains("Multimedia")
				&& temp_string.contains("Programming Language")
				&& temp_string.contains("Operating Systems");

		assertEquals(true, temp_boolean);

	}

	/**
	 * Test method for
	 * {@link com.jds.businesscomponent.hr.SkillCategoryBC#updateCategory(com.jds.apps.beans.SkillCategory)}.
	 */
	@Test
	public final void testUpdateCategory() throws HRSException {
		SkillCategory sci = new SkillCategory();

		sci.setCategoryId("124");
		sci.setCategoryName("OSs");

		catBc.updateCategory(sci);

		sci.setCategoryName("Operating Systems");
		sci.setCategoryDescription("Windows, *nix (linux, unix, sux!)");

		catBc.updateCategory(sci);

		try {
			catBc.updateCategory(sci);
			// assertEquals(true, b);
		} catch (Exception e) {
			fail("an exception");
		} catch (HRSException ex) {
			fail("an exception");
		}
	}

}
