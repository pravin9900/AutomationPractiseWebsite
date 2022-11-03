package com.automation.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.configuration.PageConfiguration;
import com.automation.dataReader.ReadFile;

public class OrderHistoryPage extends PageConfiguration{

	 WebDriver driver ;
	public OrderHistoryPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver ;
		pageFactoryInitialize(this);
	}
	
	public void getOrderDetails() throws IOException
	{
		List<WebElement> listOfOrder = driver.findElements(By.xpath("//a[@class='color-myaccount']"));
		for(int i=1;i<listOfOrder.size();i++)
		{
			String orderID = driver.findElement(By.xpath("(//a[@class='color-myaccount'])["+i+"]")).getText();
			String date = driver.findElement(By.xpath("(//td[@class='history_date bold'])["+i+"]")).getText();
			System.out.println(orderID+"\t"+date);
			ReadFile.writeIntoExcelFile(i, orderID, date);
		}
	}
	
}
