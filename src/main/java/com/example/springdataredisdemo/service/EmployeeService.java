package com.example.springdataredisdemo.service;

import com.example.springdataredisdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeDetailsById(Long id);

    List<Employee> getAllEmployeeDetails();

    void deleteEmployeeDetailsById(Long id);

    Employee saveOrUpdateEmployeeDetails(Employee employee);

    Employee activateDeactivateEmployeeByEmailId(Long id,boolean isActive);
}
