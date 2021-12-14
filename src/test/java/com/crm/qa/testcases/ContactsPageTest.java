package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	
	//constructor
	public ContactsPageTest(){
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
			testUtil.switchToFrame();
			contactsPage = homePage.clickOnContactsLink();
			
		}
		
		
		@Test(priority=1)
		public void verifyContactsPageLableTest() {
			Assert.assertTrue(contactsPage.verifyContactsLabel(),"contact label is missing on the page");
		}
		
		@Test(priority=2)
		public void selectSingleContactsTest() {
			contactsPage.selectContactsByName("test fdgfgf testq");
			//ignore assertion in this way
		}
		
		@Test(priority=3)
		public void selectMultipleContactsTest() {
			contactsPage.selectContactsByName("test fdgfgf testq");
			contactsPage.selectContactsByName("Vera Bali Balin");
			//ignore assertion in this way
	
		}
		
		
		@DataProvider
		public Object[][] getCRMTestData() {
			Object data[][] = TestUtil.getTestData(sheetName);     //getTestData from TestUtil.java
			return data;
		}
		
		
//		@Test(priority=4, dataProvider="getCRMTestData")
//		public void validateCreateNewContact(String title, String firstName, String lastName, String company) {        // 4 columns in excel
//			homePage.clickOnContactsLink();
//			//contactsPage.createNewContact("Mr.","Tom","Peter","Google");  //<----dont need, get from Excel !!!
//			contactsPage.createNewContact(title, firstName, lastName, company); 		
//		}
		
		
		
		
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
}
