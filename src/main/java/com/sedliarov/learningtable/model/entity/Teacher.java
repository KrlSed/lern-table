package com.sedliarov.learningtable.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher{

    @Id
    @GeneratedValue
    private int id;

    private String firstName;

    private String secondName;

    private boolean isAdmin;

}
