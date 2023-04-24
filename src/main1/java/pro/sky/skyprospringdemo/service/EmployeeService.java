package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.domain.Employee;

import java.math.BigDecimal;
import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, BigDecimal salary, int department);

    Employee remove(String firstName, String lastName, BigDecimal salary, int department);

    Employee find(String firstName, String lastName, BigDecimal salary, int department);

    Collection<Employee> printAll();
}
