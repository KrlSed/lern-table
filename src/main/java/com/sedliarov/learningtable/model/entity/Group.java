package com.sedliarov.learningtable.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

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

    private String name;

    @OneToOne
    @JoinColumn(name = "teacherId", referencedColumnName = "id")
    private Teacher teacher;

    @OneToMany(mappedBy="studentId")
    private Set<Student> students;
}
