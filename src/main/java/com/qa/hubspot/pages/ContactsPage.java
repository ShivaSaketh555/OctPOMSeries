package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage extends BasePage{
	
	@FindBy(xpath = "//span[contains(text(),'Create contact')]")
	WebElement createContactBtn;
	
	@FindBy(xpath = "//input[@data-field='email']")
	WebElement emailBtn;
	
	@FindBy(xpath = "//input[@data-field='firstname']")
	WebElement firstNameBtn;
	
	@FindBy(xpath = "//input[@data-field='lastname']")
	WebElement lastNameBtn;
	
	@FindBy(xpath = "//input[@data-field='jobtitle']")
	WebElement jobTitle;
	
	@FindBy(xpath = "//span/span[contains(text(),'Create contact')]")
	WebElement createSecondContactBtn;
	
	public ContactsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String emailVal, String firstname, String lastname, String jobtitle){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(createContactBtn));
		createContactBtn.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(emailBtn));
		emailBtn.sendKeys(emailVal);
		
		wait.until(ExpectedConditions.elementToBeClickable(firstNameBtn));
		firstNameBtn.sendKeys(firstname);
		
		wait.until(ExpectedConditions.elementToBeClickable(lastNameBtn));
		lastNameBtn.sendKeys(lastname);
		
		wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
		jobTitle.sendKeys(jobtitle);
		
		//wait.until(ExpectedConditions.visibilityOf(createSecondContactBtn));
		//createSecondContactBtn.click();
	}
}
