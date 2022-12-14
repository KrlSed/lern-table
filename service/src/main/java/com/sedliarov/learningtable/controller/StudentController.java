package com.sedliarov.learningtable.controller;

import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.service.StudentService;
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
import javax.validation.Valid;

/**
 * REST controller for {@link StudentDto}.
 *
 * @author Kirill Sedliarov
 */
@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

  private final StudentService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public StudentDto createStudent(@Valid @RequestBody StudentDto studentDto) {
    return service.createStudent(studentDto);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<StudentDto> getStudents() {
    return service.getStudents();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public StudentDto updateStudent(@PathVariable UUID id, @Valid @RequestBody StudentDto studentDto) {
    return service.updateStudent(id, studentDto);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public StudentDto getStudentById(@PathVariable UUID id) {
    return service.getStudentById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteStudent(@PathVariable UUID id) {
    service.deleteStudent(id);
  }
}
