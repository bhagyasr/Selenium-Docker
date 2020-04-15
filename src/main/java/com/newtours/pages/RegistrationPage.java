package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="firstName")
	private WebElement firstName;
	
	@FindBy(name="lastName")
	private WebElement lastName;
	
	@FindBy(name="email")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="confirmPassword")
	private WebElement confirmPw;
	
	@FindBy(name="register")
	private WebElement submit;
	
	

	public RegistrationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		//constructor
		this.driver= driver;
		this.wait= new WebDriverWait(this.driver, 10); //Explicit wait initialization
		//This initElements method will create all WebElements
		PageFactory.initElements(this.driver, this);
		
	}
	
	public void goTo()
	{
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		wait.until(ExpectedConditions.visibilityOf(firstName));
	}
	
	public void enterUserDetails(String first, String last)
	{
		firstName.sendKeys(first);
		lastName.sendKeys(last);
	}
	
	public void enterUserCredentials(String user, String pw)
	{
		userName.sendKeys(user);
		password.sendKeys(pw);
		confirmPw.sendKeys(pw);
		
	}
	
	public void submit()
	{
		submit.click();
	}

}
