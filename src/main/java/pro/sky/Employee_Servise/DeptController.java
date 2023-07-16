package pro.sky.Employee_Servise;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DeptController {

    private final DeptService deptService;
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping("/{dept}/salary/sum")
    public Integer sum(@PathVariable int dept){
        return deptService.sum(dept);
    }
    @GetMapping("/{dept}/salary/max")
    public Employee deptMax(@PathVariable int dept){
        return deptService.deptMax(dept);
    }
    @GetMapping("/{dept}/salary/min")
    public Employee deptMin(@PathVariable int dept){
        return deptService.deptMin(dept);
    }
    @GetMapping( "/employees")
    public Map<Integer, List<Employee>> employByDept(){
        return deptService.employByDept();
    }
    @GetMapping(value = "/{dept}/employees")
    public Collection<Employee> deptEmploy(@PathVariable int dept){
        return deptService.deptEmploy(dept);
    }
}
