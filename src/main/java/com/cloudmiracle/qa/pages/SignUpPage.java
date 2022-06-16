package com.cloudmiracle.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cloudmiracle.qa.base.TestBase;


public class SignUpPage extends TestBase
{	
	//Page Factory..
	@FindBy(xpath="//img[contains(@class,'login_img1')]")
	WebElement cmpLogo;
	@FindBy(xpath="//body[contains(@class,'login-page l_bgImg')]")
	WebElement bgImg;
	@FindBy(xpath="//div[@class='login-box']//a[contains(text(),'Sign Up')]")
	WebElement signUpPgCaption;
	@FindBy(xpath="//div[contains(@id,'signUpDiv')]//p")
	WebElement loginText;
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement loginLink;
	
	@FindBy(xpath="//input[contains(@name,'txtSUserName')]")
	WebElement signUpUserName;
	@FindBy(xpath="//input[contains(@name,'txtSLoginId')]")
	WebElement signUpLoginId;
	@FindBy(xpath="//input[contains(@name,'txtSPassword')]")
	WebElement signUpPWD;
	@FindBy(xpath="//input[contains(@name,'txtCPassword')]")
	WebElement signUpConfPWD;
	@FindBy(xpath="//input[contains(@name,'txtSEmail')]")
	WebElement signUpEmail;
	@FindBy(xpath="//input[contains(@name,'txtSMobile')]")
	WebElement signUpMob;
	@FindBy(xpath="//input[contains(@name,'btnRegister')]")
	WebElement registerBtn;
	
	@FindBy(xpath="//label[contains(@id,'lblSignUpErr')]")
	WebElement signUpError;
	
	// initializing Page objects using initElements () method
	public SignUpPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Action to Perform...
	public String validateSignUpPageCaption()
	{
		return signUpPgCaption.getText();
	}
	
	public boolean validateLoginLink()
	{
		return loginLink.isDisplayed();
	}
	
	public boolean validateLoginLinkEnable()
	{
		return loginLink.isEnabled();
	}
	
	public LoginPage validateLoginLinkFunctionality()
	{
		loginLink.click();
		return new LoginPage();
	}
	
	public String validateLoginText()
	{
		return loginText.getText();	
	}
	
	public LoginPage validateRegisterFunctionality(String un, String logId, String pwd, String email, String mob)
	{
		signUpUserName.sendKeys(un);
		signUpLoginId.sendKeys(logId);
		signUpPWD.sendKeys(pwd);
		signUpConfPWD.sendKeys(pwd);
		signUpEmail.sendKeys(email);
		signUpMob.sendKeys(mob);
		registerBtn.click();
		return new LoginPage();		
	}
	
	public boolean validateErrorMsg()
	{
		if (signUpError.getText().equalsIgnoreCase("Login Id already exist, Enter Another Id"))
		{
			System.out.println(signUpError.getText());
		}
		else if(signUpError.getText().equalsIgnoreCase("Mobile Number already exist, Enter Another Number"))
		{
			System.out.println(signUpError.getText());
		}
		else if(signUpError.getText().equalsIgnoreCase("Email Id already exist, Enter Another Id."))
		{
			System.out.println(signUpError.getText());
		}
		else
		{
			System.out.println(signUpError.getText());
		}
		return signUpError.isDisplayed();
	}
	
	
}
