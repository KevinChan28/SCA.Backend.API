package com.SCA.Backend.Repository;

import com.SCA.Backend.Models.Documents;
import com.SCA.Backend.Models.Type_Document;
import org.springframework.data.repository.CrudRepository;

public interface ITypeRepository extends CrudRepository<Type_Document, Integer> {
}
