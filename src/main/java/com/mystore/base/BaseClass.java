package com.mystore.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.mystore.utility.ExtentManager;
import com.mystore.utility.Log;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties pro;
	
	//public static WebDriver driver;
	
	public static ThreadLocal<WebDriver> wdriver=new ThreadLocal<>();
	
	public static WebDriver driver() {
		return wdriver.get();
	}
	
	@BeforeSuite(groups = {"smoke","sanity","regression"})
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		pro=new Properties();
		try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\configurations\\config.properties");
			pro.load(fis);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		

	public static void lauchAPP(String browserName) {
		
		//String browserName=pro.getProperty("browser");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			wdriver.set(new ChromeDriver());
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			wdriver.set(new FirefoxDriver());
		}else {
			WebDriverManager.iedriver().setup();
			wdriver.set(new InternetExplorerDriver());
		}
		
		
		Log.info("Open Browser :"+browserName);
		driver().manage().window().maximize();
		Log.info("browser maximised");
		driver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver().get(pro.getProperty("url"));
		Log.info("getting url :"+pro.getProperty("url"));
		
	}
	@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
	public void afterSuite() {
		ExtentManager.endReport();
	}

}
