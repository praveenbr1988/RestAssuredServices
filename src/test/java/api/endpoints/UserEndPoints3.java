package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class UserEndPoints3 {

    private static Properties prop;

    public static void setProps(Properties pr){
        prop = pr;
    }


    public static Response getReq(String uri){
        Response res =
                given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                .when()
                    .get(prop.getProperty(uri));
        return res;
    }

    public static Response postReq(String uri){
        Response res =
                given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                .when()
                    .post(prop.getProperty(uri));
        return res;
    }


}
