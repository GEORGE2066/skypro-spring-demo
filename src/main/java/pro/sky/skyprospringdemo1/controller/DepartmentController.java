package pro.sky.skyprospringdemo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo1.domain.Employee;
import pro.sky.skyprospringdemo1.service.DepartmentService;

import java.util.Collection;

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
}
