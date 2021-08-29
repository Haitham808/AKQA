package com.bunnings.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.bunnings.base.Page;

public class HomePage extends Page {
	
	
	//*********** items to add in the cart ************
	 String item1="Dulux Ceiling White Paint";
	 String item2="Spring 4L Low Sheen Interior Paint";
	
	
	
	 //********** arrayList for items needed to be added***********
	 ArrayList<String> itemsNeeded = new ArrayList<String>();
	 
	
	 //********* arrayList for items will be selected ********
	 public static ArrayList<String> itemsAddedInCart = new ArrayList<String>();
	
	
	 //*********** variables to hold total price and total quantity***********
	 public static double totalItemPrice;
	 public static int totalItemsQuantity;
	
	
	
//***********************************************************	
	// **************** elements locator   *****************
	
	By searchBox = By.id("custom-css-outlined-input");
	By searchIcon = By.id("crossIcon");
	By storeAndAvilability = By.id("panel1bh-header");
	By clickAndCollect = By.xpath("//span[contains(text(),'Click & Collect')]");
	By addFirstItem = By.xpath("//article[@data-index='0']/a/div[3]/div[2]/div[1]/button");
	By cartIcon = By.id("icon-cart");
	By allItemsInTheList = By.xpath("//div[@class='text-rating-container']/a/p");
	
	
	// *************************** this is the close icon for the pop up that appears after adding item to the cart *********************
	By closeIcon = By.className("closeIcon");
	
	
	
	
	
	
//***********************************************************************************************	
	
	
	public void searchItem() {
		
		driver.findElement(searchBox).sendKeys("paint");
		waitForElementToBeClickable(driver,searchIcon);
		driver.findElement(searchIcon).click();
		
		Assert.assertTrue(isElementPresent(driver,storeAndAvilability), "Search process is completed successfully");
		
		
	}
	
	public void prepareAddItem() {
		
		driver.findElement(storeAndAvilability).click();
		driver.findElement(clickAndCollect).click();
		
		System.out.println("Preparing is done");
		
		
	
	}
	
	public void addItem() {
		
		
	System.out.println("Starting to add items");
	
	// items needed to be selected from the list
	
	itemsNeeded.add(item1);
	itemsNeeded.add(item2);
	
	
	
	// get all items name of "paint" results
	List <WebElement> items = driver.findElements(allItemsInTheList);
	
	
	// loop through items from result and select items needed 
		 for (int i=0; i<items.size();i++ ) {
			
			String name =items.get(i).getText();
			
		
			
			if(itemsNeeded.contains(name)) {
				
				
				
				// ************* get the selected item name and add it to itemsAddedInCart arrayList *******************************
				
				String itemName = driver.findElement(By.xpath("//article["+(i+1)+"]/a/div[2]/div[2]/a/p")).getText();
				System.out.println("item name is "+ itemName);
				itemsAddedInCart.add(itemName);
				
				
				
				
				//***********  get the selected item price, convert it to double and add it to totalItemPrice price variable ***********************
				
				String itemPrice = driver.findElement(By.xpath("//article["+(i+1)+"]/a/div[3]/div[1]/p")).getText();
				System.out.println("price of item " +i + " is "+ itemPrice);
				itemPrice = itemPrice.replace("$", " ");
				totalItemPrice=totalItemPrice+Double.parseDouble(itemPrice);
				
				
				//*************** click on cart icon related to the selected item ********************************************
				waitForElementToBeClickable(driver,By.xpath("//article["+(i+1)+"]/a/div[3]/div[2]/div[1]/button"));
				driver.findElement(By.xpath("//article["+(i+1)+"]/a/div[3]/div[2]/div[1]/button")).click();
				System.out.println("Item is successfully sellected");
				
				
				
				//******************** get the quantity of the selected item, convert it to integer and add it to totalItemsQuantity variable ********************
				
				String itemValue=driver.findElement(By.xpath("//article["+(i+1)+"]/a/div[3]/div/div[1]/span[1]/div/input")).getAttribute("value");
				System.out.println("Item quantity is " + itemValue);
				totalItemsQuantity=totalItemsQuantity+ Integer.parseInt(itemValue);
				
				
				
				// ****************   check if close button is visible after adding the item, if so, click on it to close the pop up window
				
				if(isElementPresent(driver,closeIcon)) {
					waitForElementToBeClickable(driver,closeIcon);
					driver.findElement(closeIcon).click();
						
				}
				
				
			}
			
				
		 }
		 
	System.out.println("All items have been added successfully");
	
	
	// Rounding the total price to 2 decimal 	
	
	totalItemPrice=Math.round(totalItemPrice*100.0)/100.0;
	
	
	System.out.println("Total price from items page: "+ totalItemPrice);
	
	System.out.println("Total number of items from items page: "+ totalItemsQuantity);
	
	}
	


}
