package com.sedliarov.learningtable.model.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class StudentDto implements Serializable {

    private UUID id;

    private String firstName;

    private String secondName;

    private Double note;

}
