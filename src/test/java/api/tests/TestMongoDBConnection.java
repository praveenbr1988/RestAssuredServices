package api.tests;


import api.utilities.MongoDBQuery;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestMongoDBConnection {

	@Test(priority=1, enabled = true)
	public void testMongoDB() {
		// Step 1: Fetch API Response
//		Response apiResponse = given()
//				.baseUri("https://api.example.com")
//				.when()
//				.get("/endpoint")
//				.then()
//				.statusCode(200)
//				.extract()
//				.response();
//
//		String apiResponseJson = apiResponse.getBody().asString();

		// Step 2: Fetch MongoDB Collection Data as JSON
		String mongoResponseJson = MongoDBQuery.getCollectionDataAsJson("testDB", "orders");
		System.out.println("MongoDBResponse : "+mongoResponseJson);

		// Step 3: Compare API Response with MongoDB Data
//		Assert.assertEquals(apiResponseJson, mongoResponseJson, "API response does not match MongoDB data!");



	}

}
