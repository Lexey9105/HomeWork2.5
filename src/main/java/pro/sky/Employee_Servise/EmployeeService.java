package pro.sky.Employee_Servise;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {

Employee add(String firstName,String lastName);
Employee remove (String firstName,String lastName);
Employee find (String firstName,String lastName);
    Collection<Employee> findAll();
}
