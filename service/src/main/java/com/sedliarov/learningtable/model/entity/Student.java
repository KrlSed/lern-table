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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * This object is entity student.
 *
 * @author Kirill Sedliarov
 */
@Entity
@Table(name = "students",
    uniqueConstraints = @UniqueConstraint(name = "UniqueFirstAndSecondName", columnNames = {"firstName", "secondName"}))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

  @Id
  @GeneratedValue
  private UUID studentId;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String secondName;

  private Double note;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;
}
