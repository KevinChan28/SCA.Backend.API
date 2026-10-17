package com.SCA.Backend.Service.Imp;

import com.SCA.Backend.Models.Type_Document;
import com.SCA.Backend.Repository.ITypeRepository;
import com.SCA.Backend.Service.IDocumentService;
import com.SCA.Backend.Service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpTypeService implements ITypeService {

    @Autowired
    ITypeRepository _typeRepository;

    @Override
    public List<Type_Document> getTypesDocuments() {
        return (List<Type_Document>) _typeRepository.findAll();
    }
}
