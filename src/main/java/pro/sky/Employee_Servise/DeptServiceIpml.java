package pro.sky.Employee_Servise;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DeptServiceIpml implements DeptService{

private final EmployeeService employeeService;
public  DeptServiceIpml(EmployeeService employeeService){this.employeeService=employeeService;}

    @Override
    public Employee deptMax(int dept) {
        return employeeService.findAll().stream()
                .filter(e->e.getDept()==dept)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee deptMin(int dept) {
        return employeeService.findAll().stream()
                .filter(e->e.getDept()==dept)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> deptEmploy(int dept) {
        return employeeService.findAll().stream()
                .filter(e->e.getDept()==dept)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> employByDept() {
        return employeeService.findAll().stream()
                .collect(groupingBy(Employee::getDept));
    }


}
