package com.sedliarov.learningtable.controller;

import com.sedliarov.learningtable.model.dto.TeacherDto;
import com.sedliarov.learningtable.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * REST controller for {@link TeacherDto}.
 *
 * @author  Kirill Sedliarov
 */
@RestController
@AllArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {

  private final TeacherService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TeacherDto createTeacher(@RequestBody TeacherDto teacherDto) {
    return service.createTeacher(teacherDto);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<TeacherDto> getTeachers() {
    return service.getTeachers();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public TeacherDto updateTeacher(@PathVariable UUID id, @RequestBody TeacherDto teacherDto) {
    return service.updateTeacher(id, teacherDto);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public TeacherDto getTeacherById(@PathVariable UUID id) {
    return service.getTeacherById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteTeacher(@PathVariable UUID id) {
    service.deleteTeacher(id);
  }
}

