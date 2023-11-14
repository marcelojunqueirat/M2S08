package com.m2s08.checkin.model.transport;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.m2s08.checkin.model.Register;
import com.m2s08.checkin.model.enums.RegisterType;

import java.time.LocalDateTime;

public record CreateRegisterdDTO(Long id, @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime registeredAt,
                                 RegisterType type) {
    public CreateRegisterdDTO(Register register) {
        this(register.getId(), register.getRegisteredAt(), register.getType());
    }
}
