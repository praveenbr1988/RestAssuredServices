package api.testResponseValidations;

import io.restassured.response.Response;

public class ResponseValidations {

    public static void responseValidations(Response res){
        System.out.println(res.getStatusCode());
        System.out.println(res.asString());
    }

}
