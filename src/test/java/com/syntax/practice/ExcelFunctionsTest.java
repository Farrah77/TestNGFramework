package com.syntax.practice;

import org.testng.annotations.Test;

import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class ExcelFunctionsTest {
	
	@Test
	public void excelTest() {
	
	ExcelUtility obj = new ExcelUtility();	
	obj.openExcel(Constants.XL_FILEPATH, "EmployeeDetails"); //we don't store sheetName as constant because it will be changing 
	//String value = obj.getCellData(0, 2);
	//System.out.println(value);
	
	//retrieve all values from excel and store into DataProdvider (2D Object array)
	
    int row = obj.getRowNum();
	int cell = obj.getColNum(0);
	
	Object [][] data = new Object [row][cell]; //number of row with number of cells on that row
	
	for (int i=0; i<row; i++) {
		for (int y = 0; y<cell; y++) {
		//retrieve value from excel 	
		String value = obj.getCellData(i, y); 
		//store value into row and cells inside 2D array
		data[i][y] = value;
		
		}
	}
	
	
	System.out.println(data.length); 
	
	}

}
