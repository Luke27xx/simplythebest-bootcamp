/*
 * Created on Feb 17, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.utilities;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import com.jds.apps.beans.AbstractReferenceData;

/**
 * Custom transform strategy object used to transform a Collection of JDS value objects
 * to a Map with containing the id and the name of each object.
 * 
 * The overriden method <code>transform(Object target)</code> accepts a <code>Collecction</code>
 * object containing AbstractReferenceData instances.  RuntimeExceptions will be 
 * thrown when any other argument is passed to the method.
 * 
 * Classes that implement the <code>TransformStrategy</code> interface should be 
 * passed to <code>Transformer</code> objects via their constructor or to the 
 * <code>Transformer.transform(TransformStrategy, Object)</code> method.
 * 
 * @author Eugene P. Lozada, Arthur D. Gerona
 * @see Transformer
 * @see TransformStrategy
 */
public class VOCollectionToMap  implements TransformStrategy{

	/**
	 * Transforms any collection of JDS value objects in to a map containing
	 * their value object id and name.
	 * 
	 * @param target Collection of JDS value objects to be transformed
	 * @return Map of the JDS value objects containing the id and name of each\
	 * object
	 */
	public Object transform(Object target) {
		
		List list = new ArrayList();
		AbstractReferenceData data = null;
		Collection col = (Collection)target;
		if (!col.isEmpty()) {
			Iterator iterate = col.iterator();
			while (iterate.hasNext()) {
				data = (AbstractReferenceData)iterate.next();
				Map map = new HashMap();
				map.put("value", data.getId());
				map.put("label", data.getName());
				list.add(map);
			}	
		}
		return list;
	}
}
