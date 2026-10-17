package com.SCA.Backend.Service.Imp;

import com.SCA.Backend.Models.Documents;
import com.SCA.Backend.Repository.IDocumentsRepository;
import com.SCA.Backend.Service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpDocumentService implements IDocumentService {

    @Autowired
    IDocumentsRepository _documentsRepository;

    @Override
    public List<Documents> getDocuments() {
        return (List<Documents>) _documentsRepository.findAll();
    }
}
