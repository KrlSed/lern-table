package com.sedliarov.learningtable.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * This object is entity group.
 *
 * @author Kirill Sedliarov
 */
@Entity
@Table(name = "groups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group {

  @Id
  @GeneratedValue
  private UUID groupId;

  @Column(nullable = false, unique = true)
  private String name;

  private UUID teacherId;

  @ElementCollection(targetClass = UUID.class)
  @CollectionTable(name = "students", joinColumns = @JoinColumn(name = "groupId"))
  @Column(name = "studentId")
  private Set<UUID> studentIds;
}
