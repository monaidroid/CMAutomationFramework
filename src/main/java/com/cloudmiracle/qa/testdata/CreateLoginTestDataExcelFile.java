package com.cloudmiracle.qa.testdata;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateLoginTestDataExcelFile 
{

	public static void main(String[] args) throws IOException 
	{
		// LoginTestData Excel Files Create using Script..
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Login");
		sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue("UName");
		sheet.getRow(0).createCell(1).setCellValue("PWD");
		
		sheet.createRow(1);
		sheet.getRow(1).createCell(0).setCellValue("sd");
		sheet.getRow(1).createCell(1).setCellValue("sd1");
		
		sheet.createRow(2);
		sheet.getRow(2).createCell(0).setCellValue("js");
		sheet.getRow(2).createCell(1).setCellValue("js1");
		
		
		File file = new File("./TestData.xlsx");
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		workbook.close();
	}

}
