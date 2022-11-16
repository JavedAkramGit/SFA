package com.SFA.Utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	
	public static FileInputStream inputstream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public String getCellValue( String filename, String Sheetname, int rowno, int cellnum)
	
	{
		try
		{
		
		inputstream = new FileInputStream(filename);
		workbook = new XSSFWorkbook(inputstream);
		sheet = workbook.getSheet(Sheetname);
		cell = sheet.getRow(rowno).getCell(cellnum);
	    
	
	
	   workbook.close();
	   
	   return cell.getStringCellValue();
		
		
		
		
		
		}
		catch(Exception e)
		{
			return "";
		}
	}
	
public int getrowcount( String filename, String Sheetname)
	
	{
		try
		{
		
		inputstream = new FileInputStream(filename);
		workbook = new XSSFWorkbook(inputstream);
		sheet = workbook.getSheet(Sheetname);
		int ttlrows = sheet.getLastRowNum()+1;
	    
	
	
	   workbook.close();
	   
	   return ttlrows;
		
		
		
		
		
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	
public int getcolcount( String filename, String Sheetname)

{
	try
	{
	
	inputstream = new FileInputStream(filename);
	workbook = new XSSFWorkbook(inputstream);
	sheet = workbook.getSheet(Sheetname);
	int ttlcells = sheet.getRow(0).getLastCellNum();
    


   workbook.close();
   
   return ttlcells;
	
	
	
	
	
	}
	catch(Exception e)
	{
		return 0;
	}
}

	
	
	
	
}
