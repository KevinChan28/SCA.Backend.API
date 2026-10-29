package com.SCA.Backend.Service;

import com.SCA.Backend.DTO.CreateResponsibleDTO;
import com.SCA.Backend.Models.Responsible;

import java.util.List;

public interface IResponsibleService {
    List<Responsible> getAllResponsibles();
    Long createResponsible(CreateResponsibleDTO dto);
    Responsible getResponsibleById(Long idResponsible);
}
