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
public class DeptServiceIpml implements DeptService {

    private final EmployeeService employeeService;

    public DeptServiceIpml(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Integer sum(int dept) {
        if (dept < 1 || dept > 4) {
            throw new DeptEmptyException();
        }
        employeeService.findAll().stream()
                .filter(e -> e.getDept() == dept)
                .findAny()
                .orElseThrow(DeptEmptyException::new);
        return employeeService.findAll().stream()
                .filter(e -> e.getDept() == dept)
                .mapToInt(e -> e.getSalary())
                .sum();
    }

    @Override
    public Employee deptMax(int dept) {
        if (dept < 1 || dept > 4) {
            throw new DeptEmptyException();
        }
        return employeeService.findAll().stream()
                .filter(e -> e.getDept() == dept)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(DeptEmptyException::new);
    }

    @Override
    public Employee deptMin(int dept) {
        if (dept < 1 || dept > 4) {
            throw new DeptEmptyException();
        }
        return employeeService.findAll().stream()
                .filter(e -> e.getDept() == dept)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(DeptEmptyException::new);
    }

    @Override
    public Collection<Employee> deptEmploy(int dept) {
        if (dept < 1 || dept > 4) {
            throw new DeptEmptyException();
        }
        employeeService.findAll().stream()
                .filter(e -> e.getDept() == dept)
                .findAny()
                .orElseThrow(DeptEmptyException::new);
        return employeeService.findAll().stream()
                .filter(e -> e.getDept() == dept)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> employByDept() {
        employeeService.findAll().stream()
                .findAny()
                .orElseThrow(DeptEmptyException::new);

        return employeeService.findAll().stream()
                .collect(groupingBy(Employee::getDept));
    }


}
