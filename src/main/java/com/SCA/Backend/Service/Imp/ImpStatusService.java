package com.SCA.Backend.Service.Imp;

import com.SCA.Backend.Models.Status;
import com.SCA.Backend.Repository.IStatusRepository;
import com.SCA.Backend.Service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpStatusService implements IStatusService {

    @Autowired
    IStatusRepository _statusRepository;

    @Override
    public List<Status> getStatus() {
        return (List<Status>) _statusRepository.findAll();
    }
}
