package api.payloads.Pojos;

public class UserInfo {

    int id;
    String firstName;
    String lastName;
    int age;
    String profession;
    CurrentAddress currAddress;
    EmployerHistory[] employerDetails;

    public EmployerHistory[] getEmployerDetails() {
        return employerDetails;
    }

    public void setEmployerDetails(EmployerHistory[] employerDetails) {
        this.employerDetails = employerDetails;
    }



    public CurrentAddress getCurrentAddress() {
        return currAddress;
    }

    public void setCurrentAddress(CurrentAddress address) {
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
