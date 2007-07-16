/*
 * Created on Feb 1, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.properties;

import com.jds.architecture.Implementor;
import com.jds.architecture.PropertiesMonitor;
import com.jds.architecture.Service;
import com.jds.architecture.logging.LoggerImp;

import java.util.Hashtable;
import java.util.Properties;


/**
 * @author Roan W G Nicolas <roan.w.g.nicolas@accenture.com>
 *
 */
public class PropertiesMonitorService extends Service implements PropertiesMonitor{

	protected transient PropertiesMonitorImp propertiesDelegate;
	
	private Hashtable staticPropertiesTable = new Hashtable();	
	private Properties dynamicProperties = new Properties();
	
	private String globalPropertiesFolder;	

    private static final String PROPS_FOLDER_VARIABLE = "@props.dir@";
    private static final String DYNAMICPROPFILE = "hrs.properties";
    private static final String ECLIPSE_PROPFOLDER = "config/properties";    
	
    public PropertiesMonitorService() {
        
    }
	
	public void setImplementor(Implementor plugin) {
	    this.propertiesDelegate = (PropertiesMonitorImp)plugin; 
	    this.propertiesDelegate.init();
	    init();
	}
		
	public void init() {
		setGlobalPropertiesFolder(PROPS_FOLDER_VARIABLE);
		loadAllStaticProperties();
		initializeDynamicProperties();	    
	}
	
	public void setGlobalPropertiesFolder(String folderName) {
        if ((folderName.indexOf("@")==0)||(folderName.equals(""))) {
            folderName = ECLIPSE_PROPFOLDER;
        }
        this.globalPropertiesFolder = folderName;
	}
	
	public String getGlobalPropertiesFolder() {
	    return this.globalPropertiesFolder;
	}	
	
	private void loadAllStaticProperties() {
	    propertiesDelegate.loadAllStaticProperties(
	            					staticPropertiesTable,
	            					globalPropertiesFolder);
	}
	
	private void initializeDynamicProperties() {
	    propertiesDelegate.initializeDynamicProperties(
						            dynamicProperties,
						            globalPropertiesFolder,
						            DYNAMICPROPFILE);	    
	}
	
	
    public Properties getPropertiesFile(String componentName) {
                        
        return propertiesDelegate.getPropertiesFile(staticPropertiesTable, 
                									componentName);
        
    }
    
    public String getProperty(String componentName, String propertyName) {
        
        return propertiesDelegate.getProperty(staticPropertiesTable, 
                								componentName, 
                								propertyName);
        
    }
        
    public String setDynamicProperty(String propertyName,String propertyValue) {
       
        return propertiesDelegate.setDynamicProperty(dynamicProperties,
												globalPropertiesFolder,
												DYNAMICPROPFILE,
												propertyName, 
												propertyValue);        
    }
    
    public String getDynamicProperty(String propertyName) {
        
        return propertiesDelegate.getDynamicProperty(dynamicProperties, propertyName);
        
    }
    
	/** 
	* Create a Logger instance given the logger name.
	*
	* @param name    the logger name
	*/
	public static PropertiesMonitorService getPropertiesMonitor() {
	    return new PropertiesMonitorService();
	}

	/* (non-Javadoc)
	 * @see com.jds.architecture.Service#setImplementor()
	 */
	protected void setImplementor() {
		// TODO Auto-generated method stub
		
	}

	
    
}
