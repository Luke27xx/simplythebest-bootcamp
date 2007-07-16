/*
 * Created on Jan 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture;

/**
 * @author Roan W G Nicolas <roan.w.g.nicolas@accenture.com>
 *
 */
public abstract class Implementor{
	
	private Class delegateTarget;
	
	public void setDelegateTarget(Class target){
		delegateTarget = target;
	}
	
	public Class getDelegateTarget(){
		return delegateTarget;
	}
	
}
