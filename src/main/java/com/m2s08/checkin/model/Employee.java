package com.m2s08.checkin.model;

import com.m2s08.checkin.model.transport.CreateEmployeeDTO;
import com.m2s08.checkin.model.transport.CreateRegisterdDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String office;

    @Column(nullable = false)
    private Double wage;

    @OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Register> registers = new ArrayList<>();


    public Employee() {
    }

    public Employee(CreateEmployeeDTO body) {
        this.name = body.name();
        this.office = body.office();
        this.wage = body.wage();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public List<Register> getRegisters() {
        return registers;
    }

    public List<CreateRegisterdDTO> getRegisterAsObject() {
        return this.registers.stream().map(CreateRegisterdDTO::new).toList();
    }
}
