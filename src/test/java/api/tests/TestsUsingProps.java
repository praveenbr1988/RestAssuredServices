package api.tests;

import api.endpoints.UserEndpointsUsingProps;
import api.payloads.UsingPOJO.UserPojo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;



import io.restassured.response.Response;

public class TestsUsingProps {

	Faker faker;
	UserPojo userPayLoad;
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		faker = new Faker();
		userPayLoad = new UserPojo();
		userPayLoad.setId(faker.idNumber().hashCode());
		userPayLoad.setUsername(faker.name().username());
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().emailAddress());
		userPayLoad.setPassword(faker.internet().password(5,10));
		userPayLoad.setPhone(faker.phoneNumber().cellPhone());
		
		
		//Logs
		logger = LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=1)
	public void testPostUser(){
		
		logger.info("****Creating user*******");
		
		Response response = UserEndpointsUsingProps.createUser(userPayLoad);
		response.then().log().all();
		System.out.println("UserName is: "+this.userPayLoad.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("tests passed success***");
		
		logger.info("****user created*******");
		
	}
	
	@Test(priority=2)
	public void testGetUserByName(){
		
		logger.info("****Reading user*******");
		
		Response response = UserEndpointsUsingProps.readUser(this.userPayLoad.getUsername());
		System.out.println("UserName is: "+this.userPayLoad.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("****user read*******");
	}
	
	@Test(priority=3)
	public void testUpdateUserByName(){
		
		//update Data using Payload
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		
		Response response = UserEndpointsUsingProps.updateUser(this.userPayLoad.getUsername(),userPayLoad );
		response.then().log().body().statusCode(200);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//checking data after update
		Response responseAfterUpdate = UserEndpointsUsingProps.readUser(this.userPayLoad.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		
	}
	
	@Test(priority=4)
	public void testDeleteUserByName(){
		
		Response response = UserEndpointsUsingProps.deleteUser(this.userPayLoad.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//checking data after Delete
		Response responseAfterDelete = UserEndpointsUsingProps.readUser(this.userPayLoad.getUsername());
		Assert.assertEquals(responseAfterDelete.getStatusCode(), 404);
		
	}
	
	
	
	
}
