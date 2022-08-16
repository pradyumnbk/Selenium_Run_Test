package com.java8.webDriverUtility;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	
	public Driver driver;

	@BeforeTest
	public void setUp() {
		String browserName=getParameter("browser");
		driver=new Driver(browserName);
	}
	private String getParameter(String name) {
		String value=System.getProperty(name,"chrome");
		if(value==null)
			throw new RuntimeException(name+"is not a parameter!");
		
		if(value.isEmpty())
			throw new RuntimeException(name+"is empty!");
		
		return value;
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
