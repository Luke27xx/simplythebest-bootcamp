/*
 * Created on Feb 1, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Hashtable;

import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.logging.Log4JLoggerImp;

import com.jds.architecture.Implementor;
import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;

/**
 * @author Roan W G Nicolas <roan.w.g.nicolas@accenture.com>
 *
 */
public class JDSPropertiesMonitorImp extends Implementor implements PropertiesMonitorImp {

    private LoggerService log;

    
    public void init() {        
        ServiceFactory sf = ServiceFactory.getInstance();        
        log = (LoggerService)sf.getService(LoggerService.class);
    }
        
    public void loadAllStaticProperties(Hashtable staticProperties,
            							String globalPropertiesFolder) {       
        
        File dir = null;
        try {
            dir = new File(globalPropertiesFolder);
        } catch (NullPointerException e) {
            log.error("Could not open the specified properties folder: "
                    + globalPropertiesFolder, e);
        }

        if (dir == null) {
            log.error("Could not open the specified properties folder: "
                    + globalPropertiesFolder);
            return;
        }

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                boolean res = false; 
                res = !name.endsWith("dynamic.properties");
                if (!name.endsWith(".properties"))
                    res = false; 
                return res;
            }
        };
        String[] children = dir.list(filter);
        for (int i = 0; i < children.length; i++) {
            log.info("LOAD properties file:" + children[i]);
            Properties p = new Properties();
            try {
                p.load(new FileInputStream(globalPropertiesFolder + "/"
                        + children[i]));
                log.debug("START static property dump: "
                                + children[i]);
                for (Iterator iter = p.keySet().iterator(); iter.hasNext();) {
                    String element = (String) iter.next();
                    log.debug(element + "=" + p.getProperty(element));
                }
                log.debug("END static properties dump");
                staticProperties.put(children[i], p);
            } catch (FileNotFoundException e) {
                // TODO: PropertiesMonitor own Exception
                log.error("File Not Found", e);
            } catch (IOException e) {
                // TODO: PropertiesMonitor own Exception
                log.error("IO Error", e);
            }
        }
    }    
    
    public void initializeDynamicProperties(
            				Properties dynamicProperties,
            				String globalPropertiesFolder,
            				String dynamicPropertiesFileName) {
        try {            
            File dynamicPropertiesFile = new File(globalPropertiesFolder + "/" + dynamicPropertiesFileName);
            dynamicProperties.load(new FileInputStream(dynamicPropertiesFile));
            log.info("Dynamic properties initialized from " + dynamicPropertiesFile.getPath());

        } catch (IOException e) {
            // TODO: PropertiesMonitor own Exception
            log.error("IO Exception ", e);
        } catch (Exception e) {
            // TODO: PropertiesMonitor own Exception
            log.error("Other Errors ", e);
        }

        log.debug("START dynamic property dump: ");
        for (Iterator iter = dynamicProperties.keySet()
                .iterator(); iter.hasNext();) {
            String element = (String) iter.next();
            log.debug(element + "="
                    + dynamicProperties.getProperty(element));
        }
        log.debug("END dynamic property dump");

    }    
    
    public Properties getPropertiesFile(Hashtable staticProperties, 
            								String componentName) {
                
        Properties props = (Properties)staticProperties.get(componentName + ".properties");
        return props;
        
    }
    
    public String getProperty(Hashtable staticProperties, 
            					String componentName, 
            					String propertyName) {        
        String result = "";
        try {
            result = ((String) ((Properties) staticProperties.get(componentName + ".properties")).get(propertyName)).trim();
        } catch (Exception e) {
            //TODO: PropertiesMonitor own Exception
            log.error("Could not read property " + propertyName + " from file: " + componentName, e);
        }
        return result;
        
    }
        
    public String setDynamicProperty(Properties dynamicProperties,
            						String globalPropertiesFolder,
            						String dynamicPropertiesFileName,
            						String propertyName, 
            						String propertyValue) {
        
        String oldValue = (String)dynamicProperties.setProperty(propertyName, propertyValue);
        try {
            File dynamicPropertiesFile = new File("config/properties/hrs.properties");
            dynamicProperties.store(new FileOutputStream(dynamicPropertiesFile), null);
            log.info("Dynamic properties updated" + dynamicPropertiesFile.getPath() + ": Set " + propertyName + " to " + propertyValue);
	
        } catch (IOException e) {
            // TODO: PropertiesMonitor own Exception
            log.error("IO Exception ", e);
        } catch (Exception e) {
            // TODO: PropertiesMonitor own Exception
            log.error("Other Errors ", e);
        }
	   	return oldValue;        
    }
    
    public String getDynamicProperty(Properties dynamicProperties,
            						String propertyName) {
        
        String propertyValue = dynamicProperties.getProperty(propertyName);
        if(propertyValue == null){
        	return "";
        } else {
        	return propertyValue.trim();
        }                
    }    
    
}
