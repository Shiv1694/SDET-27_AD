package com.crm.autodesk.Contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateContactTest extends BaseClass {

		@Test
		public void createContTest() throws Throwable {
		int random = jLib.getRandomNum();
		String contctName = eLib.getDataFromExcel("Sheet1", 1, 0)+ random;//read data from excel
		//WebDriver driver;
		wLib.waitForPageToLoad(driver);
		
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		
		//navigate to Contacts Page
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		
		//create new contact
		CreateContactPage newContact=new CreateContactPage(driver);
		newContact.createContact(contctName);
		
		}

}
