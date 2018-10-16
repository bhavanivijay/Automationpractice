package com.app.pages;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomepageObjects extends BasePage 
{

	@FindBy(xpath = "//ul[contains (  @class, 'menu-content')]/li[1]/a")
	private WebElement Women;

	@FindBy(xpath = "//ul[contains (  @class, 'menu-content')]/li[2]/a")
	private WebElement Dresses;

	@FindBy(xpath = "//ul[contains (  @class, 'menu-content')]/li[3]/a")
	private WebElement Tshirt;

	@FindBy(xpath = "//input[@id = 'newsletter-input']")
	private WebElement Newsletter;

	@FindBy(xpath = "//p[@class='alert alert-success']")
	private WebElement Submsg;

	@FindBy(xpath = "//button[@name='submitNewsletter']")
	private WebElement submitNewsletter;

	@FindBys(@FindBy(xpath = "//ul[@id = 'homefeatured']/li"))
	private List<WebElement> lstproduct;
	
	@FindBys(@FindBy(xpath = "//ul[@class = 'product_list row list']/li"))
	private List<WebElement> searchlstproduct;

	@FindBy(id = "search_query_top")
	private WebElement search;
	
	@FindBy(xpath = "//button[@name = 'submit_search']")
	private WebElement submitSearch;
	
	@FindBy(xpath ="//h1[contains(@class, 'product-listing')]")
	private WebElement searchresult;
	
	@FindBy(xpath = "//i[@class = 'icon-th-list']")
	private WebElement listicon;

	public HomepageObjects() {
		PageFactory.initElements(driver, this);
	}

	public void ClickDressestab() {
		Dresses.click();
	}

	public void ClickWomentab() {
		Women.click();
	}

	public void ClickTshirttab() {
		Tshirt.click();
	}

	public boolean MenuDisplay() {
		return (display(Dresses) && display(Women) && display(Tshirt));
	}

	public void Newsletterset(String email)
	{
		scrolldown(800);
		setText(Newsletter, email);
		submitNewsletter.click();
	}

	public boolean Subdisplay() {
		Explicitwait(Submsg);
		return (display(Submsg));
	}

	public List<WebElement> getproductList() {
		return lstproduct;
	}
	
	public List<WebElement> getsearchProductList() {
		return searchlstproduct;
	}

	public boolean verifyAddtocart(WebElement parent) {

		mouseover(parent);
		return display(parent.findElement(By.xpath(".//*[text()= 'Add to Cart']")));
		

	}

	public String getproductname(WebElement parent) {
		return parent.findElement(By.xpath(".//a[@class = 'product-name']")).getText();

	}

	public void Searchoption(String s)
	{
		setText(search, s);
		submitSearch.click();
		Explicitwait(searchresult);
		listicon.click();
	}
	
	
	public boolean Verifyreduceprice(WebElement parent)
	{
		return display(parent.findElement(By.xpath(".//span[@class = 'discount']")));
	}
 
	public boolean verifyDiscPrice(WebElement parent)
	{
			System.out.println(parent.getText());
			return display(parent.findElement(By.xpath(".//div[contains(@class, 'right-block')]//span[contains(@class, 'reduction')]")));

		
	}
}


