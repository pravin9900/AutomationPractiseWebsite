package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.Utility.SeleniumWebElements;
import com.automation.configuration.PageConfiguration;
 

public class HeaderPage extends PageConfiguration{
 
	@FindBy (xpath = "//a[contains(text(),'Sign in')]")
	private WebElement signIn_Btn ;
	
	@FindBy (xpath= "(//a[contains(text(),\"Sign out\")])[1]")
	private WebElement signOut_Btn ;
	
	public HeaderPage(WebDriver driver)
	{
		super(driver);
		pageFactoryInitialize(this);
	}
	
	public void clickOnSignIn() throws Exception {
		SeleniumWebElements.clickOnElement(signIn_Btn);
	}
	
	public void clickOnSignOut() throws Exception {
		SeleniumWebElements.clickOnElement(signOut_Btn);
	}
	
}
