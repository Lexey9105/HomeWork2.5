package pro.sky.Employee_Servise;

import java.util.Objects;


public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private int dept;

    public Employee(String firstName,String lastName,int salary,int dept){
        this.firstName=firstName;
        this.lastName=lastName;
        this.salary=salary;
        this.dept=dept;
    }
    public Employee(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;

    }

    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}

    public int getSalary() {
        return salary;
    }

    public int getDept() {
        return dept;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", dept=" + dept +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && dept == employee.dept && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, dept);
    }
}
