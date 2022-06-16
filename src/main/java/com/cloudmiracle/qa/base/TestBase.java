package com.cloudmiracle.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloudmiracle.qa.utility.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("./src/main/java/com/cloudmiracle/qa/config/config.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	
	}
	
	public void driverInitialize()
	{
		System.out.println(prop.getProperty("browser"));
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("Webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		}
		else
		{
			System.out.println("Browser Name does not Found!!!");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitWait_Timeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		wait = new WebDriverWait(driver, TestUtil.explicitWait_Timeout);
	}

}
