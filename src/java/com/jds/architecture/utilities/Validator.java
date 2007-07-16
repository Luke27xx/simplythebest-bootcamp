/*
 * Created on Feb 7, 2005
 */
package com.jds.architecture.utilities;

/**
 * The <code>Validator</code> is a configurable utility class for providing data 
 * validation.  Instances of classes that implement <code>ValidationStrategy</code>
 * are used as delegates for this utility class and encapsulate the current
 * validation rule to be used.
 * 
 * 
 * @author Eugene P. Lozada, Arthur D. Gerona
 *
 */
public class Validator {

    private ValidationStrategy strategy;
    
	public Validator(ValidationStrategy strategy){
		
        setStrategy(strategy);
	}
 
    /**
     * Utility method to allow the the validation of a target object using the specified 
     * <code>ValidationStrategy</code>.  This method is meant to be invoked statically. 
     * When invoked by an instance of a <code>Validator</code>, this will not modify in
     * any way the current strategy used by that instance.
     * 
     * @param rule the strategy object used by this method
     * @param target the object to validate
     * @return true if the object validates according to the rule specified by the <code>rule</code>
     * by this Validator, false otherwise.
     */
    public static boolean validate(ValidationStrategy rule, Object target){
    	return rule.validate(target);
	}

    /**
     * Validates the target object using the strategy delegated to the current instance     
     * 
     * @param target object to be validated
     * @return true if the object validates according to the rule set by the strategy object used
     * by this Validator, false otherwise.
     */
    public boolean validate(Object target){
    	return validate(this.strategy, target);
    }
    
    
    
	/**
	 * Returns the strategy object used by this Validator.
	 * 
	 * @return the strategy object
	 */
	public ValidationStrategy getStrategy() {
		return strategy;
	}
	
	/**
	 * Sets the strategy object used by this Validator
	 * 
	 * @param strategy The strategy to set
	 */
	public void setStrategy(ValidationStrategy strategy) {
		if(strategy == null){
		    throw new IllegalArgumentException("invalid strategy object");
        }
        this.strategy = strategy;
	}
	
}
