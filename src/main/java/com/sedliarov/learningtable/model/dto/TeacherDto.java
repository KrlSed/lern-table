package com.sedliarov.learningtable.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class TeacherDto implements Serializable {

    private UUID teacherId;

    private String firstName;

    private String secondName;

    private boolean isAdmin;

}
