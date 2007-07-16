/*
 * Created on Feb 7, 2005
 */
package com.jds.architecture.utilities;

/**
 * The <code>Transformer</code> is a configurable utility class for providing data 
 * transformation.  Instances of classes that implement <code>TransformStrategy</code>
 * are used as delegates for this utility class and encapsulate the current
 * transform rule to be used.
 * 
 * @author Eugene P. Lozada, Arthur D. Gerona
 *
 */
public class Transformer {
    
	private TransformStrategy strategy;
	
	public Transformer(TransformStrategy strategy){
		setStrategy(strategy);
	}

    /**
     * Utility method to allow the the transformation of a target object using the specified 
     * <code>TransformStrategy</code>.  This method is meant to be invoked statically. 
     * When invoked by an instance of a <code>Transformer</code>, this will not modify in
     * any way the current strategy used by that instance.
     * 
     * @param rule the strategy object used by this method
     * @param target the object to validate
     * @return the transformed object
     */
    public static Object transform(TransformStrategy rule, Object target){
    	return rule.transform(target);
	}
    
    /**
     * Transforms the target object using the strategy delegated to the current instance     
     * 
     * @param target object to be validated
     * @return the transformed object
     */
    public Object transform(Object target){
        return transform(this.strategy, target);
    }
    
	/**
	 * Returns the strategy object used by this Transformer
	 * 
	 * @return the strategy object used
	 */
	public TransformStrategy getStrategy() {
		return strategy;
	}
	
	/**
	 * Sets the strategy object used by this Transformer
	 * 
	 * @param strategy The strategy to set.
	 */
	public void setStrategy(TransformStrategy strategy) {
		if(strategy == null){
		    throw new IllegalArgumentException("invalid strategy object");
        }
        this.strategy = strategy;
	}
}
