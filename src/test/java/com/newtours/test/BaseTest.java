package com.newtours.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public BaseTest() 
	{
		// TODO Auto-generated constructor stub
    }
		
		protected WebDriver driver;
		
		
		
		@BeforeTest
		public void begin(ITestContext cntxt) throws MalformedURLException
		{
			String testName= cntxt.getCurrentXmlTest().getName();
			String host="localhost";
			DesiredCapabilities dc = DesiredCapabilities.chrome();
			
			if(System.getProperty("host")!=null)
			{
				host=System.getProperty("host");
			}
			
			String URL="http://"+host+":"+"4444/wd/hub"; //port mapping of localhost 8080 to 4444 (selenium hub from docker hub) done
				
			if (System.getProperty("Browser")!=null)
			{
				if(System.getProperty("Browser").equalsIgnoreCase("firefox"))
				{
					dc= DesiredCapabilities.firefox();
					//dc.setCapability("name", testName);
				    //driver= new RemoteWebDriver(new URL(URL),dc); //selenium grid
				    //driver.manage().window().maximize();
				}
			}
				
				dc.setCapability("name", testName);
			    driver= new RemoteWebDriver(new URL(URL),dc);
			    driver.manage().window().maximize();
			
		}
		
		@AfterTest
		public void tearDown()
		{
			driver.quit();
		}
	

}
