package com.syntax.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReview {
	
	@Test
	public void readExcel() throws IOException {
	String xlPath = "src/test/resources/testdata/OrangeHrmData.xlsx";
	
	FileInputStream fis = new FileInputStream(xlPath);
	//open workbook
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
	//open specified sheet
	XSSFSheet sheet = workbook.getSheet("EmployeeDetails");
	//access value of specified cell
	String value = sheet.getRow(6).getCell(0).toString();
	System.out.println(value);
	
	//get number of rows and columns 
	int rows = sheet.getPhysicalNumberOfRows();
	int cols = sheet.getRow(0).getLastCellNum();
	System.out.println("Number of rows is "+rows+" and ccolumns is "+cols);
	
	//get value from each cell 1 by 1
	for (int a=0; a<rows; a++) {
		
		
		for (int b=0; b<cols; b++) {
			String cellValue = sheet.getRow(0).getCell(b).toString();
			System.out.println(cellValue);
		}
	}
	//close workbook and stream 
	workbook.close();
	fis.close();
	
	}
}