package com.sedliarov.learningtable.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;
import javax.validation.constraints.NotNull;

/**
 * This object is student DTO.
 *
 * @author Kirill Sedliarov
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto implements Serializable {

  private UUID studentId;

  @NotNull
  private String firstName;

  @NotNull
  private String secondName;

  private Double note;

  private UUID groupId;
}
