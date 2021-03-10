package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*; // package then class then * give me the rest

public class GET_Or_Read_All_Products {

	@Test
	public void read_All_Products() {
		
//	https://techfios.com/api-prod/api/product/read.php
		
		Response response= 
		given()
		       .baseUri("https://techfios.com/api-prod/api/product")
		       .header("Content-Type", "application/json; charset=UFT-8")
	   .when()
		       .get("/read.php")
		.then()
		       .extract().response(); //help to save or hold variable
	
//		validating the status code
		int statusCode= response.getStatusCode();
		System.out.println("Status Code is " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
//		list of body(all products)
		String responseBody= response.getBody().asString();
		System.out.println(responseBody);
	}
}
