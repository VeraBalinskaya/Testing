package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {
	
	//Page Factory - OR      //Page Library
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(xpath="//div[@id='ui']//following-sibling::input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//iframe[@id='rufous-sandbox']//preceding-sibling::iframe")
	WebElement password2;
	
	@FindBy(xpath="//span[@class ='icon icon-xs mdi-chart-bar']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//div[@class='rd-navbar-panel']")
	WebElement crmLogo;
	
	//constructor
	//Initialize the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);  //initialise page factory, this - current class object		
												// instead this can be LoginPage class
	}

	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
	
		loginBtn.click();
		username.sendKeys(un);	
		
		password.sendKeys(pwd);
		

		signUpBtn.click();
	
		return new HomePage();
		
	}
	

}
