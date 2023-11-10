package com.m2s08.checkin.model;

import com.m2s08.checkin.model.enums.RegisterType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime registeredAt;

    @Enumerated(EnumType.STRING)
    private RegisterType type;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
    private Employee employee;


    public Register() {
    }

    public Register(RegisterType type, Employee employee) {
        this.registeredAt = LocalDateTime.now();
        this.type = type;
        this.employee = employee;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public RegisterType getType() {
        return type;
    }

    public void setType(RegisterType type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
