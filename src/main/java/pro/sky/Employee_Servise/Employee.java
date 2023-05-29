package pro.sky.Employee_Servise;

public class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getFirstName(){return this.firstName;}
    public String getLastName(){return this.lastName;}
    public String setFirstName(String firstName){return this.firstName;}
    public String setLastName(String lastName){return this.lastName;}

}
