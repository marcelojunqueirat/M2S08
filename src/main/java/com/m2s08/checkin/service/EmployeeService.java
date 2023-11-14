package com.m2s08.checkin.service;

import com.m2s08.checkin.model.Employee;
import com.m2s08.checkin.model.Register;
import com.m2s08.checkin.model.transport.CreateEmployeeDTO;
import com.m2s08.checkin.model.transport.CreateRegisterdDTO;
import com.m2s08.checkin.model.transport.DetailedEmployeeDTO;
import com.m2s08.checkin.model.transport.GeneralEmployeeDTO;
import com.m2s08.checkin.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public GeneralEmployeeDTO create(CreateEmployeeDTO body) {
        LOGGER.info("Iniciando o cadastro de um novo funcionário");
        Employee newEmployee = this.employeeRepository.save(new Employee(body));
        return new GeneralEmployeeDTO(newEmployee);
    }

    public Page<GeneralEmployeeDTO> listAll(Pageable pageable) {
        LOGGER.info("Listando todos os registros de funcionários.");
        return this.employeeRepository.findAll(pageable).map(GeneralEmployeeDTO::new);
    }

    public DetailedEmployeeDTO getEmployee(Long id) {
        LOGGER.info("Listando registro de funcionário por identificador.");
        return this.employeeRepository.findById(id).map(DetailedEmployeeDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id not found: " + id));
    }

    @Transactional
    public CreateRegisterdDTO createRegister(Long id, CreateRegisterdDTO body) {
        LOGGER.info("Criando registros de ponto.");
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id not found: " + id));

        Register register = new Register(body.type(), employee);
        employee.getRegisters().add(register);

        return new CreateRegisterdDTO(register);
    }
}
