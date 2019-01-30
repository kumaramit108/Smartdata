package com.qa.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.utility.TestUtil;

public class SearchPageTest extends TestBase{
	
	HomePage home;

	public SearchPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		home = new HomePage();	
	}
	
	@Test
	public void searchText(){
		String excel = "D:\\Selenium Projects\\SmartDataTest\\src\\main\\java\\com\\qa\\testdata\\TestData.xlsx";
	    String Sheet = "Sheet1";
	    int rowCount = TestUtil.getRowCount(excel, Sheet);
	    for (int i=1; i <= rowCount; i++)
	    {
	       String text = TestUtil.getCellValue(excel, Sheet, i, 0);
	       HomePage hp = new HomePage();
	       hp.enterSearchText(text);
	   }
	    
	   Reporter.log(TestUtil.getPageInnerText(driver), true);
	}
	
	@AfterMethod
	public void closeBrowser(){	
	driver.quit();
	}
}
