package pro.sky.skyprospringdemo.controller;

import pro.sky.skyprospringdemo.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.domain.Employee;
import java.util.Collection;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
    private final DepartmentService depService;

    public DepartmentController(DepartmentService depService) {
        this.depService = depService;
    }

    @GetMapping(path = "/max-salary")
    public Employee findMaxSalaryFromDepartment(@RequestParam int departmentId) {
        return depService.findMaxSalaryFromDepartment(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee findMinSalaryFromDepartment(@RequestParam int departmentId) {
        return depService.findMinSalaryFromDepartment(departmentId);
    }

    @GetMapping(path = "/all")
    public Collection<Employee> printAllFromDepartment(@RequestParam(required = false) Integer departmentId) {
        if (departmentId == null) {
            return depService.printAllSortedByDepartment();
        }
        return depService.printAllFromDepartment(departmentId);
    }
}
