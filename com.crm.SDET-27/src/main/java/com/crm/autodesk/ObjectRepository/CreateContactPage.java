package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{

	@FindBy(xpath="//input[@name='lastname']")
	private WebElement contactNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement contactSaveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgLookUpImgInCreateContact;
	
	@FindBy(name="search_text")
	private WebElement orgSearchTextEdt;
	
	@FindBy(name="search")
	private WebElement orgSearchBtn;
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactNameEdt() {
		return contactNameEdt;
	}

	public WebElement getContactSaveBtn() {
		return contactSaveBtn;
	}
	
	
	//business libraries
	
	public WebElement getSelectOrgInCreateContact() {
		return selectOrgLookUpImgInCreateContact;
	}

	public void createContact(String contactName)
	{
		contactNameEdt.sendKeys(contactName);
		contactSaveBtn.click();
	}
	
	public void createContact(WebDriver driver,String contactName,String orgName)
	{
		contactNameEdt.sendKeys(contactName);
		selectOrgLookUpImgInCreateContact.click();
		switchToWindow(driver, "Accounts");
		orgSearchTextEdt.sendKeys(orgName);
		orgSearchBtn.click();
		driver.findElement(By.linkText(orgName)).click();
		switchToWindow(driver, "Contacts");
		contactSaveBtn.click();
	}
	
	
	
}
