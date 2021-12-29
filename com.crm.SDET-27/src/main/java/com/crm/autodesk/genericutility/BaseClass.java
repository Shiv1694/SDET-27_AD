package com.crm.autodesk.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;

public class BaseClass {

	public WebDriver driver;
	
	/* Create Objects to Libraries*/
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	
	@BeforeSuite(groups={"smokeSuite","RegressionSuite"})
	public void configBS() {
		System.out.println("connect to DB");
	}
	
	@BeforeClass(groups={"smokeSuite","RegressionSuite"})
	public void configBC() {
		System.out.println("=============Launch the Browser=======");
		driver = new ChromeDriver();
		wLib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod(groups={"smokeSuite","RegressionSuite"})
	public void configBM() throws Throwable {
		/*common Data*/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		/* Navigate to app*/
		   driver.get(URL);
	        /* step 1 : login */
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login(USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups={"smokeSuite","RegressionSuite"})
	public void configAM() {
	      /*step 6 : logout*/
		HomePage homePage = new HomePage(driver);
        homePage.logOut(driver);
	}
	
	@AfterClass(groups={"smokeSuite","RegressionSuite"})
	public void configAC() {
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}
	
	@AfterSuite(groups={"smokeSuite","RegressionSuite"})
	public void configAS() {
		System.out.println("========================close DB========================");
	}

	


}
