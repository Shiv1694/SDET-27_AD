package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility{

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrganizationLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;
	
	//initialize all elements by constructor
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization

	public WebElement getCreateOrganizationLookUpImg() {
		return createOrganizationLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	//buisness libraries
	
	public void clickOnCreateOrganization()
	{
		createOrganizationLookUpImg.click();
	}
	
	
}
