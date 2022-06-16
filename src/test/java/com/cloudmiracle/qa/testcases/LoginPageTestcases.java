package com.cloudmiracle.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cloudmiracle.qa.base.TestBase;
import com.cloudmiracle.qa.pages.CompanyListPage;
import com.cloudmiracle.qa.pages.LoginPage;
import com.cloudmiracle.qa.pages.SignUpPage;
import com.cloudmiracle.qa.utility.TestUtil;

public class LoginPageTestcases extends TestBase
{
	LoginPage loginPage;
	CompanyListPage cmpListPage;
	SignUpPage signUpPage;
	String sheetName = "Login";
	
	public LoginPageTestcases()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driverInitialize();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void verifyLoginPageTitle()
	{
		String actTitle = loginPage.validateLoginPageTile();
		String expTitle = "Miracle Accouting Software | Log in";
		Assert.assertEquals(actTitle, expTitle, "Login page title doesn't matched!!!");
	}
	@Test(priority = 2)
	public void verifyCmpLogoImg() 
	{
		boolean flag = loginPage.validateLogoImg();
		Assert.assertTrue(flag,"Company Logo doesn't exists!!!");
	}
	
	@Test(priority=3)
	public void verifyBackgroundImg()
	{
		boolean flag = loginPage.validateBackgroundImg();
		Assert.assertTrue(flag, "Background image doesn't exists!!!");
	}
	
	@Test(priority=4)
	public void verifyLoginPageCaption()
	{
		String actLogPgCaption = loginPage.validateLoginPageCaption();
		String expLogPgCaption = "Log in";
		Assert.assertEquals(actLogPgCaption, expLogPgCaption, "Login Page caption doesn't matched !!!");
		
	}
	
	@Test(priority=5)
	public void verifySignUpLink()
	{
		boolean flag = loginPage.validateSignUpLink();
		Assert.assertTrue(flag,"SignUp Link doesn't exists!!!");
	}
	@Test(priority=6)
	public void verifySignUpLinkEnable()
	{
		boolean flag = loginPage.validateSignUpLinkEnable();
		Assert.assertTrue(flag,"SignUp Link doesn't enable!!!");
	}
	
	@Test(priority=7)
	public void verifySignUPText()
	{
		String actSignUPTxt = loginPage.validateSignUpText();
		String expSignUPTxt = "Don't have an account? Sign up";
		Assert.assertEquals(actSignUPTxt, expSignUPTxt, "Sign UP text doesn't matched !!!");
	}
	@Test(priority=8)
	public void verifySignUPLinkFunctionality() throws InterruptedException
	{
		signUpPage = loginPage.validateSignUPLinkFunctionality();
	}
	
	@Test(priority=9)
	public void verifyForgetPWDLink()
	{
		boolean flag = loginPage.validateForgotPWDLink();
		Assert.assertTrue(flag,"Forgot Password Link doesn't exists!!!");
	}

	@Test(priority=10)
	public void verifyForgotPWDLinkEnable()
	{
		boolean flag = loginPage.validateForgotPWDLinkEnable();
		Assert.assertTrue(flag, "Forgot Password Link doesn't enable!!!");
	}
	@Test(priority=11)
	public void verifyForgotPWDLinkFunctionality()
	{
		loginPage.validateForgotPWDLinkFunctionality();
		/*
		boolean forgotMSGFlag = loginPage.validateErrorMsg();
		Assert.assertTrue(forgotMSGFlag,"Password unable to send in your e-mail!!!");
		*/
	}
	
	@DataProvider
	public Object[][] getLoginTestData()
	{
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=12, dataProvider = "getLoginTestData")
	public void verifyLoginFunctionality(String Uname, String pwd)
	{
		//Fetching values from Properties file, no need to Pass Arguments inside of Method
		//cmpListPage = loginPage.validateLoginFunctionality(prop.getProperty("uname"), prop.getProperty("pwd"));
		
		//Fetching values from Excel Files using arguments inside of method
		cmpListPage = loginPage.validateLoginFunctionality(Uname, pwd);	
		
		/*
		if (loginPage.validateErrorMsg())
		{
			System.out.println("Error Flag is : " + loginPage.validateErrorMsg());
			System.out.println("Login Failed!");
		}
		else if (cmpListPage.validateTimeLeftOption())
		{
			System.out.println("Time Flag is : " + cmpListPage.validateTimeLeftOption());
			System.out.println("Company List open!");
		}
		*/
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
