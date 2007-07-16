/*
 * Created on Jan 31, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.utilities;

/**
 * Interface that must be implemented by all Transform strategy objects. Classes 
 * that implement the <code>TransformStrategy</code> interface should be passed to 
 * <code>Transformer</code> objects via <code>Transformer.getInstance(TransformStrategy)</code>
 * or to the <code>Transformer.transform(ValidationStrategy, Object)</code> method.
 * 
 * @author Eugene P. Lozada
 */
interface TransformStrategy {
	
	public Object transform(Object target);

}
