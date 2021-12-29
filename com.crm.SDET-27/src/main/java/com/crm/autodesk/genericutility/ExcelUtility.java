package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * it is developed using Apachi POI libraries, which is used to handle Microsoft Excel Sheet
 * @author AJAY KUMAR S
 *
 */

public class ExcelUtility {
	
	/**
	 * it is used to fetch/read data from Excel based on below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */

	public String getDataFromExcel(String sheetName,int rowNum, int cellNum) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/compDetails.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		String data = row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	/**
	 * it is used to get the last used row number on specified sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/compDetails.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	/**
	 * it is used to enter the data into the Excel based on the arguments passed
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	
	public void setDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/compDetails.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(cellNum);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./data/compDetails.xlsx");
		wb.write(fos);
		wb.close();
	}
}
