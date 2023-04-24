package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.domain.Employee;
import pro.sky.skyprospringdemo.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/min-salary")
    public Employee findMinSalaryDepartment(@RequestParam int departmentId) {
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping(path = "/max-salary")
    public Employee findMaxSalaryDepartment(@RequestParam int departmentId) {
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping(path = "/all")
    public Collection<Employee> printAllDepartment(@RequestParam(required = false) Integer departmentId) {
        if (departmentId == null) {
            return departmentService.printAllEmployees();
        }
        return departmentService.printAllDepartment(departmentId);
    }

    @GetMapping(path = "/groupingByDepartment")
    public Collection<Employee> printGroupingByDepartment() {
            Map<Integer, List<Employee>> map1 = (Map<Integer, List<Employee>>) string.stream()
                    .collect(Collectors.groupingBy(Employee::getFirstName));
            return (Collection<Employee>) map1;
    }
}
