package com.employee.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Get_All_Employees extends TestBase {

	@BeforeClass
	void getAllEmployees() throws InterruptedException
	{
		//logger.info("");
		
		RestAssured.baseURI ="https://reqres.in/api";
		//Request object
		httpRequest=RestAssured.given();				
		//Response Object
		response=httpRequest.request(Method.GET,"/users?page=2");
		Thread.sleep(3000);
		System.out.println("Response of  TC001_Get_All_Employees is: "+response.asString());
	}
	
	@Test
	void checkResponseBody()
	{
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody!=null);
	}
	@Test
	void checkStatusCode()
	{
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,200);
	}
	@Test
	void checkResponseTime()
	{
		long responseTime = response.getTime();
		System.out.println(responseTime);
		if(responseTime>2000)

		Assert.assertTrue(responseTime<5000);
    }

}
