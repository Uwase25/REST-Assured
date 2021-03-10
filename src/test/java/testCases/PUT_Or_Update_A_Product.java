package testCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PUT_Or_Update_A_Product {

	SoftAssert sofAssert= new SoftAssert();
	GET_Or_Read_A_Product readAprod= new GET_Or_Read_A_Product();
	
	@Test
	public void update_A_Product() {
		
		HashMap payload= new HashMap();
		payload.put("id", "1209");
		payload.put("name", "HP Laptop Elite Pro");
		payload.put("description", "Super fast laptop");
		payload.put("price", "1199");
	//	payload.put("category_name", "Electronics");
	//	payload.put("category_id", "2");
	
		Response response= 
				given()
				       .baseUri("https://techfios.com/api-prod/api/product")
				       .header("Content-Type", "application/json; charset=UFT-8")
				       .body(payload)
			   .when()
				       .put("/update.php")
				.then()
				       .extract().response();
	
		String responseBody= response.getBody().asString();
		System.out.println("responseBody: " + responseBody);
		
//		parsing responseBody to Json
		
		JsonPath js= new JsonPath(responseBody);
		String message= js.getString("message");
		
		sofAssert.assertEquals(message, "Product was updated","not Matching the Assertions!!!" );
		
		readAprod.read_A_Products("1209");
		
		sofAssert.assertAll();
		
		
	
	
}
}