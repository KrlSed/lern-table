package com.sedliarov.learningtable.service;

import com.sedliarov.learningtable.model.dto.TeacherDto;

import java.util.List;
import java.util.UUID;

/**
 * Teacher service with necessary REST api methods.
 *
 * @author  Kirill Sedliarov
 */
public interface TeacherService {

  TeacherDto createTeacher(TeacherDto teacherDto);

  TeacherDto updateTeacher(UUID id, TeacherDto teacherDto);

  void deleteTeacher(UUID id);

  void deleteTeachers();

  TeacherDto getTeacherById(UUID id);

  List<TeacherDto> getTeachers();
}
