package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass{

	@FindBy(xpath = "//span[text()='I confirm my order']")
	private WebElement confirmOrder;
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver(), this);
	}
	
	public OrderConfirmationPage clickOnconfirmOrder() {
		confirmOrder.click();
		return new OrderConfirmationPage();
	}
}
