package com.m2s08.checkin.service;

import com.m2s08.checkin.model.Employee;
import com.m2s08.checkin.model.transport.CreateEmployeeDTO;
import com.m2s08.checkin.model.transport.DetailedEmployeeDTO;
import com.m2s08.checkin.model.transport.GeneralEmployeeDTO;
import com.m2s08.checkin.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<GeneralEmployeeDTO> listAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable).map(GeneralEmployeeDTO::new);
    }

    public DetailedEmployeeDTO getEmployee(Long id) {
        return this.employeeRepository.findById(id).map(DetailedEmployeeDTO::new)
                .orElseThrow(()-> new IllegalArgumentException("Employee with id not found: " + id));
    }
}
