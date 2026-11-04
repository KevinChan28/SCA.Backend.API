package com.SCA.Backend.DTO;

public record DocumentSummaryDTO(
        long openDocuments,
        long notAsiggnedDocuments,
        long expiredDocuments,
        long receivedToday,
        long readySign
) { }
