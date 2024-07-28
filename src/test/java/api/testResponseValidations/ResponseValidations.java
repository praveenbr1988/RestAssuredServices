package api.testResponseValidations;

import io.restassured.response.Response;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    public void verifyResponseBody(String actual, String expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(float actual, float expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(int actual, int expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(double actual, double expected, String description) {
        assertEquals(actual, expected, description);

    }

    public void verifyResponseBody(boolean actual, boolean expected, String description) {
        assertEquals(actual, expected, description);
    }



    public void verifyStatusCodeInvalidReq(Response response) {
        assertTrue(String.valueOf(response.getStatusCode()).startsWith("50"), "value of status code is" + response.getStatusCode());
    }

    public void verifyStatusCode(Response response,Integer expected) {
        assertEquals(response.getStatusCode(),expected);
    }

}
