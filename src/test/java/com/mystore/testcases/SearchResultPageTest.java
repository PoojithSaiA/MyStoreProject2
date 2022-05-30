package com.mystore.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	
	IndexPage ip;
	LoginPage lp;
	AccountCreationPage acp;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"smoke","sanity","regression"})
	public void setUP(String browser) {
		lauchAPP(browser);
	}

	@AfterMethod(groups = {"smoke","sanity","regression"})
	public void tearDown() {
		driver().quit();
	}
	
	@Test(groups = "smoke")
	public void validateProduct() {
		ip=new IndexPage();
		SearchResultPage srp= ip.searchProduct("t-shirt");
		boolean flag=srp.validateItem();
		Assert.assertTrue(flag);
	}
	
	

}
