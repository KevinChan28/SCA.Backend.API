package com.SCA.Backend.DTO;

import com.SCA.Backend.Models.Responsible;
import com.SCA.Backend.Models.Status;
import com.SCA.Backend.Models.Type_Document;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public record DocumentResponseDTO (
        Long idDocument,
        String folio,
        String subject,
        String sender,
        LocalDateTime loadedDate,
        LocalDateTime limitDate,
        String observation,
        Long statusId,
        String statusName,
        Long typeDocumentId,
        String typeDocumentName,
        Long assignedToId,
        String assignedToName) {}
