package com.crm.autodesk.Organisation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateOrgWithIndustryTest extends BaseClass{

		@Test
		public void createOrgWithIndustryTest() throws Throwable{
		int randomNum=jLib.getRandomNum();
		
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 2)+ randomNum;
		String industry = eLib.getDataFromExcel("Sheet1", 1, 3);
		String type = eLib.getDataFromExcel("Sheet1", 1, 4);
		
		//WebDriver driver;
		wLib.waitForPageToLoad(driver);
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganisationLink();
		
		OrganizationsPage oP=new OrganizationsPage(driver);
		oP.clickOnCreateOrganization();
		
		CreateOrganizationPage cOP=new CreateOrganizationPage(driver);
		cOP.createOrgWithIndus_Type(orgName, industry, type);
		
		OrganizationInfoPage oIP=new OrganizationInfoPage(driver);
		String actualorgname=oIP.getOrgInfo();
		
		/*if(actualorgname.contains(orgName))
		{
			System.out.println("org name is created");
		}else {
			System.out.println("failed to create org name");
		}*/
		
		
		}
		
}
