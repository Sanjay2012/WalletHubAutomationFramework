package com.domain.utilityClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


public class Log {
	
	// Initialization of log4j logs
	 private static final Logger log=(Logger) LogManager.getLogger(Log.class.getName());
	//public static Logger log=Logger.getLogger(Log.class);
	 
	public static void startTestCase(String sTestCaseName) {
		log.info("========================" + sTestCaseName +" TEST START ===================");
	}
	
	public static void endTestCase(String sTestCaseName) {
		log.info("========================" + sTestCaseName +" TEST END ===================");
	}
	
	// create methods for log levels
	
	public static void info(String message) {
		log.info(message);
	}
	
	public static void warn(String message) {
		log.warn(message);
	}
	
	public static void error(String message) {
		log.error(message);
	}
	
	public static void fatal(String message) {
		log.fatal(message);
	}

}
