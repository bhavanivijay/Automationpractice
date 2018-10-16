package com.app.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.app.pages.DresspageObjects;
import com.app.pages.HomepageObjects;
import com.app.pages.ProductdetailsObjects;

public class ProductdetailsTests 
{

	
	ProductdetailsObjects Pdetails;
	HomepageObjects homepage;
	DresspageObjects dresspage;
	
	
	
	public ProductdetailsTests()
	{
		Pdetails = new ProductdetailsObjects();
		homepage = new HomepageObjects();
		dresspage = new DresspageObjects();
		
	}
	

	/***Verify Tweet, Share & descriptions are displayed in product details page***/
	@Test
	public void verifyproductdispaly() 
	{
		homepage.ClickDressestab();
		dresspage.selectdress();
		
		Assert.assertTrue(Pdetails.PrDesDisplay(), "Failed: Product description not displayed");
		Assert.assertTrue(Pdetails.PrTweetDisplay(), "Failed: Tweet not displayed");
		Assert.assertTrue(Pdetails.PrShareDisplay(), "Failed: share description not displayed");
		//Pdetails.ClosePopup();
		
	}
	
}