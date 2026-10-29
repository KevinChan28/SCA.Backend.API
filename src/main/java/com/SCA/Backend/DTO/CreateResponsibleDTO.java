package com.SCA.Backend.DTO;

import jakarta.validation.constraints.NotNull;

public record CreateResponsibleDTO(
       @NotNull
       @NotNull
        String Name
) { }
