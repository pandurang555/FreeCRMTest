package com.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

public class ContactsPageTest extends TestBase{
    TestUtil testUtil;
	LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    
    String sheetName = "contacts";
    
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil= new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactsTest() {
		contactsPage.selectContactsByName("Dadasaheb Dhone");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws Throwable {
	  Object data[][] = TestUtil.getTestData(sheetName);
	  return data;
		
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstName, String middleName, String lastName) {
		homePage.clickOnContactsLink();
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Rajesh", "Ramrao", "Patil");//
		contactsPage.createNewContact(firstName, middleName, lastName);
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
