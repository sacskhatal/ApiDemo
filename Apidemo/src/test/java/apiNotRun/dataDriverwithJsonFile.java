package apiNotRun;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class dataDriverwithJsonFile {
	
	@Test
	public void postRequest() {
		// To Provide  the JsonDile Path
		
		String jsonFile="‪G:\\API Testing\\Testdata.json";  //G:\API Testing
		
		
		
		//To Read the Data From JsonFile
		
			String jsonData="";
				
		// Provide the jsonFile Details
		
		String name = "morpheus";
		String job = "leader";
		
		// Assuming you are reading the content of the JSON file into the jsonData variable
		// Here you should read the content of the file and assign it to the jsonData variable

		// Replace placeholder with actual values
		
        jsonData = jsonData.replace("{{name}}", name);
        jsonData = jsonData.replace("{{job}}", job);
		
		//To print the Response And StatusCode and Convert json To 

		Response response  = RestAssured.given()
				 
				 .contentType(ContentType.JSON)		
				 .body(jsonData)
				 
				 //To send the request
				 
				 .when()
				 .post("https://reqres.in/api/users")
				 
				 .then()
				 .extract().response();
		
		//Print the Response And StstusCode
		
		String ResponseBody = response.getBody().asString();
		
		// To Read the StatusCode
		
				int statusCode = response.getStatusCode();
				
		// To Print the StatusCode
		
				System.out.println("StatusCode is "+ statusCode);
		
		//To Print the Response
				
				System.out.println("Response is"+ ResponseBody );
		
		Assert.assertEquals(201, statusCode);
		
		Assert.assertEquals("morpheus", response.jsonPath().getString("name"));
		Assert.assertEquals("leader",response.jsonPath().getString("job"));		
		
	}

}
