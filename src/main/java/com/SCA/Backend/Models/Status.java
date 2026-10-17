package com.SCA.Backend.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public long Id_Status;
    public String Name;
    public Date Created_Date;

    public Status(){
    }

    public Status(long id_Status, String name, Date created_Date) {
        Id_Status = id_Status;
        Name = name;
        Created_Date = created_Date;
    }

    public long getId_Status() {
        return Id_Status;
    }

    public void setId_Status(long id_Status) {
        Id_Status = id_Status;
    }

    public Date getCreated_Date() {
        return Created_Date;
    }

    public void setCreated_Date(Date created_Date) {
        Created_Date = created_Date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
