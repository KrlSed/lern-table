package com.sedliarov.learningtable.model.dto;

import com.sedliarov.learningtable.model.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;


/**
 * This object is student DTO.
 *
 * @author  Kirill Sedliarov
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto implements Serializable {

  private UUID studentId;

  private String firstName;

  private String secondName;

  private Double note;

  private Group group;
}
