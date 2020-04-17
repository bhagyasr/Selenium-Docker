package com.newtours.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.newtours.pages.FindFlightPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.RegistrationConfirmation;

import org.testng.Assert;


public class BookFlightTest extends BaseTest{

	private String noOfPassengers;
	private String expectedPrice;
	
	public BookFlightTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	@Parameters({"noOfPassengers", "expectedPrice"})
	public void setUp(String noOfPassengers, String expectedPrice)
	{
		this.noOfPassengers=noOfPassengers;
		this.expectedPrice=expectedPrice;
		
	}
	
	@Test(dependsOnMethods="setUp")
	public void RegistrationPage()
	{
		com.newtours.pages.RegistrationPage rp= new com.newtours.pages.RegistrationPage(driver);
		rp.goTo();
		rp.enterUserDetails("bhagya", "Nimm");
		rp.enterUserCredentials("bhagya", "Nimm");
		rp.submit();
	}
	
	@Test(dependsOnMethods="RegistrationPage")
	public void registrationConfirmationPage()
	{
		com.newtours.pages.RegistrationConfirmation rc= new RegistrationConfirmation(driver);
		rc.confirm();
	}
	
	@Test(dependsOnMethods="registrationConfirmationPage")
	public void flightDetailsPage()
	{
		FlightDetailsPage fp = new FlightDetailsPage(driver);
		fp.selectPassengers(noOfPassengers);
		fp.goToFindFlights();	
	}
	
	@Test(dependsOnMethods="flightDetailsPage")
	public void findFlightPage()
	{
		FindFlightPage ff = new FindFlightPage(driver);
		ff.submitByPage();
		ff.securePurchase();
	}
	
	@Test(dependsOnMethods="findFlightPage")
	public void flightConfirmationPage()
	{
		FlightConfirmationPage fcp = new FlightConfirmationPage(driver);
		String actualPrice=fcp.printConfirmation();
		Assert.assertEquals(expectedPrice, actualPrice);
	}
	
	
}
