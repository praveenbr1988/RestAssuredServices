package api.endpoints;


//created for CRUD operations

import api.payloads.Pojos.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

    public static Response createUser(User payload){

        Response response = given()
                                .contentType(ContentType.JSON)
                                .accept(ContentType.JSON)
                                .body(payload)
                            .when()
                                .post(Routes.post_url);
        return response;
    }

    public static Response getUser(String userName){

        Response response = given()
                                .pathParam("username", userName)
                            .when()
                                .get(Routes.get_url);
        return response;

    }

    public static Response updateUser(String userName, User payLoad){

        Response response = given()
                                .contentType(ContentType.JSON)
                                .accept(ContentType.JSON)
                                .pathParam("username", userName)
                                .body(payLoad)
                            .when()
                                .put(Routes.update_url);
        return response;
    }

    public static Response deleteUser(String userName){

        Response response = given()
                                .pathParam("username", userName)
                            .when()
                                .delete(Routes.delete_url);
        return response;

    }

}
