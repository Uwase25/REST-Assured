package testCases;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GET_Or_Read_A_Product {
	
	SoftAssert SofAssert= new SoftAssert();
	
	@Test
	public void read_A_Products(String QueryIdValue) {
		
//	https://techfios.com/api-prod/api/product/read_one.php?id=1209
		
		Response response= 
		given()
		       .baseUri("https://techfios.com/api-prod/api/product")
		       .header("Content-Type", "application/json; charset=UFT-8")
		       .queryParam("id", "QueryIdValue")
	   .when()
		       .get("/read_one.php")
		.then()
		       .extract().response(); //help to save or hold variable
	
//  	validating the status code
//		int statusCode= response.getStatusCode();
//		System.out.println("Status Code is " + statusCode);
//		Assert.assertEquals(statusCode, 200);
//		SofAssert.assertEquals(statusCode, 201, "not matching");
		
//		list of body( products)
		
		String responseBody= response.getBody().asString();
		System.out.println("responseBody: " + responseBody);
		
//	String responseContentType= response.header("Content-Type");
//		Assert.assertEquals(responseContentType, "application/json", "Header missmatch");
		
//		parsing response body to Json
		JsonPath js= new JsonPath(responseBody);
		
//		Assertion
//		String productId= js.getString("id");
//		String productName= js.getString("name");
//		String productDescription= js.getString("description");
//		
//		Assert.assertEquals(productId, "1209");
//		Assert.assertEquals(productName, "HP Laptop Elite Pro");
//		Assert.assertEquals(productDescription, "Super fast laptop");
		
//		SofAssert.assertAll();
		
//		
//		js.prettyPrint();
//		System.out.println(js);
//		
//		response.prettyPrint(); to print line by line in console
//		
//		response time 
//		long responseTime= response.getTimeIn(TimeUnit.MILLISECONDS);
//		System.out.println("response time " + responseTime);
//	
//	validation of response body
//		 
//		if(responseTime<=2000) {
//			System.out.println("response time is within the range");
//			
//		}else {
//			System.out.println("not acceptable!!");
			}
		}
	
//	}
	
	
