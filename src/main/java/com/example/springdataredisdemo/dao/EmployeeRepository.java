package com.example.springdataredisdemo.dao;

import com.example.springdataredisdemo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {


}
