package com.cloudmiracle.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.cloudmiracle.qa.base.TestBase;
import com.cloudmiracle.qa.pages.CompanyListPage;
import com.cloudmiracle.qa.pages.LoginPage;
import com.cloudmiracle.qa.pages.SignUpPage;
import com.cloudmiracle.qa.utility.TestUtil;

public class SignUpPageTestCases extends TestBase
{
	LoginPage loginPage;
	SignUpPage signUpPage;
	CompanyListPage cmpListPage;
	String sheetName = "Signup";
	
	public SignUpPageTestCases()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		driverInitialize();
		signUpPage = new SignUpPage();
		loginPage = new LoginPage();
		signUpPage = loginPage.validateSignUPLinkFunctionality();
		//cmpListPage = loginPage.validateLoginFunctionality(prop.getProperty("uname"), prop.getProperty("pwd"));
	}
	
	@Test(priority = 1)
	public void verifyCmpLogoImg() 
	{
		boolean flag = loginPage.validateLogoImg();
		Assert.assertTrue(flag, "Company Logo doesn't exists!!!");
	}
	
	@Test(priority=2)
	public void verifyBackgroundImg()
	{
		boolean flag = loginPage.validateBackgroundImg();
		Assert.assertTrue(flag, "Background image doesn't exists!!!");
	}
	
	@Test(priority=3)
	public void verifySignUpPageCaption()
	{
		String actSignUpPgCaption = signUpPage.validateSignUpPageCaption();
		String expSignUpPgCaption = "Sign Up";
		Assert.assertEquals(actSignUpPgCaption, expSignUpPgCaption, "SignUp Page caption doesn't matched !!!");
	}
	
	@Test(priority=4)
	public void verifyLoginLink()
	{
		boolean flag = signUpPage.validateLoginLink();
		Assert.assertTrue(flag,"Login link doesn't exists!");
	}
	@Test(priority=5)
	public void verifyLoginLinkEnable()
	{
		boolean flag = signUpPage.validateLoginLinkEnable();
		Assert.assertTrue(flag,"Login link doesn't enabled!");
	}
	@Test(priority=6)
	public void verifyLoginText()
	{
		String actLoginTxt = signUpPage.validateLoginText();
		String expLoginTxt = "Already have an account? Login";
		Assert.assertEquals(actLoginTxt, expLoginTxt, "Login text doesn't matched !!!");
	}
	
	@DataProvider
	public Object[][] getSignupTestData()
	{
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=7 , dataProvider = "getSignupTestData")
	public void verifyRegisterFunctionality(String uname, String logId, String pwd, String email, String mob)
	{
		loginPage = signUpPage.validateRegisterFunctionality(uname, logId, pwd, email, mob);
		boolean flag = signUpPage.validateErrorMsg();
		System.out.println(flag);
		Assert.assertTrue(flag,"Register Successfully!");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
