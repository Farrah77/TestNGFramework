package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriteDemo {
	
	@Test
	public void writeExcel() throws Exception  {
	String xlPath = "src/test/resources/testdata/OrangeHrmData.xlsx";
	
	FileInputStream fis = new FileInputStream(xlPath);
	//open workbook and sheet
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
	XSSFSheet sheet = workbook.getSheet("EmployeeDetailsWrite");
	
	//write some values 
	//row is existing, so we just add column cell to it. 
	sheet.getRow(0).createCell(4).setCellValue("Result"); 
	
	sheet.getRow(1).createCell(4).setCellValue("Pass");//we write 
	sheet.getRow(1).getCell(4).setCellValue("Fail");   //we re-write to another value
	//adding row and value to first cell
	sheet.createRow(11).createCell(0).setCellValue("Anne");
	
	//write to excel
	FileOutputStream fos = new FileOutputStream(xlPath);
	workbook.write(fos);
	//close file and get streams open 
	fos.close();
	workbook.close();
	fis.close();
			
	
	}

}
