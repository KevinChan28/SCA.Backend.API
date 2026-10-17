package com.SCA.Backend.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "documents")
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public Long Id_Document;
    public String Folio;
    public Date Loaded_Date;
    public String Subject;
    public int Assigned_To;
    public Date Limit_Date;
    public int Status_id;
    public int Type_id;
    public String Sender;
    public String Observation;

    public Documents() {

    }

    public Documents(long id_Document, String folio, Date loaded_Date, int assignedTo, String subject, Date limit_Date, int status_id, int type_id, String sender, String observation) {
        Id_Document = id_Document;
        Folio = folio;
        Loaded_Date = loaded_Date;
        Assigned_To = assignedTo;
        Subject = subject;
        Limit_Date = limit_Date;
        Status_id = status_id;
        Type_id = type_id;
        Sender = sender;
        Observation = observation;
    }

    public long getId_Document() {
        return Id_Document;
    }

    public void setId_Document(long id_Document) {
        Id_Document = id_Document;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String folio) {
        Folio = folio;
    }

    public Date getLoaded_Date() {
        return Loaded_Date;
    }

    public void setLoaded_Date(Date loaded_Date) {
        Loaded_Date = loaded_Date;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public int getAssignedTo() {
        return Assigned_To;
    }

    public void setAssignedTo(int assignedTo) {
        Assigned_To = assignedTo;
    }

    public Date getLimit_Date() {
        return Limit_Date;
    }

    public void setLimit_Date(Date limit_Date) {
        Limit_Date = limit_Date;
    }

    public int getType_id() {
        return Type_id;
    }

    public void setType_id(int type_id) {
        Type_id = type_id;
    }

    public int getStatus_id() {
        return Status_id;
    }

    public void setStatus_id(int status_id) {
        Status_id = status_id;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public String getObservation() {
        return Observation;
    }

    public void setObservation(String observation) {
        Observation = observation;
    }
}
