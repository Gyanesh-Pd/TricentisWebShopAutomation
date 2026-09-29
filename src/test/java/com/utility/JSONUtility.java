package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {

	public static String jsonReader(Env env) {

		Gson gson = new Gson();  //Using 3rd party lib to read json file
		File jsonFile = new File(System.getProperty("user.dir") + File.separator + "config" + File.separator + "config.json");
		FileReader fileReader = null;
		
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Config config = gson.fromJson(fileReader, Config.class);
		Environment environment = config.getEnvironments().get(env.toString());
		return environment.getUrl();
	}
}
