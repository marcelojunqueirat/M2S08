package com.m2s08.checkin.controller;

import com.m2s08.checkin.model.transport.CreateEmployeeDTO;
import com.m2s08.checkin.model.transport.GeneralEmployeeDTO;
import com.m2s08.checkin.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<GeneralEmployeeDTO> create(@RequestBody @Valid CreateEmployeeDTO body){
        GeneralEmployeeDTO response = this.employeeService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
