package api.payloads.UsingJSONObject;

import org.json.JSONArray;
import org.json.JSONObject;

public class UsingJSONObj {

    public static JSONObject reqBodyForUser(){

        JSONObject addressInfo = new JSONObject();
        addressInfo.put("HouseNo", "6332");
        addressInfo.put("Street", "Durants Neck Lane");
        addressInfo.put("ZipCode", "6332");

        JSONArray employerInfo = new JSONArray();
        JSONObject employer1 = new JSONObject();
        employer1.put("EmployerName", "Apple");
        employer1.put("StartDate", "05-05-2000");
        employer1.put("EndDate", "05-05-2005");

        JSONObject employer2 = new JSONObject();
        employer2.put("EmployerName", "Facebook");
        employer2.put("StartDate", "05-05-2005");
        employer2.put("EndDate", "05-05-2010");

        employerInfo.put(0, employer1);
        employerInfo.put(1, employer2);


        JSONObject userInfo = new JSONObject();
        userInfo.put("Id", 123);
        userInfo.put("FirstName","PRaveen");
        userInfo.put("LastName", "BR");
        userInfo.put("Age", 35);
        userInfo.put("Profession", "QE Architect");
        userInfo.put("CurrentAddress", addressInfo);
        userInfo.put("EmploymentHistory", employerInfo);
        return userInfo;
    }



}
