package com.sedliarov.learningtable.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This object is entity teacher.
 *
 * @author Kirill Sedliarov
 */
@Entity
@Table(name = "teacher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

  @Id
  @GeneratedValue
  private UUID teacherId;

  private String firstName;

  private String secondName;

  private boolean isAdmin;

  @OneToOne(mappedBy = "teacher")
  private Group group;
}
