package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {
// Reads properties file	

	public static String readProperties(Env env, String propertyName) {
		
		Properties properties = new Properties();
		
		File propFile = new File(System.getProperty("user.dir") + File.separator + "config" + File.separator + env + ".properties");

		try (FileReader fileReader = new FileReader(propFile)) {
	        properties.load(fileReader);
	    }
		catch (FileNotFoundException e) {
	        throw new RuntimeException("Config file not found for environment '" + env + "' at path: " + propFile.getAbsolutePath(), e);
	    }
		catch (IOException e) {
	        throw new RuntimeException("Failed to read property file at: " + propFile.getAbsolutePath(), e);
	    }
		
		String value = properties.getProperty(propertyName.toUpperCase());
		return value;
		
	}
}