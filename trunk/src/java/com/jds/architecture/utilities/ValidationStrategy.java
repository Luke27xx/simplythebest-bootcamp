/*
 * Created on Jan 31, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.utilities;

/**
 * Interface that must be implemented by all Validation strategy objects. Classes 
 * that implement the <code>ValidationStrategy</code> interface should be passed to 
 * <code>Validator</code> objects via <code>Validation.getInstance(ValidationStrategy)</code>
 * or to the <code>Validator.validate(ValidationStrategy, Object)</code> method.
 * 
 * @author Eugene P. Lozada
 */
interface ValidationStrategy {
		
	public boolean validate(Object target);
}
