package apiNotRun;

	
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	public class XmlPayload  {
		
		@Test(priority=2)
			public void postRequest() {
				// Initiate the pay-load in xmlcontent
			
				String xmlRequest="<user>\n" +
	                    "    <name>morpheus</name>\n" +
	                    "    <job>leader</job>\n" +
	                    "</user>";
				// To provide the Information About Pay-Load data Type And Header
				
				Response response = RestAssured.given()
				
						.contentType(ContentType.XML)
						.body(xmlRequest)
						
						.when()
						.post("https://reqres.in/api/users")
						
						.then()
						.extract().response();
				
						
				// To Print The Response and StatusCode
				
				String ResponseBody =response.getBody().asString();
				
				// Read statuscode
				
				int statusCode  = response.getStatusCode();
				
				//To Print the StatusCode and response
				
				
				System.out.println("StatusCode is "+ statusCode);
				System.out.println("Response is"+ ResponseBody);
				
				
			
				// To Add Assertions for the Response validations
				
				Assert.assertEquals(201, statusCode);
				
	            Assert.assertEquals("morpheus",response.xmlPath().getString("name"));
				Assert.assertEquals("leader",response.xmlPath().getString("job"));
		      
		}
		
		@Test(priority=1)
			public void putRequest() {
			String xmlRequest = "<user>\n" +
	                "    <name>morpheus</name>\n" +
	                "    <job>zion resident</job>\n" +
	                "</user>";
			
			Response response = RestAssured.given()
					.contentType(ContentType.XML)
					.body(xmlRequest)
		
					.when()
					.put("https://reqres.in/api/users/2")
					
					.then()
					.extract().response();
			
			String ResponseBody = response.getBody().asString();
			int statusCode = response.getStatusCode();
			System.out.println("StatusCode is"+ statusCode);
			System.out.println("Response is"+ ResponseBody);
		
		
			Assert.assertEquals(200, statusCode);
			Assert.assertEquals("morpheus", response.xmlPath().getString("name"));
		    Assert.assertEquals("zion resident", response.xmlPath().getString("job"));
		 
		
		
		}
		

	}

