package com.sedliarov.learningtable.model.dto;

import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.model.entity.Teacher;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GroupDto implements Serializable {

    private int id;

    private String name;

    private Teacher teacher;

    private List<Student> studentList;

}
