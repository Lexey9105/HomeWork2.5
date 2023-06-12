package pro.sky.Employee_Servise;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DeptService {
    Employee deptMax(int dept);
    Employee deptMin(int dept);
    Collection<Employee> deptEmploy(int dept);
    Map<Integer,List<Employee>>employByDept();

}
