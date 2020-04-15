package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name="reserveFlights")
	private WebElement firstSubmit;
	
	@FindBy(name="buyFlights")
	private WebElement secondSubmit;
	
	public FindFlightPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
		this.wait= new WebDriverWait(this.driver, 10);
		PageFactory.initElements(this.driver, this);
	}
	
	public void submitByPage()
	{
		wait.until(ExpectedConditions.elementToBeClickable(firstSubmit));
		firstSubmit.click();
	}
	
	public void securePurchase()
	{
		wait.until(ExpectedConditions.elementToBeClickable(secondSubmit));
		secondSubmit.click();
	}
	

}
