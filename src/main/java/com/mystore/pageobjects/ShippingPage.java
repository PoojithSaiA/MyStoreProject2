package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	@FindBy(xpath = "//input[@name='cgv']")
	private WebElement terms;
	
	
	
	@FindBy(xpath = "//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedtoCheckout;
	
	public ShippingPage() {
		PageFactory.initElements(driver(), this);
	}
	
	public void acceptTerms() {
		terms.click();
	}
	public PaymentPage clickOnproceedtoCheckout() {
		proceedtoCheckout.click();
		return new PaymentPage();
	}

}
