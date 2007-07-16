/*
 * Created on Feb 17, 2005
 */
package test.com.jds.architecture.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jds.apps.beans.ApproversList;
import com.jds.architecture.utilities.VOCollectionToMap;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class VOCollectionToMapTest extends TestCase {
	
	ApproversList approversList1 = new ApproversList();
	ApproversList approversList2 = new ApproversList();
	ApproversList approversList3 = new ApproversList();
	ApproversList approversList4 = new ApproversList();
	ApproversList approversList5 = new ApproversList();
	ApproversList approversList6 = new ApproversList();
	ApproversList approversList7 = new ApproversList();
	ApproversList approversList8 = new ApproversList();
	Collection collectionNorm1 = new ArrayList();
	Collection collectionNorm2 = new ArrayList();
	Collection collectionNorm3 = new ArrayList();
	Collection collectionNorm4 = new ArrayList();
	Collection collectionNorm5 = new ArrayList();
	Collection collectionNorm6 = new ArrayList();
	Collection collectionNorm7 = new ArrayList();
	Collection collectionNorm8 = new ArrayList();
	String[] collectionErr1 = {"Juan de la Cruz", "123456789"};
	Collection collectionErr2 = null;
	Collection collectionErr3 = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		approversList1.setName("Juan de la Cruz");
		approversList1.setDescription("Software Engineer");
		approversList1.setStatus("bench - for deployment");
		approversList1.setId("1234567890");
		
		approversList2.setDescription("Software Engineer");
		approversList2.setStatus("bench - for deployment");
		
		approversList3.setDescription("Software Engineer");
		approversList3.setStatus("bench - for deployment");
		approversList3.setId("1234567890");
		
		approversList4.setName("Juan de la Cruz");
		approversList4.setDescription("Software Engineer");
		approversList4.setStatus("bench - for deployment");
		
		approversList6.setName("Juan de la Cruz");
		approversList6.setId("1234567890");
		
		approversList7.setId("1234567890");
		
		approversList8.setName("Juan de la Cruz");
		
		collectionNorm1.add(approversList1);
		collectionNorm2.add(approversList2);
		collectionNorm3.add(approversList3);
		collectionNorm4.add(approversList4);
		collectionNorm5.add(approversList5);
		collectionNorm6.add(approversList6);
		collectionNorm7.add(approversList7);
		collectionNorm8.add(approversList8);
		//collectionErr3.add("Juan de la Cruz");
		
	}
	
	public void testVOCollectionToMapNormal() {
		VOCollectionToMap vOCollectionToMap = 
			new VOCollectionToMap();
		
		List tempList = (ArrayList) 
			vOCollectionToMap.transform(collectionNorm1);
		Map tempMap = (HashMap) tempList.get(0);
		assertEquals("1234567890", tempMap.get("value"));
		assertEquals("Juan de la Cruz", tempMap.get("label"));
		
		tempList = (ArrayList) vOCollectionToMap.transform(collectionNorm2);
		tempMap = (HashMap) tempList.get(0);
		assertEquals(null, tempMap.get("value"));
		assertEquals(null, tempMap.get("label"));
		
		tempList = (ArrayList) vOCollectionToMap.transform(collectionNorm3);
		tempMap = (HashMap) tempList.get(0);
		assertEquals("1234567890", tempMap.get("value"));
		assertEquals(null, tempMap.get("label"));
		
		tempList = (ArrayList) vOCollectionToMap.transform(collectionNorm4);
		tempMap = (HashMap) tempList.get(0);
		assertEquals(null, tempMap.get("value"));
		assertEquals("Juan de la Cruz", tempMap.get("label"));
		
		tempList = (ArrayList) vOCollectionToMap.transform(collectionNorm5);
		tempMap = (HashMap) tempList.get(0);
		assertEquals(null, tempMap.get("value"));
		assertEquals(null, tempMap.get("label"));
		
		tempList = (ArrayList) vOCollectionToMap.transform(collectionNorm6);
		tempMap = (HashMap) tempList.get(0);
		assertEquals("1234567890", tempMap.get("value"));
		assertEquals("Juan de la Cruz", tempMap.get("label"));
		
		tempList = (ArrayList) vOCollectionToMap.transform(collectionNorm7);
		tempMap = (HashMap) tempList.get(0);
		assertEquals("1234567890", tempMap.get("value"));
		assertEquals(null, tempMap.get("label"));
		
		tempList = (ArrayList) vOCollectionToMap.transform(collectionNorm8);
		tempMap = (HashMap) tempList.get(0);
		assertEquals(null, tempMap.get("value"));
		assertEquals("Juan de la Cruz", tempMap.get("label"));
		
	}
	
	public void testVOCollectionToMapError() {
		VOCollectionToMap vOCollectionToMap = 
			new VOCollectionToMap();
		
		//2.01
		try {
			vOCollectionToMap.transform(collectionErr1);
		} catch (ClassCastException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.01");
		}
		fail("invalid exception - Xref 2.01");
		
		//2.02
		try {
			vOCollectionToMap.transform(collectionErr2);
		} catch (ClassCastException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.02");
		}
		fail("invalid exception - Xref 2.02");
		
		//2.03
		try {
			vOCollectionToMap.transform(collectionErr3);
		} catch (NullPointerException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.03");
		}
		fail("invalid exception - Xref 2.03");
		
	}
	
}
