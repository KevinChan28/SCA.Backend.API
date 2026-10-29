package com.SCA.Backend.Repository;

import com.SCA.Backend.Models.Type_Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepository extends JpaRepository<Type_Document, Long> {
}
