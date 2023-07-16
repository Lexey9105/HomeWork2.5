package pro.sky.Employee_Servise;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DeptServiceIpmlTest {


    Employee test1 = new Employee("Сергей", "Иванов", 100000, 1);
    Employee test2 = new Employee("Лидия", "Петрова", 110000, 1);
    Employee test3 = new Employee("Виталий", "Петров", 120000, 2);
    Employee test4 = new Employee("Роман", "Сидоров", 70000, 2);
    Employee test5 = new Employee("Иван", "Иванов", 21000, 4);
    Employee test6 = new Employee("Екатерина", "Иванова", 20000, 4);
    Collection<Employee> employeesTest = new ArrayList<>();
    Collection<Employee> employeesTest1 = new ArrayList<>();
    Collection<Employee> employeesTest2 = new ArrayList<>();
    Collection<Employee> employeesTest4 = new ArrayList<>();


    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DeptServiceIpml deptServiceIpml;


    @Test
    public void sumTest() {
        assertNotNull(employeeService);

        employeesTest.add(test1);
        employeesTest.add(test2);
        employeesTest.add(test3);
        employeesTest.add(test4);
        employeesTest.add(test5);
        employeesTest.add(test6);
        Mockito.when(employeeService.findAll()).thenReturn(employeesTest);
        int a = 210000;
        int b = 190000;
        int c = 41000;
        assertEquals(a, deptServiceIpml.sum(1));
        assertEquals(b, deptServiceIpml.sum(2));
        assertEquals(c, deptServiceIpml.sum(4));
        assertThrows(DeptEmptyException.class, () -> {
            deptServiceIpml.sum(5);
        });
        assertThrows(DeptEmptyException.class, () -> {
            deptServiceIpml.sum(3);
        });
    }

    @Test
    public void deptMaxTest() {
        employeesTest.add(test1);
        employeesTest.add(test2);
        employeesTest.add(test3);
        employeesTest.add(test4);
        employeesTest.add(test5);
        employeesTest.add(test6);
        Mockito.when(employeeService.findAll()).thenReturn(employeesTest);

        assertEquals(test2, deptServiceIpml.deptMax(1));
        assertEquals(test3, deptServiceIpml.deptMax(2));
        assertEquals(test5, deptServiceIpml.deptMax(4));
        assertThrows(DeptEmptyException.class, () -> {
            deptServiceIpml.deptMax(5);
        });
        assertThrows(DeptEmptyException.class, () -> {
            deptServiceIpml.deptMax(3);
        });
    }

    @Test
    public void deptMinTest() {
        employeesTest.add(test1);
        employeesTest.add(test2);
        employeesTest.add(test3);
        employeesTest.add(test4);
        employeesTest.add(test5);
        employeesTest.add(test6);
        Mockito.when(employeeService.findAll()).thenReturn(employeesTest);

        assertEquals(test1, deptServiceIpml.deptMin(1));
        assertEquals(test4, deptServiceIpml.deptMin(2));
        assertEquals(test6, deptServiceIpml.deptMin(4));
        assertThrows(DeptEmptyException.class, () -> {
            deptServiceIpml.deptMin(5);
        });
        assertThrows(DeptEmptyException.class, () -> {
            deptServiceIpml.deptMin(3);
        });
    }

    @Test
    public void deptEmployTest() {
        employeesTest.add(test1);
        employeesTest.add(test2);
        employeesTest.add(test3);
        employeesTest.add(test4);
        employeesTest.add(test5);
        employeesTest.add(test6);
        Mockito.when(employeeService.findAll()).thenReturn(employeesTest);

        employeesTest1.add(test1);
        employeesTest1.add(test2);
        employeesTest2.add(test3);
        employeesTest2.add(test4);
        employeesTest4.add(test5);
        employeesTest4.add(test6);

        assertIterableEquals(employeesTest1, deptServiceIpml.deptEmploy(1));
        assertIterableEquals(employeesTest2, deptServiceIpml.deptEmploy(2));
        assertIterableEquals(employeesTest4, deptServiceIpml.deptEmploy(4));
        assertThrows(DeptEmptyException.class, () -> {
            deptServiceIpml.deptEmploy(5);
        });
        assertThrows(DeptEmptyException.class, () -> {
            deptServiceIpml.deptEmploy(3);
        });
    }

    @Test
    public void employByDeptTest() {
        employeesTest.add(test1);
        employeesTest.add(test2);
        employeesTest.add(test3);
        employeesTest.add(test4);
        employeesTest.add(test5);
        employeesTest.add(test6);
        Mockito.when(employeeService.findAll()).thenReturn(employeesTest);


        Map<Integer, List<Employee>> employeesTestMap = employeesTest.stream()
                .collect(Collectors.groupingBy(Employee::getDept));

        assertEquals(employeesTestMap, deptServiceIpml.employByDept());

    }

    @Test
    public void employByDeptTestNull() {
        Mockito.when(employeeService.findAll()).thenReturn(employeesTest);

        assertThrows(DeptEmptyException.class, () -> {
            deptServiceIpml.employByDept();
        });
    }
}
