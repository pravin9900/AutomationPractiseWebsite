package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.Utility.SeleniumWebElements;
import com.automation.configuration.PageConfiguration;

public class PaymentPage extends PageConfiguration {

	@FindBy(xpath = "//a[contains(text() ,'Pay by bank wire')]")
	private WebElement paymentMethod;

	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	private WebElement confirmOrder;

	@FindBy(xpath = "//a[text()='Back to orders']")
	private WebElement backToOrder;

	public PaymentPage(WebDriver driver) {
		super(driver);
		pageFactoryInitialize(this);
	}
	
	public void confirmPayment()
	{
		try {
		SeleniumWebElements.clickOnElement(paymentMethod);
		SeleniumWebElements.clickOnElement(confirmOrder);
		SeleniumWebElements.clickOnElement(backToOrder);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
