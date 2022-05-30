package com.mystore.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"smoke","sanity","regression"})
	public void setUP(String browser) {
		lauchAPP(browser);
	}

	
	@AfterMethod(groups = {"smoke","sanity","regression"})
	public void tearDown() {
		driver().close();
	}
	
	@Test(groups = {"smoke","sanity"})
	public void userLogin() {
		ip=new IndexPage();
		lp=ip.clickOnSignIn();
		hp=lp.login(pro.getProperty("username"), pro.getProperty("password"));
		boolean flag=hp.validateOrderHistory();
		Assert.assertTrue(flag);
		
	}
	
	

}
