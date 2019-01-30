package com.qa.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {

	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	
	//Excel Sheet
	 public static String getCellValue(String excel, String Sheet, int r, int c){
		 
		 try{
			 FileInputStream fis = new FileInputStream(excel);

             Workbook wb = WorkbookFactory.create(fis);

             Cell cell = wb.getSheet(Sheet).getRow(r).getCell(c);

              return cell.getStringCellValue();
			 
		 }
		 catch(Exception e){
			 
			 return " ";
		 }
	 }
   
	 public static int getRowCount (String excel, String Sheet){
		 
		 try{
			 FileInputStream fis = new FileInputStream(excel);

             Workbook wb = WorkbookFactory.create(fis);

             return wb.getSheet(Sheet).getLastRowNum();
		 }
		 catch(Exception e){
			 
			 return 0;
		 }
	 }

	 // Code for Inner text of the page 
	 
	 public static String getPageInnerText(WebDriver driver){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String pageText = js.executeScript("return document.documentElement.innerText;").toString();
			return pageText;
		}
}
