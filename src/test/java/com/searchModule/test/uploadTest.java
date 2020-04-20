package com.searchModule.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newtours.test.BaseTest;
import com.searchModule.pages.fileUpload;

import org.testng.Assert;

public class uploadTest extends BaseTest{

	private String toUpload;
	
	public uploadTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test(enabled=true)
	@Parameters({"toUpload"})
	public void initialize(String toUpload)
	{
		this.toUpload=toUpload;
	}
	
	@Test(enabled=true, dependsOnMethods="initialize")
	public void upload()
	{
		fileUpload sp = new fileUpload(driver);
		sp.goToURL();
		
		//String path = new File("/src/test/java/ss.png").getAbsolutePath(); // project pic  file location
		//String path = "./src/test/java/ss.png";
		
		sp.startUpload(toUpload);
		
		boolean status= sp.checkUpload();
		System.out.println("upload status----"+status);
		
		if (status== true)
			Assert.assertTrue(true,"file uploaded successfully");
		else
			Assert.assertTrue(false, "file upload failed");
	}

}
