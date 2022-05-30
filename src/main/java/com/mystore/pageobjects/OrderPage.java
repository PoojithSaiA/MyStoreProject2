package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{
	
	@FindBy(xpath = "//span/span[@class='price']")
	private WebElement unitPrize;
	
	@FindBy(xpath = "//span[@id='total_price']")
	private WebElement totalPrice;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckout;
	
	public OrderPage() {
		PageFactory.initElements(driver(), this);
	}
	
	public double getUnitPrice() {
		String unit=unitPrize.getText();
		String price=unit.replaceAll("[^a-zA-Z0-9]", "");
		double finalPrice=Double.parseDouble(price);
		return finalPrice/100;
	}
	
	public double getTotalPrice() {
		String unit=totalPrice.getText();
		String price=unit.replaceAll("[^a-zA-Z0-9]", "");
		double finalPrice=Double.parseDouble(price);
		return finalPrice/100;
	}
	
	public LoginPage clickOnCheckout() {
		
		proceedToCheckout.click();
		return new LoginPage();
	}

}
