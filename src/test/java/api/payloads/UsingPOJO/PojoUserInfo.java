package api.payloads.UsingPOJO;

public class PojoUserInfo {

    int id;
    String firstName;
    String lastName;
    int age;
    String profession;
    PojoCurrentAddress currAddress;
    PojoEmployerHistory[] employerDetails;

    public PojoEmployerHistory[] getEmployerDetails() {
        return employerDetails;
    }

    public void setEmployerDetails(PojoEmployerHistory[] employerDetails) {
        this.employerDetails = employerDetails;
    }



    public PojoCurrentAddress getCurrentAddress() {
        return currAddress;
    }

    public void setCurrentAddress(PojoCurrentAddress address) {
        this.currAddress = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }




}
