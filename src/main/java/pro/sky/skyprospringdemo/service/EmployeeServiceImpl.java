package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Employee;
import pro.sky.skyprospringdemo.exception.EmployeeAlreadyAddedException;
import pro.sky.skyprospringdemo.exception.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employees = new HashMap<>();

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    private String getKey(Employee employee) {
        return employee.getFirstName() + " " + employee.getLastName();
    }

    public Employee findEmployeeWithMaxSalary(int department) {
        int max = Integer.MIN_VALUE;
        Employee employee = null;
        for (Employee empl : employees.values()) {
            if (empl != null && empl.getSalary() > max && empl.getDepartment() == department) {
                max = (int) employee.getSalary();
                employee = empl;
            }
        }
        return employee;
    }

    @Override
    public Employee add(String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(getKey(employee))) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(getKey(employee), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(getKey(employee))) {
            return employees.remove(getKey(employee));
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(getKey(employee))) {
            return employees.get(getKey(employee));
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> printAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    public Map<String, Employee> getEmployees() {
        return Collections.unmodifiableMap(employees);
    }
}