/**
 * 
 */
package com.jds.architecture.service.idgenerator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author training
 *
 */
public class IdGeneratorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.jds.architecture.service.idgenerator.EmployeeIdGenerator#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		assertSame(EmployeeIdGenerator.getInstance(), EmployeeIdGenerator.getInstance());
	}

	/**
	 * Test method for {@link com.jds.architecture.service.idgenerator.EmployeeIdGenerator#getNextId()}.
	 * @throws IdGeneratorException 
	 */
	@Test
	public void testGetNextId() throws IdGeneratorException {
		assertNotNull(EmployeeIdGenerator.getInstance().getNextId());
		System.out.println(EmployeeIdGenerator.getInstance().getNextId());
	}

}
