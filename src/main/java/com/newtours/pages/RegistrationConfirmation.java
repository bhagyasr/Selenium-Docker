package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmation {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//driver.findElement(By.)

	@FindBy(linkText="sign-in")
	private WebElement signLink;
	
	@FindBy(linkText="Flights")
	private WebElement flight;
	
	public RegistrationConfirmation(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		wait= new WebDriverWait(this.driver, 10);
		PageFactory.initElements(this.driver, this);
	
	}
	
	public void confirm()
	{
		wait.until(ExpectedConditions.visibilityOf(signLink));
		flight.click();
	}

}
