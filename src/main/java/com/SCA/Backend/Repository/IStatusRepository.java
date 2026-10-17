package com.SCA.Backend.Repository;

import com.SCA.Backend.Models.Documents;
import com.SCA.Backend.Models.Status;
import org.springframework.data.repository.CrudRepository;

public interface IStatusRepository extends CrudRepository<Status, Integer> {
}
