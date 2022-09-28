package com.sedliarov.learningtable.model.dto;

import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.model.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

/**
 * This object is group DTO.
 *
 * @author Kirill Sedliarov
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto implements Serializable {

  private UUID groupId;

  private String name;

  private Teacher teacher;

  private Set<Student> students;
}
