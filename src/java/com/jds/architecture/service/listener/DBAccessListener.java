/*
 * Created on Feb 9, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.service.listener;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;


import com.jds.architecture.PropertiesMonitor;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.properties.PropertiesMonitorService;
import com.jds.architecture.service.dbaccess.DBAccessException;

/**
 * @author JDSSvr
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DBAccessListener extends Timer{

	
	private static String TIME_DELAY = "30000";
	
	private static Logger log = Logger.getLogger(DBAccessListener.class);
	private long timedelay = 0;
	private TimerTask task = null;
	
	ServiceFactory sf = ServiceFactory.getInstance();
	private PropertiesMonitor pm = (PropertiesMonitor) sf.getService(PropertiesMonitorService.class);

	public DBAccessListener() {
		setDefaultTime();
	}
	
	private void setDefaultTime() {
		if (pm.getProperty("dbaccess", "jdbc.reconnect.time") != null) {
			TIME_DELAY = pm.getProperty("dbaccess", "jdbc.reconnect.time");
			try{
				timedelay = Long.parseLong(TIME_DELAY);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setTime(long timedelay){
		this.timedelay = timedelay;
	}
	
	public void setTask(TimerTask task) {
		this.task = task;
	}
	
	public void executeTask(TimerTask task) throws DBAccessException{
		log.info("@@@@@@@@@@@@@@@@@@@ task execute");
		this.schedule(task, 3000, 3000);
	}
	
		
}
