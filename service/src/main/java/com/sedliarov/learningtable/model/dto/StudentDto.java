package com.sedliarov.learningtable.model.dto;

import com.sedliarov.learningtable.model.entity.Group;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


/**
 * This object is student DTO.
 *
 * @author  Kirill Sedliarov
 */
@Data
public class StudentDto implements Serializable {

  private UUID studentId;

  private String firstName;

  private String secondName;

  private Double note;

  private Group group;
}
