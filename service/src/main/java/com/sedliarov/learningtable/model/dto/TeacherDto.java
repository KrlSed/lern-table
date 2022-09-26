package com.sedliarov.learningtable.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * This object is teacher DTO.
 *
 * @author Kirill Sedliarov
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto implements Serializable {

  private UUID teacherId;

  private String firstName;

  private String secondName;

  private boolean isAdmin;
}
