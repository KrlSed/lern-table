package com.sedliarov.learningtable.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * This object is entity student.
 *
 * @author Kirill Sedliarov
 */
@Entity
@Table(name = "students",
    uniqueConstraints = @UniqueConstraint(name = "student_unique_first_and_second_name", columnNames = {"firstName",
        "secondName"}))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

  @Id
  @GeneratedValue
  @Column(name = "student_id")
  private UUID studentId;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String secondName;

  private Double note;
}
