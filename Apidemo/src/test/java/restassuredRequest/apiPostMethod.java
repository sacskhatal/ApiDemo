package restassuredRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class apiPostMethod {
	@Test
	public void createNewResource() {
// To Initiate the Pay-Load
		String RequestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
// To Provide information about Payload Type And Header
		RequestSpecification request = RestAssured.given();
		request.header("contentType", "application/json");
		request.body(RequestBody);
// to send the request to browser and capture the response
    Response response=	request.post("https://reqres.in/api/users");
// to print the response( Json to String format) and status code
    String responseBody = response.getBody().asString();
	int statusCode = response.getStatusCode();
	System.out.println("Status code is: "+ statusCode);
	System.out.println("Response is:   "+ responseBody);
		
	}
	
	// We Have Taken Get Method , 
	@Test
	public void getResource() {	
		// To Provide Header Information
		RequestSpecification request = RestAssured.given();
		request.header("contentType","application/json");
		// to send the request to browser and capture the response
		Response response = request.get("https://reqres.in/api/unknown/2");
		// to print the response( to convert json to String format) and status code
		String ResponseBody = response.getBody().asString();
		int statusCode = response.getStatusCode();
		System.out.println("StatusCode Is "+ statusCode);
		System.out.println("Responce is "+ResponseBody);
		  
	}
	
}
