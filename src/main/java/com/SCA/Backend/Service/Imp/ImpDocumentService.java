package com.SCA.Backend.Service.Imp;

import com.SCA.Backend.DTO.CreateDocumentDTO;
import com.SCA.Backend.DTO.DocumentResponseDTO;
import com.SCA.Backend.Models.Documents;
import com.SCA.Backend.Models.Responsible;
import com.SCA.Backend.Models.Status;
import com.SCA.Backend.Models.Type_Document;
import com.SCA.Backend.Repository.IDocumentsRepository;
import com.SCA.Backend.Repository.IResponsibleRepository;
import com.SCA.Backend.Repository.IStatusRepository;
import com.SCA.Backend.Repository.ITypeRepository;
import com.SCA.Backend.Service.IDocumentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImpDocumentService implements IDocumentService {

    private final IDocumentsRepository _documentsRepository;
    private final IStatusRepository _statusRepository;
    private final ITypeRepository _typeRepository;
    private final IResponsibleRepository _responsibleRepository;

    private static final int MAX_BATCH_SIZE = 30;

    public ImpDocumentService(IDocumentsRepository documentsRepository, IStatusRepository statusRepository, ITypeRepository typeRepository, IResponsibleRepository responsibleRepository) {
        _documentsRepository = documentsRepository;
        _statusRepository = statusRepository;
        _typeRepository = typeRepository;
        _responsibleRepository = responsibleRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<DocumentResponseDTO> getDocuments() {
        return _documentsRepository.findAllWithRelations()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public Long createDocument(CreateDocumentDTO dto) {

        Documents document = buildDocument(dto);

        return _documentsRepository.save(document).getIdDocument();
    }

    @Override
    @Transactional(readOnly = true)
    public DocumentResponseDTO getDocumentById(Long documentId) {

        return _documentsRepository.findByIdWithRelations(documentId)
                .map(this::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Documento no encontrado"));
    }


    @Override
    @Transactional
    public Long updateStatus(Long idDocument, Long idStatus) {
        Documents document = _documentsRepository.findById(idDocument)
                .orElseThrow(() -> new EntityNotFoundException("Oficio no encontrado: " + idDocument));

        Status status = _statusRepository.findById(idStatus)
                .orElseThrow(() -> new EntityNotFoundException("Estatus no encontrado: " + idStatus));

        document.setStatus(status);
        // No hace falta save(): la entidad está "gestionada" dentro de la transacción
        return document.getIdDocument();
    }

    @Override
    @Transactional
    public void deleteDocumentById(Long idDocument) {
        if (!_documentsRepository.existsById(idDocument)) {
            throw new EntityNotFoundException("Documento no encontrado: " + idDocument);
        }
        _documentsRepository.deleteById(idDocument);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DocumentResponseDTO> findAllByFilters(Long statusId, Long typeId, Long responsibleId, Pageable pageable) {
        return _documentsRepository.findAllByFilters(statusId, typeId, responsibleId, pageable)
                                    .map(this::toResponse);
    }

    @Override
    @Transactional
    public int createManyDocuments(List<CreateDocumentDTO> dtoDocumentsList) {

        if (dtoDocumentsList == null || dtoDocumentsList.isEmpty()) {
            throw new IllegalArgumentException("La lista de documentos no puede estar vacía");
        }
        if (dtoDocumentsList.size() > MAX_BATCH_SIZE) {
            throw new IllegalArgumentException("Máximo " + MAX_BATCH_SIZE + " documentos por solicitud");
        }

        List<Documents> documents = dtoDocumentsList.stream()
                .map(this::buildDocument)
                .toList();

        return _documentsRepository.saveAll(documents).size();
    }

    @Override
    @Transactional
    public void assignResponsible(Long documentId, Long responsibleId) {

        Documents document = _documentsRepository.findById(documentId)
                .orElseThrow(() -> new EntityNotFoundException("Documento no encontrado: " + documentId));
        Responsible responsible = _responsibleRepository.findById(responsibleId)
                .orElseThrow(() -> new EntityNotFoundException("Responsable no encontrado: " + responsibleId));

        document.setResponsible(responsible);
    }

    @Override
    @Transactional
    public Long updateDdocument(Long idDocument,CreateDocumentDTO documentDto) {

        Documents document = _documentsRepository.findById(idDocument)
                .orElseThrow(() -> new EntityNotFoundException("Documento no encontrado: " + idDocument));

        document.setFolio(documentDto.folio());
        document.setSubject(documentDto.subject());
        document.setSender(documentDto.sender());
        document.setLimitDate(documentDto.limitDate() != null ? documentDto.limitDate().atStartOfDay() : null);
        document.setObservation(documentDto.observation());
        document.setLoadedDate(LocalDateTime.now());

        Status status = _statusRepository.findById(documentDto.statusId())
                .orElseThrow(() -> new EntityNotFoundException("Estatus no encontrado"));
        document.setStatus(status);

        Type_Document type = _typeRepository.findById(documentDto.typeId())
                .orElseThrow(() -> new EntityNotFoundException("Tipo de documento no encontrado"));
        document.setType(type);

        if (documentDto.assignedTo() != null) {
            Responsible responsible = _responsibleRepository.findById(documentDto.assignedTo())
                    .orElseThrow(() -> new EntityNotFoundException("Responsable no encontrado"));
            document.setResponsible(responsible);
        }

        return _documentsRepository.save(document).getIdDocument();
    }

    private DocumentResponseDTO toResponse(Documents d) {
        Responsible r = d.getResponsible();   // puede ser null

        return new DocumentResponseDTO(
                d.getIdDocument(),
                d.getFolio(),
                d.getSubject(),
                d.getSender(),
                d.getLoadedDate(),
                d.getLimitDate(),
                d.getObservation(),
                d.getStatus().getId_Status(),
                d.getStatus().getName(),
                d.getType().getId_Type(),
                d.getType().getName(),
                r != null ? r.getId_Responsible() : null,
                r != null ? r.getName() : null);
    }

    private Documents buildDocument(CreateDocumentDTO createDocumentDTO) {

        Documents document = new Documents();

        document.setFolio(createDocumentDTO.folio());
        document.setSubject(createDocumentDTO.subject());
        document.setSender(createDocumentDTO.sender());
        document.setLimitDate(createDocumentDTO.limitDate() != null ? createDocumentDTO.limitDate().atStartOfDay() : null);
        document.setObservation(createDocumentDTO.observation());
        document.setLoadedDate(LocalDateTime.now());

        Status status = _statusRepository.findById(createDocumentDTO.statusId())
                .orElseThrow(() -> new EntityNotFoundException("Estatus no encontrado"));
        document.setStatus(status);

        Type_Document type = _typeRepository.findById(createDocumentDTO.typeId())
                .orElseThrow(() -> new EntityNotFoundException("Tipo de documento no encontrado"));
        document.setType(type);

        if (createDocumentDTO.assignedTo() != null) {
            Responsible responsible = _responsibleRepository.findById(createDocumentDTO.assignedTo())
                    .orElseThrow(() -> new EntityNotFoundException("Responsable no encontrado"));
            document.setResponsible(responsible);
        }

        return document;
    }
}
