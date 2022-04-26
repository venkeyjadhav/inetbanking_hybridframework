package com.inetbanking.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	static XSSFWorkbook wb;
	 public ExcelDataProvider(String fname) {
	try {
		File fs = new File(fname);
	   FileInputStream fins = new FileInputStream(fs);
	   wb =new XSSFWorkbook(fins);
	} catch (Exception e) {
		e.printStackTrace();
	}
		 
	}
	 
	 public String getStringcellValue(String sheetname,int row,int column) {
		 
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	 }
	 
	 public String getStringcellValue(int sheetindex,int row,int column) {
		 
			return wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
		 }
	 public int getNumericCellValue(String sheetname,int row,int column) {
		 
			return (int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
		 }
	 public int getNumericCellValue(int sheetindex,int row,int column) {
		 
			return (int) wb.getSheetAt(sheetindex).getRow(row).getCell(column).getNumericCellValue();
		 }
	 public Object[][] getExcelTestData(String sheetname) {
		 
		XSSFSheet sheet = wb.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		short colcount = sheet.getRow(0).getLastCellNum();
		
		System.out.println("total row count : "+rowcount);
		System.out.println("total col count : "+colcount);
		
		Object[][] data =new Object[rowcount][colcount];
		
		for(int i=0;i<rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	 }

}
