package api.testResponseValidations;

import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseValidations {

    public static void responseStatusCodeValidation(int expectedCode, Response res){
        Assert.assertEquals(res.getStatusCode(),expectedCode);
    }

    public static void responseDataValidation(String expectedData, Response res){
        Assert.assertEquals(res.getBody(),expectedData);
    }

    public static void responseValidations(Response res){
        System.out.println(res.getStatusCode());
        System.out.println(res.asString());
    }

}
