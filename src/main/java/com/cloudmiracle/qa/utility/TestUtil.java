package com.cloudmiracle.qa.utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class TestUtil 
{
	public static long page_load_TimeOut = 40;
	public static long implicitWait_Timeout = 10;
	public static long explicitWait_Timeout = 40;
	
	static Workbook book;
	static Sheet sheet;
	public static String testData_File_Path = "./src/main/java/com/cloudmiracle/qa/testdata/TestData.xlsx";
	public static String page_size = "50";
	
	public static void waitVisibleElement(WebDriver driver, WebElement ele)
	{
		try
		{
			new WebDriverWait(driver,explicitWait_Timeout).until(ExpectedConditions.visibilityOf(ele));
		}
		catch(TimeoutException e)
		{
			e.printStackTrace();
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
	}

	public static void waitVisibleElements(WebDriver driver, List<WebElement> ele)
	{
		try
		{
			new WebDriverWait(driver,explicitWait_Timeout).until(ExpectedConditions.visibilityOfAllElements(ele));
		}
		catch(TimeoutException e)
		{
			e.printStackTrace();
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
	}
	public static void getTextValuesOfElements(List<WebElement> ele) 
	{
		System.out.println("------------------------");
		for(int i = 0; i < ele.size(); i++)
		{
			System.out.println(ele.get(i).getText());
		}
		System.out.println("------------------------");
	}
	public static void getElement(List<WebElement> ele, String value) 
	{
		for(int i = 0; i < ele.size(); i++)
		{
			if(ele.get(i).getText().equalsIgnoreCase(value))
			{
				ele.get(i).click();
				break;
			}
		}
	}
	public static void compareTextValuesOfElements(List<WebElement> ele, String value, String msg) 
	{
		for(int i = 0; i < ele.size(); i++)
		{
			System.out.println(msg + ele.get(i).getText());
			if(ele.get(i).getText().contains(value))
			{
				ele.get(i).click();
				break;
			}
		}
	}
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		try
		{
			file = new FileInputStream(testData_File_Path);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			book = WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i =0; i < sheet.getLastRowNum(); i++)
		{
			System.out.println("value of I "+ i);
			for(int k =0; k < sheet.getRow(0).getLastCellNum(); k++)
			{
				System.out.println("value of K" + k);
				//System.out.println(sheet.getRow(i+1).getCell(k).getCellType());
				//data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				//System.out.println(data[i][k]);
				if(sheet.getRow(i+1).getCell(k).getCellType()==CellType.STRING)
				{
					data[i][k] = sheet.getRow(i+1).getCell(k).getStringCellValue();
					System.out.println(data[i][k]);
				}
				else if(sheet.getRow(i+1).getCell(k).getCellType()==CellType.NUMERIC)
				{
					//data[i][k] = sheet.getRow(i+1).getCell(k).getNumericCellValue();
					DataFormatter df = new DataFormatter();
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(k));
					data[i][k] = value;
					System.out.println(data[i][k]);
				}
			}
		}
		return data;
		
	}
}
