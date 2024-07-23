package api.tests;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    Faker faker;
    User userPayLoad;

    @BeforeClass
    public void setupData(){
        faker = new Faker();
        userPayLoad= new User();
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



}
