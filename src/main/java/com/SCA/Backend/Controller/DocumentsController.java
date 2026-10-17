package com.SCA.Backend.Controller;

import com.SCA.Backend.Service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documents")
public class DocumentsController {
    @Autowired
    private IDocumentService _documentService;

    @GetMapping("/all")
    public ResponseEntity<?> getDocuments() {
        return ResponseEntity.ok(_documentService.getDocuments());
    }
}
