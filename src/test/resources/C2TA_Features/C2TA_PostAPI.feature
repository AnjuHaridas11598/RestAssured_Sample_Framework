	@PostRequest	
	Feature: Create a user using Post Request

Scenario: Create a user with valid data
Given The base URI should launch
When I have a valid post request payload
And I send a POST request to the API
Then I should receive a 200 Created response
And The response should contain the posted values


