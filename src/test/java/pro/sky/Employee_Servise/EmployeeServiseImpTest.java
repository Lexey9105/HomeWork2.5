package pro.sky.Employee_Servise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiseImpTest {

    private final EmployeeService employeeService = new EmployeeServiseImp();

    public static Stream<Arguments> paramsForTest1() {
        return Stream.of(
                Arguments.of("Сергей", "Иванов", 100000, 1),
                Arguments.of("Виталий", "Петров", 120000, 2),
                Arguments.of("Роман", "Сидоров", 70000, 3),
                Arguments.of("Иван", "Иванов", 20000, 4)
        );
    }


    public static Stream<Arguments> ExceptIncorrectTest() {
        return Stream.of(
                Arguments.of("Серг1ей", "Иванов", 100000, 1),
                Arguments.of("Виталий", "Петр3ов", 120000, 2),
                Arguments.of("Роман", "Сидоров", -1000, 3),
                Arguments.of("Иван", "Иванов", 20000, 0)
        );
    }

    public static Stream<Arguments> ExceptAlreadyTest() {
        return Stream.of(
                Arguments.of("Сергей", "Иванов", 100000, 1),
                Arguments.of("Роман", "Сидоров", 70000, 3)
        );
    }

    public static Stream<Arguments> ExceptNotFoundTest() {
        return Stream.of(
                Arguments.of("Евгений", "Пригожин"),
                Arguments.of("Бибер", "Соколов")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForTest1")
    public void addTest(String firstName, String lastName, int salary, int dept) {
        Employee employeeTest = new Employee(firstName, lastName, salary, dept);
        assertEquals(employeeTest, employeeService.add(firstName, lastName, salary, dept));
    }

    @ParameterizedTest
    @MethodSource("ExceptIncorrectTest")
    public void IncorrectTest(String firstName, String lastName, int salary, int dept) {
        assertThrows(EmployeeIncorrectDataExeption.class, () -> {
            employeeService.add(firstName, lastName, salary, dept);
        });
    }

    @ParameterizedTest
    @MethodSource("ExceptAlreadyTest")
    public void AlreadyTest(String firstName, String lastName, int salary, int dept) {
        employeeService.add(firstName, lastName, salary, dept);

        assertThrows(EmployeeAlreadyAddedException.class, () -> {
            employeeService.add(firstName, lastName, salary, dept);
        });
    }

    @ParameterizedTest
    @MethodSource("ExceptAlreadyTest")
    public void removeTest(String firstName, String lastName, int salary, int dept) {
        employeeService.add(firstName, lastName, salary, dept);

        Employee employeeTest = new Employee(firstName, lastName, 0, 0);
        assertEquals(employeeTest, employeeService.remove(firstName, lastName));
    }

    @ParameterizedTest
    @MethodSource("ExceptNotFoundTest")
    public void removeExceptionTest(String firstName, String lastName) {
        employeeService.add("Сергей", "Иванов", 100000, 1);
        employeeService.add("Виталий", "Петров", 120000, 2);
        employeeService.add("Роман", "Сидоров", 70000, 3);
        employeeService.add("Иван", "Иванов", 20000, 4);

        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.remove(firstName, lastName);
        });
    }

    @ParameterizedTest
    @MethodSource("paramsForTest1")
    public void findTest(String firstName, String lastName, int salary, int dept) {
        employeeService.add(firstName, lastName, salary, dept);

        Employee employeeTest = new Employee(firstName, lastName, 0, 0);
        assertEquals(employeeTest, employeeService.find(firstName, lastName));
    }

    @ParameterizedTest
    @MethodSource("ExceptNotFoundTest")
    public void findExceptionTest(String firstName, String lastName) {
        employeeService.add("Сергей", "Иванов", 100000, 1);
        employeeService.add("Виталий", "Петров", 120000, 2);
        employeeService.add("Роман", "Сидоров", 70000, 3);
        employeeService.add("Иван", "Иванов", 20000, 4);

        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.find(firstName, lastName);
        });
    }

    @ParameterizedTest
    @MethodSource("paramsForTest1")
    public void findAllTest(String firstName, String lastName, int salary, int dept) {
        employeeService.add(firstName, lastName, salary, dept);


        Employee employeeTest = new Employee(firstName, lastName, salary, dept);
        String eKeyTest = employeeTest.getFirstName() + employeeTest.getLastName();
        Map<String, Employee> employeesTest = new HashMap<>();
        employeesTest.put(eKeyTest, employeeTest);

        assertIterableEquals(employeesTest.values(), employeeService.findAll());


    }


}
