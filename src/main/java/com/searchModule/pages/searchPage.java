package com.searchModule.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(id="search_form_input_homepage")
	private WebElement searchBar;
	
	@FindBy(linkText="Videos")
	private WebElement videos;
	
	@FindBy(xpath="//div[contains(@data-link,'https://www.youtube.com/watch?')]")
	private List<WebElement> videoLinks;
	
	public searchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.wait= new WebDriverWait(driver,15);
		PageFactory.initElements(this.driver, this);
	}
	
	public void goTo()
	{
		System.out.println("-------before----here----"+ driver.getTitle());
		driver.get("https://duckduckgo.com/");
	}
	
	public void search(String name)
	{
		wait.until(ExpectedConditions.visibilityOf(searchBar));
		searchBar.sendKeys(name,Keys.RETURN);
		//searchBar.sendKeys
	}

	public int findVideos()
	{
	    wait.until(ExpectedConditions.visibilityOf(videos));
		videos.click();
		By videoLink= By.xpath("//div[contains(@data-link,'https://www.youtube.com/watch?')]");
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(videoLink, 10));
		int size=videoLinks.size();
		System.out.println("No:of Videos returned" +size);
		
		return size;
		
		
	}
}
