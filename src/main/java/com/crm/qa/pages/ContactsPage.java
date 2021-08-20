package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase{

	//Page Factory - OR :
	
			@FindBy(xpath= "//div[text()='Contacts']")
			WebElement contactsLabel;
			
			@FindBy(xpath= "//button[@class='ui linkedin button']")
			WebElement saveBtn;
			
			@FindBy(name= "first_name")
			WebElement firstName;
			
			@FindBy(name= "last_name")
			WebElement lastName;
			
			@FindBy(name= "middle_name")
			WebElement middleName;
			
			
   //Initializing the Page Objects : 
			
			public ContactsPage() {
				
				PageFactory.initElements(driver, this);
				
			   }
			
	//Actions:
			
		public boolean verifyContactsLabel() {
			
			return contactsLabel.isDisplayed();
		}
		
		public void selectContactsByName(String name) {
			WebElement checkBox = driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//input[@name='id']"));
			//To resolve ElementClickInterceptedException following two lines are added//
			//Exception occurs when the target element that you want to click is overlaid by some other element in the web page.//
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", checkBox);
			
		}
		
		public void createNewContact(String ftName, String mdName, String ltName) {
			firstName.sendKeys(ftName);
			middleName.sendKeys(mdName);
			lastName.sendKeys(ltName);
			saveBtn.click();
			}
		
		}

