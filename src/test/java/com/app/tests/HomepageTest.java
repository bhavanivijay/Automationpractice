package com.app.tests;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.pages.DresspageObjects;
import com.app.pages.HomepageObjects;

public class HomepageTest {
	HomepageObjects homepage;
	
	DresspageObjects dressPage;

	public HomepageTest() {
		homepage = new HomepageObjects();
		dressPage = new DresspageObjects();
	}

	/*** Verify Tabs - Women, Dresses and T-shirt are displayed on Home Page. ****/
	@Test
	public void verifyMenudispaly() {
		Assert.assertTrue(homepage.MenuDisplay(), "Failed: Menu not displayed");
	}

	/*** Verify Corresponding page been navigated on selecting these tabs ****/
	@Test
	public void VerifypageNavigation() {
		homepage.ClickDressestab();
		Assert.assertTrue(dressPage.getTitle().contains("DRESSES"));
		homepage.ClickWomentab();
		Assert.assertTrue(dressPage.getTitle().contains("WOMEN"));
		homepage.ClickTshirttab();
		Assert.assertTrue(dressPage.getTitle().contains("T-SHIRTS"));

	}

	/*** Verify Subscription message is displayed after entering valid e-mail ****/
	@Test
	public void verifySubscription() 
	{
		int value = new Random().nextInt(50000);
		String email = "Bhavani" + value + "@gmail.com";
		homepage.Newsletterset(email);
		Assert.assertTrue(homepage.Subdisplay());
	}

	/*** Verify Add to cart is displayed under each product ***/
	@Test
	public void verifyAddtocartbtn() 
	{
		List<WebElement> Products = homepage.getproductList();
		for (WebElement Prod : Products) 
		{
			//homepage.verifyAddtocart(Prod);
			Assert.assertTrue(homepage.verifyAddtocart(Prod),
				"Failed: addcart not displayed for" + homepage.getproductname(Prod));
		}

	}

	
	/*** Verify search product and verify product discount  ****/
	@Test
	public void VerifyDiscountDisplay() 
	{
		homepage.Searchoption("Printed");
				
		List<WebElement> Products = homepage.getsearchProductList();
		for (WebElement Prod : Products) 
		{
			boolean disc = homepage.Verifyreduceprice(Prod);			
			if (disc == true)
			{
				Assert.assertTrue(homepage.verifyDiscPrice(Prod),"Failed: discounted price not displayed");
			}
			else
			{
				continue;
			}
		}
	}
}
