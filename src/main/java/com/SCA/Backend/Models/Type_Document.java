package com.SCA.Backend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name = "type_document")
@Getter
@Setter
@NoArgsConstructor
public class Type_Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_Type;
    private String Name;
    private LocalDateTime Created_Date;

}
