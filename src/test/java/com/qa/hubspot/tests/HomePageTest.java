package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {
	
	public BasePage basepage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	
	
	@BeforeMethod
	public void setUp(){
		basepage = new BasePage();
		driver = basepage.init_driver();
		prop = basepage.init_prop();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title=homePage.verifyHomePageTitle();
		System.out.println("Home Page title is" +title);
		Assert.assertEquals(title,Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyHomePageHeaderTest(){
		String header = homePage.verifyHomePageHeader();
		System.out.println("Home Page header is :" +header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void verifyAccountNameTest(){
		String accountName = homePage.verifyAccountName();
		System.out.println("Logged In Account Name is:" +accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
