package com.BaseClass;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTClient {
	
	public static String baseURI="https://www.c2ta.co.in";
	
public static void testCreateUser() {
	/*
	 * postUser=new UserDetails();
	 * RestAssured.given().spec(TestConfig.getRequestSpecification()).
	 * body(postUser);
	 */
	
	RestAssured.baseURI=baseURI;
	
}

	

}
