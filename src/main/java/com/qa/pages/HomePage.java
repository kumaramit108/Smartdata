package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	//OR - Object repository
	
	@FindBy(xpath = "//input[@title='Search']")
	WebElement serch_box;
	
	@FindBy(xpath = "//span[contains(text(),'java')]")
	List<WebElement> search_text;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void enterSearchText(String text){
		serch_box.sendKeys(text);
		int size = search_text.size();
		
		//Click through ID 
		System.out.println(size);
		search_text.get(1).click();
		
		//Click through name
		/*for(int i = 1; i <=size ; i++){
		System.out.println(search_text.get(i).getText());
		if(search_text.get(i).getText().equals("javascript")){
			search_text.get(i).click();
			break;
		}	
	 }*/
		
	}
}
