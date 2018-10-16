package com.app.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	public String browser = "chrome";

	public BasePage() {
		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\JEGAN E\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\JEGAN E\\Downloads\\geckodriver-v0.22.0-win32\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("http://automationpractice.com/index.php");
		}
	}

	public boolean display(WebElement element) 
	{
		boolean res = false;
		try 
		{
			res = element.isDisplayed();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	public void mouseover(WebElement e)
	{
		Actions obj = new Actions(driver);
		obj.moveToElement(e).build().perform();

	}

	public void scrolldown(int i)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,i)");	
	}
	
	public void setText(WebElement element, String name) 
	{
		element.click();
		element.clear();
		element.sendKeys(name);

	}
	
	public void selectFromDropDown(WebElement element, String option) 
	{
		Select obj = new Select(element);
		obj.selectByValue(option);
		
	}

	
	public void Explicitwait(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(e));
		
	}

		
	public void switchframe(WebElement iframe)
	{
		driver.switchTo().frame(iframe);
	}
	
	public void switchdefault()
	{
		driver.switchTo().defaultContent();
	}
	
	public boolean isElementVisible(WebElement element) 
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}
	public boolean isElementInVisible(WebElement element) 
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOf(element));
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}

	public void closebrowser()
	{
		driver.quit();
	}
	
}
