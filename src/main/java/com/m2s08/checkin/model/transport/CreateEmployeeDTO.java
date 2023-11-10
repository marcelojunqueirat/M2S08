package com.m2s08.checkin.model.transport;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateEmployeeDTO(@NotBlank String name, @NotBlank String office, @NotNull Double wage) {
}
