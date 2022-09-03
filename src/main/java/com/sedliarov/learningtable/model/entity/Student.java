package com.sedliarov.learningtable.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private UUID studentId;

    private String firstName;

    private String secondName;

    private Double note;

    @ManyToOne
    @JoinColumn(name="group_id", nullable=false)
    private Group group;
}
