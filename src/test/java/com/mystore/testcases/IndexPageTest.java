package com.mystore.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage ip;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"smoke","sanity","regression"})
	public void setUP(String browser) {
		lauchAPP(browser);
	}
	
	@AfterMethod(groups = {"smoke","sanity","regression"})
	public void tearDown() {
		driver().close();
	}
	
	@Test(groups = "smoke")
	public void validatLogo() {
		 ip=new IndexPage();
		boolean flag= ip.validateLogo();
		 Assert.assertTrue(flag);
	}
	
	@Test(groups = "smoke")
	public void validatePageTitle() {
		String title=ip.getMyStoreTitle();
		Assert.assertEquals(title, "My Store");
	}

}
