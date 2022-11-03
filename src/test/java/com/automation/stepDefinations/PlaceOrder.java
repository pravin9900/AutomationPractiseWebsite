package com.automation.stepDefinations;

import java.io.IOException;
import java.time.Duration;

import com.automation.configuration.TestConfig;
import com.automation.dataReader.ReadFile;
import com.automation.drivers.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.HeaderPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.OrderHistoryPage;
import com.automation.pages.PaymentPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceOrder extends TestConfig {
	HeaderPage headerPage;
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	PaymentPage paymentPage;
	OrderHistoryPage orderHistoryPage;

	@Given("open chrome driver browser and launch the automation practise url")
	public void open_chrome_driver_browser_and_launch_the_automation_practise_url() {
		System.setProperty("webdriver.chrome.driver", "Browser drivers//chromedriver.exe");
		BaseTest.getDriver().get(ReadFile.readPropertiesFile("Url"));
		BaseTest.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("I clicked on signin button")
	public void i_clicked_on_signin_button() throws Exception {
		headerPage = new HeaderPage(BaseTest.getDriver());
		headerPage.clickOnSignIn();
	}

	@When("I entered Login credentials and clicked on login button")
	public void i_entered_login_credentials_and_clicked_on_login_button() throws Exception {
		loginPage = new LoginPage(BaseTest.getDriver());
		loginPage.enterLoginDetails(ReadFile.readPropertiesFile("email"), ReadFile.readPropertiesFile("password"));
		loginPage.clickOnSignIn();
	}

	@When("I entered productName in search box and clicked on search button")
	public void i_entered_product_name_in_search_box_and_clicked_on_search_button() {
		homePage = new HomePage(BaseTest.getDriver());
		try {
			homePage.searchProduct(ReadFile.readPropertiesFile("productName"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("I added product to the cart")
	public void i_added_product_to_the_cart() {
		try {
			homePage.addProductToCart();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("I Checked out the product")
	public void i_checked_out_the_product() throws Exception {
		Thread.sleep(4000);
		homePage.clickOnCheckoutBtn();
		cartPage = new CartPage(BaseTest.getDriver());
		cartPage.clickOnCheckout();
		cartPage.clickOnCheckout();
		cartPage.clickOnCheckBox();
		cartPage.clickOnProceedToCheckOut();
	}

	@When("I completed the payment")
	public void i_completed_the_payment() {
		paymentPage = new PaymentPage(BaseTest.getDriver());
		paymentPage.confirmPayment();
	}

	@Then("I stored the order conformation ID into excel workbook")
	public void i_stored_the_order_conformation_id_into_excel_workbook() throws IOException {
		orderHistoryPage = new OrderHistoryPage(BaseTest.getDriver());
		orderHistoryPage.getOrderDetails();
	}

	@Then("I clicked on sign out button")
	public void i_clicked_on_sign_out_button() {
		try {
			//headerPage.clickOnSignOut();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
