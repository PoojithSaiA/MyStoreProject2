package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	
	@FindBy(xpath = "//span[text()='Order confirmation']")
	private WebElement confirmOrder;

	public OrderConfirmationPage() {
		PageFactory.initElements(driver(), this);
	}
	
	public String validateOrderConfirmation() {
		return confirmOrder.getText();
	}
	

}
