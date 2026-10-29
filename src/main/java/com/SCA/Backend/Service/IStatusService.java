package com.SCA.Backend.Service;

import com.SCA.Backend.DTO.CreateStatusDTO;
import com.SCA.Backend.Models.Status;

import java.util.List;

public interface IStatusService {

    List<Status> getStatus();
    Status getStatusById(Long idStatus);
    Long createStatus(CreateStatusDTO dto);
    Long updateStatus(Status status);
}
