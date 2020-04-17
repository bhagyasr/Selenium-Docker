package com.searchModule.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newtours.test.BaseTest;
import com.searchModule.pages.fileUpload;

import java.io.File;

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
		
		File uploadedFile = new File("./src/test/java/ss.png"); // project pic  file location
		//String path = System.getProperty("user.dir") +"/src/test/java/ss.png";
		
		sp.startUpload(uploadedFile.getAbsolutePath());
		
		boolean status= sp.checkUpload();
		System.out.println("upload status----"+status);
		
		if (status== true)
			Assert.assertTrue(true,"file uploaded successfully");
		else
			Assert.assertTrue(false, "file upload failed");
	}

}
