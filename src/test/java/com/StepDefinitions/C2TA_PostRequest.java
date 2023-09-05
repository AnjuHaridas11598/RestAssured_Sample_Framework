package com.StepDefinitions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.BaseClass.RESTClient;
import com.PojoClass.PostUserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.minidev.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.junit.Assert.*;

public class C2TA_PostRequest {
	public RESTClient restClient;
	public Response response;
	public PostUserDetails postUser;
	private Logger logger=LogManager.getLogger(C2TA_PostRequest.class);
	
	

	
	@Given("The base URI should launch")
	public void the_base_uri_should_launch() {

		logger.info("Base URI");
		RESTClient.testCreateUser();

	}	
	
	@When("I have a valid post request payload")
	public void i_have_a_valid_post_request_payload() {
	    postUser=new PostUserDetails();
	    postUser.setTitle("Developer");
	    postUser.setBody("Java");
	    postUser.setAuthor("Siva");
	    
	}
	@When("I send a POST request to the API")
	public void i_send_a_post_request_to_the_api() {
		
		ObjectMapper objMap=new ObjectMapper();
		String requestBody;
		try {
			requestBody=objMap.writeValueAsString(postUser);
		}
		
			catch (JsonProcessingException e) {
		        e.printStackTrace();
		        throw new RuntimeException("Failed to serialize payload to JSON");
		}
		logger.info("Post Request body");
		RequestSpecification requestSpec=RestAssured.given().contentType(ContentType.JSON).body(requestBody).log().all();
		
		response=requestSpec.post("/api/insert.php");
		
		System.out.println("Response"+response.getBody().asString());
		postUser = new PostUserDetails();
		
		
		
	}
	@Then("I should receive a {int} Created response")
	public void i_should_receive_a_created_response(Integer int1) {
	
		logger.info("Validation Results");
		response.then().statusCode(200).log().all();
		
	}
	
	@Then("The response should contain the posted values")
	public void the_response_should_contain_the_posted_values() {
		
		
	   assertEquals(postUser.getTitle(),response.jsonPath().getString("title"));
	   assertEquals(postUser.getBody(),response.jsonPath().getString("body"));
	   assertEquals(postUser.getAuthor(),response.jsonPath().getString("author"));
	}






}
