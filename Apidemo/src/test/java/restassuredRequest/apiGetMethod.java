package restassuredRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class apiGetMethod {
	@Test
	public void apiMethod() {
		RequestSpecification request = RestAssured.given();

		Response responce = request.get("https://reqres.in/api/users?page=2");
		String responceBody = responce.getBody().asString();

		int statusCode = responce.getStatusCode();

		System.out.println("Status code is: " + statusCode);
		System.out.println("Responce is:   " + responceBody);

	}

}
