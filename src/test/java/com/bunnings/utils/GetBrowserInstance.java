package com.bunnings.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class GetBrowserInstance {
	
	public WebDriver driver;
	
	
	//Method to initiate and return driver based on the chosen browser type
	
	public WebDriver getDriver(String browserName) {
	    if (browserName.equalsIgnoreCase("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    } else if (browserName.equalsIgnoreCase("Edge")) {
	    	System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\msedgedriver.exe");
	    	driver = new EdgeDriver();
	    } else if (browserName.equalsIgnoreCase("firefox")) {
	    	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
	    	driver = new FirefoxDriver();
	    }
	    return driver;
	  }
	
	

}
