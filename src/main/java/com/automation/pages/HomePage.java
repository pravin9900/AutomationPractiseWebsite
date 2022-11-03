package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.Utility.SeleniumWebElements;
import com.automation.configuration.PageConfiguration;

public class HomePage extends PageConfiguration {

	@FindBy(id = "search_query_top")
	private WebElement search_txt;

	@FindBy(name = "submit_search")
	private WebElement search_btn;

	@FindBy(xpath = "(//div[@class ='product-image-container'])[1]")
	private WebElement product;

	@FindBy(xpath = "(//span[text()='Add to cart'])[1]")
	private WebElement addToCart_btn;

	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	private WebElement checkout_btn;

	public HomePage(WebDriver driver) {
		super(driver);
		pageFactoryInitialize(this);
	}

	public void searchProduct(String productName) throws Exception {
		SeleniumWebElements.enterInputIntoElement(search_txt, productName);
		SeleniumWebElements.clickOnElement(search_btn);
	}

	public void addProductToCart() throws Exception {
		SeleniumWebElements.moveToElement(product);
		SeleniumWebElements.clickOnElement(addToCart_btn);
	}

	public void clickOnCheckoutBtn() throws Exception {
		SeleniumWebElements.clickByJavascript(checkout_btn);;
	}
}
