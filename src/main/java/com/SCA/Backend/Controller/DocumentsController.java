package com.SCA.Backend.Controller;

import com.SCA.Backend.DTO.CreateDocumentDTO;
import com.SCA.Backend.DTO.DocumentResponseDTO;
import com.SCA.Backend.Service.IDocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/documents")
@Tag(name = "Documentos", description = "Gestión de los acuerdos que nos llegan")
public class DocumentsController {

    private final IDocumentService _documentService;

    public DocumentsController(IDocumentService _documentService) {
        this._documentService = _documentService;
    }

    @Operation(summary = "Obtener todos los documentos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de documentos")
    })
    @GetMapping
    public ResponseEntity<Page<DocumentResponseDTO>> getDocuments(
            @RequestParam(required = false)Long statusId,
            @RequestParam(required = false)Long typeId,
            @RequestParam(required = false)Long responsibleId,
            @ParameterObject
            @PageableDefault(size = 10, sort = "IdDocument", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(_documentService.findAllByFilters(statusId,typeId,responsibleId, pageable));
    }

    @Operation(summary = "Crear un documento")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Documento creado"),
            @ApiResponse(responseCode = "404", description = "Status o tipo de documento no encontrado"),
    })
    @PostMapping
    public ResponseEntity<Long> createDocument(@Valid @RequestBody CreateDocumentDTO document) {
        Long id = _documentService.createDocument(document);
        return ResponseEntity.created(URI.create("/documents/" + id)).body(id);
    }


    @Operation(summary = "Actualizar un documento")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Id del Documento actualizado"),
            @ApiResponse(responseCode = "404", description = "Status, tipo o responsable de documento no encontrado"),
    })
    @PutMapping
    public ResponseEntity<Long> updateDocument(@Valid @RequestBody CreateDocumentDTO document, @RequestBody Long idDocument) {
        Long id = _documentService.updateDdocument(idDocument,document);
        return ResponseEntity.ok(id);
    }


    @Operation(summary = "Crear varios documentos")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Documentos creados"),
            @ApiResponse(responseCode = "400", description = "Lista vacía o demasiado grande"),
            @ApiResponse(responseCode = "404", description = "Status, tipo o responsable no encontrado")
    })
    @PostMapping("/batch")
    public ResponseEntity<Integer> createManyDocuments(@RequestBody List<CreateDocumentDTO> documents) {
        int sizeDocuments = _documentService.createManyDocuments(documents);
        return ResponseEntity.status(HttpStatus.CREATED).body(sizeDocuments);
    }


    @Operation(summary = "Obetener documento por Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de documentos"),
            @ApiResponse(responseCode = "404", description = "Documento no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<DocumentResponseDTO> getDocumentById( @PathVariable Long id) {
        return ResponseEntity.ok(_documentService.getDocumentById(id));
    }


    @Operation(summary = "Cambiar el status de un documento")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Id del documento actualizado"),
            @ApiResponse(responseCode = "404", description = "Documento o status no encontrado")
    })
    @PatchMapping("/{idDocument}/status/{idStatus}")
    public ResponseEntity<Long> updateStatus(@PathVariable Long idDocument, @PathVariable Long idStatus) {
        return ResponseEntity.ok(_documentService.updateStatus(idDocument, idStatus));
    }


    @Operation(summary = "Asignar responsable a un documento")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Responsable asignado"),
            @ApiResponse(responseCode = "404", description = "Documento o responsable no encontrado")
    })
    @PatchMapping("/{idDocument}/responsible/{idResponsible}")
    public ResponseEntity<Void> assignResponsible(@PathVariable Long idDocument, @PathVariable Long idResponsible) {
        _documentService.assignResponsible(idDocument, idResponsible);

        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Eliminar un documento")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Documento eliminado"),
            @ApiResponse(responseCode = "404", description = "Documento no encontrado")
    })
    @DeleteMapping("/{idDocument}")
    public ResponseEntity<Void> deleteDocumentById(@PathVariable Long idDocument) {
        _documentService.deleteDocumentById(idDocument);

        return ResponseEntity.noContent().build();
    }
}
