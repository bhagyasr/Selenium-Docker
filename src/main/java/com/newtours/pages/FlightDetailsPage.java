package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="passCount")
	private WebElement passengers;
	
	@FindBy(name="findFlights")
	private WebElement continueBtn;

	public FlightDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		wait= new WebDriverWait(this.driver,10);
		PageFactory.initElements(this.driver, this);
		
	}
	
	public void selectPassengers(String n)
	{
		wait.until(ExpectedConditions.elementToBeClickable(passengers));
		Select dropdown= new Select(passengers);
		dropdown.selectByValue(n);
	}
	
	public void goToFindFlights()
	{
		continueBtn.click();
	}

}
