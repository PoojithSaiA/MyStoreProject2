package com.mystore.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	
	IndexPage ip;
	LoginPage lp;
	AccountCreationPage acp;
	SearchResultPage srp;
	AddToCartPage atcp;
	OrderPage op;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"smoke","sanity","regression"})
	public void setUP(String browser) {
		lauchAPP(browser);
	}

	@AfterMethod(groups = {"smoke","sanity","regression"})
	public void tearDown() {
		driver().quit();
	}
	
	@Test(groups = "regression")
	public void addToCart() {
		ip=new IndexPage();
		srp= ip.searchProduct("t-shirt");
		atcp= srp.clickOnItem();
		op= atcp.addProductToCart();
		double unitPrice=op.getUnitPrice();
		double totalPrice=op.getTotalPrice();
		double expectedPrice=(unitPrice*2)+2;
		Assert.assertEquals(totalPrice, expectedPrice);
		
		
		
	
		
	}

}
