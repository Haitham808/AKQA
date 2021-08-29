package com.bunnings.testcases;

import org.testng.annotations.Test;

import com.bunnings.pages.Cart;
import com.bunnings.pages.HomePage;

import base.BaseTest;

public class AddProductToCart extends BaseTest  {
	
	
	@Test
	public void startTest()  {
		
		
		HomePage page = new HomePage();
		
		page.searchItem();
		page.prepareAddItem();
		page.addItem();
		
		
		
		
		
		Cart cart= new Cart();
		
		
		cart.cartPage();
		cart.validateProductNames();
		cart.validateNumberOfItems();
		cart.validateTotalPrice();
		
	}
	
	

}
