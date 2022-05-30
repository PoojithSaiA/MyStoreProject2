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

public class AccountCreationPageTest extends BaseClass {
	
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
	
	@Test(groups = "sanity")
	public void accountCreation() {
		ip =new IndexPage();
		lp=ip.clickOnSignIn();
		acp= lp.createAccount("hjdjdm@gmail.com");
		boolean flag=acp.validateformTitle();
		Assert.assertTrue(flag);
		
	}

}
