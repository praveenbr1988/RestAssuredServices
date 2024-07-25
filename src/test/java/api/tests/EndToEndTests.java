package api.tests;

import api.endpoints.UserEndPoints3;
import api.testResponseValidations.ResponseValidations;
import api.utilities.PropertiesFileLoad;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class EndToEndTests {

    static Properties pr;

    static {
        try {
            pr = PropertiesFileLoad.propFileLoad("src/test/resources/Properties/Environment.properties");
            UserEndPoints3.setProps(pr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public static void testcase1() throws IOException {

        Response rs = UserEndPoints3.getReq("QA_URI");
        //Response Assertions
        ResponseValidations.responseValidations(rs);
    }


    @Test
    public static void testcase2() throws IOException {

        Response rs = UserEndPoints3.postReq("QA_URI");
        //Response Assertions
        ResponseValidations.responseValidations(rs);
    }
}
