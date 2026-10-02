package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.LoginData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider (name="LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider()
	{
		Gson gson = new Gson();
		File filePath = new File(System.getProperty("user.dir")+File.separator+"testData"+File.separator+"loginData.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		LoginData data = gson.fromJson(fileReader, LoginData.class);
		
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for(User user:data.getData())
		{
			dataToReturn.add(new Object[] {user});
		}
			return dataToReturn.iterator();
	}
	
	@DataProvider (name="LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider()
	{
		return CSVReaderUtility.readCSVFile("loginData.csv");
	}
	
	@DataProvider (name="LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider()
	{
		return ExcelReaderUtility.readExcelFile("loginData.xlsx");
	}
	
	
}
