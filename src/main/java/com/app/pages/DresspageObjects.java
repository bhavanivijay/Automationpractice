package com.app.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DresspageObjects extends BasePage {
	

	@FindBy(xpath = "//*[@class = 'heading-counter']")
	private WebElement header;

	@FindBy(xpath = "//*[@class = 'cat-name']")
	private WebElement title;

	@FindBys(@FindBy(xpath = "//ul[@class = 'product_list grid row']/li"))
	private List<WebElement> lstproduct;
	
	@FindBys(@FindBy(xpath = "//div[@class = 'right-block']//*[@class = 'price product-price']"))
	private List<WebElement> prices;

	@FindBys(@FindBy(xpath = "//div[@class = 'right-block']/h5/a"))
	private List<WebElement> ProductNames;

	
	@FindBy(xpath = "//ul//a[text() ='S']")
	private WebElement sizeS;

	@FindBy(xpath = "//ul//a[text() ='M']")
	private WebElement sizeM;

	@FindBy(xpath = "//ul//a[text() ='L']")
	private WebElement sizeL;

	@FindBy(xpath = "//span[text() = 'Add to cart']")
	private WebElement Addcart;
	
	@FindBy(xpath = "//div[contains(@class,'layer_cart')]/h2")
	private WebElement Addcartmsg;
	
	@FindBy(id = "selectProductSort")
	private WebElement Sortby;
	
	@FindBy(id = "layered_ajax_loader")
	private WebElement load;
	
	
	
	@FindBy(xpath = "//*[@title = 'Close window']")
	private WebElement close;

	public DresspageObjects() 
	{
		PageFactory.initElements(driver, this);
	}

	public int getheaderproductCount() 
	{
		return Integer.parseInt(header.getText().split(" ")[2]);

		/*
		 String hd = header.getText(); 
		 String[] arr = hd.split(" "); 
		 String t = arr[2]; 
		 return Integer.parseInt(t);
		 */
	}


	
	
	public int getTotalProducts()
	{
		return lstproduct.size();
	}

	public boolean sizeSdisplay() 
	{
		return display(sizeS); 
	}

	public boolean sizeMdisplay() 
	{
		return  display(sizeM); 
	}
	
	public boolean sizeLdisplay() 
	{
		return  display(sizeL);
	}
	
	
	public void AddtoCart(int i) 
	{
		scrolldown(300);
		mouseover(lstproduct.get(i));
		Addcart.click();

	}

	public boolean addcartdisplay()
	{
		Explicitwait(Addcartmsg);
		return display(Addcartmsg);
	}
	
	public void ClosePopup()
	{
		close.click();
	}

	public String getTitle() 
	{
		return title.getText();
	}

	
	public void selectdress()
	{
		WebElement parent = lstproduct.get(0);
		parent.findElement(By.xpath(".//img")).click();
				
	}
	
	
	public void selectsortby(String option)
	{
		scrolldown(550);
		selectFromDropDown(Sortby, option);
		isElementVisible(load);
		isElementInVisible(load);
		
	}
	
	public List<Double> getProductPrices()
	{
		ArrayList<Double> list = new ArrayList<Double>();
		for(WebElement e : prices)
		{
			/*String text = e.getText();
			text = text.replace("$","");
			Double price = Double.parseDouble(text);
			System.out.println(price);
			list.add(price);
			*/
			list.add(Double.parseDouble(e.getText().replace("$","")));
		}
		System.out.println(list);
		return list;
	}
	
	
	
	public List<String> getProductNames()
	{
		ArrayList<String> list = new ArrayList<String>();
		for(WebElement e : ProductNames)
		{
			list.add(e.getText());
		}
		System.out.println(list);
		return list;
	}
	
	/*public boolean ProductnameCompare(String first, String second)
	{
		if(first.compareTo(second) <= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}*/
}