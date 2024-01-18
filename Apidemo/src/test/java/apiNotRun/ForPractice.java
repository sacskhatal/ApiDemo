package apiNotRun;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class ForPractice {
	
	@Test 
	           public void postRequest() {
			
					String RequestBody = "{\r\n"
							+ "\r\n"
							+ "	\"id\": 2,\r\n"
							+ "	\"name\"     :   \"Kimrao\",\r\n"
							+ "	\"location\" :   \"US \",\r\n"
							+ "	\"phone\"    :   \"985087682145\",\r\n"
							+ "	\"courses\"  : \r\n"
							+ "	[\r\n"
							+ "		\"Python\",\r\n"
							+ "		\"Appium\"\r\n"
							+ " 		]\r\n"
							+ "			},";
		
		
					Response response = RestAssured.given()
							.body(RequestBody)
							.when()
							.post("http://localhost:3000/");
					String ResponseBody = response.getBody().asString();
					int statusCode = response.getStatusCode();
					System.out.println("Response Is : "+ ResponseBody);
					System.out.println("statusCode is : "+ statusCode);
			
		
	}


}
