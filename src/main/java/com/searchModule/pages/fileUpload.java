package com.searchModule.pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fileUpload {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//@FindBy(xpath="//span[@class='btn btn-success fileinput-button\']")
	//private WebElement addFiles;
	
	//@FindBy(xpath="//input[@type='file']")
	//private WebElement addFile;
	
	//@FindBy(name="Screen Shot 2020-01-20 at 6.37.24 PM.png")
	//private WebElement fileNameDisplay;
	
	//@FindBy(xpath="//button[@class='btn btn-primary start']")
	//private List<WebElement> uploadStart;
	
	//@FindBy(xpath="//button[@class='btn btn-danger delete']")
	//private List<WebElement> deleteButton;

	//@FindBy(linkText="Screen Shot 2020-03-18 at 4.32.13 PM.png")
	//private WebElement afterUploadLink;
	
	@FindBy(id="file-upload")
    private WebElement fileUpload;

    @FindBy(id="file-submit")
    private WebElement uploadBtn;

    @FindBy(id="uploaded-files")
    private WebElement uploadedFileName;
	
	public fileUpload(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.wait= new WebDriverWait(driver,15);
		PageFactory.initElements(this.driver, this);
	}
	
	public void goToURL()
	{
		driver.get("http://the-internet.herokuapp.com/upload");
	}
	
	public void startUpload(String path)
	{
		/*By addFiles= By.xpath("//span[@class='btn btn-success fileinput-button\']");
		wait.until(ExpectedConditions.presenceOfElementLocated(addFiles));
		
		 if(driver instanceof RemoteWebDriver){
	            ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
		//driver.findElement(By.xpath("//input[@type='file']"));
	    //addFile.setFileDetector(new LocalFileDetector());
	        }
		
		addFile.sendKeys(path);
		
		By upStart= By.xpath("//button[@class='btn btn-primary start']");
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(upStart,1));
		uploadStart.get(1).click();*/
		
		//if(driver instanceof RemoteWebDriver){
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("file-upload")));
		 
		try {
           // ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        //}
			
        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
    	String path1 = System.getProperty("user.dir")+new File("/ss.png").getAbsolutePath(); // project pic  file location
    	
        this.fileUpload.sendKeys(path1);
        this.uploadBtn.click();
        driver.getTitle();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
		}
		catch(Exception e)
		{
			 System.out.println("Exception returned--"+e);
		     e.printStackTrace();
		}
	}
	
	public boolean checkUpload()
	{
		//By uploadLink = By.linkText("Screen Shot 2020-03-18 at 4.32.13 PM.png");
		//wait.until(ExpectedConditions.presenceOfElementLocated(uploadLink));
		
		//if (afterUploadLink.isDisplayed())
		//	return true;
		//else
		//	return false;
		
		System.out.println("Uploaded file name---"+uploadedFileName.getText().trim());
		
		if(uploadedFileName.getText().trim().contains("ss"))
			return true;
		else
			return false;
		
	}

}
