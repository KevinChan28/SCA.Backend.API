package com.SCA.Backend.Controller;

import com.SCA.Backend.DTO.CreateStatusDTO;
import com.SCA.Backend.DTO.CreateTypeDocumentDTO;
import com.SCA.Backend.Service.ITypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/type")
@Tag(name = "Tipo de documentos", description = "Gestión de los tipos de documentos que tiene la empresa")
public class TypeDocumentController {

    private final ITypeService _typeService;

    public TypeDocumentController(ITypeService typeService) {
        _typeService = typeService;
    }

    //Obtener todos los tipos de documentos
    @GetMapping("/all")
    public ResponseEntity<?> getStatus() {
        return ResponseEntity.ok(_typeService.getTypesDocuments());
    }

    @GetMapping("/{idTypeDocument}")
    public ResponseEntity<?> getTypeDocumentById(@Valid @PathVariable long idTypeDocument) {
        return ResponseEntity.ok(_typeService.getTypeDocumentById(idTypeDocument));
    }

    @PostMapping()
    public ResponseEntity<?> createTypeDocument(@Valid @RequestBody CreateTypeDocumentDTO createTypeDocumentDTO) {
        return ResponseEntity.ok(_typeService.createTypeDocument(createTypeDocumentDTO));
    }
}
