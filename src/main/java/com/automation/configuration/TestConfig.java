package com.automation.configuration;

import org.openqa.selenium.WebDriver;
import com.automation.drivers.BaseTest;

public class TestConfig {

	public WebDriver selenium() {
		return BaseTest.getDriver();
	}

}
