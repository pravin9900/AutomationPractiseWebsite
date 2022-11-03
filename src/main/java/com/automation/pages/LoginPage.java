package com.automation.pages;
  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.Utility.SeleniumWebElements;
import com.automation.configuration.PageConfiguration;
 

public class LoginPage extends PageConfiguration {

	@FindBy (xpath = "//input[@id='email']")
	private WebElement email ;
	
	@FindBy (xpath = "//input[@id='passwd']")
	private WebElement password ;
	
	@FindBy (xpath = "//button[@id='SubmitLogin']")
	private WebElement signIn_Btn ;
	
	@FindBy (xpath = "//li[text()='Authentication failed.']")
	private WebElement errorMessage ;
	
	public LoginPage(WebDriver driver)
	{ 
		super(driver);
		pageFactoryInitialize(this);
	}
	
	public void enterLoginDetails(String  email1, String pass) throws Exception {
		SeleniumWebElements.enterInputIntoElement(email, email1);
		SeleniumWebElements.enterInputIntoElement(password, pass);
	}
	
	public void clickOnSignIn() throws Exception
	{
		SeleniumWebElements.clickOnElement(signIn_Btn);
	}
	
	public void validateErrorMessage()
	{
		String error = SeleniumWebElements.getTextOfElement(errorMessage);
		if(error.equalsIgnoreCase("Authentication failed."))
		{ 
			System.out.println("User unable to login to Automation Practise Website...");
		}
		
	}
}
