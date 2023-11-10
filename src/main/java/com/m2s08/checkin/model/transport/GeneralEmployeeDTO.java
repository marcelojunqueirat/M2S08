package com.m2s08.checkin.model.transport;

import com.m2s08.checkin.model.Employee;

public record GeneralEmployeeDTO(Long id, String name, String office, Double wage) {

    public GeneralEmployeeDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getOffice(), employee.getWage());
    }
}
