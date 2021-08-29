package com.bunnings.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bunnings.utils.Constants;
import com.bunnings.utils.GetBrowserInstance;



public class Page {
	
	// create instance of web browser
	GetBrowserInstance browser = new GetBrowserInstance();
	
	
	// driver variable
	public static WebDriver driver;
	
	
	
	
		public Page()  {
			
			
	// ****************************  Initiating the driver  *************************************
			if(driver==null) {
				Page.driver = browser.getDriver(Constants.BROWSER);
				driver.manage().window().maximize();
				driver.get(Constants.URL);
				driver.manage().timeouts().implicitlyWait(Constants.ImplicitWait, TimeUnit.SECONDS);
				
			}
		}
	
	// *************************** Method to check if element is present and returns true or false *********************
		public boolean isElementPresent(WebDriver driver, By locator) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				return true;
			} catch (Exception e) {
				System.out.println(locator + " Not found");
				return false;
			}
		}
		
		
	// ****************************** Method to explicit wait for element to be present *******************************
		public void waitForVisabilityOfElement (WebDriver driver, By locator) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
			} catch (Exception e) {
				System.out.println(locator + " Not found");
				
			}
		}
		
		
		// ****************************** Method to explicit wait for element to be present *******************************
				public void waitForElementToBeClickable (WebDriver driver, By locator) {
					try {
						WebDriverWait wait = new WebDriverWait(driver, 10);
						wait.until(ExpectedConditions.elementToBeClickable(locator));
					
					} catch (Exception e) {
						System.out.println(locator + " Not found");
						
					}
				}	
		
	
	// ****************************** Method to quit the browser will be called after finishing the test *******************************
		public static void  quit() {
			driver.quit();
			driver=null;
		}
	
	

}
