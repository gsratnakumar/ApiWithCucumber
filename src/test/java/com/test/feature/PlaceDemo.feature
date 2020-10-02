Feature: Verify AddPlace API

@AppPlace
Scenario Outline: Verify response code Add place with valid data.
Given Add place with valid payload "<Name>" "<Language>" "<Address>" and query parameters
When hit "AddPlaceAPI" resource with http request "POST"
Then Verify status code "200" and get response
And Deserializ the "Add place" response
And Verify response body "status" is "OK"
Then Verify place name "<Name>" using  "GetPlaceAPI" api with "GET" http request 

Examples:
      |Name             |Language             |Address|
      |Green Rose House   |Spanish              |Red rose house,30, high layout, cohen 09|
     
@GetPlace
Scenario: Verify Get place reponse
Given Place id with query parameters
When hit "GetPlaceAPI" resource with http request "GET"
Then Verify status code "200" and get response
And Deserializ the "Get place" response



