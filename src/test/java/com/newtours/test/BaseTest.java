package com.newtours.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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
			//dc.setCapability("version", "11");
	        //dc.setCapability("platform", Platform.MAC);
	        //dc.setCapability("platformName", "windows");
	       // dc.setCapability("video", "True");
	        dc.setCapability("ie.fileUploadDialogTimeout", 10000); // First time open of the internet explorer file upload dialog box is slow.
			
			if(System.getProperty("host")!=null)
			{
				host=System.getProperty("host");
			}
			
			 String URL="http://"+host+":"+"4444/wd/hub"; //port mapping of localhost 8080 to 4444 (selenium hub from docker hub) done
			
			 //String URL="http://"+host+":"+"8080/wd/hub";
				
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
			    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			    //driver.manage().window().maximize();
			
		}
		
		@AfterTest
		public void tearDown()
		{
			driver.quit();
		}
	

}
