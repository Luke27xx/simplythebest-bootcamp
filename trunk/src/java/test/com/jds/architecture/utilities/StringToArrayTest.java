/*
 * Created on Feb 17, 2005
 */
package test.com.jds.architecture.utilities;

import com.jds.architecture.utilities.StringToArray;

import junit.framework.TestCase;

/**
 * @author arthur.d.gerona
 */
public class StringToArrayTest extends TestCase {
	
	public static final String validTarget1  = "   Test String Space";
	public static final String validTarget2  = "Test String Space   ";
	public static final String validTarget3  = "\t\tTest\tString\tTab";
	public static final String validTarget4  = "Test\tString\tTab\t\t";
	public static final String validTarget5  = "\n\nTest\nString\nNewline";
	public static final String validTarget6  = "Test\nString\nNewline\n\n";
	public static final String validTarget7  = "\r\rTest\rString\rCarriage-return";
	public static final String validTarget8  = "Test\rString\rCarriage-return\r\r";
	public static final String validTarget9  = "\f\fTest\fString\fForm-feed";
	public static final String validTarget10 = "Test\fString\fForm-feed\f\f";
	public static final String validTarget11 = " \t\n\r\fTest \t\n\r\fString \t\n\r\fCombination \t\n\r\f";
	public static final Object validTarget12 = new Object();
	public static final String validTarget13 = "StringToArrayTestPlan";
	public static final String validTarget14 = "String To\tArray\nTest\rPlan\f";
	public static final String validTarget15 = "";
	public static final String errorTarget1 = null;
	
	public void testTransformNormal() {
		StringToArray stringToArray = new StringToArray();
		StringToArray stringToArray2 = new StringToArray("T");
		
		String[] spaceTest			= {"Test", "String", "Space"};
		String[] tabTest			= {"Test", "String", "Tab"};
		String[] newlineTest 		= {"Test", "String", "Newline"};
		String[] carriageReturnTest = {"Test", "String", "Carriage-return"};
		String[] formFeedTest 		= {"Test", "String", "Form-feed"};
	    String[] combinationTest 	= {"Test", "String", "Combination"};
	    String[] additionalTest1 	= {"String", "oArray", "estPlan"};
	    String[] additionalTest2 	= {"String ", "o\tArray\n", "est\rPlan\f"};
	    
	    
	    String[] result1  = (String[]) stringToArray.transform(validTarget1);
	    String[] result2  = (String[]) stringToArray.transform(validTarget2);
	    String[] result3  = (String[]) stringToArray.transform(validTarget3);
	    String[] result4  = (String[]) stringToArray.transform(validTarget4);
	    String[] result5  = (String[]) stringToArray.transform(validTarget5);
	    String[] result6  = (String[]) stringToArray.transform(validTarget6);
	    String[] result7  = (String[]) stringToArray.transform(validTarget7);
	    String[] result8  = (String[]) stringToArray.transform(validTarget8);
	    String[] result9  = (String[]) stringToArray.transform(validTarget9);
	    String[] result10 = (String[]) stringToArray.transform(validTarget10);
	    String[] result11 = (String[]) stringToArray.transform(validTarget11);
	    
	    String[] result13 = (String[]) stringToArray2.transform(validTarget13);
	    String[] result14 = (String[]) stringToArray2.transform(validTarget14);
	    String[] result15 = (String[]) stringToArray.transform(validTarget15);
	    
	    //1.01 a-k
	    for(int i=0; i < 3; i++) {
	    	if(!( (spaceTest[i].equals(result1[i])) && (spaceTest[i].equals(result2[i])) &&
	    			(tabTest[i].equals(result3[i])) && (tabTest[i].equals(result4[i])) &&
	    			(newlineTest[i].equals(result5[i])) && (newlineTest[i].equals(result6[i])) &&
					(carriageReturnTest[i].equals(result7[i])) && (carriageReturnTest[i].equals(result8[i])) &&
					(formFeedTest[i].equals(result9[i])) && (formFeedTest[i].equals(result10[i])) &&
					(combinationTest[i].equals(result11[i])) ))
	    		fail("invalid assertion - Xref 1.01");
	    }
	    
	    //1.02 a-b
	    for(int i=0; i < 3; i++) {
	    	if(!( (additionalTest1[i].equals(result13[i])) && (additionalTest2[i].equals(result14[i])) ))
	    		fail("invalid assertion - Xref 1.02");
	    }
	    
	    //1.03
	    try {
	    	stringToArray.transform(validTarget12);
		} catch (ClassCastException ex) {
			fail("invalid exception - Xref 1.03");
		}
		
		//1.04
		if(result15.length != 0)
			fail("invalid assertion - Xref 1.04");
			
	}
		
	public void testTransformError() {
		StringToArray stringToArray = new StringToArray();
	
		//2.01
		try {
			stringToArray.transform(errorTarget1);
		} catch (NullPointerException ex) {
			return;
		} catch (Exception e) {
			fail("invalid exception - Xref 2.02");
		}
		fail("invalid exception - Xref 2.02");
		
	}

}
