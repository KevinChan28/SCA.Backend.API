package com.SCA.Backend.Service.Imp;

import com.SCA.Backend.DTO.CreateResponsibleDTO;
import com.SCA.Backend.Models.Responsible;
import com.SCA.Backend.Repository.IResponsibleRepository;
import com.SCA.Backend.Service.IResponsibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImpResponsibleService implements IResponsibleService {

    private final IResponsibleRepository _responsibleRepository;

    public ImpResponsibleService(IResponsibleRepository _responsibleRepository) {
        this._responsibleRepository = _responsibleRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Responsible> getAllResponsibles() {
        return _responsibleRepository.findAll();
    }

    @Override
    public Long createResponsible(CreateResponsibleDTO dto) {

        Responsible responsible = new Responsible();
        responsible.setName(dto.Name());

        return _responsibleRepository.save(responsible).getId_Responsible();
    }

    @Transactional(readOnly = true)
    @Override
    public Responsible getResponsibleById(Long idResponsible) {
        return  _responsibleRepository.findById(idResponsible).get();
    }
}
