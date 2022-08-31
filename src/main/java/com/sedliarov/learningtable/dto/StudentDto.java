package com.sedliarov.learningtable.dto;


import java.io.Serializable;

public class StudentDto implements Serializable {

    private int id;

    private String firstName;

    private String secondName;
    private Double note;

    public StudentDto(int id, String firstName, String secondName, Double note) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.note = note;
    }

    public StudentDto() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }
}
