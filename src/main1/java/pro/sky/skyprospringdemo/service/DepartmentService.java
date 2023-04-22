package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentService(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    public Employee findEmployeeWithMinSalary(int department) {
        return employeeServiceImpl.getEmployees().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary)).orElse(null);
    }

    public Employee findEmployeeWithMaxSalary(int department) {
        return employeeServiceImpl.getEmployees().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary)).orElse(null);
    }

    public Collection<Employee> printAllDepartment(Integer department) {
        return employeeServiceImpl.getEmployees().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    public Collection<Employee> printAllEmployees() {
        return employeeServiceImpl.getEmployees().values().stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.toList());
    }
}
