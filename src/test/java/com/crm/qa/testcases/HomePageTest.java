package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	
	//constructor
		public HomePageTest(){
			super();     // call super class constructor of ancestor TestBase : properties will be defined
			
		}
	
	//test cases should be SEPARATED -- INDEPENDENT with each other
	//before each test case  -- launch the browser
	//@test -- execute test case	
	//after -- close the browser	
		
	@BeforeMethod
	public void setUp() {
		initialization();              //from TestBase
	
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test(priority=1)
	public void verifyHomeTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Home page title not matched");
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		// testUtil.switchtoFrame();
		 Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	
	
	@Test(priority=3)
	public void verifyContacctsLinkTest() {
		contactsPage = homePage.clickOnContactsLink(); 
		
	
	}
	
		
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
