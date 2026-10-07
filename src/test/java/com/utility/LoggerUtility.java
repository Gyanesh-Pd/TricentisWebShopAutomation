package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

	// Singleton - private constructor - cannot create object outside the class
	private LoggerUtility() {
	}

	public static Logger getLogger(Class<?> clazz) {
		Logger logger = LogManager.getLogger(clazz);
		return logger;
	}
}
