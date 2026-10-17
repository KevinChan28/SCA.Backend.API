package com.SCA.Backend.Controller;

import com.SCA.Backend.Service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/type")
public class TypeDocumentController {
    @Autowired
    ITypeService _typeService;

    @GetMapping("/all")
    public ResponseEntity<?> getStatus() {
        return ResponseEntity.ok(_typeService.getTypesDocuments());
    }
}
