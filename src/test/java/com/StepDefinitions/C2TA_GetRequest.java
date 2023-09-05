package com.StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.BaseClass.RESTClient;
import com.PojoClass.GetUserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;

public class C2TA_GetRequest {
	
	public RESTClient restClient;
	public Response response;
	public GetUserDetails getUser;
	private Logger logger=LogManager.getLogger(C2TA_GetRequest.class);
	
	@When("I send a valid GET request to the API")
	public void i_send_a_valid_get_request_to_the_api() {
		ObjectMapper objMap=new ObjectMapper();
		String requestBody;
		try {
			requestBody=objMap.writeValueAsString(getUser);
		}
		
			catch (JsonProcessingException e) {
		        e.printStackTrace();
		        throw new RuntimeException("Failed to serialize payload to JSON");
		}
		logger.info("Get Request body");
		
		response=RestAssured.get("/api/read.php?id=971");
		System.out.println("Response"+response.getBody().asString());
		
		
	}

	@Then("I should receive a {int} response code for retrieved response")
	public void i_should_receive_a_response_code_for_retrieved_response(int expectedStatusCode) {
		int actualStatusCode=response.getStatusCode();
		assertEquals(expectedStatusCode,actualStatusCode);
		
	    
	}

	@Then("The response should contains the retrieved data")
	public void the_response_should_contains_the_retrieved_data() {
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
	}
	


	}	
	
	
