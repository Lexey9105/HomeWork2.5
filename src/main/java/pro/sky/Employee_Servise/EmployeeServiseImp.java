package pro.sky.Employee_Servise;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiseImp implements EmployeeService{
    private static int employeeMax=5;
    private List<Employee> employees;


    public EmployeeServiseImp(){
        this.employees=new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        if(employees.size()>=employeeMax){throw new EmployeeStorageIsFullException();}

        Employee employee=new Employee(firstName, lastName);
        if(employees.contains(employee)){throw new EmployeeAlreadyAddedException();}
        employees.add(employee);

        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee=new Employee(firstName, lastName);
        if(!employees.contains(employee)){throw new EmployeeNotFoundException();}
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee=new Employee(firstName, lastName);
        if(!employees.contains(employee)){throw new EmployeeNotFoundException();}
        return employee;
    }
    public Collection<Employee> findAll(){
        return employees;
    }
}
