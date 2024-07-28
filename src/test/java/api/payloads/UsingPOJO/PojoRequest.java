package api.payloads.UsingPOJO;

import api.payloads.Pojos.CurrentAddress;
import api.payloads.Pojos.EmployerHistory;
import api.payloads.Pojos.UserInfo;

public class PojoRequest {

    public static UserInfo reqBody(){

        CurrentAddress currAddress = new CurrentAddress();
        currAddress.setHouseNo("6332");
        currAddress.setStreet("Durants neck lane");
        currAddress.setZipCode("27616");

        EmployerHistory[] emp = new EmployerHistory[2];
        emp[0].setEmployerName("Apple");
        emp[0].setStartDate("05/05/2000");
        emp[0].setEndDate("05/05/2005");
        emp[1].setEmployerName("Facebook");
        emp[1].setStartDate("05/05/2005");
        emp[1].setEndDate("05/05/2010");



        UserInfo data = new UserInfo();
        data.setId(123);
        data.setFirstName("PRaveen");
        data.setLastName("BR");
        data.setAge(35);
        data.setProfession("QE Architect");
        data.setCurrentAddress(currAddress);
        data.setEmployerDetails(emp);

        return data;
    }

}
