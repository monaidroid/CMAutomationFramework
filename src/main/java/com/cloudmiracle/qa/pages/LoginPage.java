package com.cloudmiracle.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cloudmiracle.qa.base.TestBase;
import com.cloudmiracle.qa.utility.TestUtil;

public class LoginPage extends TestBase
{
	//Define Page Factory - Object Repository(OR) for Login Page..
	@FindBy(xpath="//img[contains(@class,'login_img1')]")
	WebElement cmpLogo;
	@FindBy(xpath="//body[contains(@class,'login-page l_bgImg')]")
	WebElement bgImg;
	@FindBy(xpath="//div[contains(@class,'login-box')]//a")
	WebElement loginPgCaption;
	@FindBy(xpath="//div[contains(@id,'loginDiv')]//p")
	WebElement signUPText;
	@FindBy(xpath="//a[contains(text(),'Sign up')]")
	WebElement signUp;
	
	@FindBy(name="txtUserName")
	WebElement userName;
	@FindBy(name="txtPassword")
	WebElement password;
	@FindBy(xpath="//input[@name='btnSubmit']")
	WebElement signInBtn;
	@FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
	WebElement forgotPWD;
	@FindBy(xpath="//label[contains(@id,'lblErrorMsg')]")
	WebElement errorMsg;
	
	

	
	
	// initializing Page objects using initElements () method
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions to perform...
	public String validateLoginPageTile()
	{
		return driver.getTitle();
	}
	public boolean validateLogoImg()
	{
		return cmpLogo.isDisplayed();
	}
	public boolean validateBackgroundImg()
	{
		return bgImg.isDisplayed();
	}
	public String validateLoginPageCaption()
	{
		return loginPgCaption.getText();
	}
	public boolean validateSignUpLink()
	{
		return signUp.isDisplayed();	
	}
	public boolean validateSignUpLinkEnable() 
	{
		return signUp.isEnabled();
	}
	public String validateSignUpText()
	{
		return signUPText.getText();	
	}
	public SignUpPage validateSignUPLinkFunctionality() throws InterruptedException
	{
		signUp.click();
		Thread.sleep(3000);
		return new SignUpPage();
	}
	public boolean validateForgotPWDLink()
	{
		return forgotPWD.isDisplayed();	
	}
	public boolean validateForgotPWDLinkEnable() 
	{
		return forgotPWD.isEnabled();
	}
	public void validateForgotPWDLinkFunctionality()
	{
		forgotPWD.click();
	}
	public boolean validateSigninBtn()
	{
		return signInBtn.isEnabled();
	}
	public CompanyListPage validateLoginFunctionality(String un, String pwd)
	{
		userName.sendKeys(un);
		password.sendKeys(pwd);
		signInBtn.click();
		return new CompanyListPage();		
	}
	public boolean validateErrorMsg()
	{
		TestUtil.waitVisibleElement(driver, errorMsg);
		System.out.println(errorMsg.getText());
		/*
		if (errorMsg.getText().equalsIgnoreCase("Invalid Login Id Or Password"))
		{
			System.out.println(errorMsg.getText());
		}
		else if (errorMsg.getText().equalsIgnoreCase("Invalid Login Id"))
		{
			System.out.println(errorMsg.getText());
		}
		else
		{
			System.out.println(errorMsg.getText());
		}*/
		return errorMsg.isEnabled();
		
	}	
	
	
}
