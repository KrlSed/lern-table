package com.sedliarov.learningtable.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherDto implements Serializable {

    private int id;

    private String firstName;

    private String secondName;

    private boolean isAdmin;

}
