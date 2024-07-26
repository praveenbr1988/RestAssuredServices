package api.tests;

import api.endpoints.UserEndPoints;
import api.payloads.UsingPOJO.UserPojo;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FakerUserTests {

    Faker faker;
    UserPojo userPayLoad;

    @BeforeClass
    public void setupData(){
        faker = new Faker();
        userPayLoad= new UserPojo();
        userPayLoad.setId(faker.idNumber().hashCode());
        userPayLoad.setFirstName(faker.name().firstName());
        userPayLoad.setLastName(faker.name().lastName());
        userPayLoad.setUsername(faker.name().username());;
        userPayLoad.setEmail(faker.internet().safeEmailAddress());
        userPayLoad.setPassword(faker.internet().password(5,10));
        userPayLoad.setPhone(faker.phoneNumber().cellPhone());
    }


    @Test(priority = 1)
    public void testPostUser(){
        Response response = UserEndPoints.createUser(userPayLoad);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 2)
    public void testGetUserByName(){
        Response response = UserEndPoints.getUser(this.userPayLoad.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 3)
    public void testUpdateUserByName(){
        //Update the test data
        userPayLoad.setFirstName(faker.name().firstName());
        userPayLoad.setLastName(faker.name().lastName());
        userPayLoad.setEmail(faker.internet().safeEmailAddress());

        Response response = UserEndPoints.updateUser(this.userPayLoad.getUsername(), this.userPayLoad);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        //Checking after update
        Response responseAfterUpdate = UserEndPoints.getUser(this.userPayLoad.getUsername());
        responseAfterUpdate.then().log().all();
        Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);

    }

    @Test(priority = 4)
    public void testDeleteUserByName(){
        Response response = UserEndPoints.deleteUser(this.userPayLoad.getUsername());
        //response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }



}
