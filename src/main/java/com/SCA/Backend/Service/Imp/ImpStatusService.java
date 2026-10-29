package com.SCA.Backend.Service.Imp;

import com.SCA.Backend.DTO.CreateStatusDTO;
import com.SCA.Backend.Models.Status;
import com.SCA.Backend.Repository.IStatusRepository;
import com.SCA.Backend.Service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImpStatusService implements IStatusService {

    @Autowired
    IStatusRepository _statusRepository;

    @Override
    public List<Status> getStatus() {
        return (List<Status>) _statusRepository.findAll();
    }

    @Override
    public Status getStatusById(Long idStatus) {
        return _statusRepository.findById(idStatus).get();
    }

    @Override
    public Long createStatus(CreateStatusDTO dto) {
        Status status = new Status();
        status.setName(dto.Name());
        status.setCreated_Date(LocalDateTime.now());

        return _statusRepository.save(status).getId_Status();
    }

    @Override
    public Long updateStatus(Status status) {
        return 0L;
    }
}
