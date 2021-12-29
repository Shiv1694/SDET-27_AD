package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement contactSearchTextEdt;
	
	@FindBy(name="submit")
	private WebElement contactSearchNowBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactLookUpImg;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactSearchTextEdt() {
		return contactSearchTextEdt;
	}

	public WebElement getContactSearchNowBtn() {
		return contactSearchNowBtn;
	}

	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}
	
	public void clickOnCreateContactLookUpImg()
	{
		createContactLookUpImg.click();
	}
	
	
}
