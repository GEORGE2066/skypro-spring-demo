package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Service
public interface DepartmentService {
    Employee findMaxSalaryFromDepartment(int department);

    Employee findMinSalaryFromDepartment(int department);

    Collection<Employee> printAllFromDepartment(int department);

    Collection<Employee> printAllSortedByDepartment();
}
