package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass{
	
	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement item;

	public SearchResultPage() {
		PageFactory.initElements(driver(), this);
	}
	
	public  boolean validateItem() {
		return item.isDisplayed();
		
	}
	
	public AddToCartPage clickOnItem() {
		item.click();
		return new AddToCartPage();
	}
	
	
}
