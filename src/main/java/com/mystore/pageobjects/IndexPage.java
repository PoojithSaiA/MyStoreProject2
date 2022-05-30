package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	@FindBy(xpath = "//a[@class='login']")
	private WebElement signInbtn;
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//button[@name='submit_search']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;
	
	public IndexPage() {
		PageFactory.initElements(driver(), this);
	}
	
	public LoginPage clickOnSignIn() {
		signInbtn.click();
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return myStoreLogo.isDisplayed();
	}
	
	public String getMyStoreTitle() {
		return driver().getTitle();
	}
	
	public SearchResultPage searchProduct(String productName) {
		searchBox.sendKeys(productName);
		searchBtn.click();
		return new SearchResultPage();
	}

}




