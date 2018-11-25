package com.qa.hubspot.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.hubspot.util.Constants;



public class BasePage {
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver init_driver(){
		
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		return driver;
		
	}

	public Properties init_prop(){
		prop= new Properties();
		try {
			FileInputStream ip= new FileInputStream("D:\\Testing Practice\\OctPOMSeries\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
		    
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
