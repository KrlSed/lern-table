package com.sedliarov.learningtable.service;

import com.sedliarov.learningtable.model.dto.TeacherDto;

import java.util.List;
import java.util.UUID;

public interface TeacherService {

  TeacherDto createTeacher(TeacherDto TeacherDto);

  TeacherDto updateTeacher(UUID id, TeacherDto TeacherDto);

  void deleteTeacher(UUID id);

  TeacherDto getTeacherById(UUID id);

  List<TeacherDto> getTeachers();
}
