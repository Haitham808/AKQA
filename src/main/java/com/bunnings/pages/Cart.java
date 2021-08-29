package com.bunnings.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.bunnings.base.Page;

public class Cart extends Page {
	
	
	 //********** arrayList for items in cart page***********
	 ArrayList<String> itemsInCart = new ArrayList<String>();
	 
	//*********** variables to hold total price and total quantity in Cart page***********
	 int itemsNumber;
	 double overAllPrice;
	
	
	//***************** Items locator ******************************************
	
	By cartIcon = By.id("icon-cart");
	By productsInCart = By.cssSelector("h4.ProductName");
	By totalNoOfItems = By.xpath("//div[@data-locator='title_Total']");
	By cartIcon1 = By.id("icon-cart1");
	By priceSum = By.xpath("//div[@data-locator='tile_TotalPrice']");
	
	
	
	
//*******************************************************************************************
	
	
	public void cartPage() {
		
		//********************* Loading Cart page *********************************
		
		driver.findElement(cartIcon).click();
		
		Assert.assertTrue(isElementPresent(driver,priceSum), "Cart page is loaded successfully");
		
	}
	
	
	
	public void validateProductNames() {
			
		//********************** get all product names from cart page and store them in itemsInCart arrayList *****************************
		
		List <WebElement> products = driver.findElements(productsInCart);
		for (int i=0;i<products.size();i++) {
			String name = products.get(i).getText();
			itemsInCart.add(name);
		}
		
		
		//*********************** check if product names in cart page are the same as the items selected in shopping page **********************
		
		Assert.assertEquals(HomePage.itemsAddedInCart, itemsInCart,"Items selected and items in cart Match");
		
		
	}
	
	
	
	public void validateNumberOfItems() {
		
		//***************** get the total number of items in the cart and convert to integer ***********************
		
		String totalItems = driver.findElement(totalNoOfItems).getText();
		totalItems = totalItems.replaceAll("[^\\d]", " ");
		totalItems = totalItems.trim();
		itemsNumber = Integer.parseInt(totalItems);
		
		System.out.println("Total number of items from Cart Pageis: "+itemsNumber);
		
		//******************* Validating if total number of items in cart page matches number of selected items ********************
		
		Assert.assertEquals(HomePage.totalItemsQuantity, itemsNumber,"Total number of items Match");
		
		
	}
	
	public void validateTotalPrice (){
		
		//***************** get the total price of items in the cart and convert to double ***********************
		
		String totalPrice = driver.findElement(priceSum).getText();
		totalPrice = totalPrice.replace("$", " ");
		overAllPrice=Math.round(Double.parseDouble(totalPrice)*100.0)/100.0;
		
		System.out.println("total price from cart page is: "+ overAllPrice);
		
		
		//******************* Validating if total price of items in cart page matches total price of selected items ********************
		
		
		Assert.assertEquals(HomePage.totalItemPrice, overAllPrice,"Total price of items Do Not Match");
		
	}
	
	

}
