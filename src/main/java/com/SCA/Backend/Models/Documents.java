package com.SCA.Backend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "documents")
@Getter
@Setter
@NoArgsConstructor
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_document", unique = true, nullable = false)
    private Long IdDocument;
    private String Folio;
    @Column(name = "loaded_date")
    private LocalDateTime LoadedDate;
    private String Subject;
    @Column(name = "limit_date")
    private LocalDateTime LimitDate;
    private String Sender;
    private String Observation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to")
    private Responsible responsible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Type_Document type;
}
