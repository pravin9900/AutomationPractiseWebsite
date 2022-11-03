package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.Utility.SeleniumWebElements;
import com.automation.configuration.PageConfiguration;

public class CartPage extends PageConfiguration {

	WebDriver driver ;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	private WebElement checkout_btn;

	@FindBy(xpath = "//input[@id='cgv']")
	private WebElement termsCheckbox;
	
	@FindBy (xpath = "//button[@name='processCarrier']")
	private WebElement proceedToCheckOut ;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver ;
		pageFactoryInitialize(this);
	}
	public void clickOnCheckout()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(checkout_btn));
			SeleniumWebElements.clickByJavascript(checkout_btn);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnCheckBox()
	{
		try {
			SeleniumWebElements.clickOnElement(termsCheckbox);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnProceedToCheckOut()
	{
		SeleniumWebElements.clickByJavascript(proceedToCheckOut);
	}
}
