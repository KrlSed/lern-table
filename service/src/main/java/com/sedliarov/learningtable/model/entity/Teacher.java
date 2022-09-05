package com.sedliarov.learningtable.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This object is entity teacher.
 *
 * @author  Kirill Sedliarov
 */
@Entity
@Table(name = "teachers")
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

  private boolean admin;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
  @JoinColumn(nullable = true)
  private Group group;
}
