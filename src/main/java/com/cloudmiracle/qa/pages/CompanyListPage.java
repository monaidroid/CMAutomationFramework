package com.cloudmiracle.qa.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cloudmiracle.qa.base.TestBase;
import com.cloudmiracle.qa.utility.TestUtil;

public class CompanyListPage extends TestBase
{
	static String searchValue;
	@FindBy(xpath="//nav//a[contains(@id,'time')]")
	WebElement timeLeft;
	@FindBy(xpath="//a[contains(@class,'dropdown-toggle')]//span")
	WebElement userName;
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	WebElement logOut;
	@FindBy(xpath="//div[contains(text(),'Company List')]")
	WebElement cmpListPgCaption;
	
	@FindBy(xpath="//div[contains(@class,'dx-texteditor-container')]//input")
	WebElement cmpSearchtxt;
	@FindAll (@FindBy(xpath = "//div[contains(@class,'dx-datagrid-headers')]//tr"))
	List<WebElement> cmpListTableHeader;
	@FindAll(@FindBy(xpath = "//div[@class='dx-datagrid-content']//td[2]"))
	List<WebElement> cmpListTableData;
	@FindAll(@FindBy(xpath = "//div[contains(@class,'dx-page-sizes')]//div"))
	List<WebElement> cmpListPageSizes;
	@FindAll(@FindBy(xpath = "//div[contains(@class,'dx-pages')]//div"))
	List<WebElement> cmpListPages;
	@FindAll(@FindBy(xpath = "//div[contains(@class,'dx-toolbar-before')]//span"))
	List<WebElement> cmpButtonsList;
	
	@FindBy(xpath = "//div[contains(text(),'New Company')]")
	WebElement newCompanyHeader;
	@FindBy(xpath = "//div[contains(text(),'Edit Company')]")
	WebElement editCompanyHeader;
	@FindBy(xpath = "//div[contains(text(),'Confirm Delete')]")
	WebElement deleteConfHeader;
	
	@FindAll(@FindBy(xpath = "//div[contains(@role,'tablist')]//span"))
	List<WebElement> cmpTabLists;
	@FindAll(@FindBy(xpath="//div[contains(@id,'cmpDetails')]//fieldset//legend"))
	List<WebElement> cmpDetailsLegends;
	@FindAll(@FindBy(xpath = "//div[@class='text-right']//span"))
	List<WebElement> cmpDetailsBtnList;
	@FindBy(xpath="//i[contains(@class,'dx-icon dx-icon-close')]")
	WebElement closeBtn;
	
	@FindBy(xpath="//input[contains(@aria-valuemin,'1')]")
	WebElement cmpNum;
	@FindBy(xpath = "//div[contains(@id,'txtNm')]//input")
	WebElement cmpName;
	@FindBy(xpath = "//div[contains(@id,'txtShortNm')]//input")
	WebElement cmpSName;
	@FindBy(xpath = "//div[contains(@id,'txtRHeader1')]//input")
	WebElement cmpReportHdr;
	@FindBy(xpath = "//div[contains(@id,'txtRHeader2')]//input")
	WebElement cmpReportHeader;
	
	
	public CompanyListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions to perform...
	public boolean validateTimeLeftElement()
	{
		TestUtil.waitVisibleElement(driver, timeLeft);
		boolean flag = timeLeft.isEnabled();
		return flag;
	}
	public boolean validateUserNameElement()
	{
		TestUtil.waitVisibleElements(driver, cmpListTableHeader);
		TestUtil.waitVisibleElement(driver, userName);
		System.out.println(userName.getText());
		return userName.isDisplayed();
	}
	public String validateCmpListPageCaption() 
	{
		TestUtil.waitVisibleElement(driver, cmpListPgCaption);
		return cmpListPgCaption.getText();
	}
	public boolean validateSearchElement() 
	{
		TestUtil.waitVisibleElement(driver, cmpSearchtxt);
		return cmpSearchtxt.isEnabled();
	}
	public String validateCmpListTableHeader() 
	{
		TestUtil.waitVisibleElements(driver, cmpListTableHeader);
		
		TestUtil.getTextValuesOfElements(cmpListTableHeader);
		return cmpListTableHeader.get(0).getText();
	}
	public void validateCmpListTableContent()
	{
		TestUtil.waitVisibleElements(driver, cmpListTableHeader);
		TestUtil.waitVisibleElements(driver, cmpListTableData);
		TestUtil.getTextValuesOfElements(cmpListTableData);
	}
	public void validateCmpListPageSizeElement() 
	{
		TestUtil.waitVisibleElements(driver, cmpListPageSizes);
		String msg = "Available Page size is: ";
		TestUtil.compareTextValuesOfElements(cmpListPageSizes, TestUtil.page_size, msg);
	}
	public void validateCmpListTotalPages() 
	{
		TestUtil.waitVisibleElements(driver, cmpListPages);
		for(int i = 0; i < cmpListPages.size(); i++)
		{
			String pgNum = String.valueOf(i);
			if(cmpListPages.get(i).getText().contains("Page"))
			{
				System.out.println(cmpListPages.get(i).getText());
			}
			else if(cmpListPages.get(i).getText().equalsIgnoreCase(pgNum))
			{
				System.out.println("Number of Page available is: " + cmpListPages.get(i).getText());
			}
		}	
	}
	public void validateCmpListAllButtonsElement() 
	{
		TestUtil.waitVisibleElements(driver, cmpButtonsList);
		TestUtil.getTextValuesOfElements(cmpButtonsList);	
	}
	
