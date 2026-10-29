package com.SCA.Backend.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateTypeDocumentDTO (
        @NotNull
        @NotEmpty
        String Name
){}
