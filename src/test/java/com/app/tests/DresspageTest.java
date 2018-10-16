package com.app.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.app.pages.DresspageObjects;
import com.app.pages.HomepageObjects;

public class DresspageTest {

	HomepageObjects homepage;
	DresspageObjects dresspage;

	public DresspageTest() {
		homepage = new HomepageObjects();
		dresspage = new DresspageObjects();
	}

	/***Verify Respective Matching result count and product count is being displayed***/
	
	@BeforeMethod
	public void clickdress()
	{
		System.out.println("clicking dress tab");
		homepage.ClickDressestab();
	}
	
	@AfterClass
	public void closebrowser()
	{
		System.out.println("closing browser");
		dresspage.closebrowser();
	}
	
	
	@Test
	public void verifyproductcount()
	{
		//homepage.ClickDressestab();
		Assert.assertEquals(dresspage.getheaderproductCount(), dresspage.getTotalProducts(), "Failed: count mismatch");
	}

	/***Verify Size – L, M and S is displayed***/
	@Test
	public void verifysizeSMLdispaly()
	{
		//homepage.ClickDressestab();
		Assert.assertTrue(dresspage.sizeSdisplay(), "Failed:Size S not displayed");
		Assert.assertTrue(dresspage.sizeMdisplay(), "Failed:Size M not displayed");
		Assert.assertTrue(dresspage.sizeLdisplay(), "Failed:Size L not displayed");
	}

	/*** Add first product and verify its added to cart***/
	@Test
	public void verifyaddtocart() 
	{
		//homepage.ClickDressestab();
		dresspage.AddtoCart(0);
		Assert.assertTrue(dresspage.addcartdisplay(), "Failed: cart not added");
		dresspage.ClosePopup();
	}


	/***Verify price ascending order***/
	@Test
	public void Verifylowfirstsort() 
	{
		//homepage.ClickDressestab();
		dresspage.selectsortby("price:asc");
		List<Double> Productprices = dresspage.getProductPrices();
		for(int i = 0; i<Productprices.size()-1; i++)
		{
			Assert.assertTrue(Productprices.get(i) <= Productprices.get(i+1), "Failed: price not in ascending order");
		}
		
		
	}

	/***Verify price ascending order***/
	@Test
	public void verifyAtoZ()
	{
		//homepage.ClickDressestab();
		dresspage.selectsortby("name:asc");
		List<String> Productnames = dresspage.getProductNames();
		for(int i = 0; i<Productnames.size()-1; i++)
		{
	
			Assert.assertTrue(Productnames.get(i).compareTo(Productnames.get(i+1))<=0, "Failed: Products name not in ascending order");
		}
		
		
	}
	
	
}
