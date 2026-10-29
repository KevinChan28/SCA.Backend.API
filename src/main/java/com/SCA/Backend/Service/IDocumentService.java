package com.SCA.Backend.Service;

import com.SCA.Backend.DTO.CreateDocumentDTO;
import com.SCA.Backend.DTO.DocumentResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDocumentService {
    List<DocumentResponseDTO> getDocuments();
    Long createDocument(CreateDocumentDTO document);
    DocumentResponseDTO getDocumentById(Long documentId);
    Long updateStatus(Long idDocument, Long idStatus);
    void deleteDocumentById(Long idDocument);
    Page<DocumentResponseDTO> findAllByFilters(Long statusId, Long typeId, Long responsibleId, Pageable pageable);
    int createManyDocuments (List<CreateDocumentDTO> dtoDocumentsList);
    void assignResponsible(Long documentId, Long responsibleId);
    Long updateDdocument(Long idDocument,CreateDocumentDTO document);
}
