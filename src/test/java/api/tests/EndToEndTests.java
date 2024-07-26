package api.tests;

import api.endpoints.UserEndPoints3;
import api.payloads.UsingPOJO.PojoUserInfo;
import api.payloads.UsingPOJO.PojoRequest;
import api.payloads.UsingJSONObject.UsingJSONObj;
import api.payloads.UsingJSONFiles.UsingJSONFile;
import api.testResponseValidations.ResponseValidations;
import api.utilities.PropertiesFileLoad;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


import java.io.File;
import java.io.FileReader;
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

        //Using JSONPath to retrieve any value from the response
        ReadContext ctx = JsonPath.parse(rs.toString());
        String employeeName= ctx.read("$.data[0].employee_name");
        System.out.println("employeeName is: "+employeeName);
    }

//Using POJO RequestBody
    @Test
    public static void testcase2() throws IOException {
        PojoUserInfo req = PojoRequest.reqBody();
        Response rs = UserEndPoints3.postReq(req, "QA_URI");
        //Response Assertions
        ResponseValidations.responseValidations(rs);
        ResponseValidations.responseDataValidation("ExpectedData", rs);
        ResponseValidations.responseStatusCodeValidation(200, rs);
    }

    //Using JSONObject RequestBody
    @Test
    public static void testcase3() throws IOException {
        JSONObject req = UsingJSONObj.reqBodyForUser();
        Response rs = UserEndPoints3.postReq(req, "QA_URI");
        //Response Assertions
        ResponseValidations.responseValidations(rs);
        ResponseValidations.responseDataValidation("ExpectedData", rs);
        ResponseValidations.responseStatusCodeValidation(200, rs);
    }

    //Using JSONFile RequestBody
    @Test
    public static void testcase4() throws IOException {

        JSONObject req = UsingJSONFile.getReqFromJsonFile("src/test/resources/JSONFiles/ReqBody.JSON");


        Response rs = UserEndPoints3.postReq(req, "QA_URI");
        //Response Assertions
        ResponseValidations.responseValidations(rs);
        ResponseValidations.responseDataValidation("ExpectedData", rs);
        ResponseValidations.responseStatusCodeValidation(200, rs);
    }

}
