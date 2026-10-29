package com.SCA.Backend.Repository;

import com.SCA.Backend.Models.Documents;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IDocumentsRepository extends JpaRepository<Documents, Long> {

    @Query("""
            SELECT d FROM Documents d
            JOIN FETCH d.status
            JOIN FETCH d.type
            LEFT JOIN FETCH d.responsible
            """)
    List<Documents> findAllWithRelations();

    @Query(value = """
        SELECT d FROM Documents d
        JOIN FETCH d.status
        JOIN FETCH d.type
        LEFT JOIN FETCH d.responsible
        WHERE (:statusId IS NULL OR d.status.Id_Status = :statusId)
          AND (:typeId IS NULL OR d.type.Id_Type = :typeId)
          AND (:responsibleId IS NULL OR d.responsible.Id_Responsible = :responsibleId)
        """,
            countQuery = """
        SELECT COUNT(d) FROM Documents d
        WHERE (:statusId IS NULL OR d.status.Id_Status = :statusId)
          AND (:typeId IS NULL OR d.type.Id_Type = :typeId)
          AND (:responsibleId IS NULL OR d.responsible.Id_Responsible = :responsibleId)
        """)
    Page<Documents> findAllByFilters(@Param("statusId") Long statusId,
                                  @Param("typeId") Long typeId,
                                  @Param("responsibleId") Long responsibleId,
                                  Pageable pageable);

    @Query("""
        SELECT d FROM Documents d
        JOIN FETCH d.status
        JOIN FETCH d.type
        LEFT JOIN FETCH d.responsible
        WHERE d.IdDocument = :id
        """)
    Optional<Documents> findByIdWithRelations(@Param("id") Long id);
}
