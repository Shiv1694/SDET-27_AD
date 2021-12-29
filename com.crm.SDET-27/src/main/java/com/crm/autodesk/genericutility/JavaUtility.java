package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;



/**
 * 
 * @author AJAY KUMAR S
 *
 */

public class JavaUtility {
	
	/**
	 * it is used to generate random number
	 * @return int data
	 */
	public int getRandomNum() {
		Random randomNum=new Random(10000);
		int intRandomNum = randomNum.nextInt();
		return intRandomNum;
	}
	
	/**
	 * it returns the system date and time in IST format
	 * @return
	 */
		
	public String getSystemDateAndTime() {
		Date date = new Date();
		return date.toString();
	}
	
	/**
	 * it is used to get the system date in YYYY-MM-DD format
	 * @return 
	 */
	
	public String getSystemDateWithFormat() {
		Date date=new Date();
		String dateAndTime=date.toString();
		
		String YYYY=dateAndTime.split(" ")[5];
		String DD=dateAndTime.split(" ")[2];
		int MM=date.getMonth()+1;
		
		String finalFormat= YYYY +"-"+ MM +"-"+"-"+DD;
		return finalFormat;
		
	}

}
