Feature: Get a user using GET Request

Scenario: Get a updated user
Given The base URI should launch
When I have a valid GET request
And I send a GET request to the API
Then I should receive a 200 response code for retrieved response
And The response should contains the retrieved data
