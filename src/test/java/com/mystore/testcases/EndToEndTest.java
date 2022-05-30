package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.utility.Log;

public class EndToEndTest extends BaseClass{
	
	IndexPage ip;
	LoginPage lp;
	AccountCreationPage acp;
	SearchResultPage srp;
	AddToCartPage atcp;
	OrderPage op;
	AddressPage ap;
	ShippingPage sp;
	PaymentPage pp;
	OrderSummaryPage osp;
	OrderConfirmationPage ocp;
	
	
	@Parameters("browser")
	@BeforeMethod(groups = {"smoke","sanity","regression"})
	public void setUP(String browser) {
		lauchAPP(browser);
	}
	@AfterMethod(groups = {"smoke","sanity","regression"})
	public void tearDown() {
		driver().quit();
	}
	
	
	@Test(groups = "regression",dataProvider = "credentials",dataProviderClass = DataProviders.class)
	public void endtoEnd(String uname,String pass) {
		Log.startTestCase("endtoEnd");
		ip=new IndexPage();
		srp= ip.searchProduct("t-shirt");
		Log.info("searching product t-shirt");
		atcp= srp.clickOnItem();
		Log.info("click on item");
		op= atcp.addProductToCart();
		Log.info("product added to cart");
		LoginPage lp= op.clickOnCheckout();
		//ap= lp.login1(pro.getProperty("username"), pro.getProperty("password"));
		ap= lp.login1(uname,pass);
		sp= ap.clickOnproceedToCheckout();
		sp.acceptTerms();
		pp= sp.clickOnproceedtoCheckout();
		osp= pp.clickOnpaymentMethod();
		ocp= osp.clickOnconfirmOrder();
		Log.info("clicked on order confirmation");
		String Confirmation=ocp.validateOrderConfirmation();
		Assert.assertEquals(Confirmation, "Order confirmation");
		Log.endTestCase("endToEnd");;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
