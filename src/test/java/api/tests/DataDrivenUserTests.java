package api.tests;

import api.payloads.User;
import api.endpoints.UserEndPoints;
import api.utilities.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenUserTests {

	private static final Logger logger = LoggerUtil.getLogger(DataDrivenUserTests.class);
	User userPayLoad;
	
	@Test(priority=1, dataProvider="AllData",dataProviderClass = DataProviders.class )
	public void testPostUser(String uId, String uName, String fName, String lName, String uEmail, String pwd, String ph){
		
		userPayLoad = new User();
		userPayLoad.setId(Integer.parseInt(uId));
		userPayLoad.setUsername(uName);
		userPayLoad.setFirstName(fName);
		userPayLoad.setLastName(lName);
		userPayLoad.setEmail(uEmail);
		userPayLoad.setPassword(pwd);
		userPayLoad.setPhone(ph);			
		
		Response response = UserEndPoints.createUser(userPayLoad);
		response.then().log().all();
		System.out.println("UserName is: "+this.userPayLoad.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("tests passed success***");
		logger.info("***Creating User***");
		
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass = DataProviders.class )
	public void testGetUserByName(String uName){
		logger.info("***Fetching User***");
		Response response = UserEndPoints.getUser(uName);
		System.out.println("UserName is: "+this.userPayLoad.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
}
