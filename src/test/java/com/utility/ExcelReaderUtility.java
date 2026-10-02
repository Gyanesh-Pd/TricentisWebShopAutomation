package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String filename) {

		File xlsxFile = new File(System.getProperty("user.dir") + "//testData//"+filename);
		
		XSSFWorkbook xssfWorkbook = null;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		List<User> userList = null;
		User user;
		Row row;
		Cell emailAddressCell, passwordCell;
		
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			xssfSheet = xssfWorkbook.getSheet("LoginDataSheet");
			rowIterator = xssfSheet.iterator();
			rowIterator.next(); 
			
			userList= new ArrayList<User>();
			
			while (rowIterator.hasNext()) 
			{
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				
				user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
			}
			xssfWorkbook.close();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}

		return userList.iterator();
	}
}
