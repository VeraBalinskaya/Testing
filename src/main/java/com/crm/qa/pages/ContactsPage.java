package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
//	@FindBy(id="")
//	WebElement firstName;
//	
//	@FindBy(id="")
//	WebElement lastName;
//	
		//constructor
		//Initialize the Page Objects:
		public ContactsPage() {
			PageFactory.initElements(driver, this);  //initialise page factory, this - current class object		
													// instead this can be LoginPage class
		}

		
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td"
				+ "//preceding-sibling::td//input[@name='id']")).click();
		
	}
	
//	public void createNewContact(String title, String ftName, String ltName, String comp) {
//		Select select = new Select(driver.findElement(By.name("title"))); 
//		select.selectByVisibleText(title);
//	
//	    firstName.sendKeys(ftName);
//	    lastName.sendKeys(ltName);
//	    company.sendKeys(comp);
//	    saveBtn.click();   
//	}
	
	

}
