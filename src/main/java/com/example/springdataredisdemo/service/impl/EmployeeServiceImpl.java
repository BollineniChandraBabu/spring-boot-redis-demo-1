package com.example.springdataredisdemo.service.impl;

import com.example.springdataredisdemo.constants.AppConstants;
import com.example.springdataredisdemo.dao.EmployeeRepository;
import com.example.springdataredisdemo.entity.Employee;
import com.example.springdataredisdemo.service.EmployeeService;
import com.example.springdataredisdemo.vo.HttpStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Employee getEmployeeDetailsById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployeeDetails() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public void deleteEmployeeDetailsById(Long id) {
       employeeRepository.deleteById(id);
    }

    @Override
    public Employee saveOrUpdateEmployeeDetails(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee activateDeactivateEmployeeByEmailId(Long id,boolean isActive) {
        Employee employee=employeeRepository.findById(id).orElse(null);
        if(Objects.nonNull(employee)) {
            return employeeRepository.save(employee);
        }
        return employee;
    }
}
