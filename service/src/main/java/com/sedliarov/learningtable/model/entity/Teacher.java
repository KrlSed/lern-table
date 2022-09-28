package com.sedliarov.learningtable.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * This object is entity teacher.
 *
 * @author Kirill Sedliarov
 */
@Entity
@Table(name = "teachers",
    uniqueConstraints = @UniqueConstraint(name = "TeacherUniqueFirstAndSecondName", columnNames = {"firstName",
        "secondName"}))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

  @Id
  @GeneratedValue
  private UUID teacherId;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String secondName;

  private boolean isAdmin;

  @JsonIgnore
  @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
  private Group group;
}
