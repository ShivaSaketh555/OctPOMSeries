package com.qa.hubspot.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.TestUtil;

public class HomePage extends BasePage{
	
	@FindBy(xpath = "//h1[contains(text(),'Sales Dashboard')]")
	WebElement Homepageheader;
	
	@FindBy(xpath = "//span[@class='account-name ']")
	WebElement useraccountName;
	
	@FindBy(xpath = "//a[@id='nav-primary-contacts-branch' and @data-tracking='click hover']")
	WebElement contactsTab;
	
	//@FindBy(xpath ="//a[@id='nav-primary-contacts-branch' and @data-tracking='click']")
	@FindBy(id = "nav-secondary-contacts")
	WebElement contactsLink;
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*public static void clickElementByJS(WebElement element, WebDriver driver){
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}*/
	
	public String verifyHomePageTitle(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleIs(Constants.HOME_PAGE_TITLE));
		return driver.getTitle();
	}
	
	public String verifyHomePageHeader(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(Homepageheader));
		return Homepageheader.getText();
	}
	
	public String verifyAccountName(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(useraccountName));
		return useraccountName.getText();
	}

	public ContactsPage goToContactsPage(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(contactsTab));
		contactsTab.click();
		
		TestUtil.normalWait();
		contactsLink.click();
		
		
		return new ContactsPage(driver);
		
	}
}
