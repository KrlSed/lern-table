package com.sedliarov.learningtable.service;

import com.sedliarov.learningtable.dto.TeacherDto;

import java.util.List;
import java.util.UUID;

public interface TeacherService {
    TeacherDto addTeacher(TeacherDto TeacherDto);

    TeacherDto updateTeacher(int id, TeacherDto TeacherDto);

    void deleteTeacher(int id);

    TeacherDto getTeacherById(int id);

    List<TeacherDto> getAllTeacher();
}
