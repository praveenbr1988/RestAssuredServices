package api.tests;

import api.endpoints.UserEndPoints3;
import api.payloads.Pojos.UserInfo;
import api.payloads.UsingPOJO.PojoRequest;
import api.payloads.UsingJSONObject.UsingJSONObj;
import api.payloads.UsingJSONFiles.UsingJSONFile;
import api.testResponseValidations.ResponseValidations;
import api.utilities.PropertiesFileLoad;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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


    @Test(enabled = false)
    public static void testcase1() throws IOException {

        Response rs = UserEndPoints3.getReq("QA_URI");
        //Response Assertions
        ResponseValidations.responseValidations(rs);


        //Using jsonOath()
        String empName= rs.jsonPath().get("data[0].employee_name");
        System.out.println("employeeName is: "+empName);


        //Using ReadContext to retrieve any value from the response
        ReadContext ctx = JsonPath.parse(rs.asString());
        String employeeName= ctx.read("$.data[0].employee_name");
        System.out.println("employeeName is: "+employeeName);

        List<String> empNameList1 = ctx.read("$..employee_name");
        List<String> empNameList2 = ctx.read("$..data[?(@.employee_age<30)]");

//        $.data[3:5]-->From to To elements
//        $.data[:5]-->Upto 5 elements
//        $.data[5:]-->After 5 Elements

        System.out.println("List1 of employees is: "+empNameList1);
        System.out.println("List2 of employees is: "+empNameList2);

        //Using ORG.JSON
        JSONObject jo =  new JSONObject(rs.asString());
        String empName1 = jo.getJSONArray("data").getJSONObject(0).get("employee_name").toString();
        System.out.println("employeeName is: "+empName1);
    }

//Using POJO RequestBody
    @Test(enabled = false)
    public static void testcase2() throws IOException {
        UserInfo req = PojoRequest.reqBody();
        Response rs = UserEndPoints3.postReq(req, "QA_URI");
        //Response Assertions
        ResponseValidations.responseValidations(rs);
        ResponseValidations.responseDataValidation("ExpectedData", rs);
        ResponseValidations.responseStatusCodeValidation(200, rs);
    }

    //Using JSONObject RequestBody
    @Test(enabled = false)
    public static void testcase3() throws IOException {
        JSONObject req = UsingJSONObj.reqBodyForUser();
        Response rs = UserEndPoints3.postReq(req, "QA_URI");
        //Response Assertions
        ResponseValidations.responseValidations(rs);
        ResponseValidations.responseDataValidation("ExpectedData", rs);
        ResponseValidations.responseStatusCodeValidation(200, rs);
    }

    //Using JSONFile RequestBody
    @Test(enabled = false)
    public static void testcase4() throws IOException {

        JSONObject req = UsingJSONFile.getReqFromJsonFile("src/test/resources/JSONFiles/ReqBody.JSON");


        Response rs = UserEndPoints3.postReq(req, "QA_URI");
        //Response Assertions
        ResponseValidations.responseValidations(rs);
        ResponseValidations.responseDataValidation("ExpectedData", rs);
        ResponseValidations.responseStatusCodeValidation(200, rs);
    }


    //Using JSONFile RequestBody
    @Test(enabled = true)
    public static void testcase5() throws IOException {

        JSONObject res = UsingJSONFile.getReqFromJsonFile("src/test/resources/JSONFiles/FBPostsResponse.JSON");
        System.out.println("JSON Structure " +res);

        // Parse the JSON response
        JSONArray jsonArray = res.getJSONArray("FBPosts");

        List<Map<String, Object>> customerList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Map<String, Object> customerMap = new HashMap<>();
            for (String key : jsonObject.keySet()) {
                customerMap.put(key, jsonObject.get(key));
            }
            customerList.add(customerMap);
        }

        System.out.println("customerList " +customerList);

        // Process the data to find customers with the maximum number of posts
        int maxPost = customerList.stream().mapToInt(c-> (int) c.get("Posts")).max().orElse(0);

        List<String> namesWithMaxPosts  = customerList.stream()
                                        .filter(c-> (int) c.get("Posts")==maxPost)
                                        .map(c->c.get("FName")+" "+c.get("LName")).toList();

        // Print the names
        namesWithMaxPosts.forEach(System.out::println);



    }


}
