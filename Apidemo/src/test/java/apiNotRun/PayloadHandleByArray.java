package apiNotRun;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PayloadHandleByArray {
	
@BeforeClass
	    public void assertResponseFields() {
	        // Define the base URL for the API
	        RestAssured.baseURI = "https://example.com/api";}

	        @Test
	        
	        public void getRequest() {
	        // Send the GET request
	        Response response = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .get("/endpoint");

	        // Assert the response status code is 200 (or the expected status code)
	        assertEquals(200, response.getStatusCode());

	        // Extract the response body as a string
	        String responseBody = response.getBody().asString();

	        // Define an array of field names to check
	        String[] expectedFieldNames = {
	            "field1", "field2", "field3", /* Add all 50 field names here */
	        };

	        // Iterate through the expected field names and assert they exist in the response
	        for (String fieldName : expectedFieldNames) {
	            assertTrue(responseBody.contains("\"" + fieldName + "\":"));
	        }
	    }
	}
