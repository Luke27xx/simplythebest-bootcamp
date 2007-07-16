/*
 * Created on Feb 7, 2005
 */
package com.jds.architecture.utilities;

import java.util.StringTokenizer;

/**
 * Transform strategy object used to breakdown a string into its component substrings
 * using default or specified delimeters and returns it as an array of strings.
 * This method uses the java.util.StringTokenizer class to perform this transform.
 * 
 * The overriden method <code>transform(Object target)</code> accepts any object. 
 * Exceptions will be thrown when any other argument is passed to the method.
 * 
 * Classes that implement the <code>TransformStrategy</code> interface should be 
 * passed to <code>Transformer</code> objects via their constructor or to the 
 * <code>Transformer.transform(TransformStrategy, Object)</code> method.
 * 
 * @author Eugene P. Lozada, Arthur D. Gerona
 * @see Transformer
 * @see TransformStrategy
 */
public class StringToArray implements TransformStrategy{

	private String delim;
	public static String DEFAULT_DELIMETER="\n\t\r\f  ";
	
	public StringToArray(){
		this.delim = DEFAULT_DELIMETER;
	}
	
	public StringToArray(String delim){
		this.delim = delim;
	}
	
	/**
	 * Breaks down a string into its component parts according to the default
	 * of specified delimeters.
	 * 
	 * @param target the object to be transformed
	 * @return String array containing the substring components of the argument
	 */
	public Object transform(Object target) {
	
		return null;
		
	}


}