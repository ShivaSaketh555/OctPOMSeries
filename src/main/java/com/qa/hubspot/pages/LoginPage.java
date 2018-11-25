package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	@FindBy(id = "username")
	WebElement username;
    
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "loginBtn")
	WebElement loginBtn;
	
	@FindBy(xpath= "//a/i18n-string[contains(text(),'Forgot my password')]")
	WebElement ForgetPasswordLink;
	
	@FindBy(xpath = "//span[contains(text(),'Show Password')]")
	WebElement ShowPassswordLink;
	
	
	@FindBy(xpath = "//i18n-string[contains(text(),'Sign up')]")
	WebElement SignUpLink;
	
	@FindBy(xpath = "//span[contains(text(),'Sign in with Google')]")
	WebElement SignInWithGoogle;
	
	@FindBy(xpath = "//i18n-string[contains(text(),'Log in with SSO')]")
	WebElement LoginSSO;
	
	@FindBy(xpath = "//i18n-string[contains(text(),'All Rights Reserved.')]")
	WebElement Rights;
	
	@FindBy(xpath = "//i18n-string[contains(text(),'Privacy Policy')]")
	WebElement Privacypolicy;
	
	public LoginPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyForgetMyPasswordLink(){
		return ForgetPasswordLink.isDisplayed();
		
	}
	
	public boolean showpwd(){
		return ShowPassswordLink.isDisplayed();
	}
	
	public boolean verifySignUp(){
		return SignUpLink.isDisplayed();
	}
	
	public boolean verifySignInWithGoogle(){
		return SignInWithGoogle.isDisplayed();
	}
	
	public boolean verifyLoginSSO(){
		return LoginSSO.isDisplayed();
	}
	
	public boolean verifyRightstext(){
		return Rights.isDisplayed();
	}
	
	public boolean verifyPrivacyPolicy(){
		return Privacypolicy.isDisplayed();
	}
	public HomePage doLogin(String usn, String pwd){
		username.sendKeys(usn);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage(driver);
	}
	
	
}
