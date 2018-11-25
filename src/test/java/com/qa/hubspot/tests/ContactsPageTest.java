package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.TestUtil;

public class ContactsPageTest {
	public BasePage basepage;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage; 
	public ContactsPage contactspage;
	
	
	@BeforeMethod
	public void setUp(){
		basepage = new BasePage();
		driver = basepage.init_driver();
		prop = basepage.init_prop();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homePage.goToContactsPage();
	}

	
	@DataProvider(name = "getContactsTestData")
	public Object[][] getContactsTestData(){
		return TestUtil.getTestData("contacts");
	}
	
	@Test(dataProvider = "getContactsTestData")
	public void createContactTest(String emailId, String firstName, String lastName, String jobTitle){
		contactspage.createNewContact(emailId, firstName, lastName, jobTitle);
		
	}
	
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
