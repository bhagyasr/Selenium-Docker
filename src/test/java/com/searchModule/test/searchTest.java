package com.searchModule.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newtours.test.BaseTest;
import com.searchModule.pages.searchPage;

import junit.framework.Assert;


public class searchTest extends BaseTest {

	private String toSearch;
	
	public searchTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	@Parameters({"toSearch"})
	public void initialize(String toSearch)
	{
		this.toSearch=toSearch;
	}
	
	@Test(dependsOnMethods="initialize")
	public void search()
	{
		searchPage sp = new searchPage(driver);
		System.out.println("-----here-----insearchtest"+driver.getTitle());
		sp.goTo();
		sp.search(toSearch);
		int size=sp.findVideos();
		Assert.assertTrue(size>0);
	}
	
	
	
}
