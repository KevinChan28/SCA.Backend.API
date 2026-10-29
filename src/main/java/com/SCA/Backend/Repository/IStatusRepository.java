package com.SCA.Backend.Repository;

import com.SCA.Backend.Models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<Status, Long> {
}
