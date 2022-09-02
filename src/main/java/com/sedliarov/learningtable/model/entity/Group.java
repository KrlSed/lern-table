package com.sedliarov.learningtable.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
    private UUID id;

    private String name;

    @OneToOne
    @JoinColumn
    private Teacher teacher;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Student> studentList = new ArrayList<>();
}
