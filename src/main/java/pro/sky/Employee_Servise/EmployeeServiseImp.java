package pro.sky.Employee_Servise;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiseImp implements EmployeeService{

    private final Map<String,Employee> employees;


    public EmployeeServiseImp(){
        this.employees=new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName,int salary,int dept) {
        if(StringUtils.isAlpha(firstName)==false||StringUtils.isAlpha(lastName)==false){throw new EmployeeIncorrectDataExeption();}
        firstName=StringUtils.capitalize (firstName);
        lastName=StringUtils.capitalize (lastName);
        Employee employee=new Employee(firstName, lastName, salary, dept);
        String eKey= employee.getFirstName()+employee.getLastName();
        if(employees.containsKey(eKey)){throw new EmployeeAlreadyAddedException();}
        employees.put(eKey,employee);

        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee=new Employee(firstName, lastName);
        String eKey= employee.getFirstName()+employee.getLastName();
        if(!employees.containsKey(eKey)){throw new EmployeeNotFoundException();}
        employees.remove(eKey);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee=new Employee(firstName, lastName);
        String eKey= employee.getFirstName()+employee.getLastName();
        if(!employees.containsKey(eKey)){throw new EmployeeNotFoundException();}
        return employee;
    }
    public Collection<Employee> findAll(){
        return employees.values();
    }
}
