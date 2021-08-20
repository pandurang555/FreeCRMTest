package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
 
	//Page Factory - OR :
		@FindBy(xpath= "//*[@id=\"top-header-menu\"]/div[1]")
		WebElement crmLogo;
		
		@FindBy(className= "user-display")
		WebElement userNamelabel;
		
		@FindBy(xpath= "//*[@id=\"main-nav\"]/div[3]/a/span")
		WebElement contactsLink;
		
		@FindBy(xpath= "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
		WebElement CreateNewContactLink;
		
		@FindBy(xpath= "//*[@id=\"main-nav\"]/div[4]/a/span")
		WebElement companiesLink;
		
		@FindBy(xpath= "//*[@id=\"main-nav\"]/div[5]/a/span")
		WebElement dealsLink;
		
		@FindBy(linkText= "https://ui.cogmento.com/tasks")
		WebElement tasksLink;



     //Initializing the Page Objects : 
	   public HomePage() {
		
		PageFactory.initElements(driver, this);
		
	   }
	
	 // Actions :  
	   
    public boolean verifyHomePagecrmLogo() {
			  return crmLogo.isDisplayed();
			}  
	   
	
	public String verifyHomePageTitle() {
	  return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		 return userNamelabel.isDisplayed();
		}
		
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public CompaniesPage clickOnCompaniesLink() {
		companiesLink.click();
		return new CompaniesPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		contactsLink.click();
		//Actions action = new Actions(driver);
		//action.moveToElement(contactsLink).build().perform();
		CreateNewContactLink.click();
	}
	
	
	
	
	
	
	
	
}	
	