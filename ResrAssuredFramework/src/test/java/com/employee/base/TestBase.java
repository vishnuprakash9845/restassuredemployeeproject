package com.employee.base;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeClass;
import org.testng.log4testng.Logger;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID="3";
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		//logger=Logger.getLogger(TestBase.class.getName());
		//PropertyConfigurator.configure("Log4j.properties");
		//logger.setLevel(Level.DEBUG);
		
	}

}