	public String validateAddBtnFunctionality() 
	{
		TestUtil.waitVisibleElements(driver, cmpButtonsList);
		TestUtil.getElement(cmpButtonsList, "Add");
		TestUtil.waitVisibleElement(driver, newCompanyHeader);
		return newCompanyHeader.getText();	
	}
	public void validateCmpDetailsAllTabElements() 
	{
		validateAddBtnFunctionality();
		TestUtil.waitVisibleElements(driver, cmpTabLists);
		TestUtil.getTextValuesOfElements(cmpTabLists);
	}
	public void validateCmpDetailsLegendsElements() 
	{
		validateAddBtnFunctionality();
		TestUtil.waitVisibleElements(driver, cmpDetailsLegends);
		TestUtil.getTextValuesOfElements(cmpDetailsLegends);
	}
	public void validateCmpDetailsAllButtonsElements() 
	{
		validateAddBtnFunctionality();
		TestUtil.waitVisibleElements(driver, cmpDetailsBtnList);
		TestUtil.getTextValuesOfElements(cmpDetailsBtnList);	
	}
	public void validateCloseBtnElement() 
	{
		validateAddBtnFunctionality();
		TestUtil.waitVisibleElement(driver, closeBtn);
		//closeBtn.click();
		//cmpSearchtxt.sendKeys("LTT");
	}
	public void validateAddNewCompanyDetailsFunctionality(String cmpNo, String cmpNm, String cmpSNm, String cmpRH1, String cmpRH2) 
	{
		validateAddBtnFunctionality();
		cmpNum.clear();
		cmpNum.sendKeys(cmpNo);
		cmpName.sendKeys(cmpNm);
		//TestUtil.getElement(cmpDetailsBtnList, "Next");
		//TestUtil.getElement(cmpDetailsBtnList, "Previous");
		cmpSName.sendKeys(cmpSNm);
		cmpReportHdr.sendKeys(cmpRH1);
		cmpReportHeader.sendKeys(cmpRH2);
		TestUtil.getElement(cmpDetailsBtnList, "Next");
		TestUtil.getElement(cmpDetailsBtnList, "Previous");
	}
	public String validateEditBtnFunctionality() 
	{
		TestUtil.waitVisibleElements(driver, cmpListTableData);
		searchValue = "NK";
		cmpSearchtxt.sendKeys(searchValue);
		TestUtil.waitVisibleElements(driver, cmpButtonsList);
		TestUtil.getElement(cmpButtonsList, "Edit");
		TestUtil.waitVisibleElement(driver, editCompanyHeader);
		return editCompanyHeader.getText();
	}
	
	public String validateDeleteBtnFunctionality() 
	{
		TestUtil.waitVisibleElements(driver, cmpListTableData);
		searchValue = "LTT";
		cmpSearchtxt.sendKeys(searchValue);
		TestUtil.waitVisibleElements(driver, cmpButtonsList);
		TestUtil.getElement(cmpButtonsList, "Delete");
		TestUtil.waitVisibleElement(driver, deleteConfHeader);
		return deleteConfHeader.getText();
	}
	public boolean validateLogoutElement() 
	{
		TestUtil.waitVisibleElement(driver, userName);
		userName.click();
		TestUtil.waitVisibleElement(driver, logOut);
		System.out.println(logOut.getText());
		return logOut.isEnabled();
	}
	public LoginPage validateLogoutFunctionality()
	{
		TestUtil.waitVisibleElement(driver, userName);
		userName.click();
		TestUtil.waitVisibleElement(driver, logOut);
		logOut.click();
		return new LoginPage();
		
	}
}
