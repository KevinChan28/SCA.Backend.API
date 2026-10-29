package com.SCA.Backend.Service;

import com.SCA.Backend.DTO.CreateTypeDocumentDTO;
import com.SCA.Backend.Models.Type_Document;

import java.util.List;

public interface ITypeService {

    List<Type_Document> getTypesDocuments();
    Long createTypeDocument(CreateTypeDocumentDTO dto);
    Type_Document getTypeDocumentById(Long idTypeDocument);
}
