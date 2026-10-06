package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

	// static - only one memory allocation - Singleton
	private static Logger logger;

	// private constructor - cannot create object outside the class
	private LoggerUtility() {
	}

	public static Logger getLogger(Class<?> clazz) {
		if (logger == null) {
			logger = LogManager.getLogger(clazz);
		}
		return logger;
	} 
}
 