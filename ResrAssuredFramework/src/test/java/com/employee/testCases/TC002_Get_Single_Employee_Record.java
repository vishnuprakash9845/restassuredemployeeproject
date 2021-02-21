package com.employee.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Single_Employee_Record extends TestBase {
	
	@BeforeClass
	void getEmployeeData() throws InterruptedException
	{
		//logger.info("");
		
		RestAssured.baseURI ="https://reqres.in/api";
		//Request object
		httpRequest=RestAssured.given();				
		//Response Object
		response=httpRequest.request(Method.GET,"/users?"+empID);
		Thread.sleep(3000);
		System.out.println("Response of  TC002_Get_Single_Employee_Record is: "+response.asString());
	}
	
	@Test
	void checkResponseBody()
	{
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empID), true);
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
