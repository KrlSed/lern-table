package com.sedliarov.learningtable.dto;

import java.io.Serializable;

public class TeacherDto implements Serializable {

    private int id;

    private String firstName;

    private String secondName;
    private boolean isAdmin;

    public TeacherDto(int id, String firstName, String secondName, boolean isAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.isAdmin = isAdmin;
    }

    public TeacherDto(){}

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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
