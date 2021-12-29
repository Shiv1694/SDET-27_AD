package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author AJAY KUMAR S
 *
 */

public class FileUtility {
	
	/**
	 * it is used to fetch/read the data from properties file based on the key you passed as argument
	 * @param key
	 * @return
	 * @throws Throwable
	 */

	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/data.properties.txt");
		Properties pObj=new Properties();
		pObj.load(fis);
		
		String value=pObj.getProperty(key);
		return value;
	}
}
