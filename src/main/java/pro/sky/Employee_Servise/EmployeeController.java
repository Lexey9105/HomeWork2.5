package pro.sky.Employee_Servise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
@GetMapping("/add")
    public Employee add(@RequestParam String firstName,@RequestParam String lastName,@RequestParam int salary,@RequestParam int dept){
        return employeeService.add(firstName, lastName, salary, dept);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,@RequestParam String lastName){
        return employeeService.remove(firstName, lastName);}

    @GetMapping("/find")
    public  Employee find(@RequestParam String firstName,@RequestParam String lastName){
        return employeeService.find(firstName, lastName);}

    @GetMapping("findAll")
    public Collection<Employee> findAll(){
        return employeeService.findAll();
    }
}
