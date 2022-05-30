package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailAdderss;
	
	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement password;
	
	@FindBy(xpath = "//a[text()='Forgot your password?']")
	private WebElement forgotPassword;
	
	@FindBy(xpath = "//span/i[@class='icon-lock left']")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//input[@id='email_create']")
	private WebElement createAccountEmail;
	
	
	@FindBy(xpath = "//span/i[@class='icon-user left']")
	private WebElement createAccountBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver(), this);
	}
	
	public HomePage login(String email,String pass) {
		emailAdderss.clear();
		emailAdderss.sendKeys(email);
		password.clear();
		password.sendKeys(pass);
		signInBtn.click();
		return new HomePage();
		
		
	}
	
	public AddressPage login1(String email,String pass) {
		emailAdderss.clear();
		emailAdderss.sendKeys(email);
		password.clear();
		password.sendKeys(pass);
		signInBtn.click();
		return new AddressPage();		
	}
	
	
	public AccountCreationPage createAccount(String email) {
		createAccountEmail.clear();
		createAccountEmail.sendKeys(email);
		createAccountBtn.click();
		
		return new AccountCreationPage();
	}
	
	
	
	
}
