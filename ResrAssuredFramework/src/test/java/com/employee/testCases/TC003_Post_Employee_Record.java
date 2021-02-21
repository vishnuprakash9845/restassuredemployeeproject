package com.employee.testCases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;
import com.employee.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC003_Post_Employee_Record extends TestBase{
	
	public RequestSpecification httpRequest;
	public Response response;
	
	String empName=RestUtils.empName();
	String empSalary=RestUtils.empSal();
	String empJob=RestUtils.empJob();
	
	@BeforeClass
	void createEmployee() throws InterruptedException
	{
		RestAssured.baseURI ="https://reqres.in/api";
	    httpRequest=RestAssured.given();

		JSONObject requestParams=new JSONObject();
		requestParams.put("name", empName);
		requestParams.put("job", empJob);
		
		httpRequest.header("Content-Type", "application/json");		
		httpRequest.body(requestParams.toJSONString());
		
	    response=httpRequest.request(Method.POST,"/users");
	    Thread.sleep(3000);
		System.out.println("Response of  TC003_Post_Employee_Record is: "+response.asString());
	}

	@Test
	void checkResponseBody()
	{
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empName), true);
		Assert.assertEquals(responseBody.contains(empJob), true);
	}
	@Test
	void checkStatusCode()
	{
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,201);
	}
	
	
}
