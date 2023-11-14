package com.m2s08.checkin.model.transport;

import com.m2s08.checkin.model.Employee;
import com.m2s08.checkin.model.Register;

import java.util.List;

public record DetailedEmployeeDTO(Long id, String name, String office, Double wage, List<Register> registers) {

    public DetailedEmployeeDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getOffice(), employee.getWage(), employee.getRegisters());
    }
}
