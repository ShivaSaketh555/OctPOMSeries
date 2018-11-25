package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class LoginTest {
	public BasePage basepage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(){
		basepage = new BasePage();
		driver = basepage.init_driver();
		prop = basepage.init_prop();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
	}
	
	
	@Test(priority=1)
	public void verifyLoginPageTitle(){
		String title = loginPage.getLoginPageTitle();
		System.out.println("Title of the Login Page is" +title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyForgetPassword(){
		Assert.assertTrue(loginPage.verifyForgetMyPasswordLink());
	}
	
	@Test(priority=3)
	public void verifyShowPassword(){
		Assert.assertTrue(loginPage.showpwd());
	}
	
	@Test(priority=4)
	public void verifySignUpTest(){
		Assert.assertTrue(loginPage.showpwd());
	}
	
	@Test(priority=5)
	public void verifySignInWithGoogleTest(){
		Assert.assertTrue(loginPage.verifySignInWithGoogle());
	}
	
	@Test(priority=6)
	public void verifyLoginSSOTest(){
		Assert.assertTrue(loginPage.verifyLoginSSO());
	}
	
	@Test(priority=7)
	public void verifyRightstextTest(){
		Assert.assertTrue(loginPage.verifyRightstext());
	}
	
	@Test(priority=8)
	public void verifyPrivacyPolicyTest(){
		Assert.assertTrue(loginPage.verifyPrivacyPolicy());
	}
	
	@Test(priority=9)
	public void loginTest(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

	
	

}
