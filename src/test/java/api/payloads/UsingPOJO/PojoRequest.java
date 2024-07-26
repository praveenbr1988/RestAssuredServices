package api.payloads.UsingPOJO;

public class PojoRequest {

    public static PojoUserInfo reqBody(){

        PojoCurrentAddress currAddress = new PojoCurrentAddress();
        currAddress.setHouseNo("6332");
        currAddress.setStreet("Durants neck lane");
        currAddress.setZipCode("27616");

        PojoEmployerHistory[] emp = new PojoEmployerHistory[2];
        emp[0].setEmployerName("Apple");
        emp[0].setStartDate("05/05/2000");
        emp[0].setEndDate("05/05/2005");
        emp[1].setEmployerName("Facebook");
        emp[1].setStartDate("05/05/2005");
        emp[1].setEndDate("05/05/2010");



        PojoUserInfo data = new PojoUserInfo();
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
