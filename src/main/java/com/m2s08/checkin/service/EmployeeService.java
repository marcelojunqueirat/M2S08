package com.m2s08.checkin.service;

import com.m2s08.checkin.model.Employee;
import com.m2s08.checkin.model.transport.CreateEmployeeDTO;
import com.m2s08.checkin.model.transport.GeneralEmployeeDTO;
import com.m2s08.checkin.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public GeneralEmployeeDTO create(CreateEmployeeDTO body) {
        Employee newEmployee = this.employeeRepository.save(new Employee(body));
        return new GeneralEmployeeDTO(newEmployee);
    }
}
