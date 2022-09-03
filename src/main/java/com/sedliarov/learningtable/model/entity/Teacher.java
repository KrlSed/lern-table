package com.sedliarov.learningtable.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

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

    private boolean isAdmin;

    @OneToOne(mappedBy = "teacher")
    private Group group;
}
