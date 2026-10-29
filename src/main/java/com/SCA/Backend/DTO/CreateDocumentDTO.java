package com.SCA.Backend.DTO;

import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CreateDocumentDTO(

    @NotBlank
    String folio,
    @NotBlank
    String subject,
    @NotBlank
    String sender,
    Long assignedTo,
    LocalDate limitDate,
    @NotNull
    Long statusId,
    @NotNull
    Long typeId,
    String observation){}

