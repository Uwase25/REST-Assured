package testCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class POST_Or_Create_A_Product {
	
	SoftAssert SofAssert= new SoftAssert();
	
	@Test
	public void create_A_Products() {
		
//	https://techfios.com/api-prod/api/product/create.php
		
		HashMap payload= new HashMap();
		payload.put("name", "HP Laptop Elite Pro");
		payload.put("description", "Super fast laptop");
		payload.put("price", "1199");
		payload.put("category_name", "Electronics");
		payload.put("category_id", "2");
		
		Response response= 
	 given()
	       .baseUri("https://techfios.com/api-prod/api/product")
	       .header("Content-Type", "application/json")
	       .body(payload)
    .when()
	       .post("/create.php")
	.then()
	       .extract().response(); //help to save or hold variable)
	 
		
		String responseBody= response.getBody().asString();
		System.out.println("response body: " + responseBody);
	
		
//       parsing response body to Json
		
		JsonPath js= new JsonPath(responseBody);
		String message= js.getString("message");
		Assert.assertEquals(message, "Product was created.");
	
		
		
	}
}
	

	
