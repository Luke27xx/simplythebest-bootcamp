package com.jds.architecture;

import java.util.Properties;

/**
 * <p>
 * PropertiesMonitor is an interface that reads properties files from a 
 * specified location.
 * </p> 
 * 
 * <p>
 * There are two location where the PropertiesMonitor reads its 
 * properties files:<br>
 * 1. <b>Eclipse Location</b>			(config/properties)<br>
 * 2. <b>build.properties Location</b>	(specified under the build.properties)<br>
 * </p>
 * 
 * <p>
 * There are two types of properties files which the 
 * PropertiesMonitor reads:<br>
 * 1. <b>Dynamic Properties File</b> -	can be change during runtime.<br> 
 * 									 -	File: hrs.properties (default)<br>
 * 2. <b>Static Properties Files</b> - 	does not change during runtime.<br>
 * 									 -	Sample Files: dao.properties (dao component)<br>
 * </p>
 *  							
 * @author Roan W G Nicolas <roan.w.g.nicolas@accenture.com>
 * 
 */
public interface PropertiesMonitor{
    
    
    /**
     * Get the entire Properties File based on the component Name.
     * 
     * @param componentName name of the properties file of the component.
     * @return the contents of the properties file.
     * 
     */    
    public Properties getPropertiesFile(String componentName);    
        
    /**
     * Gets the value of the property name based on the component name.
     * 
     * @param componentName name of the component.
     * @param propertyName name of the properties.
     * @return String value of the property name.
     * 
     */
    public String getProperty(String componentName, String propertyName);
        
    /**
     * Sets the value of a dynamic property
     * 
     * @param propertyName the name of the property.
     * @param propertyValue the value of th eproperty.
     * @return returns the previous value of the property or "" if there is no previous value.
     * 
     */        
    public String setDynamicProperty(String propertyName, String propertyValue);

    /**
     * Gets the value of the Property Name from the Dynamic Propertie file.
     * 
     * @param propertyName of the key.
     * @return String value of the property name.
     * 
     */    
    public String getDynamicProperty(String propertyName);
    
}
