package com.SCA.Backend.DTO;

import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

public record UpdateDocumentDTO(

        String folio,
        String subject,
        String sender,
        Long statusId,
        Long assignedTo,
        LocalDate limitDate,
        Long typeId,
        String observation
) {
}
