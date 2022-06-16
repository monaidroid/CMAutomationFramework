package com.cloudmiracle.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.cloudmiracle.qa.base.TestBase;
import com.cloudmiracle.qa.pages.CompanyListPage;
import com.cloudmiracle.qa.pages.LoginPage;
import com.cloudmiracle.qa.utility.TestUtil;


public class CompanyListPageTestcases extends TestBase
{
	CompanyListPage cmpListPage;
	LoginPage loginPage;
	String sheetName = "AddNewCompany";
	
	public CompanyListPageTestcases() 
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driverInitialize();
		loginPage = new LoginPage();
		cmpListPage = new CompanyListPage();
		cmpListPage = loginPage.validateLoginFunctionality(prop.getProperty("uname"), prop.getProperty("pwd"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitWait_Timeout, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void verifyTimeLeftElement()
	{
		boolean flag  = cmpListPage.validateTimeLeftElement();
		Assert.assertTrue(flag,"Time Left Option doesn't enabled!");
	}
	@Test(priority=2)
	public void verifyUserNameElement()
	{
		boolean flag = cmpListPage.validateUserNameElement();
		Assert.assertTrue(flag, "User Name element doesn't exists in Company List Page!");
	}
	@Test(priority=4)
	public void verifyCmpListPageCaption()
	{
		String actTitle = cmpListPage.validateCmpListPageCaption();
		String expTitle = "Company List";
		Assert.assertEquals(actTitle, expTitle,"Company List Page Caption doesn't matched!");
	}
	@Test(priority=5)
	public void verifySearchElement()
	{
		boolean flag = cmpListPage.validateSearchElement();
		Assert.assertTrue(flag,"Search box doesn't exists!");
	}
	@Test(priority=6)
	public void verifyCmpListTableHeader() 
	{
		String actHeader = cmpListPage.validateCmpListTableHeader();
		String expHeader = "No.\n"
				+ "Company Name";
		Assert.assertEquals(actHeader, expHeader,"Company List table header doesn't matched!");
	}
	@Test(priority=7)
	public void verifyCmpListTableContent() 
	{
		cmpListPage.validateCmpListTableContent();
	}
	@Test(priority=8)
	public void verifyCmpListPageSizeElement() 
	{
		cmpListPage.validateCmpListPageSizeElement();
	}
	@Test(priority=9)
	public void verifyCmpListTotalPages() 
	{
		cmpListPage.validateCmpListTotalPages();
	}
	@Test(priority=10)
	public void verifyCmpListAllButtonsElement() 
	{
		cmpListPage.validateCmpListAllButtonsElement();
		
	}
	@Test(priority=11)
	public void verifyAddBtnFunctionality() 
	{
		String actNewCmpHeader = cmpListPage.validateAddBtnFunctionality();
		String expNewCmpHeader = "New Company";
		Assert.assertEquals(actNewCmpHeader, expNewCmpHeader,"New Company window header doesn't matched!");
	}
	@Test(priority=12)
	public void verifyEditBtnFunctionality() 
	{
		String actEditCmpHeader = cmpListPage.validateEditBtnFunctionality();
		String expEditCmpHeader = "Edit Company";
		Assert.assertEquals(actEditCmpHeader, expEditCmpHeader, "Edit Company window header doesn't matched!");
	}
	@Test(priority=13)
	public void verifyDeleteBtnFunctionality() 
	{
		String actDeleteHeader = cmpListPage.validateDeleteBtnFunctionality();
		String expDeleteHeader = "Confirm Delete";
		Assert.assertEquals(actDeleteHeader, expDeleteHeader,"Delete Confirmation window header doesn't matched!");
	}
	@Test(priority=14)
	public void verifyCmpDetailsAllTabElements() 
	{
		cmpListPage.validateCmpDetailsAllTabElements();
	}
	@Test(priority=15)
	public void verifyCmpDetailsLegendsElements() 
	{
		cmpListPage.validateCmpDetailsLegendsElements();
	}
	@Test(priority=16)
	public void verifyCmpDetailsAllButtonsElements() 
	{
		cmpListPage.validateCmpDetailsAllButtonsElements();
	}
	@Test(priority=17)
	public void verifyCloseBtnElement() 
	{
		cmpListPage.validateCloseBtnElement();
	}
	@DataProvider
	public Object[][] getAddNewCompanyDetails() 
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;	
	}
	@Test(priority=18, dataProvider = "getAddNewCompanyDetails")
	public void verifytoAddNewCompanyDetailsFunctionality(String cmpNo, String cmpName, String cmpSNm, String cmpRH1, String cmpRH2) 
	{
		cmpListPage.validateAddNewCompanyDetailsFunctionality(cmpNo, cmpName, cmpSNm, cmpRH1, cmpRH2);
	}
	@Test(priority=3)
	public void verifyLogoutElement() 
	{
		boolean flag = cmpListPage.validateLogoutElement();
		Assert.assertTrue(flag, "LogOut Option doesn't exists!");
	}
	@Test(priority = 19)
	public void verifyLogoutFunctionality()
	{
		loginPage = cmpListPage.validateLogoutFunctionality();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
