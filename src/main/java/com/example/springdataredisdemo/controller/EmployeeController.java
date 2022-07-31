package com.example.springdataredisdemo.controller;

import com.example.springdataredisdemo.constants.AppConstants;
import com.example.springdataredisdemo.entity.Employee;
import com.example.springdataredisdemo.service.EmployeeService;
import com.example.springdataredisdemo.vo.HttpStatusResponse;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.example.springdataredisdemo.constants.AppConstants.EMPLOYEE;
import static com.example.springdataredisdemo.constants.AppConstants.EMPLOYEE_BY_ID;

@RestController
@RequestMapping(EMPLOYEE)
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = EMPLOYEE_BY_ID,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatusResponse> getEmployeeDetails(@PathVariable Long id) {
        Employee employee=employeeService.getEmployeeDetailsById(id);
        return Optional.ofNullable(employee).map(
                        emp -> new ResponseEntity<>(HttpStatusResponse.setHttpResponse(HttpStatus.OK.value(),
                                AppConstants.EMPLOYEE_RETRIEVAL_SUCCESS_MESSAGE, employee), HttpStatus.OK))
                .orElse(
                        new ResponseEntity<>(HttpStatusResponse.setHttpResponse(HttpStatus.NO_CONTENT.value(),
                                AppConstants.NO_EMPLOYEE_FOUND_MESSAGE, null), HttpStatus.NO_CONTENT));
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatusResponse> getAllEmployeeDetails() {
        List<Employee> employees=employeeService.getAllEmployeeDetails();
        return Optional.ofNullable(employees).filter(CollectionUtils::isNotEmpty).map(
                        emp -> new ResponseEntity<>(HttpStatusResponse.setHttpResponse(HttpStatus.OK.value(),
                                AppConstants.EMPLOYEE_RETRIEVAL_SUCCESS_MESSAGE, employees), HttpStatus.OK))
                .orElse(
                        new ResponseEntity<>(HttpStatusResponse.setHttpResponse(HttpStatus.OK.value(),
                                AppConstants.NO_EMPLOYEE_FOUND_MESSAGE, null), HttpStatus.NO_CONTENT));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatusResponse> saveEmployeeDetails(@Valid @RequestBody Employee employee) {
        employee = employeeService.saveOrUpdateEmployeeDetails(employee);
        return new ResponseEntity<>(HttpStatusResponse.setHttpResponse(HttpStatus.CREATED.value(),
                AppConstants.EMPLOYEE_CREATION_SUCCESS_MESSAGE, employee),HttpStatus.CREATED);
    }

    @DeleteMapping(value = EMPLOYEE_BY_ID,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatusResponse> deleteEmployeeDetails(@PathVariable Long id) {
        employeeService.deleteEmployeeDetailsById(id);
        return new ResponseEntity<>(HttpStatusResponse.setHttpResponse(HttpStatus.OK.value(),
                AppConstants.EMPLOYEE_DELETION_SUCCESS_MESSAGE, null),HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatusResponse> updateEmployeeStatus(@Valid @RequestBody Employee employee) {
        employee =employeeService.saveOrUpdateEmployeeDetails(employee);
        return new ResponseEntity<>(HttpStatusResponse.setHttpResponse(HttpStatus.OK.value(),
                AppConstants.EMPLOYEE_UPDATION_SUCCESS_MESSAGE, employee),HttpStatus.OK);
    }

    @PutMapping(value = EMPLOYEE_BY_ID,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatusResponse> activateDeactivateEmployeeByEmailId(@PathVariable Long id, @RequestParam boolean isActive) {
        Employee employee =employeeService.activateDeactivateEmployeeByEmailId(id,isActive);
        return Optional.ofNullable(employee).map(
                        emp -> new ResponseEntity<>(HttpStatusResponse.setHttpResponse(HttpStatus.OK.value(),
                                AppConstants.EMPLOYEE_RETRIEVAL_SUCCESS_MESSAGE, employee), HttpStatus.OK))
                .orElse(
                        new ResponseEntity<>(HttpStatusResponse.setHttpResponse(HttpStatus.OK.value(),
                                AppConstants.NO_EMPLOYEE_FOUND_MESSAGE, null), HttpStatus.CONFLICT));
    }
}
