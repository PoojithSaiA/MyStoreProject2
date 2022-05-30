package com.mystore.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;
import com.mystore.driveractions.Action;

public class AddToCartPage extends BaseClass{
	
	@FindBy(xpath = "//i[@class='icon-plus']")
	private WebElement quantity;
	
	@FindBy(xpath = "//select[@name='group_1']")
	private WebElement size;
	
	@FindBy(xpath = "//a[@id='color_14']")
	private WebElement color;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckout;
	
	public AddToCartPage() {
		PageFactory.initElements(driver(), this);
	}
	
	public OrderPage addProductToCart() {
		quantity.click();
		Action.selectByIndex(size, 1);
		Action.fluentWait(driver(), addToCartBtn, 20);
		addToCartBtn.click();
		Action.fluentWait(driver(), proceedToCheckout, 20);
		JavascriptExecutor js=(JavascriptExecutor) driver();
		js.executeScript("arguments[0].click", proceedToCheckout);
		return new OrderPage();
	}
	
	public boolean validateproceedToCheckout() {
		return proceedToCheckout.isDisplayed();
	}
	
	

}
