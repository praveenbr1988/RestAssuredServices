package api.utilities;

import io.restassured.response.Response;

public class JSONResParsing {

    public static String jsonResDataParse(Response res, String jsonPath){
        return res.jsonPath().get(jsonPath).toString();
    }



}
