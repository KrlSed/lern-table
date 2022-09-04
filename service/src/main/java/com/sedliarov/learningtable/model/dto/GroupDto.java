package com.sedliarov.learningtable.model.dto;

import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.model.entity.Teacher;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

/**
 * This object is group DTO.
 *
 * @author  Kirill Sedliarov
 */
@Data
public class GroupDto implements Serializable {

  private UUID groupId;

  private String name;

  private Teacher teacher;

  private Set<Student> students;
}
