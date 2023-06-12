package pro.sky.Employee_Servise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DeptController {

    private final DeptService deptService;
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }
    @GetMapping("/max-salary")
    public Employee deptMax(@RequestParam int dept){
        return deptService.deptMax(dept);
    }

    @GetMapping("/min-salary")
    public Employee deptMin(@RequestParam int dept){
        return deptService.deptMin(dept);
    }
    @GetMapping( "/all")
    public Map<Integer, List<Employee>> employByDept(){
        return deptService.employByDept();
    }
    @GetMapping(value = "/all",params = {"departmentId"})
    public Collection<Employee> deptEmploy(@RequestParam int dept){
        return deptService.deptEmploy(dept);
    }
}
