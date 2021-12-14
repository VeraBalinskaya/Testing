package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	//Page Factory - OR      //Page Library
	@FindBy(xpath="//div[@id='top-header-menu']//span[@class='user-display']")      //Vera Bali
	@CacheLookup    // store in cache memory, FASTER
	WebElement userNameLable;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="")
	WebElement newcontactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	
	//constructor
	//Initialize the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);  //initialise page factory, this - current class object		
												// instead this can be LoginPage class
	}

	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLable.isDisplayed();
	}
	
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();     //returns object
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newcontactsLink.click();
	}
	
	

}
