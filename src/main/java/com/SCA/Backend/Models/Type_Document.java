package com.SCA.Backend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "type_document")
public class Type_Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id_Type;
    public String Name;
    public String Created_Date;

    public Type_Document() {}

    public Type_Document(String created_Date, String name, int id_Type) {
        Created_Date = created_Date;
        Name = name;
        Id_Type = id_Type;
    }

    public int getId_Type() {
        return Id_Type;
    }

    public void setId_Type(int id_Type) {
        Id_Type = id_Type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCreated_Date() {
        return Created_Date;
    }

    public void setCreated_Date(String created_Date) {
        Created_Date = created_Date;
    }
}
