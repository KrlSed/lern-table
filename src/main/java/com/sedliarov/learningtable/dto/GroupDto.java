package com.sedliarov.learningtable.dto;

import com.sedliarov.learningtable.model.Student;
import com.sedliarov.learningtable.model.Teacher;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupDto implements Serializable {

    private int id;

    private String name;

    private Teacher teacher;

    private List<Student> studentList;

    public GroupDto(){}

    public GroupDto(int id, String name, Teacher teacher, List<Student> studentList) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.studentList = studentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
