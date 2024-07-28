package api.endpoints;

public class Routes {

    public static String base_Url = "https://petstore.swagger.io/v2";

    //UserModule
    public static String post_url =base_Url + "/user";
    public static String get_url =base_Url + "/user/{username}";
    public static String update_url =base_Url + "/user/{username}";
    public static String delete_url =base_Url + "/user/{username}";

    //Booking urls
    public static String BASE_URL  = "https://restful-booker.herokuapp.com";
    public static String CREATE_UPDATE_BOOKING_URL  = "/booking";
    public static String AUTH_URL  = "/auth";
    public static String PING_URL  = "/ping";


    //petmodule urls

}
