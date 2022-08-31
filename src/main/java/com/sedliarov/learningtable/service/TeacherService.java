package com.sedliarov.learningtable.service;

import com.sedliarov.learningtable.model.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    TeacherDto addTeacher(TeacherDto TeacherDto);

    TeacherDto updateTeacher(TeacherDto TeacherDto);

    void deleteTeacher(int id);

    TeacherDto getTeacherById(int id);

    List<TeacherDto> getAllTeacher();
}
