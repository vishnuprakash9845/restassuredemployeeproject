package com.employee.testCases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC005_Delete_Employee_Record extends TestBase{

	public RequestSpecification httpRequest;
	public Response response;
	
	@BeforeClass
	void deleteEmployee() throws InterruptedException
	{
		RestAssured.baseURI ="https://reqres.in/api";
	    httpRequest=RestAssured.given();	
		
	    response=httpRequest.request(Method.GET,"/users/"+empID);
	    Thread.sleep(1);
	    
	    System.out.println("Before Delete Response of  TC005_Delete_Employee_Record is: "+response.asString());
	    
	    JsonPath jsonPathEvaluator = response.jsonPath();
	    
	    String empID=jsonPathEvaluator.get("[0].id");
	    response=httpRequest.request(Method.DELETE,"/users/"+empID);
	    
	    Thread.sleep(3000);
	    
		System.out.println("After Delete Response of  TC005_Delete_Employee_Record is: "+response.asString());
	}
	
	@Test
	void checkResponseBody()
	{
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(""), true);
	}
	@Test
	void checkStatusCode()
	{
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,204);
	}
}
