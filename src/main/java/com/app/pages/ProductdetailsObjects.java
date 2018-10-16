package com.app.pages;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductdetailsObjects extends BasePage
{
	
	DresspageObjects dresspage = new DresspageObjects();
	

	
	@FindBy(xpath = "//body[@id = 'product']//div[@id = 'short_description_content']/p")
	private WebElement Description;
	
	@FindBy(xpath = "//button[contains(@class, 'twitter')]")
	private WebElement Tweet;
	
	
	@FindBy(xpath = "//button[contains(@class, 'facebook')]")
	private WebElement Share;
	
	@FindBy(xpath = "//a[@title ='Close']")
	private WebElement close;
	
	@FindBy(xpath = "//iframe[@class = 'fancybox-iframe']")
	private WebElement frame;
	
	
	public ProductdetailsObjects() 
	{
			PageFactory.initElements(driver, this);
	}
	
	
		
	public boolean PrDesDisplay()
	{
		switchframe(frame);
		Explicitwait(Description);
	    return display(Description) ;
	}
	
	public boolean PrTweetDisplay()
	{
		return display(Tweet);
	}
	
	public boolean PrShareDisplay()
	{
		return display(Share);
	}
	
	
	public void ClosePopup()
	{
		switchdefault();
		close.click();
	}
}