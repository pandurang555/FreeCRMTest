package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - OR :
	@FindBy(name= "email")
	WebElement username;
	
	@FindBy(name= "password")
	WebElement password;
	
	@FindBy(xpath= "//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement loginBtn;
	
	@FindBy(xpath= "//*[@id=\"ui\"]/div/div/div[1]")
	WebElement ForgotPwdLink;
	 
	// Initializing the Page Objects : 
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	// Actions :  
	
	public String validateLoginPageTitle() {
	  return driver.getTitle();
	}
	
	public boolean validateFPLink() {
		return ForgotPwdLink.isDisplayed();
   }
   
	public HomePage login(String un, String pwd) {
	
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
	
	
	
	
	
}	
	